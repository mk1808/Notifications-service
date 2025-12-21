/* eslint-disable import/no-named-as-default-member */
import i18n from "i18next";
import HttpBackend from "i18next-http-backend";
import { initReactI18next } from "react-i18next";

i18n
	.use(initReactI18next)
	.use(HttpBackend)
	.init({
		backend: {
			loadPath: "locales/{{lng}}/translation.json",
		},
		lng: "pl",
		fallbackLng: "pl",
		debug: true,
		supportedLngs: ["en", "pl"],
		interpolation: {
			escapeValue: false,
		},
	});

export default i18n;
