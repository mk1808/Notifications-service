import { HStack, StackSeparator } from "@chakra-ui/react";
import { type JSX } from "react";
import { Link } from "react-router-dom";

interface LandingPageProps {
	placeholder?: string;
}

const LandingPage = ({ placeholder }: LandingPageProps): JSX.Element => (
	<div>
		<h1>LandingPage component</h1>
		{placeholder}
		<HStack ml="10" mt="6" separator={<StackSeparator />}>
			<Link to="/" viewTransition>
				Home
			</Link>
			<Link to="/about" viewTransition>
				About
			</Link>
			<Link to="/messages" viewTransition>
				Messages
			</Link>
			<Link to="/test" viewTransition>
				Test
			</Link>
			<Link to="/login" viewTransition>
				Login
			</Link>
			<Link to="/not_existing" viewTransition>
				Not existing
			</Link>
		</HStack>
	</div>
);

export default LandingPage;
