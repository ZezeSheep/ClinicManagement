package Services.interfaces;

import java.util.List;

import model.Consult;
import model.Dentist;

public interface IDentistService {

	List<Dentist> getAllDentists();

	void addConsult(Consult consult, String dentistEmail);
	
	void createDentist(Dentist dentist);

	List<Consult> getAllConsultsFromDentistEmail(String email);

}
