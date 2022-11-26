package repository;

import java.util.List;

import model.Dentist;

public class DentistRepository extends Repository<Dentist> {

    public DentistRepository(String fileName) {
        super(fileName);
        //TODO Auto-generated constructor stub
    }

    @Override
    public List<Dentist> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dentist get(int id) {
    	return new Dentist("Raphael dentista", "admin@cefet.com", "shuashuashua", "12345678912");
    }

	@Override
	public Dentist get(String id) {
		return new Dentist("Raphael dentista", "admin@cefet.com", "shuashuashua", "12345678912");
	}

	@Override
	public void save(Dentist objT) {
		// TODO Auto-generated method stub
		
	}
    
}
