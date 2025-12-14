import { UseAxios } from "./UseAxios";

export const UseAxiosPut = <T,>(url: string, payload: T) => {
	const { makeRequest, cancel, data, error, loaded } = UseAxios({
		url,
		method: "PUT",
		payload,
	});
	return { makeRequest, cancel, data, error, loaded };
};
