import { useAxios } from "./useAxios";

export const useAxiosPatch = <T>(url: string, payload: T) => {
	const api = useAxios({
		url,
		method: "PATCH",
		payload,
	});
	return api;
};
