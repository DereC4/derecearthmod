package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class SitDownWolfProcedure extends MinecraftEarthModModElements.ModElement {
	public SitDownWolfProcedure(MinecraftEarthModModElements instance) {
		super(instance, 164);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure SitDownWolf!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency x for procedure SitDownWolf!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency y for procedure SitDownWolf!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency z for procedure SitDownWolf!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure SitDownWolf!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)) {
			if ((((entity.getPersistentData().getString("sit"))).equals("standing"))) {
				world.addParticle(ParticleTypes.SMOKE, x, y, z, 0, 1, 0);
				entity.getPersistentData().putString("sit", "sitting");
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 696, (int) 100, (false), (false)));
				entity.setSneaking((true));
			} else if ((((entity.getPersistentData().getString("sit"))).equals("sitting"))) {
				world.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, 0, 1, 0);
				entity.getPersistentData().putString("sit", "standing");
				entity.setSneaking((false));
			}
		}
	}
}
