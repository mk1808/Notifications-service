import { type JSX } from "react";
import "../styles.scss";
interface AuthLayoutProps {
	placeholder?: string;
}

const NotificationsList = ({ placeholder }: AuthLayoutProps): JSX.Element => (
	<div className="notifications-list">
		<h1>NotificationsList</h1>
		{placeholder}
	</div>
);

export default NotificationsList;
