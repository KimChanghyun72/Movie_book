
public class TimeTableVO {
	private String timetable_code;
	private String theater_code;
	private String movie_code;
	private String start_tione;
	private String end_time;
	private String screening_date;

	public TimeTableVO() {
	}

	public TimeTableVO(String timetable_code, String theater_code, String movie_code, String start_tione,
			String end_time, String screening_date) {
		super();
		this.timetable_code = timetable_code;
		this.theater_code = theater_code;
		this.movie_code = movie_code;
		this.start_tione = start_tione;
		this.end_time = end_time;
		this.screening_date = screening_date;
	}

	@Override
	public String toString() {
		return "TimeTableVO [timetable_code=" + timetable_code + ", theater_code=" + theater_code + ", movie_code="
				+ movie_code + ", start_tione=" + start_tione + ", end_time=" + end_time + ", screening_date="
				+ screening_date + "]";
	}

	public String getTimetable_code() {
		return timetable_code;
	}

	public void setTimetable_code(String timetable_code) {
		this.timetable_code = timetable_code;
	}

	public String getTheater_code() {
		return theater_code;
	}

	public void setTheater_code(String theater_code) {
		this.theater_code = theater_code;
	}

	public String getMovie_code() {
		return movie_code;
	}

	public void setMovie_code(String movie_code) {
		this.movie_code = movie_code;
	}

	public String getStart_tione() {
		return start_tione;
	}

	public void setStart_tione(String start_tione) {
		this.start_tione = start_tione;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getScreening_date() {
		return screening_date;
	}

	public void setScreening_date(String screening_date) {
		this.screening_date = screening_date;
	}

}
