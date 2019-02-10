package com.paradoxicalblock.StoryCraft.proxy;

import com.paradoxicalblock.StoryCraft.entities.StoryEntities;
import com.paradoxicalblock.StoryCraft.particles.TextureStitcher;
import com.paradoxicalblock.StoryCraft.particles.VillagerDispleasedParticle;
import com.paradoxicalblock.StoryCraft.particles.VillagerPleasedParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
 
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        StoryEntities.initModels();
        MinecraftForge.EVENT_BUS.register(new TextureStitcher());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }


@Override
public void generatePleasedParticles(Entity theEntity)
{
    double motionX = theEntity.world.rand.nextGaussian() * 0.2D;
    double motionY = theEntity.world.rand.nextGaussian() * 0.2D;
    double motionZ = theEntity.world.rand.nextGaussian() * 0.2D;
    Particle particlePleased = new VillagerPleasedParticle(

          theEntity.world, 
          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 
          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() 

                * theEntity.height, 
          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 

          motionX, 

          motionY, 

          motionZ);
    Minecraft.getMinecraft().effectRenderer.addEffect(particlePleased);        
}
@Override
public void generateDispleasedParticles(Entity theEntity)
{
	double motionX = theEntity.world.rand.nextGaussian() * 0.2D;
    double motionY = theEntity.world.rand.nextGaussian() * 0.2D;
    double motionZ = theEntity.world.rand.nextGaussian() * 0.2D;
    Particle particleDispleased = new VillagerDispleasedParticle(

          theEntity.world, 
          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 
          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() 

                * theEntity.height, 
          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width 

                * 2.0F - theEntity.width, 

          motionX, 

          motionY, 

          motionZ);
    Minecraft.getMinecraft().effectRenderer.addEffect(particleDispleased);
}

}
