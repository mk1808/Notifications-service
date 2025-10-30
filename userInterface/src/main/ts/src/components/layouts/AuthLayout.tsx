import { type JSX } from "react";
import "./styles.scss";
interface AuthLayoutProps {
	placeholder?: string;
}

const AuthLayout = ({ placeholder }: AuthLayoutProps): JSX.Element => (
	<div className="AuthLayout">
		<h1>AuthLayout component</h1>
		{placeholder}
	</div>
);

export default AuthLayout;
