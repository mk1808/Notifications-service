import { type JSX } from "react";
import "./styles.scss";
interface ContentLayoutProps {
	placeholder?: string;
}

const ContentLayout = ({ placeholder }: ContentLayoutProps): JSX.Element => (
	<div className="ContentLayout">
		<h1>ContentLayout component</h1>
		{placeholder}
	</div>
);

export default ContentLayout;
