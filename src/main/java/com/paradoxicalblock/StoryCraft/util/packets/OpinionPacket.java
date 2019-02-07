package com.paradoxicalblock.StoryCraft.util.packets;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class OpinionPacket implements IMessage {
	  public OpinionPacket(){}

	  public Long MSB;
	  public Long LSB;
	  public int magnitude;
	  public OpinionPacket(UUID toSend, int magnitude) {
	    this.MSB = toSend.getMostSignificantBits();
	    this.LSB = toSend.getLeastSignificantBits();
	    this.magnitude = magnitude;
	  }

	  @Override public void toBytes(ByteBuf buf) {
	    buf.writeLong(this.MSB);
	    buf.writeLong(this.LSB);
	    buf.writeInt(this.magnitude);
	  }

	  @Override public void fromBytes(ByteBuf buf) {
	    MSB = buf.readLong();
	    LSB = buf.readLong();
	    magnitude = buf.readInt();
	  }
	}
