import { type JSX } from "react";
interface InfoPageProps {
	placeholder?: string;
}

const InfoPage = ({ placeholder }: InfoPageProps): JSX.Element => (
	<div>
		<h1>InfoPage component</h1>
		{placeholder}
	</div>
);

export default InfoPage;
