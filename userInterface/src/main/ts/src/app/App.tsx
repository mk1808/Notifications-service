import "./styles.scss";
import {
	Alert,
	Button,
	Field,
	HStack,
	Input,
	RatingGroup,
	Slider,
} from "@chakra-ui/react";
import { Camera } from "lucide-react";

const App = () => {
	return (
		<HStack>
			<Button onClick={() => console.log()}>Click me</Button>
			<Button>Click me</Button>
			<Field.Root>
				<Field.Label>Email</Field.Label>
				<Input placeholder="me@example.com" />
			</Field.Root>
			<Slider.Root defaultValue={[40]} width="200px">
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
			<Camera color="red" size={48} />;
			<Alert.Root>
				<Alert.Indicator />
				<Alert.Content>
					<Alert.Title />
					<Alert.Description />
				</Alert.Content>
			</Alert.Root>
		</HStack>
	);
};

export default App;
