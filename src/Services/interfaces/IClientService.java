package Services.interfaces;

import java.util.List;

import model.Client;
import model.Consult;

public interface IClientService {

	void addConsult(Consult consult, String clientEmail);
	
	public List<Client> getAllClients();
	
	public Client getClientByEmail(String email);
	
	List<Consult> getAllConsultsFromClientEmail(String email);

}
