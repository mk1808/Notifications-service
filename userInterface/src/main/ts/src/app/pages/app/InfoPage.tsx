import { type JSX } from "react";

import ConfigInfo from "@/features/info/components/ConfigInfo";
interface InfoPageProps {
	placeholder?: string;
}

const InfoPage = ({ placeholder }: InfoPageProps): JSX.Element => (
	<div>
		<ConfigInfo />
	</div>
);

export default InfoPage;
