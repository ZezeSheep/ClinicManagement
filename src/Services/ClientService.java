package Services;

import java.util.List;

import Services.interfaces.IClientService;
import model.Client;
import model.Constants;
import model.Consult;
import repository.*;

public class ClientService implements IClientService {
	
	private ClientRepository clientRepository;
	
	public ClientService() {
		clientRepository = new ClientRepository(Constants.CLIENT_DB_FILE_NAME);
	}
	
	public Client getClientByEmail(String email) {
		return clientRepository.get(email);
	}
	
	public List<Client> getAllClients(){
		return clientRepository.getAll();
	}
	
	public List<Consult> getAllConsultsFromClientEmail(String email) {
		return clientRepository.get(email).getConsults();
	}
	
	public void addConsult(Consult consult, String clientEmail) {
		Client client = getClientByEmail(clientEmail);
		List<Consult> consults = client.getConsults();
		consults.add(consult);
		client.setConsults(consults);
		clientRepository.modify(client.getEmail(), client);
	}
}
