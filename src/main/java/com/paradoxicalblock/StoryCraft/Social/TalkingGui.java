package com.paradoxicalblock.StoryCraft.Social;

import java.util.ArrayList;
import java.util.List;

import com.paradoxicalblock.StoryCraft.entities.SocialVillager;
import com.paradoxicalblock.StoryCraft.util.StoryCraftPacketHandler;
import com.paradoxicalblock.StoryCraft.util.packets.CharmPacket;
import com.paradoxicalblock.StoryCraft.util.packets.ExaminePacket;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
/*
 This gui is used for social interaction. It's largely the bread and butter of StoryCraft, as it defines in
 broad strokes how players will interact with NPCs.
 */
public class TalkingGui extends GuiScreen {
	private EntityPlayer player = Minecraft.getMinecraft().player;
	private GuiButton buttonPersuade;
	private GuiButton buttonSorry;
	private GuiButton buttonInsult;
	private GuiButton buttonChallenge;
	private GuiButton buttonTrade;
	private GuiButton buttonFollow;
	private GuiButton buttonGauge;
	private SocialVillager target;
	public float threshold;
	private List<GuiButton> Positive = new ArrayList<GuiButton>();
	private List<GuiButton> Negative = new ArrayList<GuiButton>();
	private List<GuiButton> Service = new ArrayList<GuiButton>();
	public TalkingGui(Entity target)
	{
		super();
		this.target = (SocialVillager) target;
	}
	@Override
	public void initGui()
	{
		super.initGui();
		//Category buttons
		this.buttonList.add(new GuiButton(1, (width - 50), (height - 20), 50, 20, "Positive"));
		this.buttonList.add(new GuiButton(2, (width - 100), (height - 20), 50, 20, "Negative"));
		this.buttonList.add(new GuiButton(3, (width - 150), (height - 20), 50, 20, "Services"));
		
		//Exit button
		this.buttonList.add(new GuiButton(4, width - 20, 0, 20, 20, "x"));
		
		//Button for complimenting, or otherwise displaying kindness and positivity
		this.buttonList.add(buttonPersuade = new GuiButton(5, (width - 50), (height - 40), 50, 20, "Charm"));
		Positive.add(buttonPersuade);
		buttonPersuade.visible = false;
		
		//Button for apologizing for minor offenses
		this.buttonList.add(buttonSorry = new GuiButton(6, (width - 50), (height - 60), 50, 20, "Apology"));
		Positive.add(buttonSorry);
		buttonSorry.visible = false;
		
		//Button for demeaning an individual without threatening their life
		this.buttonList.add(buttonInsult = new GuiButton(7, (width - 100), (height - 40), 50, 20, "Insult"));
		Negative.add(buttonInsult);
		buttonInsult.visible = false;
		
		//Button for challenging an individual to combat
		this.buttonList.add(buttonChallenge = new GuiButton(8, (width - 100), (height - 60), 50, 20, "Threaten"));
		Negative.add(buttonChallenge);
		buttonChallenge.visible = false;
		
		//Button for trading as per a vanilla villager
		this.buttonList.add(buttonTrade = new GuiButton(9, (width - 150), (height - 40), 50, 20, "Barter"));
		Service.add(buttonTrade);
		buttonTrade.visible = false;
		
		//Button for hiring an individual to fight for you
		this.buttonList.add(buttonFollow = new GuiButton(10, (width - 150), (height - 60), 50, 20, "Recruit"));
		Service.add(buttonFollow);
		buttonFollow.visible = false;
		
		//Debug button for checking opinion
		this.buttonList.add(buttonGauge = new GuiButton(11, (width - 50), (height - 80), 50, 20, "Examine"));
		Positive.add(buttonGauge);
		buttonGauge.visible = false;
		
	}
	@Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
	//Hides all, "Positive" category buttons
	private void HidePositive()
	{
		for(GuiButton button : Positive)
		{
			button.visible = false;
		}
	}
	//Hides all "Negative" category buttons
	private void HideNegative()
	{
		for(GuiButton button : Negative)
		{
			button.visible = false;
		}
	}
	//Hides all, "Service" category buttons
	private void HideService()
	{
		for(GuiButton button : Service)
		{
			button.visible = false;
		}
	}
	@Override
	protected void actionPerformed(GuiButton b)
	{
		//Positive category button
		if (b.id == 1)
		{
			HideNegative();
			HideService();
			if (buttonPersuade.visible == true)
			{
				HidePositive();
			}
			else
			{
				for(GuiButton button : Positive)
				{
					button.visible = true;
				}
			}
		}
		//Negative category button
		if (b.id == 2)
		{
			HidePositive();
			HideService();
			if(buttonInsult.visible == true)
			{
				HideNegative();
			}
			else
			{
				for(GuiButton button : Negative)
				{
					button.visible = true;
				}
			}
		}
		//Services category button
		if (b.id == 3)
		{
			HidePositive();
			HideNegative();
			if(buttonTrade.visible == true)
			{
				HideService();
			}
			else
				for(GuiButton button : Service)
				{
					button.visible = true;
				}
		}
		//X button for closing
		if (b.id == 4)
		{
			this.mc.displayGuiScreen((GuiScreen)null);
		}
		//Charm button
		if (b.id == 5)
		{
			StoryCraftPacketHandler.INSTANCE.sendToServer(new CharmPacket(target.getUniqueID()));
		}
		//Examine button
		if (b.id == 11)
		{
			StoryCraftPacketHandler.INSTANCE.sendToServer(new ExaminePacket(target.getUniqueID()));
		}
	}
}