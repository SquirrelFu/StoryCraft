package com.paradoxicalblock.StoryCraft.Social;

import java.util.Random;
import java.util.UUID;

public class Personality {

	private int friendliness;
	private int generosity;
	private int bravery;
	private UUID holder;
	public Personality(int friendly, int generous, int brave, UUID holder )
	{
		this.friendliness = friendly;
		this.generosity = generous;
		this.bravery = brave;
		this.holder = holder;
	}
	public Personality(int generous, int brave, UUID holder)
	{
		this.friendliness = new Random().nextInt(200) - 100;
		this.generosity = generous;
		this.bravery = brave;
		this.holder = holder;
	}
	public Personality(int brave, UUID holder)
	{
		this.friendliness = new Random().nextInt(200) - 100;
		this.generosity = new Random().nextInt(200) - 100;
		this.bravery = brave;
		this.holder = holder;
	}
	public Personality(UUID holder)
	{
		this.friendliness = new Random().nextInt(200) - 100;
		this.generosity = new Random().nextInt(200) - 100;
		this.bravery = new Random().nextInt(200) - 100;
		this.holder = holder;
	}
	public int getFriendly()
	{
		return this.friendliness;
	}
	public int getGenerous()
	{
		return this.generosity;
	}
	public int getBrave()
	{
		return this.bravery;
	}
	public UUID getHolder()
	{
		return this.holder;
	}
}
