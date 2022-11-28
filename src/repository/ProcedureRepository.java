package repository;

public abstract class ProcedureRepository<T> extends Repository<T> {

    public ProcedureRepository(String fileName) {
        super(fileName);
    }

    public abstract T get(int id);
    
}
