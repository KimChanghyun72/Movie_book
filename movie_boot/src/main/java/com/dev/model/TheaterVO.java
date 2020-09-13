package com.dev.model;

public class TheaterVO {
	private String theater_code;
	private String screen_name;
	private String theater_name;

	public TheaterVO() {
	}

	public TheaterVO(String theater_code, String screen_name, String theater_name) {
		super();
		this.theater_code = theater_code;
		this.screen_name = screen_name;
		this.theater_name = theater_name;
	}

	@Override
	public String toString() {
		return "TheaterVO [theater_code=" + theater_code + ", screen_name=" + screen_name + ", theater_name="
				+ theater_name + "]";
	}

	public String getTheater_code() {
		return theater_code;
	}

	public void setTheater_code(String theater_code) {
		this.theater_code = theater_code;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

}
