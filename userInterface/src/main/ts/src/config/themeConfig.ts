import { createSystem, defaultConfig, defineConfig } from "@chakra-ui/react";

const config = defineConfig({
	strictTokens: true,
	theme: {
		tokens: {
			colors: {
				primary: {
					DEFAULT: { value: "#2a9d8f" },
					50: { value: "#f2fbf9" },
					100: { value: "#d3f4ed" },
					200: { value: "#a6e9db" },
					300: { value: "#72d6c6" },
					400: { value: "#44bdac" },
					500: { value: "#2a9d8f" },
					600: { value: "#208177" },
					700: { value: "#1d6861" },
					800: { value: "#1c534f" },
					900: { value: "#1b4642" },
					950: { value: "#0a2928" },
				},
				secondary: {
					DEFAULT: { value: "#e76f51" },
					50: { value: "#fdf5f3" },
					100: { value: "#fde8e3" },
					200: { value: "#fbd6cd" },
					300: { value: "#f8b9a9" },
					400: { value: "#f19078" },
					500: { value: "#e76f51" },
					600: { value: "#d3502f" },
					700: { value: "#b14024" },
					800: { value: "#933821" },
					900: { value: "#7a3422" },
					950: { value: "#42180d" },
				},
				accent: {
					DEFAULT: { value: "#da8d26" },
					50: { value: "#fdf9ed" },
					100: { value: "#f8edcd" },
					200: { value: "#f0d997" },
					300: { value: "#e9c46a" },
					400: { value: "#e2ab3d" },
					500: { value: "#da8d26" },
					600: { value: "#c16c1e" },
					700: { value: "#a04f1d" },
					800: { value: "#833e1d" },
					900: { value: "#6c331b" },
					950: { value: "#3d190b" },
				},
			},
		},
		semanticTokens: {
			colors: {
				bg: { value: "{colors.primary.50}" },
				fg: { value: "{colors.primary.950}" },
				primary: {
					solid: { value: "{colors.primary.500}" },
					contrast: { value: "{colors.primary.100}" },
					fg: { value: "{colors.primary.700}" },
					muted: { value: "{colors.primary.100}" },
					subtle: { value: "{colors.primary.200}" },
					emphasized: { value: "{colors.primary.300}" },
					focusRing: { value: "{colors.primary.500}" },
				},
				secondary: {
					solid: { value: "{colors.secondary.500}" },
					contrast: { value: "{colors.secondary.100}" },
					fg: { value: "{colors.secondary.700}" },
					muted: { value: "{colors.secondary.100}" },
					subtle: { value: "{colors.secondary.200}" },
					emphasized: { value: "{colors.secondary.300}" },
					focusRing: { value: "{colors.secondary.500}" },
				},
				accent: {
					solid: { value: "{colors.accent.500}" },
					contrast: { value: "{colors.accent.100}" },
					fg: { value: "{colors.accent.700}" },
					muted: { value: "{colors.accent.100}" },
					subtle: { value: "{colors.accent.200}" },
					emphasized: { value: "{colors.accent.300}" },
					focusRing: { value: "{colors.accent.500}" },
				},
			},
		},
	},
	globalCss: {
		html: {
			colorPalette: "primary",
		},
	},
});

const styleSystem = createSystem(defaultConfig, config);

export function getCssVar(tokenName: string): string {
	return styleSystem.token.var(tokenName);
}

export default styleSystem;
