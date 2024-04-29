import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import tsconfigPaths from 'vite-tsconfig-paths';

export default defineConfig({
  plugins: [react(), tsconfigPaths()],
  test: {
    globals: true,
    environment: 'jsdom',
    setupFiles: './vitest.setup.mjs',
  },
  build: {
    outDir: 'dist'
  },
  base: './', // Set the base URL for your application
  publicDir: 'public', // Specify the directory for static assets
  resolve: {
    alias: {
      '@': '/src', // Set up an alias for the src directory
    },
  },
  optimizeDeps: {
    include: ['react', 'react-dom', 'react-router-dom'], // Optimize dependencies
  },
  // Add this section to configure the fallback to index.html
  server: {
    historyApiFallback: {
      index: '/index.html',
    },
  },


});
