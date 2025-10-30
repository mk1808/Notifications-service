import { JSX } from 'react';
import './styles.scss';

interface TemplateNameProps {
	placeholder?: string;
}

const TemplateName = ({
	placeholder
}: TemplateNameProps): JSX.Element => (
	<div className="template-name">
		<h1>TemplateName component</h1>
		{placeholder}
	</div>
);

export default TemplateName;