import { createBrowserRouter } from "react-router-dom";

import InfoPage from "../pages/app/InfoPage";
import SendMessagePage from "../pages/app/SendMessagePage";
import TestPage from "../pages/app/TestPage";
import LoginPage from "../pages/auth/LoginPage";
import LandingPage from "../pages/LandingPage";
import NotFoundPage from "../pages/NotFoundPage";

const AppRoutes = createBrowserRouter([
	{
		path: "/",
		Component: LandingPage,
	},
	{
		path: "/about",
		Component: InfoPage,
	},
	{
		path: "/messages",
		Component: SendMessagePage,
	},
	{
		path: "/test",
		Component: TestPage,
	},
	{
		path: "/login",
		Component: LoginPage,
	},
	{
		path: "*",
		Component: NotFoundPage,
	},
]);

export default AppRoutes;
