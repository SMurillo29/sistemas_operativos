package com.smv.sistemas_operativos.models;

public class Response {

	 private boolean response;
	 private String message;

	public Response(boolean response, String message) {
		this.response = response;
		this.message = message;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
		
}
