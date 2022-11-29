package repository;

public abstract class UserRepository<T> extends Repository<T> {

    public UserRepository(String fileName) {
        super(fileName);
    }

    public abstract T get(String email);
    
    public abstract void modify(String email, T objT);

}
