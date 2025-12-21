export declare namespace Api {
	interface NotificationDto {
		id: string;
		created: Date;
		content: string;
		recipient: string;
	}
}

export type CallbackType = <T>(t: T) => void;
