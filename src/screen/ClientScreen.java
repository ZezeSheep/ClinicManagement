package screen;

import java.util.List;
import java.util.Scanner;

import controller.ViewController;
import model.Client;
import model.Constants;
import model.Dentist;
import model.Procedure;
import repository.ClientRepository;
import repository.DentistRepository;
import repository.ProcedureRepository;

public class ClientScreen extends CRUDScreen {
	
	private ClientRepository clientRepository;
	private DentistRepository dentistRepository;
	private ProcedureRepository procedureRepository;
	private ConsultRepository consultRepository;
	private Client client;

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		clientRepository = new ClientRepository(Constants.CLIENT_DB_FILE_NAME);
		this.scanner = scanner;
	}
	
	public void show() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println("(1) Ver dentistas\n(2) Ver procedimentos\n(3) Ver minhas consultas\n(4) Cadastrar consultas\n(5) Editar minha conta\n(6) Sair");
			String optionSelected = scanner.next();
			userSelectedAnyOption = true;
			
			switch(optionSelected) {
				case "1":
					showAllDentists();
					break;
				case "2":
					showAllProcedures();
					break;
				case "3":
					showAllMyConsultation();
					break;
				case "4":
					registerNewConsultation();
					break;
				case "5":
					editMyAccount();
					break;
				case "6":
					getOut();
					break;
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema " + client.name + ". Até a próxima!");
		System.exit(0);
	}

	private void editMyAccount() {
		// TODO Auto-generated method stub
		
	}

	private void registerNewConsultation() {
		// TODO Auto-generated method stub
		
	}

	private void showAllMyConsultation() {
		List<Consult> consultList = consultRepository.getByClientId(client.getEmail());
		for(Consult consult : consultList) {
			String consultLine = String.format("Dentist: %s\nTime:%s\n", 
					consult.getDentistName(),consult.getTime());
			System.out.println(consultLine + "\n");
		}
		
	}

	private void showAllProcedures() {
		List<Procedure> procedureList = procedureRepository.getAll();
		for(Procedure procedure : procedureList) {
			String procedureLine = String.format("ID: %s\n", 
					procedure.getId());
			System.out.println(procedureLine + "\n");
		}
		
	}

	private void showAllDentists() {
		List<Dentist> dentistList = dentistRepository.getAll();
		for(Dentist dentist : dentistList) {
			String dentistLine = String.format("Name: %s\nCPF:%s\nEmail:%s", 
					dentist.getName(),dentist.getCpf(),dentist.getEmail());
			System.out.println(dentistLine + "\n");
		}		
	}

	@Override
	protected void showRecordedEntities() {
		/*List<Client> recordedClients = clientRepository.getAll();
		for(Client client : recordedClients) {
			String clientLine = String.format("Name: %s\nPlan Number:%s\nDocument:%s", 
					client.getName(),client.getPlanNumber(),client.getDocument());
			System.out.println(clientLine + "\n");
		}*/		
	}

	/*@Override
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
	}*/
}
