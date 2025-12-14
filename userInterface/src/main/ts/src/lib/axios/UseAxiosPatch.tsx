import { UseAxios } from "./UseAxios";

export const UseAxiosPatch = <T,>(url: string, payload: T) => {
	const { cancel, data, error, loaded } = UseAxios({
		url,
		method: "PATCH",
		payload,
	});
	return { cancel, data, error, loaded };
};
