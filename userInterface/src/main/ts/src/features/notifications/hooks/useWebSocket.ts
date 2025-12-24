import type { Api, CallbackType } from "@/types/types";
import { Client } from "@stomp/stompjs";
import { useCallback, useEffect, useRef, useState } from "react";
import SockJS from "sockjs-client";

const env = import.meta.env;
const api = env.VITE_API
const websocketUrl = env.VITE_API_NOTIFICATIONS_WEBSOCKET;
const delay = env.VITE_NOTIFICATIONS_WEBSOCKET_RECONNECT_DELAY;
const channel = env.VITE_NOTIFICATIONS_WEBSOCKET_CHANNEL;

export const useWebSocket = (callback: CallbackType = () => {}) => {
	const [messages, setMessages] = useState<Api.NotificationDto[]>([]);
	const stompClientRef = useRef<Client|null>(null);
	
	const addMessage = useCallback(
		(newMessage: Api.NotificationDto) => {
			setMessages((messages) => [...messages, newMessage]);
		},
		[setMessages],
	);

	useEffect(() => {
		const socket = new SockJS(`${api}${websocketUrl}`);
		const username = self.crypto.randomUUID();
		const stompClient = new Client({
			webSocketFactory: () => socket,
			reconnectDelay: delay,
			debug: (str) => {
				console.log(str);
			},
			onConnect: () => {
				console.log('Connected to WebSocket');
				stompClient.subscribe(channel, (response) => {
					console.log('Received message:', response.body);
					const newMessage = JSON.parse(response.body);
					addMessage(newMessage);
					callback(newMessage);
				});
			},
			onStompError: (frame) => {
				console.error('Broker reported error: ' + frame.headers['message']);
				console.error('Additional details: ' + frame.body);
			},
		});

		stompClient.activate();
		stompClientRef.current = stompClient;

		return () => {
			stompClient.deactivate();
		};
	}, []);

	return { messages };
};