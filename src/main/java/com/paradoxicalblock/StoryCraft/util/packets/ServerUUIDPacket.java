package com.paradoxicalblock.StoryCraft.util.packets;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ServerUUIDPacket implements IMessage {
	
	public long MSB;
	public long LSB;
	public int entityID;
	public ServerUUIDPacket() {}
	public ServerUUIDPacket(UUID uuid, int entityID)
	{
		this.MSB = uuid.getMostSignificantBits();
		this.LSB = uuid.getLeastSignificantBits();
		this.entityID = entityID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		this.MSB = buf.readLong();
		this.LSB = buf.readLong();
		this.entityID = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(MSB);
		buf.writeLong(LSB);
		buf.writeInt(entityID);
		
	}

}
