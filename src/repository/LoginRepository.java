package repository;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.User;

public class LoginRepository extends Repository<User>{

	public LoginRepository(String fileName) {
		super(fileName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		list.add(new User("Raphael", "admin@cefet.com", "shuashuashua", "12345678912"));
		list.add(new User("Jose", "jose@cefet.com", "shuashuashua", "12345678910"));
		return list;
    }

    @Override
    public User get(String email) {
        // TODO Auto-generated method stub
        return new Client("Raphael", "admin@cefet.com", "7ae0b52ec36ba1971fbe113cd8ad64a2", "12345678912");
    }

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return this.get("" + id);
	}

	@Override
	public void save(User objT) {
		// TODO Auto-generated method stub
		
	}
}
