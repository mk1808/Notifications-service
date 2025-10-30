import { type JSX } from "react";
interface LoginPageProps {
	placeholder?: string;
}

const LoginPage = ({ placeholder }: LoginPageProps): JSX.Element => (
	<div>
		<h1>LoginPage component</h1>
		{placeholder}
	</div>
);

export default LoginPage;
