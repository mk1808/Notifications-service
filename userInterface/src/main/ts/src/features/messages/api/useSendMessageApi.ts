import { useAxiosPost } from "@/lib";
const url = import.meta.env.VITE_API_NOTIFICATIONS;

export const useSendMessageApi = () => {
	const api = useAxiosPost(`${url}/send`);
	return api;
};
