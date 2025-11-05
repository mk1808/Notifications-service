"use client";

import { ChakraProvider } from "@chakra-ui/react";

import styleSystem from "../../config/themeConfig";

import { ColorModeProvider, type ColorModeProviderProps } from "./ColorMode";

export const ChakraConfigProvider = (props: ColorModeProviderProps) => {
	return (
		<ChakraProvider value={styleSystem}>
			<ColorModeProvider {...props} />
		</ChakraProvider>
	);
};
