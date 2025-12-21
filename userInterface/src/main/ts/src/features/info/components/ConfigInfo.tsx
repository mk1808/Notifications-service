import { Heading } from "@chakra-ui/react";
import { useEffect, useState, type JSX } from "react";
import { useTranslation } from "react-i18next";

import { useGetConfigApi } from "../api/useGetConfigApi";

import { isDiffShorterThan } from "@/utils";

import "./../styles.scss";

interface ConfigInfoProps {
	placeholder?: string;
}

const ConfigInfo = ({ placeholder }: ConfigInfoProps): JSX.Element => {
	const { t } = useTranslation();
	const configApi = useGetConfigApi();
	const [appConfig, setAppConfig] = useState(
		(() => {
			const config: string | null = localStorage.getItem("config");
			return config ? JSON.parse(config) : null;
		})(),
	);
	const [lastFetched, setLastFetched] = useState(
		localStorage.getItem("lastFetched") ?? null,
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
	return (
		<div className="config-info">
			<Heading>
				{t("wayOfSendingNotifications")}:{" "}
				{appConfig?.dbProperties?.notificationSource}
			</Heading>
			<Heading>ConfigInfo component</Heading>
			{placeholder}
		</div>
	);
};

export default ConfigInfo;
