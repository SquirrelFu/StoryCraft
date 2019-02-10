package com.paradoxicalblock.StoryCraft.util.packets;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class InsultPacket implements IMessage {

	public Long MSB;
	public Long LSB;
	public InsultPacket(){}
	  
	public InsultPacket(UUID toSend) {
		this.MSB = toSend.getMostSignificantBits();
		this.LSB = toSend.getLeastSignificantBits();
	}

	@Override public void toBytes(ByteBuf buf) {
			buf.writeLong(MSB);
			buf.writeLong(LSB);
	}

	@Override public void fromBytes(ByteBuf buf) {
			MSB = buf.readLong();
			LSB = buf.readLong();
	}
}