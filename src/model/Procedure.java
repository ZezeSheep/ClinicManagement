package model;

import java.util.UUID;

public class Procedure {
	
	protected String name;
	private UUID id;

    public Procedure(UUID id) {
		super();
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
