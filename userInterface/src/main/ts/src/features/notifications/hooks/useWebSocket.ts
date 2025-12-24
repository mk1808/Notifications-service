import type { Api, CallbackType } from "@/types/types";
import { useCallback, useEffect, useState } from "react";
const url = import.meta.env.VITE_API_NOTIFICATIONS_SSE;

export const useWebSocket = (callback: CallbackType = () => {}) => {
	const [messages, setMessages] = useState<Api.NotificationDto[]>([]);

	
	const addMessage = useCallback(
		(newMessage: Api.NotificationDto) => {
			setMessages((messages) => [...messages, newMessage]);
		},
		[setMessages],
	);

	useEffect(() => {
		const eventSource = new EventSource(url);

		eventSource.onmessage = (event) => {
			console.log(event);
			const newMessage = JSON.parse(event.data) as Api.NotificationDto;
			addMessage(newMessage);
			callback(newMessage);
		};

		eventSource.onerror = (error) => {
			console.log(error);
			eventSource.close();
		};
	}, [addMessage, callback]);

	return { messages };
};

const StompExample = () => {
	const [message, setMessage] = useState('');
	const [name, setName] = useState('');
	const stompClientRef = useRef(null);

	useEffect(() => {
		const socket = new SockJS('http://localhost:8072/NOTIFICATIONS/ws');
		const stompClient = new Client({
			webSocketFactory: () => socket,
			reconnectDelay: 5000,
			debug: (str) => {
				console.log(str);
			},
			onConnect: () => {
				console.log('Connected to WebSocket');
				stompClient.subscribe('/topic/public', (response) => {
					console.log('Received message:', response.body);
					setMessage(JSON.parse(response.body).content);
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

	const sendMessage = () => {
		const stompClient = stompClientRef.current;
		if (stompClient && stompClient.connected) {
			console.log('Sending message:', name);
			stompClient.publish({
				destination: '/app/hello',
				body: name,
			});
		} else {
			console.error('Stomp client is not connected');
		}
	};

	return (
		<div>
			<input 
				type="text" 
				placeholder="Enter your name" 
				value={name} 
				onChange={(e) => setName(e.target.value)} 
			/>
			<button onClick={sendMessage}>Send</button>
			<p>{message}</p>
		</div>
	);
};