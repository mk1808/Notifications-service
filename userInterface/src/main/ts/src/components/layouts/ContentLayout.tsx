import React, { type JSX } from 'react';
import './styles.sass';
interface ContentLayoutProps { }

const ContentLayout = (props: ContentLayoutProps): JSX.Element => (
  <div className="ContentLayout">
    <h1>ContentLayout component</h1>
  </div>
);

export default ContentLayout;