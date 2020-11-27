package net.textilemc.ModMenuFL.mixin;

import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.textilemc.ModMenuFL.gui.screen.ModMenuScreen;
import net.textilemc.textile.gui.api.SizedButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
	@Inject(at = @At("TAIL"), method = "init")
	private void injectButton (CallbackInfo ci) {
		this.screenItems.add(new SizedButton(3, 25, 25, 50, 20, "Mods"));
		//int id, int var2, int var3, int var4, int var5, String var6
	}

	@Inject(at = @At("TAIL"), method = "onButtonClicked")
	private void buttonClicked(Button arg, CallbackInfo ci) {
		if (arg.id == 3) {
			// Mods button was clicked
			this.mc.showScreen(new ModMenuScreen(this));
		}
	}
}
