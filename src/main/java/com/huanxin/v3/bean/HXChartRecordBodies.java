package com.huanxin.v3.bean;

public class HXChartRecordBodies {
	private String type;  //消息类型。txt: 文本消息；img: 图片；loc: 位置；audio: 语音
	private String msg;
	private Integer length;  // 语音时长，单位为秒，这个属性只有语音消息有
	private String url;      //图片语音等文件的网络URL，图片和语音消息有这个属性
	private String filename; //文件名字，图片和语音消息有这个属性
	private String secret;   //获取文件的secret，图片和语音消息有这个属性

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
