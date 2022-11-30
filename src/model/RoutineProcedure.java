package model;

import java.io.Serializable;
import java.util.UUID;

public class RoutineProcedure extends Procedure implements Serializable{
	
	private static final long serialVersionUID = 7100179587555243994L;

    public RoutineProcedure(UUID id) {
        super(id);
    }
    
}
