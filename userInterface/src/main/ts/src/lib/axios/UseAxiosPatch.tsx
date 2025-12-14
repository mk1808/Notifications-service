import { UseAxios } from "./UseAxios";

export const UseAxiosPatch = <T,>(url: string, payload: T) => {
	const { makeRequest, cancel, data, error, loaded } = UseAxios({
		url,
		method: "PATCH",
		payload,
	});
	return { makeRequest, cancel, data, error, loaded };
};
