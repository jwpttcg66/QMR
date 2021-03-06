package com.game.guild.message;

import com.game.message.Message;

import org.apache.mina.core.buffer.IoBuffer;

/** 
 * @author Commuication Auto Maker
 * 
 * @version 1.0.0
 * 
 * 更换帮旗名字消息
 */
public class ReqGuildChangeBannerNameToServerMessage extends Message{

	//帮会Id
	private long guildId;
	
	//旗帜名字
	private String bannerName;
	
	
	/**
	 * 写入字节缓存
	 */
	public boolean write(IoBuffer buf){
		//帮会Id
		writeLong(buf, this.guildId);
		//旗帜名字
		writeString(buf, this.bannerName);
		return true;
	}
	
	/**
	 * 读取字节缓存
	 */
	public boolean read(IoBuffer buf){
		//帮会Id
		this.guildId = readLong(buf);
		//旗帜名字
		this.bannerName = readString(buf);
		return true;
	}
	
	/**
	 * get 帮会Id
	 * @return 
	 */
	public long getGuildId(){
		return guildId;
	}
	
	/**
	 * set 帮会Id
	 */
	public void setGuildId(long guildId){
		this.guildId = guildId;
	}
	
	/**
	 * get 旗帜名字
	 * @return 
	 */
	public String getBannerName(){
		return bannerName;
	}
	
	/**
	 * set 旗帜名字
	 */
	public void setBannerName(String bannerName){
		this.bannerName = bannerName;
	}
	
	
	@Override
	public int getId() {
		return 121216;
	}

	@Override
	public String getQueue() {
		return null;
	}
	
	@Override
	public String getServer() {
		return null;
	}
	
	@Override
	public String toString(){
		StringBuffer buf = new StringBuffer("[");
		//帮会Id
		buf.append("guildId:" + guildId +",");
		//旗帜名字
		if(this.bannerName!=null) buf.append("bannerName:" + bannerName.toString() +",");
		if(buf.charAt(buf.length()-1)==',') buf.deleteCharAt(buf.length()-1);
		buf.append("]");
		return buf.toString();
	}
}