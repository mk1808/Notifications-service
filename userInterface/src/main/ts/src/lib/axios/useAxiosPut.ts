import { useAxios } from "./useAxios";

export const useAxiosPut = <T>(url: string, payload: T) => {
	const api = useAxios({
		url,
		method: "PUT",
		payload,
	});
	return api;
};
