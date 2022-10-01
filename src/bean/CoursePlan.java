package bean;

public class CoursePlan {
	
	private int planId;
	private int batchId;
	private int dayNumber;
	private String topic;
	private String ststus;
	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStstus() {
		return ststus;
	}
	public void setStstus(String ststus) {
		this.ststus = ststus;
	}
	public CoursePlan(int planId, int batchId, int dayNumber, String topic, String ststus) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.dayNumber = dayNumber;
		this.topic = topic;
		this.ststus = ststus;
	}
	public CoursePlan() {
		
	}
	@Override
	public String toString() {
		return "CoursePlan [planId=" + planId + ", batchId=" + batchId + ", dayNumber=" + dayNumber + ", topic=" + topic
				+ ", ststus=" + ststus + "]";
	}
	

}
