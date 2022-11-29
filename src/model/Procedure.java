package model;

import java.io.Serializable;
import java.util.UUID;

public class Procedure implements Serializable {
	
	private static final long serialVersionUID = 7100179587555243994L;
	
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
