import { type JSX } from "react";
interface NotFoundPageProps {
	placeholder?: string;
}

const NotFoundPage = ({ placeholder }: NotFoundPageProps): JSX.Element => (
	<div>
		<h1>NotFoundPage component</h1>
		{placeholder}
	</div>
);

export default NotFoundPage;
