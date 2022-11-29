package Services.interfaces;

import java.util.List;

import model.Consult;

public interface IConsultService {
	
	public void createConsult(Consult consult, String clientEmail, String dentistEmail);
	
	public List<Consult> getAllConsultsOfClient(String email);

}
