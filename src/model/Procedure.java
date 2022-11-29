package model;

import java.io.Serializable;
import java.util.UUID;

public class Procedure implements Serializable {
    private UUID id;

    public Procedure(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    
}
