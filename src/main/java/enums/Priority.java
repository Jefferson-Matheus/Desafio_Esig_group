package enums;

public enum Priority {
	BAIXA("BAIXA"),
	MEDIA("MÉDIA"),
	ALTA("ALTA");
	
	private String description;
	
	Priority(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
