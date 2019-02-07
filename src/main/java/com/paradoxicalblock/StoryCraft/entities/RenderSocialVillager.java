package com.paradoxicalblock.StoryCraft.entities;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSocialVillager extends RenderLiving<SocialVillager>{
	private ResourceLocation mobTexture = new ResourceLocation("storycraft:textures/entity/ender_girl_skin.png");
	public static final Factory FACTORY = new Factory();
	public RenderSocialVillager(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelPlayer(0.5F, true), 0.5F);
	}
	

	@Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull SocialVillager entity) {
        return mobTexture;
    }
	 public static class Factory implements IRenderFactory<SocialVillager> {

	        @Override
	        public Render<? super SocialVillager> createRenderFor(RenderManager manager) {
	            return new RenderSocialVillager(manager);
	        }

	    }
}
