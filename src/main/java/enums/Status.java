package enums;

public enum Status {
	
	EM_ANDAMENTO("Em Andamento"),
	CONCLUIDA("Concluida");
	
	private String description;
	
	Status(String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	
}
