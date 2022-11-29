package Services.interfaces;

import model.Consult;

public interface IConsultService {
	
	public void createConsult(Consult consult, String clientEmail, String dentistEmail);

}
