import React, { type JSX } from 'react';
import './../styles.sass';
interface AppProviderProps { }

const AppProvider = (props: AppProviderProps): JSX.Element => (
  <div className="app-provider">
    <h1>AppProvider component</h1>
  </div>
);

export default AppProvider;