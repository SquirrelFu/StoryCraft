package com.paradoxicalblock.StoryCraft.proxy;

import com.paradoxicalblock.StoryCraft.Social.TalkingGui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {
	public GuiProxy()
	{
		
	}
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	return new TalkingGui(world.getEntityByID(x));
    }
}
