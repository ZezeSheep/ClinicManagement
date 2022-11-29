package repository;

import java.util.UUID;

public abstract class ProcedureRepository<T> extends Repository<T> {

    public ProcedureRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    public abstract T get(UUID id);

    public abstract void modify(UUID id, T objT);
    
}
