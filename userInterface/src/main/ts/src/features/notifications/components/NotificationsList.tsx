import { type JSX } from "react";

import "../styles.scss";
import {
	useNotificationContext,
	type NotificationsState,
} from "@/providers/NotificationsProvider";
interface AuthLayoutProps {
	placeholder?: string;
}

const NotificationsList = ({ placeholder }: AuthLayoutProps): JSX.Element => {
	const { list }: NotificationsState = useNotificationContext();
	console.log(list);
	return (
		<div className="notifications-list">
			<h1>NotificationsList</h1>
			{list.map((element: any) => (
				<p key={element.id}>{element.content}</p>
			))}
			{placeholder}
		</div>
	);
};

export default NotificationsList;
