package com.paradoxicalblock.StoryCraft.Social;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.paradoxicalblock.StoryCraft.Main.StoryCraft;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;

public class PersonalityManager extends WorldSavedData {
	private static List<Personality> outlooks = new ArrayList<Personality>();
	private static final String DATA_NAME = StoryCraft.MODID + "_PersonalityData";
	private static PersonalityManager INSTANCE = null;
	public PersonalityManager() {
		super(DATA_NAME);
	}
	public PersonalityManager(String s)
	{
		super(s);
	}
	public Personality getPersonality(UUID holder)
	{
		for (Personality viewpoint : outlooks)
		{
			if (viewpoint.getHolder().equals(holder))
			{
				return viewpoint;
			}
		}
		return null;
	}
	public void AddPersonality(UUID uuid)
	{
		outlooks.add(new Personality(uuid));
		markDirty();
	}
	public void AddPersonality(int bravery, UUID uuid)
	{
		outlooks.add(new Personality(bravery, uuid));
		markDirty();
	}
	public void AddPersonality(int generosity, int bravery, UUID uuid)
	{
		outlooks.add(new Personality(generosity, bravery, uuid));
		markDirty();
	}
	public void AddPersonality(int friendliness, int generosity, int bravery, UUID uuid)
	{
		outlooks.add(new Personality(friendliness, generosity, bravery, uuid));
		markDirty();
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		outlooks.clear();
		NBTTagList outlookList = nbt.getTagList("Personalities", 10);
		Iterator<NBTBase> outlookIter = outlookList.iterator();
		while (outlookIter.hasNext())
		{
			NBTTagCompound individualRelate = (NBTTagCompound) outlookIter.next();
			UUID holder = individualRelate.getUniqueId("Holder");
			int friendly = individualRelate.getInteger("Friendliness");
			int bravery = individualRelate.getInteger("Bravery");
			int generosity = individualRelate.getInteger("Generosity");
			Personality loadView = new Personality(friendly,generosity,bravery,holder);
			outlooks.add(loadView);
		}
		
	}
	public void personalitiesClear()
	{
		outlooks.clear();
		markDirty();
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		NBTTagCompound personalityFinal = new NBTTagCompound();
		NBTTagList viewpointList = new NBTTagList();
		for (Personality viewpoint : outlooks)
		{
			NBTTagCompound viewSave = new NBTTagCompound();
			viewSave.setInteger("Friendliness", viewpoint.getFriendly());
			viewSave.setInteger("Bravery", viewpoint.getBrave());
			viewSave.setInteger("Generosity", viewpoint.getGenerous());
			viewSave.setUniqueId("Holder", viewpoint.getHolder());
			viewpointList.appendTag(viewSave);
		}
		personalityFinal.setTag("Personalities", viewpointList);
		return personalityFinal;
	}
	public static void SetInstance(World world)
	{
		String tagname = StoryCraft.MODID + "_PersonalityData";
		MapStorage storage = world.getPerWorldStorage();
		PersonalityManager result = (PersonalityManager)storage.getOrLoadData(PersonalityManager.class, tagname);
		if (result == null) {
			result = new PersonalityManager(tagname);
			storage.setData(tagname, result);
		}
		INSTANCE = result;
	}
	public static void resetInstance() {
		INSTANCE = null;
	}
	public static PersonalityManager getInstance()
	{
		return INSTANCE;
	}	
}