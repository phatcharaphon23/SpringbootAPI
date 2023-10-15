package com.example.demo.models;

public class RaponseCutomize {

	private boolean success;
	private Object messege;
	
	public RaponseCutomize(){
		
	}

	/**
	 * @param success
	 * @param messege
	 */
	public RaponseCutomize(boolean success, Object messege) {
		
		this.success = success;
		this.messege = messege;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getMessege() {
		return messege;
	}

	public void setMessege(Object messege) {
		this.messege = messege;
	}
}
