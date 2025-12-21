import { Heading } from "@chakra-ui/react";
import { type JSX } from "react";
import { useTranslation } from "react-i18next";

import { useReloadConfig } from "../hooks/useReloadConfig";

import "./../styles.scss";

interface ConfigInfoProps {
	placeholder?: string;
}

const ConfigInfo = ({ placeholder }: ConfigInfoProps): JSX.Element => {
	const { t } = useTranslation();
	const appConfig = useReloadConfig();
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
