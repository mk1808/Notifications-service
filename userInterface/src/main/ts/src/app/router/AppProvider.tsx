import { type JSX } from "react";
import "./../styles.scss";
interface AppProviderProps {
	placeholder?: string;
}

const AppProvider = ({ placeholder }: AppProviderProps): JSX.Element => (
	<div className="app-provider">
		<h1>AppProvider component</h1>
		{placeholder}
	</div>
);

export default AppProvider;
