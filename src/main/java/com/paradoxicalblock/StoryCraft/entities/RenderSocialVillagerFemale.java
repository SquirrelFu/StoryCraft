package com.paradoxicalblock.StoryCraft.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.paradoxicalblock.StoryCraft.Social.GeneticsManager;
import com.paradoxicalblock.StoryCraft.entities.models.SocialVillagerFemaleModel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSocialVillagerFemale extends RenderLiving<SocialVillagerFemale>{
	private List<ResourceLocation> bakerList = new ArrayList<ResourceLocation>();
	//Note: Brown hair, blue eyes, light skin for this particular appearance
	private ResourceLocation baker1 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf1.png");
	//Brown hair, brown eyes, light skin.
	private ResourceLocation baker2 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf2.png");
	//Gray hair, brown eyes, light skin. Elder?
	private ResourceLocation baker3 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf3.png");
	//Blonde hair, blue eyes, light skin.
	private ResourceLocation baker4 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf4.png");
	//Brown hair, brown eyes, medium skin.
	private ResourceLocation baker5 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf5.png");
	//Black hair, brown eyes, dark skin
	private ResourceLocation baker6 = new ResourceLocation("storycraft:textures/entity/femaleskins/bakerf6.png");
	private List<ResourceLocation> butcherList = new ArrayList<ResourceLocation>();
	private ResourceLocation butcher1 = new ResourceLocation("storycraft:textures/entity/femaleskins/butcherf1.png");
	private ResourceLocation butcher2 = new ResourceLocation("storycraft:textures/entity/femaleskins/butcherf2.png");
	private ResourceLocation butcher3 = new ResourceLocation("storycraft:textures/entity/femaleskins/butcherf3.png");
	private ResourceLocation butcher4 = new ResourceLocation("storycraft:textures/entity/femaleskins/butcherf4.png");
	private List<ResourceLocation> farmerList = new ArrayList<ResourceLocation>();
	private ResourceLocation farmer1 = new ResourceLocation("storycraft:textures/entity/femaleskins/farmerf1.png");
	private ResourceLocation farmer2 = new ResourceLocation("storycraft:textures/entity/femaleskins/farmerf2.png");
	private ResourceLocation farmer3 = new ResourceLocation("storycraft:textures/entity/femaleskins/farmerf3.png");
	private ResourceLocation farmer4 = new ResourceLocation("storycraft:textures/entity/femaleskins/farmerf4.png");
	private ResourceLocation farmer5 = new ResourceLocation("storycraft:textures/entity/femaleskins/farmerf5.png");
	private List<ResourceLocation> guardList = new ArrayList<ResourceLocation>();
	private ResourceLocation guard1 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf1.png");
	private ResourceLocation guard2 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf2.png");
	private ResourceLocation guard3 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf3.png");
	private ResourceLocation guard4 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf4.png");
	private ResourceLocation guard5 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf5.png");
	private ResourceLocation guard6 = new ResourceLocation("storycraft:textures/entity/femaleskins/guardf6.png");
	private List<ResourceLocation> librarianList = new ArrayList<ResourceLocation>();
	private ResourceLocation librarian1 = new ResourceLocation("storycraft:textures/entity/femaleskins/librarianf1.png");
	private ResourceLocation librarian2 = new ResourceLocation("storycraft:textures/entity/femaleskins/librarianf2.png");
	private ResourceLocation librarian3 = new ResourceLocation("storycraft:textures/entity/femaleskins/librarianf3.png");
	private ResourceLocation librarian4 = new ResourceLocation("storycraft:textures/entity/femaleskins/librarianf4.png");
	private ResourceLocation librarian5 = new ResourceLocation("storycraft:textures/entity/femaleskins/librarianf5.png");
	private List<ResourceLocation> minerList = new ArrayList<ResourceLocation>();
	private ResourceLocation miner1 = new ResourceLocation("storycraft:textures/entity/femaleskins/minerf1.png");
	private ResourceLocation miner2 = new ResourceLocation("storycraft:textures/entity/femaleskins/minerf2.png");
	private ResourceLocation miner3 = new ResourceLocation("storycraft:textures/entity/femaleskins/minerf3.png");
	private ResourceLocation miner4 = new ResourceLocation("storycraft:textures/entity/femaleskins/minerf4.png");
	private ResourceLocation miner5 = new ResourceLocation("storycraft:textures/entity/femaleskins/minerf5.png");
	private List<ResourceLocation> priestList = new ArrayList<ResourceLocation>();
	private ResourceLocation priest1 = new ResourceLocation("storycraft:textures/entity/femaleskins/priestf1.png");
	private ResourceLocation priest2 = new ResourceLocation("storycraft:textures/entity/femaleskins/priestf2.png");
	private ResourceLocation priest3 = new ResourceLocation("storycraft:textures/entity/femaleskins/priestf3.png");
	private ResourceLocation priest4 = new ResourceLocation("storycraft:textures/entity/femaleskins/priestf4.png");
	private ResourceLocation priest5 = new ResourceLocation("storycraft:textures/entity/femaleskins/priestf5.png");
	private List<ResourceLocation> smithList = new ArrayList<ResourceLocation>();
	private ResourceLocation smith1 = new ResourceLocation("storycraft:textures/entity/femaleskins/smithf1.png");
	private ResourceLocation smith2 = new ResourceLocation("storycraft:textures/entity/femaleskins/smithf2.png");
	private ResourceLocation smith3 = new ResourceLocation("storycraft:textures/entity/femaleskins/smithf3.png");
	private ResourceLocation smith4 = new ResourceLocation("storycraft:textures/entity/femaleskins/smithf4.png");
	private ResourceLocation smith5 = new ResourceLocation("storycraft:textures/entity/femaleskins/smithf5.png");
	private List<ResourceLocation> warriorList = new ArrayList<ResourceLocation>();
	private ResourceLocation warrior1 = new ResourceLocation("storycraft:textures/entity/femaleskins/warriorf1.png");
	private ResourceLocation warrior2 = new ResourceLocation("storycraft:textures/entity/femaleskins/warriorf2.png");
	private ResourceLocation warrior3 = new ResourceLocation("storycraft:textures/entity/femaleskins/warriorf3.png");
	private ResourceLocation warrior4 = new ResourceLocation("storycraft:textures/entity/femaleskins/warriorf4.png");
	private ResourceLocation warrior5 = new ResourceLocation("storycraft:textures/entity/femaleskins/warriorf5.png");
	public static final Factory FACTORY = new Factory();
	public RenderSocialVillagerFemale (RenderManager rendermanagerIn) {
		super(rendermanagerIn, new SocialVillagerFemaleModel(), 0.5F);
	}
	

	@Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull SocialVillagerFemale entity) {
		Integer appearance = entity.appearance;
		Integer career = entity.career;
		bakerList.add(baker1);
		bakerList.add(baker2);
		bakerList.add(baker3);
		bakerList.add(baker4);
		bakerList.add(baker5);
		bakerList.add(baker6);
		butcherList.add(butcher1);
		butcherList.add(butcher2);
		butcherList.add(butcher3);
		butcherList.add(butcher4);
		farmerList.add(farmer1);
		farmerList.add(farmer2);
		farmerList.add(farmer3);
		farmerList.add(farmer4);
		farmerList.add(farmer5);
		guardList.add(guard1);
		guardList.add(guard2);
		guardList.add(guard3);
		guardList.add(guard4);
		guardList.add(guard5);
		guardList.add(guard6);
		librarianList.add(librarian1);
		librarianList.add(librarian2);
		librarianList.add(librarian3);
		librarianList.add(librarian4);
		librarianList.add(librarian5);
		minerList.add(miner1);
		minerList.add(miner2);
		minerList.add(miner3);
		minerList.add(miner4);
		minerList.add(miner5);
		priestList.add(priest1);
		priestList.add(priest2);
		priestList.add(priest3);
		priestList.add(priest4);
		priestList.add(priest5);
		smithList.add(smith1);
		smithList.add(smith2);
		smithList.add(smith3);
		smithList.add(smith4);
		smithList.add(smith5);
		warriorList.add(warrior1);
		warriorList.add(warrior2);
		warriorList.add(warrior3);
		warriorList.add(warrior4);
		warriorList.add(warrior5);
		GeneticsManager manager = GeneticsManager.get(entity.world);
		if (career == 0)
		{
			if (appearance == 0)
			{
				manager.addGenome(entity.getUniqueID(),"Light","Brown","Blue");
			}
			if (appearance == 1)
			{
				manager.addGenome(entity.getUniqueID(),"Light","Brown","Brown");
			}
			if (appearance == 2)
			{
				manager.addGenome(entity.getUniqueID(),"Light","Black","Brown");
			}
			if (appearance == 3)
			{
				manager.addGenome(entity.getUniqueID(),"Light","Blonde","Blue");
			}
			if (appearance == 4)
			{
				manager.addGenome(entity.getUniqueID(), "Medium", "Brown", "Brown");
			}
			if (appearance == 5)
			{
				manager.addGenome(entity.getUniqueID(), "Dark", "Black", "Brown");
			}
			return bakerList.get(appearance);
		}
		if (career == 1)
		{
			return butcherList.get(appearance);
		}
		if (career == 2)
		{
			return farmerList.get(appearance);
		}
		if (career == 3)
		{
			return guardList.get(appearance);
		}
		if (career == 4)
		{
			return librarianList.get(appearance);
		}
		if (career == 5)
		{
			return minerList.get(appearance);
		}
		if (career == 6)
		{
			return priestList.get(appearance);
		}
		if (career == 7)
		{
			return warriorList.get(appearance);
		}
		return new ResourceLocation("storycraft:textures/entity/alex.png");
		
    }
	
	public static class Factory implements IRenderFactory<SocialVillagerFemale> {

	        @Override
	        public Render<? super SocialVillagerFemale> createRenderFor(RenderManager manager) {
	            return new RenderSocialVillagerFemale(manager);
	        }

	    }
}
