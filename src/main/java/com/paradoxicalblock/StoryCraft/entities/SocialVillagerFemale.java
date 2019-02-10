package com.paradoxicalblock.StoryCraft.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class SocialVillagerFemale extends SocialVillager implements IEntityAdditionalSpawnData {
	private String firstName = "";
	private String lastName = "";
	public DataParameter<String> uuidKey;
	public SocialVillagerFemale(World worldIn) {
		super(worldIn);
		setSize(0.5F, 1.95F * 0.9F);
		boolean nameBool = new Random().nextBoolean();
		setFirstName(nameBool);
		setLastName();
		this.setCustomNameTag(firstName + " " + lastName);
		femaleCareerSkins = new ArrayList<Integer>();
		femaleCareerSkins.add(6);
		femaleCareerSkins.add(4);
		femaleCareerSkins.add(5);
		femaleCareerSkins.add(6);
		femaleCareerSkins.add(5);
		femaleCareerSkins.add(5);
		femaleCareerSkins.add(5);
		femaleCareerSkins.add(5);
	}
	public void entityInit()
	{	
		super.entityInit();
		
	}
	public void setFirstName(boolean gender)
	{
		String nameToApply = "";
		
		if (gender == true)
		{
			List<String> femaleNames = readFile("storycraft:names/femaleNames.txt");
			if (femaleNames != null)
			{
				int nameIndex = new Random().nextInt(femaleNames.size() - 1);
				nameToApply = femaleNames.get(nameIndex);
			}
		}
		else
		{
			List<String> unisexNames = readFile("storycraft:names/unisexnames.txt");
			if (unisexNames.size() > 0)
			{
				int nameIndex = new Random().nextInt(unisexNames.size() - 1);
				nameToApply = unisexNames.get(nameIndex);
			}
		}
		firstName = nameToApply;
	}
	public void setLastName()
	{
		List<String> surnames = readFile("storycraft:names/surnames.txt");
		int nameIndex = new Random().nextInt(surnames.size() - 1);
		lastName = surnames.get(nameIndex);
	}
	public List<String> readFile(String filePath)
	{
		InputStream binary = null;
		try {
			binary = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(filePath)).getInputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		InputStreamReader reader = new InputStreamReader(binary);
		BufferedReader buffer = new BufferedReader(reader);
		List<String> listOut = new ArrayList<String>();
		try {
			while (buffer.readLine() != null)
			{
				listOut.add(buffer.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (listOut.size() != 0)
		{
			return listOut;
		}
		else
		{
			return null;
		}
	}
	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(this.career);
		buffer.writeInt(this.appearance);
		
	}
	@Override
	public void readSpawnData(ByteBuf additionalData) {
		this.career = additionalData.readInt();
		this.appearance = additionalData.readInt();
		
	}
}
