import { type JSX } from "react";
interface SendMessagePageProps {
	placeholder?: string;
}

const SendMessagePage = ({
	placeholder,
}: SendMessagePageProps): JSX.Element => (
	<div>
		<h1>SendMessagePage component</h1>
		{placeholder}
	</div>
);

export default SendMessagePage;
