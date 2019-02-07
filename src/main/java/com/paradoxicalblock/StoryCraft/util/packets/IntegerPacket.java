package com.paradoxicalblock.StoryCraft.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class IntegerPacket implements IMessage {
	  public IntegerPacket(){}

	  int toSend;
	  public IntegerPacket(int toSend) {
	    this.toSend = toSend;
	  }

	  @Override public void toBytes(ByteBuf buf) {
	    buf.writeInt(toSend);
	  }

	  @Override public void fromBytes(ByteBuf buf) {
	    toSend = buf.readInt();
	  }
	}
