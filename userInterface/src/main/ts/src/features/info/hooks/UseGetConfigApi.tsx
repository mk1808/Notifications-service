import { UseAxiosGet } from "@/lib";
const url = import.meta.env.VITE_API_CONFIG;

export const UseGetConfigApi = () => {
	const { makeRequest, cancel, data, error, loaded } = UseAxiosGet(url);
	return { makeRequest, cancel, data, error, loaded };
};
