import React, { type JSX } from 'react';
import './../styles.sass';
interface AppRouterProps { }

const AppRouter = (props: AppRouterProps): JSX.Element => (
  <div className="app-router">
    <h1>AppRouter component</h1>
  </div>
);

export default AppRouter;