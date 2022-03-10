package com.panjohnny.magic;

import com.panjohnny.magic.blocks.MagicBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PJMagic implements ModInitializer {
	public static final String MOD_ID = "pj_magic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create(MOD_ID + ":resources");
	public static final DefaultParticleType COOL_PARTICLE = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		MagicBlocks.register();
//		Registry.register(Registry.PARTICLE_TYPE, MOD_ID+":cool_particle", COOL_PARTICLE);
	}
}
