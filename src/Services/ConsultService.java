package Services;

import java.util.List;

import Services.interfaces.IClientService;
import Services.interfaces.IConsultService;
import Services.interfaces.IDentistService;
import model.Consult;

public class ConsultService implements IConsultService {

	private IDentistService dentistService;
	private IClientService clientService;
	
	public ConsultService() {
		dentistService = new DentistService();
		clientService = new ClientService();
	}
	
	public void createConsult(Consult consult, String clientEmail, String dentistEmail) {
		clientService.addConsult(consult, clientEmail);
		dentistService.addConsult(consult, dentistEmail);
	}
	
	public List<Consult> getAllConsultsOfClient(String email){
		return clientService.getAllConsultsFromClientEmail(email);
	}
	
	public List<Consult> getAllConsultsOfDentist(String email){
		return dentistService.getAllConsultsFromDentistEmail(email);
	}
	
}
