import { useAxios } from "./useAxios";

export const useAxiosDelete = (url: string) => {
	const api = useAxios({
		url,
		method: "DELETE",
	});
	return api;
};
