package com.paradoxicalblock.StoryCraft.proxy;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;
import com.paradoxicalblock.StoryCraft.entities.StoryEntities;
import com.paradoxicalblock.StoryCraft.util.StoryCraftPacketHandler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
 
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event)
    {
    	StoryEntities.init();
    	StoryCraftPacketHandler.RegisterMessages();
    }
 
    public void init(FMLInitializationEvent event)
    {
    	NetworkRegistry.INSTANCE.registerGuiHandler(StoryCraft.instance, new GuiProxy());
    	
    }
 
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    }
 
}
