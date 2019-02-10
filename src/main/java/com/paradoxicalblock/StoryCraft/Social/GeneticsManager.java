package com.paradoxicalblock.StoryCraft.Social;

import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class GeneticsManager extends WorldSavedData {
	private static final String DATA_NAME = StoryCraft.MODID + "_GeneticsData";
	private NBTTagCompound genetics = new NBTTagCompound();
	public GeneticsManager(String name) {
		super(name);
	}
	public GeneticsManager()
	{
		super(DATA_NAME);
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		genetics = nbt.getCompoundTag("Genetics");
		
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("Genetics", genetics);
		return compound;
	}
	public static GeneticsManager get(World world)
	{
		MapStorage storage = world.getMapStorage();
		GeneticsManager instance = (GeneticsManager) storage.getOrLoadData(GeneticsManager.class,DATA_NAME);
		if (instance == null)
		{
			instance = new GeneticsManager();
			storage.setData(DATA_NAME, instance);
		}
		return instance;
	}
	public void addGenome(UUID holder)
	{
		NBTTagCompound genome = new NBTTagCompound();
		genome.setString("Eyes", "Brown");
		genome.setString("Hair", "Black");
		genome.setString("Skin", "Dark");
		genetics.setTag(holder.toString(), genome);
	}
	public void addGenome(UUID holder, String skin)
	{
		NBTTagCompound genome = new NBTTagCompound();
		genome.setString("Eyes", "Brown");
		genome.setString("Hair", "Black");
		genome.setString("Skin", skin);
		genetics.setTag(holder.toString(), genome);
	}
	public void addGenome(UUID holder, String skin, String hair)
	{
		NBTTagCompound genome = new NBTTagCompound();
		genome.setString("Eyes", "Brown");
		genome.setString("Hair", hair);
		genome.setString("Skin", skin);
		genetics.setTag(holder.toString(), genome);
	}
	public void addGenome(UUID holder, String skin, String hair, String eyes)
	{
		NBTTagCompound genome = new NBTTagCompound();
		genome.setString("Eyes", eyes);
		genome.setString("Hair", hair);
		genome.setString("Skin", skin);
		genetics.setTag(holder.toString(), genome);
	}
}
