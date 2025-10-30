import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import "./index.css";
import App from "./app/App.tsx";
import { ChakraConfigProvider } from "./components/ui";

createRoot(document.getElementById("root")!).render(
	<StrictMode>
		<ChakraConfigProvider>
			<App />
		</ChakraConfigProvider>
	</StrictMode>,
);
