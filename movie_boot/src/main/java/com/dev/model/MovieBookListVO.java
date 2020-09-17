package com.dev.model;

import lombok.Data;

@Data
public class MovieBookListVO {
	private String ticket_num;
	private String seat_code;
	private int final_price;
	private String theater_name;
	private String movie_name;
}
