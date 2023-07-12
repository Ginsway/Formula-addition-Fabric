package io.github.ginsway.fadd.mixin;

import io.github.ginsway.fadd.FormulaAddition;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class FormulaAdditionMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		FormulaAddition.LOGGER.info("This line is printed by formula_addition mod mixin!");
	}
}
