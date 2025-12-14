import { useAxiosGet } from "@/lib";
const url = import.meta.env.VITE_API_CONFIG;

export const useGetConfigApi = () => {
	return useAxiosGet(url);
};
