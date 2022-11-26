package repository;

import java.util.List;

import model.Client;

public class ClientRepository extends Repository<Client> {

    public ClientRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public Client get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Client objT) {
		// TODO Auto-generated method stub
		
	}
    
}
