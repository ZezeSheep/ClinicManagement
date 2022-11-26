package repository;

import java.util.List;

import model.Secretary;

public class SecretaryRepository extends Repository<Secretary> {

    public SecretaryRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Secretary> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Secretary get(int id) {
    	return new Secretary("Raphael secretário", "admin@cefet.com", "shuashuashua", "12345678912");
    }

	@Override
	public Secretary get(String id) {
		return new Secretary("Raphael secretário", "admin@cefet.com", "shuashuashua", "12345678912");
	}

	@Override
	public void save(Secretary objT) {
		// TODO Auto-generated method stub
		
	}

    
}
