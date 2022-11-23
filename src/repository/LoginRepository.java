package repository;

import java.util.List;
import model.User;

public class LoginRepository extends Repository<User>{

	public LoginRepository(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User get(String email) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
