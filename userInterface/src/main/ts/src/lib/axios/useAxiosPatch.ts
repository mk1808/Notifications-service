import { useAxios } from "./useAxios";

export const UseAxiosPatch = <T>(url: string, payload: T) => {
	const api = useAxios({
		url,
		method: "PATCH",
		payload,
	});
	return api;
};
