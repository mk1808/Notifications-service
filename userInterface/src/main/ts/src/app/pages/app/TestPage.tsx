import {
	Alert,
	Button,
	Field,
	HStack,
	Input,
	RatingGroup,
	Slider,
	Box,
} from "@chakra-ui/react";
import { Camera } from "lucide-react";
import { type JSX } from "react";
import { useTranslation } from "react-i18next";

import { getCssVar } from "@/config/themeConfig";
interface InfoPageProps {
	placeholder?: string;
}

const TestPage = ({ placeholder }: InfoPageProps): JSX.Element => {
	const { t } = useTranslation();
	const sendUrl = import.meta.env.VITE_API_NOTIFICATIONS;
	const configUrl = import.meta.env.VITE_API_CONFIG;
	const getReq = async () => {
		const response1 = await fetch(sendUrl + "/send", {
			method: "GET"
		});
	}
	const postReq = async () => {
		const response2 = await fetch(configUrl, {
			method: "POST"
		});
	}
	return (
		<>
			{t("welcome")}
			<HStack>
				<Button onClick={() => console.log(placeholder)}>Click me</Button>
				<Button _hover={{ bg: "secondary" }} bg="primary">
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
		</>
	);
};

export default TestPage;
