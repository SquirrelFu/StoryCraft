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

public class RelationshipManager extends WorldSavedData {
	private static List<Relationship> relationships = new ArrayList<Relationship>();
	private static final String DATA_NAME = StoryCraft.MODID + "_SocialData";
	private static RelationshipManager INSTANCE;
	public RelationshipManager() {
		super(DATA_NAME);
	}
	public RelationshipManager(String s)
	{
		super(s);
	}
	public Relationship getRelationship(UUID subject, UUID object)
	{
		Iterator<Relationship> relateIter = relationships.iterator();
		while (relateIter.hasNext())
		{
			Relationship relate = relateIter.next();
			if (relate.getSubject().equals(subject) && relate.getObject().equals(object))
			{
				return relate;
			}
		}
		return null;
	}
	public List<Relationship> getAllRelationships()
	{
		return relationships;
	}
	public List<Relationship> getAllTargetRelationships(UUID subject)
	{
		List<Relationship> listOut = new ArrayList<Relationship>();
		for (Relationship relate : relationships)
		{
			if (relate.getSubject().equals(subject))
			{
				listOut.add(relate);
			}
		}
		return listOut;
	}
	public void AddRelationship(UUID subject, UUID object, int startingOpinion, String context)
	{
		relationships.add(new Relationship(subject, object, startingOpinion, context));
		this.markDirty();
	}
	public void AddRelationship(UUID subject, UUID object, int startingOpinion)
	{
		relationships.add(new Relationship(subject, object, startingOpinion, "Neutral"));
		this.markDirty();
	}
	public void AddRelationship(UUID subject, UUID object)
	{
		relationships.add(new Relationship(subject, object, 0, "Neutral"));
		this.markDirty();
	}
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		relationships.clear();
		NBTTagList relateList = nbt.getTagList("Relationships", 10);
		Iterator<NBTBase> relateIter = relateList.iterator();
		while (relateIter.hasNext())
		{
			NBTTagCompound individualRelate = (NBTTagCompound) relateIter.next();
			UUID subject = individualRelate.getUniqueId("Subject");
			UUID object = individualRelate.getUniqueId("Object");
			int opinion = individualRelate.getInteger("Opinion");
			String context = individualRelate.getString("Context");
			boolean charmed = individualRelate.getBoolean("Charmed");
			Relationship loadRelate = new Relationship(subject,object,opinion,context,charmed);
			relationships.add(loadRelate);
		}
		
	}
	public void relationsClear()
	{
		relationships.clear();
		this.markDirty();
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		StoryCraft.logger.info("writeToNBT called.");
		NBTTagList relationList = new NBTTagList();
		for (Relationship relate : relationships)
		{
			NBTTagCompound relateSave = new NBTTagCompound();
			relateSave.setInteger("Opinion", relate.getOpinion());
			relateSave.setString("Context", relate.getContext());
			relateSave.setBoolean("Charmed", relate.getCharmed());
			relateSave.setUniqueId("Subject", relate.getSubject());
			relateSave.setUniqueId("Object", relate.getObject());
			relationList.appendTag(relateSave);
		}
		compound.setTag("Relationships", relationList);
		return compound;
	}
	public static void SetInstance(World world)
	{
		String tagname = StoryCraft.MODID + "_SocialData";
		MapStorage storage = world.getMapStorage();
		RelationshipManager result = (RelationshipManager)storage.getOrLoadData(RelationshipManager.class, tagname);
		if (result == null) {
			result = new RelationshipManager(tagname);
			storage.setData(tagname, result);
		}
		INSTANCE = result;
	}
	public static void resetInstance() {
		INSTANCE = null;
	}
	public static RelationshipManager getInstance()
	{
		return INSTANCE;
	}
}
