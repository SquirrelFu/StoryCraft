package com.paradoxicalblock.StoryCraft.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.paradoxicalblock.StoryCraft.Social.PersonalManager;

import net.minecraft.client.Minecraft;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SocialVillagerMale extends SocialVillager {
	private String firstName = "";
	private String lastName = "";
	public DataParameter<String> uuidKey;
	
	public SocialVillagerMale(World worldIn) {
		super(worldIn);
		setSize(0.5F, 1.95F);
		boolean nameBool = new Random().nextBoolean();
		setFirstName(nameBool);
		setLastName();
		this.setCustomNameTag(firstName + " " + lastName);
		}
	@Override 
	public void entityInit()
	{	
		super.entityInit();
		maleCareerSkins = new ArrayList<Integer>();
		maleCareerSkins.add(6);
		maleCareerSkins.add(5);
		maleCareerSkins.add(5);
		maleCareerSkins.add(6);
		maleCareerSkins.add(5);
		maleCareerSkins.add(5);
		maleCareerSkins.add(5);
		maleCareerSkins.add(6);
		Random rand = new Random();
		int friendly = rand.nextInt(200) - 100;
		int brave = rand.nextInt(200) - 100;
		int generous = rand.nextInt(200) - 100;
		career = rand.nextInt(8);
		appearance = new Random().nextInt(maleCareerSkins.get(career));
		if (!world.isRemote)
		{
			int sexualityInt = new Random().nextInt(9);
			if (sexualityInt == 9)
			{
				boolean sexualityBool = new Random().nextBoolean();
				if (sexualityBool == true)
				{
					sexuality = "Bisexual";
				}
				else
				{
					sexuality = "Gay";
				}
			}
			else
			{
				sexuality = "Straight";
			}
			PersonalManager manager = PersonalManager.get(world);
			
			
			if (manager.getAppearance(getUniqueID().toString()) != null)
			{
				appearance = manager.getAppearance(getUniqueID().toString());
			}
			manager.addPersonality(getUniqueID().toString(), friendly, generous, brave, sexuality, appearance, career);
			
		}
		
	}
	public void setFirstName(boolean gender)
	{
		String nameToApply = "";
		
		if (gender == true)
		{
			List<String> maleNames = readFile("storycraft:names/malenames.txt");
			if (maleNames != null)
			{
				int nameIndex = new Random().nextInt(maleNames.size() - 1);
				nameToApply = maleNames.get(nameIndex);
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
}
