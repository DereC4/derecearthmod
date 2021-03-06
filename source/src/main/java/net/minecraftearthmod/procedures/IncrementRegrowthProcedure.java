package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class IncrementRegrowthProcedure extends MinecraftEarthModModElements.ModElement {
	public IncrementRegrowthProcedure(MinecraftEarthModModElements instance) {
		super(instance, 93);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure IncrementRegrowth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("regrow")) <= 6005)) {
			entity.getPersistentData().putDouble("regrow", ((entity.getPersistentData().getDouble("regrow")) + 1));
		}
	}
}
