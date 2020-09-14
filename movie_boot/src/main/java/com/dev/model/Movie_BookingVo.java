package com.dev.model;

public class Movie_BookingVo {
	private String ticket_num;
	private String timetable_code;
	private String id;
	private String seat_code;
	private double ageComm_pct;
	private int final_price;

	public Movie_BookingVo() {
	}
	public Movie_BookingVo(String ticket_num) {
		this.ticket_num = ticket_num;
	}
	public Movie_BookingVo(String ticket_num, String timetable_code, String id, String seat_code, double ageComm_pct,
			int final_price) {
		super();
		this.ticket_num = ticket_num;
		this.timetable_code = timetable_code;
		this.id = id;
		this.seat_code = seat_code;
		this.ageComm_pct = ageComm_pct;
		this.final_price = final_price;
	}

	@Override
	public String toString() {
		return "Movie_BookingVo [ticket_num=" + ticket_num + ", timetable_code=" + timetable_code + ", id=" + id
				+ ", seat_code=" + seat_code + ", ageComm_pct=" + ageComm_pct + ", final_price=" + final_price + "]";
	}

	public String getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(String ticket_num) {
		this.ticket_num = ticket_num;
	}

	public String getTimetable_code() {
		return timetable_code;
	}

	public void setTimetable_code(String timetable_code) {
		this.timetable_code = timetable_code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeat_code() {
		return seat_code;
	}

	public void setSeat_code(String seat_code) {
		this.seat_code = seat_code;
	}

	public double getAgeComm_pct() {
		return ageComm_pct;
	}

	public void setAgeComm_pct(double ageComm_pct) {
		this.ageComm_pct = ageComm_pct;
	}

	public int getFinal_price() {
		return final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	
}
