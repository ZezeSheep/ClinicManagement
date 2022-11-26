package screen;

import java.util.List;
import java.util.Scanner;
import controller.ViewController;
import model.Client;
import repository.ClientRepository;

public class ClientScreen extends CRUDScreen {
	
	private ClientRepository clientRepository;

	public ClientScreen(ViewController viewController) {
		super(viewController);
		clientRepository = new ClientRepository("");
	}
/*
	@Override
	protected void showRecordedEntities() {
		List<Client> recordedClients = clientRepository.getAll();
		for(Client client : recordedClients) {
			String clientLine = String.format("Name: %s\nPlan Number:%s\nDocument:%s", 
					client.getName(),client.getPlanNumber(),client.getDocument());
			System.out.println(clientLine + "\n");
		}		
	}

	@Override
	protected void ChangeScreen() {
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				createClient();
				viewController.GetClientScreen().Execute(); break;
			case 2:
				editClient();
				viewController.GetClientScreen().Execute(); break;
			case 3:
				removeClient();
				viewController.GetClientScreen().Execute(); break;
			case 4: break;
			default: break;
		}		
	}
	
	private void removeClient() {
		System.out.println("Digite o id do cliente a ser removido: ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		clientRepository.remove(id);
	}
	
	private void createClient() {
		Client newClient = new Client();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do cliente:");
		String name = scanner.next();
		newClient.setName(name);
		
		System.out.println("Digite o número do plano do cliente:");
		String planNumber = scanner.next();
		newClient.setPlanNumber(planNumber);
		
		System.out.println("Digite o documento do cliente:");
		String document = scanner.next();
		newClient.setDocument(document);
		
		clientRepository.save(newClient);
	}
	
	private void editClient() {
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		Client currentClient = clientRepository.get(id);
		
		System.out.println("Digite o novo nome do cliente:");
		String name = scanner.next();
		currentClient.setName(name);
		
		System.out.println("Digite o novo número do plano do cliente:");
		String planNumber = scanner.next();
		currentClient.setPlanNumber(planNumber);
		
		System.out.println("Digite o novo documento do cliente:");
		String document = scanner.next();
		currentClient.setDocument(document);
		
		clientRepository.save(currentClient);
	}
	
*/

	@Override
	protected void showRecordedEntities() {
		// TODO Auto-generated method stub
		
	}
}
