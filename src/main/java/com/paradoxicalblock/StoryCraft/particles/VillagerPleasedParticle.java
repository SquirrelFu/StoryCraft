package com.paradoxicalblock.StoryCraft.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class VillagerPleasedParticle extends Particle {
	private final ResourceLocation plus = new ResourceLocation("storycraft:particle/plus_small");
	public VillagerPleasedParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		this.motionX *= 0.009999999776482582D + xSpeedIn;
        this.motionY *= 0.009999999776482582D + ySpeedIn;
        this.motionZ *= 0.009999999776482582D + zSpeedIn;
		this.posX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.setMaxAge(16);
        this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(plus.toString()));
	}
	
	@Override
	public int getFXLayer()
	{
		return 1;
	}
}
