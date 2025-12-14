import { UseAxiosPost } from "@/lib";
const url = import.meta.env.VITE_API_NOTIFICATIONS;

export const UseSendMessageApi = () => {
	const { makeRequest, cancel, data, error, loaded } = UseAxiosPost(
		`${url}/send`,
	);
	return { makeRequest, cancel, data, error, loaded };
};
