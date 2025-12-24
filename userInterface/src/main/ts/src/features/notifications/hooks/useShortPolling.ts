import { useCallback, useEffect, useMemo, useRef, useState } from "react";

import { useGetConfigApi } from "@/features/info/api/useGetConfigApi";
import type { Api, CallbackType, UUID } from "@/types/types";

import { useGetShortPollingMessage } from "../api/useGetShortPollingMessage";
import { useUnregisterShortPollingClient } from "../api/useUnregisterShortPollingClient";

export const useShortPolling = (callback: CallbackType = () => {}) => {
	const clientId = useMemo<UUID>(() => crypto.randomUUID(), []);
	const requestIntervalValue = useRef(0);
	const requestTimeout = useRef(0);

	const configApi = useGetConfigApi();
	const getMessagesApi = useGetShortPollingMessage(clientId);
	const unregisterApi = useUnregisterShortPollingClient(clientId);

	const [messages, setMessages] = useState<Api.NotificationDto[]>([]);

	const addMessage = useCallback(
		(newMessage: Api.NotificationDto) => {
			callback(newMessage);
			setMessages((messages) => [...messages, newMessage]);
		},
		[setMessages, callback],
	);

	const makeGetMessagesRequest = useCallback(async () => {
		const data: Api.NotificationDto | string =
			await getMessagesApi.makeRequest();
		if (typeof data === "object") {
			addMessage(data);
			makeGetMessagesRequest();
		} else {
			clearTimeout(requestTimeout.current);
			requestTimeout.current = setTimeout(
				makeGetMessagesRequest,
				requestIntervalValue.current,
			);
		}
	}, [addMessage, getMessagesApi]);

	const initDataFetch = useCallback(async () => {
		const config: { dbProperties: Api.DbProperties } =
			await configApi.makeRequest();

		requestIntervalValue.current =
			config.dbProperties.shortPollingClientRequestInterval;
		makeGetMessagesRequest();
	}, [configApi, makeGetMessagesRequest]);

	const unregisterClient = useCallback(async () => {
		clearTimeout(requestTimeout.current);
		unregisterApi.makeRequest();
	}, [unregisterApi]);

	useEffect(() => {
		initDataFetch();
		return () => {
			unregisterClient();
		};
	}, []);

	return { messages };
};
