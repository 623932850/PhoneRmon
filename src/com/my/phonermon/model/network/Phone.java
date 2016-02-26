package com.my.phonermon.model.network;

import java.util.Date;

import cn.bmob.v3.BmobObject;

public class Phone extends BmobObject {

	private static final long serialVersionUID = 4651090820245503392L;
	
	public static final int INCOMINE = 1;
	public static final int OUTGOING = 2;

	/**来电电话号码，去电时为本机号码*/
	private String fromPhoneNumber;
	/**去电电话号码，来电时为本机号码*/
	private String toPhoneNumber;
	/**电话拨打时间*/
	private Date callTime;
	/**手机唯一码*/
	private String imei;
	/**SIM卡唯一码*/
	private String imsi;
	/**mac地址*/
	private String mac;
	/**品牌*/
	private String brand;
	/**型号*/
	private String model;
	/**型号*/
	private Integer callType;
	/**型号*/
	private String callTypeText;

	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}

	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

	public String getToPhoneNumber() {
		return toPhoneNumber;
	}

	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
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

	public Integer getCallType() {
		return callType;
	}

	public void setCallType(Integer callType) {
		this.callType = callType;
	}

	public String getCallTypeText() {
		return callTypeText;
	}

	public void setCallTypeText(String callTypeText) {
		this.callTypeText = callTypeText;
	}

	public void setStatus(Integer status) {
		this.callType = status;
		if(status == INCOMINE){
			callTypeText = "呼入";
		}else{
			callTypeText = "呼出";
		}
	}

}
