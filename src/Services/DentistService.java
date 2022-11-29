package Services;

import java.util.List;

import Services.interfaces.IDentistService;
import model.Constants;
import model.Consult;
import model.Dentist;
import repository.DentistRepository;

public class DentistService implements IDentistService{
	private DentistRepository dentistRepository;
	private LoginService loginService;
	
	public DentistService() {
		dentistRepository = new DentistRepository(Constants.DENTIST_DB_FILE_NAME);
		loginService = new LoginService();
	}
	
	public List<Dentist> getAllDentists(){
		return dentistRepository.getAll();
	}
	
	public Dentist getDentistByEmail(String email){
		return dentistRepository.get(email);
	}
	
	public List<Consult> getAllConsultsFromDentistEmail(String email) {
		return dentistRepository.get(email).getConsults();
	}
	
	public void addConsult(Consult consult, String dentistEmail) {
		Dentist dentist = getDentistByEmail(dentistEmail);
		List<Consult> consults = dentist.getConsults();
		consults.add(consult);
		dentist.setConsults(consults);
		dentistRepository.modify(dentist.getEmail(), dentist);
	}

	@Override
	public void createDentist(Dentist dentist) {
		if(getDentistByEmail(dentist.getEmail()) != null) {
			System.out.println("Ja existe um dentista cadastrado com o email " + dentist.getEmail());
			return;
		}
		String hashPassword = SecurityService.getMD5Hash(dentist.getPasswordHash());
		dentist.setPasswordHash(hashPassword);
		loginService.createUser(dentist);
		dentistRepository.save(dentist);
		
	}

	@Override
	public void removeDentist(Dentist dentist) {
	//	dentistRepository.remove(dentist);
		
	}
}
