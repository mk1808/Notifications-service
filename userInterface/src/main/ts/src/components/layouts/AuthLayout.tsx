import React, { type JSX } from 'react';
import './styles.sass';
interface AuthLayoutProps { }

const AuthLayout = (props: AuthLayoutProps): JSX.Element => (
  <div className="AuthLayout">
    <h1>AuthLayout component</h1>
  </div>
);

export default AuthLayout;