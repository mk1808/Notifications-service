import { useCallback, useEffect, useState } from "react";

import type { Api, CallbackType } from "@/types/types";
const url = import.meta.env.VITE_API_NOTIFICATIONS_SSE;

export const useSse = (callback: CallbackType = () => {}) => {
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
