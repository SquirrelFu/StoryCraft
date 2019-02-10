package com.paradoxicalblock.StoryCraft.particles;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcher {

	@SubscribeEvent
	public void textureStitchEventPre(TextureStitchEvent.Pre event)
	{
		ResourceLocation plus = new ResourceLocation("storycraft:particle/plus_small");
		ResourceLocation minus = new ResourceLocation("storycraft:particle/minus_small");
		event.getMap().registerSprite(plus);
		event.getMap().registerSprite(minus);
	}
}
