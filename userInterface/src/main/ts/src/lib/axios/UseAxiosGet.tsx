import { UseAxios } from "./UseAxios";

export const UseAxiosGet = (url: string) => {
	const { cancel, data, error, loaded } = UseAxios({ url, method: "GET" });
	return { cancel, data, error, loaded };
};
