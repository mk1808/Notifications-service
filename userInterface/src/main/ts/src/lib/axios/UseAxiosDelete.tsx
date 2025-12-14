import { UseAxios } from "./UseAxios";

export const UseAxiosDelete = (url: string) => {
	const { cancel, data, error, loaded } = UseAxios({ url, method: "DELETE" });
	return { cancel, data, error, loaded };
};
