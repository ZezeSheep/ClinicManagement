package repository;

public abstract class UserRepository<T> extends Repository<T> {

    public UserRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    // Retorna null quando nao encontrar correspondencias
    public abstract T get(String email);
    

}
