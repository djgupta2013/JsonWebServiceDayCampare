package bean;

public class DateNTime {
	private String startMonth,startYear,endMonth,endYear;
	
	
	
	public DateNTime(String startMonth,String startYear,String endMonth,String endYear) {
		this.startMonth=startMonth;
		this.startYear=startYear;
		this.endMonth=endMonth;
		this.endYear=endYear;
		
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	/*public DateNTime(int startMonth,int startYear,int endMonth,int endYear) {
		this.startMonth=startMonth;
		this.startYear=startYear;
		this.endMonth=endMonth;
		this.endYear=endYear;
		
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}*/
}
