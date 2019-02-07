package com.paradoxicalblock.StoryCraft.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 
@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        final Block[] blocks = {
        };
 
        event.getRegistry().registerAll(blocks);
    }
    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
 
        final Item[] itemBlocks = {
        };
 
        event.getRegistry().registerAll(itemBlocks);
 
    }
}
