import axios from "axios";
import { useRef, useState } from "react";

interface UseAxiosProps<T> {
	url: string;
	method: "POST" | "PUT" | "GET" | "DELETE" | "PATCH";
	payload?: T;
}

export const UseAxios = <T,>({ url, method, payload }: UseAxiosProps<T>) => {
	const [data, setData] = useState(null);
	const [error, setError] = useState("");
	const [loaded, setLoaded] = useState(false);
	const controllerRef = useRef(new AbortController());
	const cancel = () => {
		controllerRef.current.abort();
	};
	const makeRequest = async (body?: T) => {
		console.log("hello");
		try {
			const response = await axios.request({
				data: body ?? payload,
				signal: controllerRef.current.signal,
				method,
				url,
			});

			setData(response.data);
		} catch (error: any) {
			setError(error.message);
		} finally {
			setLoaded(true);
		}
	};

	return { makeRequest, cancel, data, error, loaded };
};
