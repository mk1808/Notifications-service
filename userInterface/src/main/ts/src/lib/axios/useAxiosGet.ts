import { useAxios } from "./useAxios";

export const UseAxiosGet = (url: string) => {
	const api = useAxios({
		url,
		method: "GET",
	});
	return api;
};
