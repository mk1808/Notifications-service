import "./styles.scss";
import { RouterProvider } from "react-router-dom";

import NotificationsProvider from "@/providers/NotificationsProvider";

import router from "./router/AppRoutes";

const App = () => {
	return (
		<NotificationsProvider>
			<RouterProvider router={router} />
		</NotificationsProvider>
	);
};

export default App;
