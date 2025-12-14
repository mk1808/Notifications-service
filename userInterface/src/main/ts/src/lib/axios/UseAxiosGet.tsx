import { UseAxios } from "./UseAxios";

export const UseAxiosGet = (url: string) => {
	const { makeRequest, cancel, data, error, loaded } = UseAxios({
		url,
		method: "GET",
	});
	return { makeRequest, cancel, data, error, loaded };
};
