package models;

public class Complaint {
	private String text;
	private long id;

	public Complaint(long id, String text) {
		this.id = id;
		this.text = text;
	}

	@Override
	public String toString() {
		return id + ": " + text;
	}

}
