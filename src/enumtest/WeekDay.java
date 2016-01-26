package enumtest;

public enum WeekDay {
	Sunday("星期日"),
	Monday(""),
	Tuesday(""),
	Wednesday(""),
	Thursday(""),
	Friday(""),
	Saturday("");
	private String description;
	private WeekDay(String description){
		this.setDescription(description);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static void main(String[] args) {
		for (WeekDay week:WeekDay.values()) {
			System.out.println(week.ordinal()+":"+week.name()+":"+week.getDescription());
		}
	}
}
