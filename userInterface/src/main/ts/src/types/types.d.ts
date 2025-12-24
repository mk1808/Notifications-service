export declare namespace Api {
	interface NotificationDto {
		id: string;
		created: Date;
		content: string;
		recipient: string;
	}

	interface DbProperties {
		notificationSource: string;
		shortPollingClientInactivitySchedulerInterval: number;
		shortPollingClientInactivityTimeout: number;
		shortPollingClientRequestInterval: number;
	}
}

export type CallbackType = <T>(t: T) => void;

type UUID = `${string}-${string}-${string}-${string}-${string}`;
