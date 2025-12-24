import {
	Alert,
	Box,
	Button,
	Field,
	HStack,
	Input,
	RatingGroup,
	Separator,
	Slider,
	Text,
	VStack,
} from "@chakra-ui/react";
import { Camera } from "lucide-react";
import { useCallback, useEffect, useMemo, type JSX } from "react";
import { useTranslation } from "react-i18next";

import { getCssVar } from "@/config/themeConfig";
import { useGetConfigApi } from "@/features/info/api/useGetConfigApi";
import { useSendMessageApi } from "@/features/messages/api/useSendMessageApi";
import {
	useShortPolling,
	useSse,
	useWebSocket,
} from "@/features/notifications";

interface InfoPageProps {
	placeholder?: string;
}

const TestPage = ({ placeholder }: InfoPageProps): JSX.Element => {
	const { t } = useTranslation();

	const postResponse = useSendMessageApi();

	const response = useGetConfigApi();

	const { messages } = useSse(console.log);
	const shortPolling = useShortPolling(console.log);
	const onWebsocketMessage = useCallback((m) => console.log(m), []);
	const messagesWebsocket = useWebSocket(onWebsocketMessage);

	useEffect(() => {
		response.makeRequest();
		console.log(response.data);
	}, []);
	const stringifiedData = useMemo(() => {
		return JSON.stringify(postResponse.data ?? {});
	}, [postResponse.data]);

	return (
		<>
			{placeholder}
			{t("welcome")} <br />
			{stringifiedData}
			{postResponse.loaded}
			{postResponse.error}
			{JSON.stringify(response.data || {})}
			<HStack>
				<Button
					onClick={() => {
						response.makeRequest();
					}}
				>
					Click me
				</Button>
				<Button
					_hover={{ bg: "secondary" }}
					bg="primary"
					onClick={() => {
						postResponse.makeRequest({});
					}}
				>
					Click me
				</Button>
				<Field.Root>
					<Field.Label>Email</Field.Label>
					<Input placeholder="me@example.com" />
				</Field.Root>
				<Slider.Root defaultValue={[40]} width="52">
					<Slider.Control>
						<Slider.Track>
							<Slider.Range />
						</Slider.Track>
						<Slider.Thumbs />
					</Slider.Control>
				</Slider.Root>
				<RatingGroup.Root count={5} defaultValue={3} size="sm">
					<RatingGroup.HiddenInput />
					<RatingGroup.Control />
				</RatingGroup.Root>
				<Camera color="primary" size={48} />;
				<Camera color="green" size={48} />;
				<Alert.Root>
					<Alert.Indicator />
					<Alert.Content>
						<Alert.Title />
						<Alert.Description />
					</Alert.Content>
				</Alert.Root>
				<p className="paragraph-id">TEST STYLI SCSS</p>
				<p className="paragraph-id2">TEST STYLI SCSS</p>
			</HStack>
			<HStack>
				<p>
					Wartość zmiennej
					<span style={{ backgroundColor: getCssVar("colors.primary") }}>
						{getCssVar("colors.primary")}
					</span>
				</p>
				<Button colorPalette="primary">Button</Button>
				<Button colorPalette="secondary">Button</Button>
				<Button colorPalette="accent">Button</Button>
				<Box bg="primary.solid" color="primary.contrast">
					Hello world
				</Box>
				<Button variant="outline">Outline</Button>
				<Field.Root invalid>
					<Field.Label>Email</Field.Label>
					<Input placeholder="me@example.com" />
					<Field.ErrorText>This is an error text</Field.ErrorText>
				</Field.Root>
				<p>zwykły tekst</p>
			</HStack>
			<Text style={{ marginTop: "50px", marginBottom: "10px" }}>SSE</Text>
			<Separator />
			<VStack>
				{messages.map((message) => (
					<p key={message.id}>{message.content}</p>
				))}
			</VStack>
			<Text style={{ marginTop: "50px", marginBottom: "10px" }}>
				SHORT POLLING
			</Text>
			<Separator />
			<VStack>
				{shortPolling.messages.map((message) => (
					<p key={message.id}>{message.content}</p>
				))}
			</VStack>
			<Text style={{ marginTop: "50px", marginBottom: "10px" }}>
				WEBSOCKETS
			</Text>
			<Separator />
			<VStack>
				{messagesWebsocket.messages.map((message) => (
					<p key={message.id}>{message.content}</p>
				))}
			</VStack>
		</>
	);
};

export default TestPage;
