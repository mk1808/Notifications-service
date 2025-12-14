import { useAxios } from "./useAxios";

export const UseAxiosPost = <T>(url: string, payload?: T) => {
	const api = useAxios({
		url,
		method: "POST",
		payload,
	});
	return api;
};
