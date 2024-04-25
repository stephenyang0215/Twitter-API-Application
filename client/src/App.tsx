import '@mantine/core/styles.css';
import { MantineProvider } from '@mantine/core';
import { AppShell, Container, Text, Skeleton, Stack } from '@mantine/core';
import { Router } from './Router';
import { theme } from './theme';
import { AuthContext, AuthProvider, TAuthConfig } from 'react-oauth2-code-pkce';
export default function App() {
  return (
    <MantineProvider theme={theme}>
      <Router />
    </MantineProvider>
  );
}
