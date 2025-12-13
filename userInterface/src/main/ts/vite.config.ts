import react from "@vitejs/plugin-react";
import { defineConfig, loadEnv } from "vite";
import tsconfigPaths from "vite-tsconfig-paths";

export default defineConfig(({ mode }) => {
  const env = loadEnv(mode, process.cwd());
  const API_URL = `${env.VITE_API ?? 'http://localhost:8072'}`;

  const NOTIFICATIONS_URL = `${env.VITE_API_NOTIFICATIONS_PROXY ?? '/NOTIFICATIONS/api/notifications'}`;
  const CONFIG_URL = `${env.VITE_API_CONFIG_PROXY ?? '/NOTIFICATIONS/api/config'}`;

  return {
    plugins: [react(), tsconfigPaths()],
    server: {
      proxy: {
        '/notifications': {
          target: API_URL,
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/notifications/, NOTIFICATIONS_URL)
        },
        '/config': {
          target: API_URL,
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/config/, CONFIG_URL)
        },
      },
    },
  };
});

