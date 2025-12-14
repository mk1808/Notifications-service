import { UseAxios } from "./UseAxios";

export const UseAxiosPost = <T,>(url: string, payload: T) => {
	const { cancel, data, error, loaded } = UseAxios({
		url,
		method: "POST",
		payload,
	});
	return { cancel, data, error, loaded };
};
