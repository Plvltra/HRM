package com.zzx.dto;

import com.zzx.entity.Appointment;
import com.zzx.enums.AppointStateEnum;

public class AppointExecution {

	private long bookId;
	
	private int state;
	
	private String stateInfo;
	
	private Appointment appointment;
	
	public AppointExecution() {
	
	}
	
	public AppointExecution(long bookId, AppointStateEnum stateEnum) {
		this(bookId, stateEnum, null);
	}
	
	public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
		this.bookId = bookId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.appointment = appointment;
	}
	
	@Override
	public String toString() {
		String appoStr = appointment == null? "null" : this.appointment.toString();
		return "bookId:" + bookId + " state:" + state + " stateInfo:" + stateInfo
				+ " appointment:" + appoStr;
	}
}
