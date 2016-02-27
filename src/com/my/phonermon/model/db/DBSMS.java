package com.my.phonermon.model.db;

public class DBSMS {
	private Integer _id;
	private Integer thread_id;
	private String address;
	private Integer person;
	private Long date;
	private Integer type;// 发短信为2，收到短信为1
	private String subject;
	private String body;

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Integer getThread_id() {
		return thread_id;
	}

	public void setThread_id(Integer thread_id) {
		this.thread_id = thread_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "SMS [_id=" + _id + ", thread_id=" + thread_id + ", address="
				+ address + ", person=" + person + ", date=" + date + ", type="
				+ type + ", subject=" + subject + ", body=" + body + "]";
	}
}
