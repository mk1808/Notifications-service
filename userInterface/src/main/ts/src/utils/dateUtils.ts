export const getDatesDifference = (date1: Date, date2: Date) => {
	return date1.getTime() - date2.getTime();
};

export const isDiffShorterThan = (
	date1: Date,
	date2: Date,
	minutes: number,
) => {
	return getDatesDifference(date1, date2) < minutes * 60 * 1000;
};
