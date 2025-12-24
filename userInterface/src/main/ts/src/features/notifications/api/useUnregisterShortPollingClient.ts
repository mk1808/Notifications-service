import { useAxiosPatch } from "@/lib";
import type { UUID } from "@/types/types";
const url = import.meta.env.VITE_API_NOTIFICATIONS_SHORT_POLLING;

export const useUnregisterShortPollingClient = (clientId: UUID) => {
	return useAxiosPatch(`${url}/unregister/${clientId}`, null);
};
