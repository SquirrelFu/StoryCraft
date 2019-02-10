package com.paradoxicalblock.StoryCraft.entities;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StoryEntities {
	static ResourceLocation villagerMale = new ResourceLocation("storycraft:textures/entity/steve.png");
	static ResourceLocation villagerFemale = new ResourceLocation("storycraft:textures/entity/alex.png");

	public static void init()
	{
        EntityRegistry.registerModEntity(villagerMale, SocialVillagerMale.class, "SocialVillagerMale", 0, StoryCraft.instance, 64, 3, true, 0xadd8e6, 0x0008b);
        EntityRegistry.registerModEntity(villagerFemale, SocialVillagerFemale.class, "SocialVillagerFemale", 1, StoryCraft.instance, 64, 3, true, 0xffb6c1, 0xff1493);

	}
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(SocialVillagerMale.class, RenderSocialVillagerMale.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(SocialVillagerFemale.class, RenderSocialVillagerFemale.FACTORY);
    }
}
