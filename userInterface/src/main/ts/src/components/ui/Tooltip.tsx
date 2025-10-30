import { Tooltip as ChakraTooltip, Portal } from "@chakra-ui/react";
import * as React from "react";

// eslint-disable-next-line import/namespace
export interface TooltipProps extends ChakraTooltip.RootProps {
	showArrow?: boolean;
	portalled?: boolean;
	portalRef?: React.RefObject<HTMLElement | null>;
	content: React.ReactNode;
	contentProps?: ChakraTooltip.ContentProps;
	disabled?: boolean;
}

export const Tooltip = ({
	showArrow,
	children,
	disabled,
	portalled = true,
	content,
	contentProps,
	portalRef,
	ref,
	...rest
}: TooltipProps & { ref?: React.RefObject<HTMLDivElement | null> }) => {
	if (disabled) return children;

	return (
		<ChakraTooltip.Root {...rest}>
			<ChakraTooltip.Trigger asChild>{children}</ChakraTooltip.Trigger>
			<Portal container={portalRef} disabled={!portalled}>
				<ChakraTooltip.Positioner>
					<ChakraTooltip.Content ref={ref} {...contentProps}>
						{showArrow ? (
							<ChakraTooltip.Arrow>
								<ChakraTooltip.ArrowTip />
							</ChakraTooltip.Arrow>
						) : null}
						{content}
					</ChakraTooltip.Content>
				</ChakraTooltip.Positioner>
			</Portal>
		</ChakraTooltip.Root>
	);
};
