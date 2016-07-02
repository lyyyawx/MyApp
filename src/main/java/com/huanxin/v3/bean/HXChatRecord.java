package com.huanxin.v3.bean;

public class HXChatRecord {
	private String uuid;

	private String type;

	private int created;

	private int modified;

	private int timestamp;

	private String from;

	private String msg_id;

	private String to;

	private String chat_type;

	private HXChartRecordPayload payload;

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public int getCreated() {
		return this.created;
	}

	public void setModified(int modified) {
		this.modified = modified;
	}

	public int getModified() {
		return this.modified;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return this.from;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_id() {
		return this.msg_id;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTo() {
		return this.to;
	}

	public void setChat_type(String chat_type) {
		this.chat_type = chat_type;
	}

	public String getChat_type() {
		return this.chat_type;
	}

	public void setPayload(HXChartRecordPayload payload) {
		this.payload = payload;
	}

	public HXChartRecordPayload getPayload() {
		return this.payload;
	}

}