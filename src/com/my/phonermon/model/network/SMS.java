package com.my.phonermon.model.network;

import java.util.Date;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.my.phonermon.MyApplication;

public class SMS extends BaseBmobObject {
	
	private static final long serialVersionUID = 7606768867338772381L;
	
	public static final int Receive = 1;
	public static final int Send = 2;
	
	private String sender;
	private String receiver;
	private String smsMsg;
	private Date senderTime;
	private String imei;
	private String imsi;
	private String mac;
	private String brand;
	private String model;
	private Integer status;
	private String statusText;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSmsMsg() {
		return smsMsg;
	}

	public void setSmsMsg(String smsMsg) {
		this.smsMsg = smsMsg;
	}

	public Date getSenderTime() {
		return senderTime;
	}

	public void setSenderTime(Date senderTime) {
		this.senderTime = senderTime;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
		if(status == Receive){
			statusText = "接收";
		}else{
			statusText = "发送";
		}
	}
	
	public static void queryAll(FindListener<SMS> listener){
		BmobQuery<SMS> query = new BmobQuery<SMS>();
		query.findObjects(MyApplication.getMe(), listener);
	}

}
