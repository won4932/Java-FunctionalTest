package com.reservation.reservationevent.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	private String type;
	private String sender;
	private String receiver;
	private String roles;
	private String data;

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void newConnect() {
		this.type = "new";
	}

	public void closeConnect() {
		this.type = "close";
	}
}
