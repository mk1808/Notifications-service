import { UseAxios } from "./UseAxios";

export const UseAxiosPut = <T,>(url: string, payload: T) => {
	const { cancel, data, error, loaded } = UseAxios({
		url,
		method: "PUT",
		payload,
	});
	return { cancel, data, error, loaded };
};
