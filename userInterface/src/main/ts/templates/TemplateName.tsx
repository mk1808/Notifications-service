import React, { JSX } from 'react';
import './styles.scss';
interface TemplateNameProps { }

const TemplateName = (props: TemplateNameProps): JSX.Element => (
  <div className="template-name">
    <h1>TemplateName component</h1>
  </div>
);

export default TemplateName;