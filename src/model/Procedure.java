package model;

import java.io.Serializable;

public class Procedure implements Serializable {
    private int id;

    public Procedure(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    
}
