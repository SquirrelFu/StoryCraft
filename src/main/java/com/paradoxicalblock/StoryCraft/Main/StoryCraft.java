package com.paradoxicalblock.StoryCraft.Main;

import org.apache.logging.log4j.Logger;

import com.paradoxicalblock.StoryCraft.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 
@Mod(modid = StoryCraft.MODID, name = StoryCraft.NAME, version = StoryCraft.VERSION, acceptedMinecraftVersions = StoryCraft.MC_VERSION)
public class StoryCraft {
 
    public static final String MODID = "storycraft";
    public static final String NAME = "StoryCraft";
    public static final String VERSION = "1.0";
    public static final String MC_VERSION = "[1.12.2]";
 
    public static final String CLIENT = "com.paradoxicalblock.StoryCraft.proxy.ClientProxy";
    public static final String SERVER = "com.paradoxicalblock.StoryCraft.proxy.ServerProxy";
 
    @SidedProxy(clientSide = StoryCraft.CLIENT, serverSide = StoryCraft.SERVER)
    public static CommonProxy proxy;
    public static Logger logger;
    
    @Mod.Instance
    public static StoryCraft instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
 
}
