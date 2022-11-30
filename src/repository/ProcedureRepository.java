package repository;

import java.util.UUID;

public abstract class ProcedureRepository<T> extends Repository<T> {

    public ProcedureRepository(String fileName) {
        super(fileName);
    }

    public abstract T get(UUID id);

    public abstract void modify(UUID id, T objT);
    
}
