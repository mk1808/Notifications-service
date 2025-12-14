import { useAxios } from "./useAxios";

export const useAxiosPost = <T>(url: string, payload?: T) => {
	const api = useAxios({
		url,
		method: "POST",
		payload,
	});
	return api;
};
