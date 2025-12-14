import { UseAxios } from "./UseAxios";

export const UseAxiosPost = <T,>(url: string, payload?: T) => {
	const { makeRequest, cancel, data, error, loaded } = UseAxios({
		url,
		method: "POST",
		payload,
	});
	return { makeRequest, cancel, data, error, loaded };
};
