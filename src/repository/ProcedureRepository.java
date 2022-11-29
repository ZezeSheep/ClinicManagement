package repository;

public abstract class ProcedureRepository<T> extends Repository<T> {

    public ProcedureRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    public abstract T get(int id);

    public abstract void modify(int id, T objT);
    
}
