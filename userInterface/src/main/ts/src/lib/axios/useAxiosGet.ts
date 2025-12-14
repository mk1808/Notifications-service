import { useAxios } from "./useAxios";

export const useAxiosGet = (url: string) => {
	const api = useAxios({
		url,
		method: "GET",
	});
	return api;
};
