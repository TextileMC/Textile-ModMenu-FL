package net.textilemc.ModMenuFL.gui.screen;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.Button;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.textilemc.textile.gui.api.SizedButton;

import java.util.concurrent.atomic.AtomicInteger;

public class ModMenuScreen extends Screen {
	public Screen parent;

	public ModMenuScreen(Screen parent) {
		this.parent = parent;
	}

	@Override
	public void init() {
		this.screenItems.add(new SizedButton(1, 0, 0, 75, 20, "Go back"));
	}

	@Override
	public final void onButtonClicked(Button arg) {
		if (arg.id == 1) {
			// Go back to Title Screen
			this.mc.showScreen(new TitleScreen());
		}
	}

	@Override
	public void render(int mouseX, int mouseY, float delta) {
		this.method_584();
		renderText(this.field_917, "Mods", this.screenWidth / 2, 20, 16777215);

		AtomicInteger counter = new AtomicInteger(40);
		FabricLoader.getInstance().getAllMods().stream().forEachOrdered(modContainer -> {
			renderText(this.field_917, modContainer.getMetadata().getName(), this.screenWidth / 4, counter.get(), 16777215);
			renderText(this.field_917, String.valueOf(modContainer.getMetadata().getVersion()), this.screenWidth - 50, counter.get(), 16777215);
			renderText(this.field_917, modContainer.getMetadata().getDescription(), this.screenWidth / 3, counter.get() + 10, 16777215);
			counter.addAndGet(20);
		});
		super.render(mouseX, mouseY, delta);
	}
}
