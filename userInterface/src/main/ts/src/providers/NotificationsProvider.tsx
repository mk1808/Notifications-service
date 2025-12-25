import {
	createContext,
	useCallback,
	useMemo,
	useReducer,
	type ReactNode,
} from "react";

import type { Action, Api } from "@/types/types";

export const NotificationContext = createContext({});
export const NotificationActionContext = createContext({});

export const ADD = "ADD";
export const ACKNOWLEDGE = "ACKNOWLEDGE";
export const DELETE = "DELETE";

export interface NotificationsState {
	list: Api.NotificationDto[];
	numberOfNew: number;
}

const initialState: NotificationsState = {
	list: [],
	numberOfNew: 0,
};

function reducer(state: NotificationsState, action: Action) {
	switch (action.type) {
		case ADD: {
			console.log("add");
			return {
				...state,
				list: [...state.list, action.data.notification],
			};
		}
		case ACKNOWLEDGE: {
			console.log("acknowledge");
			return {
				...state,
			};
		}
		case DELETE: {
			console.log("delete");
			return {
				...state,
			};
		}
		default:
			return state;
	}
}

const NotificationsProvider = ({ children }: { children: ReactNode }) => {
	const [state, dispatch] = useReducer<NotificationsState, [action: Action]>(
		reducer,
		initialState,
	);

	const add = useCallback((notification: Api.NotificationDto) => {
		dispatch({ type: ADD, data: { notification } });
	}, []);

	const acknowledge = useCallback((notification: Api.NotificationDto) => {
		dispatch({ type: ACKNOWLEDGE, data: { notification } });
	}, []);

	const deleteN = useCallback((notification: Api.NotificationDto) => {
		dispatch({ type: DELETE, data: { notification } });
	}, []);

	const notificationsValue = useMemo(() => state, [state]);
	const notificationsActionValue = useMemo(
		() => ({
			add,
			acknowledge,
			deleteN,
		}),
		[add, acknowledge, deleteN],
	);
	return (
		<NotificationContext value={notificationsValue}>
			<NotificationActionContext value={notificationsActionValue}>
				{children}
			</NotificationActionContext>
		</NotificationContext>
	);
};
export default NotificationsProvider;
