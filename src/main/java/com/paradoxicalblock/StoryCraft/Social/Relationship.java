package com.paradoxicalblock.StoryCraft.Social;

import java.util.UUID;

/*
 * This class is a single relationship between 
 */

public class Relationship {

	private UUID subject;
	private UUID object;
	private int opinion;
	private String context;
	private boolean charmAttempt = false;
	public Relationship(UUID subject, UUID object, int opinion, String context, boolean charmed)
	{
		this.subject = subject;
		this.object = object;
		this.opinion = opinion;
		this.context = context;
		this.charmAttempt = charmed;
	}
	public Relationship(UUID subject, UUID object, int opinion, String context)
	{
		this.subject = subject;
		this.object = object;
		this.opinion = opinion;
		this.context = context;
		this.charmAttempt = false;
	}
	public Relationship(UUID subject, UUID object, int opinion)
	{
		this.subject = subject;
		this.object = object;
		this.opinion = opinion;
		this.context = "Neutral";
		this.charmAttempt = false;
		
	}
	public Relationship(UUID subject, UUID object)
	{
		this.subject = subject;
		this.object = object;
		this.opinion = 0;
		this.context = "Neutral";
		this.charmAttempt = false;
	}
	public int getOpinion()
	{
		return this.opinion;
	}
	public void setOpinion(int newOpinion)
	{
		this.opinion = newOpinion;
	}
	public void modifyOpinion(int modifier)
	{
		this.opinion += modifier;
	}
	public String getContext()
	{
		return this.context;
	}
	public void setContext(String newContext)
	{
		this.context = newContext;
	}
	public boolean getCharmed()
	{
		return this.charmAttempt;
	}
	public void setCharmed()
	{
		this.charmAttempt = true;
	}
	public void resetCharmed()
	{
		this.charmAttempt = false;
	}
	public UUID getSubject()
	{
		return this.subject;
	}
	public UUID getObject()
	{
		return this.object;
	}
}
