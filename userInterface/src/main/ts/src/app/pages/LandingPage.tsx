import { type JSX } from "react";

interface LandingPageProps {
	placeholder?: string;
}

const LandingPage = ({ placeholder }: LandingPageProps): JSX.Element => (
	<div>
		<h1>LandingPage component</h1>
		{placeholder}
	</div>
);

export default LandingPage;
