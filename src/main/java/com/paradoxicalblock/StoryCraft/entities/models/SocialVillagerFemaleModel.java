package com.paradoxicalblock.StoryCraft.entities.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;

public class SocialVillagerFemaleModel extends ModelPlayer {

	public SocialVillagerFemaleModel() {
		super(0.5F, true);
		
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		setRotationAngles(scale, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, entityIn);
		GL11.glPushMatrix();
		GL11.glTranslatef(0F, 1.5F-1.5F*0.9F, 0F); 
		GL11.glScalef(0.9F,0.9F,0.9F);
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GL11.glPopMatrix();
	}
}

