package com.paradoxicalblock.StoryCraft.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSocialVillagerMale extends RenderLiving<SocialVillagerMale>{
	private List<ResourceLocation> bakerList = new ArrayList<ResourceLocation>();
	//Gray hair, brown eyes, dark skin
	private ResourceLocation baker1 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm1.png");
	//Brown hair, brown eyes, light skin
	private ResourceLocation baker2 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm2.png");
	//Brown hair, blue eyes, light skin
	private ResourceLocation baker3 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm3.png");
	//Red hair, blue eyes, light skin
	private ResourceLocation baker4 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm4.png");
	//Blonde hair, blue eyes, light skin
	private ResourceLocation baker5 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm5.png");
	//Black hair, brown eyes, light skin
	private ResourceLocation baker6 = new ResourceLocation("storycraft:textures/entity/maleskins/bakerm6.png");
	private List<ResourceLocation> butcherList = new ArrayList<ResourceLocation>();
	private ResourceLocation butcher1 = new ResourceLocation("storycraft:textures/entity/maleskins/butcherm1.png");
	private ResourceLocation butcher2 = new ResourceLocation("storycraft:textures/entity/maleskins/butcherm2.png");
	private ResourceLocation butcher3 = new ResourceLocation("storycraft:textures/entity/maleskins/butcherm3.png");
	private ResourceLocation butcher4 = new ResourceLocation("storycraft:textures/entity/maleskins/butcherm4.png");
	private ResourceLocation butcher5 = new ResourceLocation("storycraft:textures/entity/maleskins/butcherm5.png");
	private List<ResourceLocation> farmerList = new ArrayList<ResourceLocation>();
	private ResourceLocation farmer1 = new ResourceLocation("storycraft:textures/entity/maleskins/farmerm1.png");
	private ResourceLocation farmer2 = new ResourceLocation("storycraft:textures/entity/maleskins/farmerm2.png");
	private ResourceLocation farmer3 = new ResourceLocation("storycraft:textures/entity/maleskins/farmerm3.png");
	private ResourceLocation farmer4 = new ResourceLocation("storycraft:textures/entity/maleskins/farmerm4.png");
	private ResourceLocation farmer5 = new ResourceLocation("storycraft:textures/entity/maleskins/farmerm5.png");
	private List<ResourceLocation> guardList = new ArrayList<ResourceLocation>();
	private ResourceLocation guard1 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm1.png");
	private ResourceLocation guard2 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm2.png");
	private ResourceLocation guard3 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm3.png");
	private ResourceLocation guard4 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm4.png");
	private ResourceLocation guard5 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm5.png");
	private ResourceLocation guard6 = new ResourceLocation("storycraft:textures/entity/maleskins/guardm6.png");
	private List<ResourceLocation> librarianList = new ArrayList<ResourceLocation>();
	private ResourceLocation librarian1 = new ResourceLocation("storycraft:textures/entity/maleskins/librarianm1.png");
	private ResourceLocation librarian2 = new ResourceLocation("storycraft:textures/entity/maleskins/librarianm2.png");
	private ResourceLocation librarian3 = new ResourceLocation("storycraft:textures/entity/maleskins/librarianm3.png");
	private ResourceLocation librarian4 = new ResourceLocation("storycraft:textures/entity/maleskins/librarianm4.png");
	private ResourceLocation librarian5 = new ResourceLocation("storycraft:textures/entity/maleskins/librarianm5.png");
	private List<ResourceLocation> minerList = new ArrayList<ResourceLocation>();
	private ResourceLocation miner1 = new ResourceLocation("storycraft:textures/entity/maleskins/minerm1.png");
	private ResourceLocation miner2 = new ResourceLocation("storycraft:textures/entity/maleskins/minerm2.png");
	private ResourceLocation miner3 = new ResourceLocation("storycraft:textures/entity/maleskins/minerm3.png");
	private ResourceLocation miner4 = new ResourceLocation("storycraft:textures/entity/maleskins/minerm4.png");
	private ResourceLocation miner5 = new ResourceLocation("storycraft:textures/entity/maleskins/minerm5.png");
	private List<ResourceLocation> priestList = new ArrayList<ResourceLocation>();
	private ResourceLocation priest1 = new ResourceLocation("storycraft:textures/entity/maleskins/priestm1.png");
	private ResourceLocation priest2 = new ResourceLocation("storycraft:textures/entity/maleskins/priestm2.png");
	private ResourceLocation priest3 = new ResourceLocation("storycraft:textures/entity/maleskins/priestm3.png");
	private ResourceLocation priest4 = new ResourceLocation("storycraft:textures/entity/maleskins/priestm4.png");
	private ResourceLocation priest5 = new ResourceLocation("storycraft:textures/entity/maleskins/priestm5.png");
	private List<ResourceLocation> smithList = new ArrayList<ResourceLocation>();
	private ResourceLocation smith1 = new ResourceLocation("storycraft:textures.entity/maleskins/smithm1.png");
	private ResourceLocation smith2 = new ResourceLocation("storycraft:textures.entity/maleskins/smithm2.png");
	private ResourceLocation smith3 = new ResourceLocation("storycraft:textures.entity/maleskins/smithm3.png");
	private ResourceLocation smith4 = new ResourceLocation("storycraft:textures.entity/maleskins/smithm4.png");
	private ResourceLocation smith5 = new ResourceLocation("storycraft:textures.entity/maleskins/smithm5.png");
	private List<ResourceLocation> warriorList = new ArrayList<ResourceLocation>();
	private ResourceLocation warrior1 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm1.png");
	private ResourceLocation warrior2 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm2.png");
	private ResourceLocation warrior3 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm3.png");
	private ResourceLocation warrior4 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm4.png");
	private ResourceLocation warrior5 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm5.png");
	private ResourceLocation warrior6 = new ResourceLocation("storycraft:textures/entity/maleskins/warriorm6.png");

	public static final Factory FACTORY = new Factory();
	public RenderSocialVillagerMale (RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelPlayer(0.5F, false), 0.5F);
	}
	

	@Override
    @Nonnull
    protected ResourceLocation getEntityTexture(@Nonnull SocialVillagerMale entity) {
		Integer appearance = -1;
		Integer career = -1;
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
		butcherList.add(butcher5);
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
		warriorList.add(warrior6);
		if (career == 0)
		{
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
			return smithList.get(appearance);
		}
		if (career == 8)
		{
			return warriorList.get(appearance);
		}
		return new ResourceLocation("storycraft:textures/entity/steve.png");
    }
	
	public static class Factory implements IRenderFactory<SocialVillagerMale> {

	        @Override
	        public Render<? super SocialVillagerMale> createRenderFor(RenderManager manager) {
	            return new RenderSocialVillagerMale(manager);
	        }

	    }
}
