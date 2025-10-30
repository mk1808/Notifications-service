import { type JSX } from "react";
import "./../styles.scss";
interface AppRouterProps {
	placeholder?: string;
}

const AppRouter = ({ placeholder }: AppRouterProps): JSX.Element => (
	<div className="app-router">
		<h1>AppRouter component</h1>
		{placeholder}
	</div>
);

export default AppRouter;
