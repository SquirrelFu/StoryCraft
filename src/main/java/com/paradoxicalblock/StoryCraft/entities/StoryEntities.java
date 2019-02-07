package com.paradoxicalblock.StoryCraft.entities;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StoryEntities {
	static ResourceLocation mobTexture = new ResourceLocation("storycraft:textures/entity/ender_girl_skin.png");

	public static void init()
	{
		int id = 1;
        EntityRegistry.registerModEntity(mobTexture, SocialVillager.class, "SocialVillager", id++, StoryCraft.instance, 64, 3, true, 0x996600, 0x00ff00);
	}
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(SocialVillager.class, RenderSocialVillager.FACTORY);
    }
}
