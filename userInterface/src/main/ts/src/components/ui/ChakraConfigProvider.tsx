"use client";

import { ChakraProvider, defaultSystem } from "@chakra-ui/react";

import { ColorModeProvider, type ColorModeProviderProps } from "./ColorMode";

export const ChakraConfigProvider = (props: ColorModeProviderProps) => {
	return (
		<ChakraProvider value={defaultSystem}>
			<ColorModeProvider {...props} />
		</ChakraProvider>
	);
};
