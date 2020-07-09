package com.zzx.enums;

public enum AppointStateEnum{
	SUCCESS(1,"ԤԼ�ɹ�"),
	NO_NUMBER(0, "��治��"), 
	REPEAT_APPOINT(-1, "�ظ�ԤԼ"), 
	INNER_ERROR(-2, "ϵͳ�쳣");
	
	private int state;
	private String stateInfo;
	
	private AppointStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}
	
	public static AppointStateEnum stateOf(int value) {
		for(AppointStateEnum stateEnum : AppointStateEnum.values()){
			if(stateEnum.getState() == value){
				return stateEnum;
			}
		}
		return null;
	}
}
