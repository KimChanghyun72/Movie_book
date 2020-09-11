package com.dev.model;

public class MovieVO {
	private String movie_code;
	private String movie_name;
	private String movie_time;
	private String movie_director;
	private int movie_price;
	private String movie_poster;
	private String movie_grade;

	public MovieVO() {
	}

	public MovieVO(String movie_code, String movie_name, String movie_time, String movie_director, int movie_price,
			String movie_poster, String movie_grade) {
		super();
		this.movie_code = movie_code;
		this.movie_name = movie_name;
		this.movie_time = movie_time;
		this.movie_director = movie_director;
		this.movie_price = movie_price;
		this.movie_poster = movie_poster;
		this.movie_grade = movie_grade;
	}

	@Override
	public String toString() {
		return "MovieVO [movie_code=" + movie_code + ", movie_name=" + movie_name + ", movie_time=" + movie_time
				+ ", movie_director=" + movie_director + ", movie_price=" + movie_price + ", movie_poster="
				+ movie_poster + ", movie_grade=" + movie_grade + "]";
	}

	public String getMovie_code() {
		return movie_code;
	}

	public void setMovie_code(String movie_code) {
		this.movie_code = movie_code;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_time() {
		return movie_time;
	}

	public void setMovie_time(String movie_time) {
		this.movie_time = movie_time;
	}

	public String getMovie_director() {
		return movie_director;
	}

	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}

	public int getMovie_price() {
		return movie_price;
	}

	public void setMovie_price(int movie_price) {
		this.movie_price = movie_price;
	}

	public String getMovie_poster() {
		return movie_poster;
	}

	public void setMovie_poster(String movie_poster) {
		this.movie_poster = movie_poster;
	}

	public String getMovie_grade() {
		return movie_grade;
	}

	public void setMovie_grade(String movie_grade) {
		this.movie_grade = movie_grade;
	}

}
