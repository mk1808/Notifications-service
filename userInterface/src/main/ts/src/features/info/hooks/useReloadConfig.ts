import { useCallback, useEffect, useState } from "react";

import { useGetConfigApi } from "../api/useGetConfigApi";

import { isDiffShorterThan } from "@/utils";

export const useReloadConfig = () => {
	const configApi = useGetConfigApi();
	const initAppConfig = useCallback(() => {
		const config: string | null = localStorage.getItem("config");
		return config ? JSON.parse(config) : null;
	}, []);
	const [appConfig, setAppConfig] = useState(() => initAppConfig());
	const [lastFetched, setLastFetched] = useState(
		localStorage.getItem("lastFetched") ?? null
	);

	useEffect(() => {
		const reloadConfig = async () => {
			const now: Date = new Date();
			if (
				appConfig != null &&
				lastFetched != null &&
				isDiffShorterThan(now, new Date(lastFetched), 5)
			) {
				return;
			}
			getConfig(now);
		};

		const getConfig = async (now: Date) => {
			try {
				const configResponse = await configApi.makeRequest();
				localStorage.setItem("config", JSON.stringify(configResponse));
				localStorage.setItem("lastFetched", now.toString());
				setAppConfig(configResponse);
				setLastFetched(now.toString());
			} catch (e) {
				console.error(e);
			}
		};

		reloadConfig();
	}, [configApi, appConfig, lastFetched]);

	return appConfig;
};
