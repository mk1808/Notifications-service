import { UseAxios } from "./UseAxios";

export const UseAxiosDelete = (url: string) => {
	const { makeRequest, cancel, data, error, loaded } = UseAxios({
		url,
		method: "DELETE",
	});
	return { makeRequest, cancel, data, error, loaded };
};
