package repository;

import java.util.ArrayList;
import java.util.List;

import model.Client;
import model.User;

public class ClientRepository extends Repository<Client> {

    public ClientRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
    	List<Client> list = new ArrayList<Client>();
		list.add(new Client("Raphael", "admin@cefet.com", "shuashuashua", "12345678912"));
		list.add(new Client("Jose", "jose@cefet.com", "shuashuashua", "12345678910"));
		return list;
    }

    @Override
    public Client get(int id) {
        return new Client("Raphael", "admin@cefet.com", "shuashuashua", "12345678912");
    }

	@Override
	public Client get(String id) {
		return new Client("Raphael", "admin@cefet.com", "shuashuashua", "12345678912");
	}

	@Override
	public void save(Client objT) {
		// TODO Auto-generated method stub
		
	}
    
}
