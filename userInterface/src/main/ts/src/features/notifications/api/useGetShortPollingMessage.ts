import { useAxiosGet } from "@/lib";
import type { UUID } from "@/types/types";
const url = import.meta.env.VITE_API_NOTIFICATIONS_SHORT_POLLING;

export const useGetShortPollingMessage = (clientId: UUID) => {
	return useAxiosGet(`${url}/${clientId}`);
};
