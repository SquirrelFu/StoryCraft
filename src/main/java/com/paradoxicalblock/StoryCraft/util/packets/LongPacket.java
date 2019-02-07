package com.paradoxicalblock.StoryCraft.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class LongPacket implements IMessage {
	  public LongPacket(){}

	  Long toSend;
	  public LongPacket(Long toSend) {
	    this.toSend = toSend;
	  }

	  @Override public void toBytes(ByteBuf buf) {
	    buf.writeLong(this.toSend);
	  }

	  @Override public void fromBytes(ByteBuf buf) {
	    toSend = buf.readLong();
	  }
	}
