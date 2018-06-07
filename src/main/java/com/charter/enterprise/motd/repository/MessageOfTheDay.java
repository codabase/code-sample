package com.charter.enterprise.motd.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MessageOfTheDay {

	@Id
	@GeneratedValue
	private Long id;
	private String msg;



	private MessageOfTheDay() {
		super();
	}
	public MessageOfTheDay(String name) {
		this();
		this.msg = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MessageOfTheDay ) {
			return this.msg.equals(obj);
		}
		return false;
	}
}
