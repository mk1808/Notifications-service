import { Heading } from "@chakra-ui/react";
import { useEffect, type JSX } from "react";
import { useTranslation } from "react-i18next";

import { useGetConfigApi } from "../api/useGetConfigApi";
import "./../styles.scss";

interface ConfigInfoProps {
	placeholder?: string;
}

const ConfigInfo = ({ placeholder }: ConfigInfoProps): JSX.Element => {
	const { t } = useTranslation();
	const response = useGetConfigApi();

	useEffect(() => {
		response.makeRequest();
		console.log(response.data);
	}, []);
	return (
		<div className="config-info">
			<Heading>
				{t("wayOfSendingNotifications")}:{" "}
				{response?.data?.dbProperties?.notificationSource}
			</Heading>
			<Heading>ConfigInfo component</Heading>
			{placeholder}
		</div>
	);
};

export default ConfigInfo;
