package screen;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import Services.ClientService;
import Services.ConsultService;
import Services.DentistService;
import Services.ProcedureService;
import Services.SecretaryService;
import Services.SecurityService;
import Services.interfaces.IClientService;
import Services.interfaces.IConsultService;
import Services.interfaces.IDentistService;
import Services.interfaces.IProcedureService;
import Services.interfaces.ISecretaryService;
import controller.ViewController;
import model.AestheticProcedure;
import model.Client;
import model.Dentist;
import model.RoutineProcedure;
import model.Secretary;
import model.SurgicalProcedure;
import utils.ScreenShowUtils;

public class SecretaryScreen extends Screen {
	
	private Secretary secretary;
	private IDentistService dentistService;
	private IProcedureService procedureService;
	private ISecretaryService secretaryService;
	private IClientService clientService;

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public SecretaryScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		this.dentistService = new DentistService();
		this.procedureService = new ProcedureService();
		secretaryService = new SecretaryService();
        this.procedureService = new ProcedureService();
        this.clientService = new ClientService();
	}

	@Override
	public void show() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println(
					"(1) Ver dentistas\n"
		          + "(2) Cadastrar dentista\n"
		          + "(3) Ver procedimentos\n"
		          + "(4) Cadastrar procedimento\n"
		          + "(5) Ver pacientes\n"
		          + "(6) Ver secretarios\n"
		          + "(7) Cadastrar secretario\n"
		          + "(8) Sair\n");
			String optionSelected = scanner.next();
			userSelectedAnyOption = true;
			
			switch(optionSelected) {
				case "1":
					showAllDentists();
					break;
				case "2":
					createDentist();
					break;
				case "3":
					showAllProcedures();
					break;
				case "4":
					createProcedure();
					break;
				case "5":
					showAllClients();
					break;
				case "6":
					showAllSecretaries();
					break;
				case "7":
					createSecretary();
					break;
				case "8":
					getOut();
					break;
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}

	private void createSecretary() {
		ScreenShowUtils.clearScreen();
		System.out.println("Certo, vamos cadastrar um novo secretario!");
		System.out.println("Digite o nome do secretario: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.print("Digite o email do secretario: ");
		String email = scanner.next();
		System.out.print("Digite a senha do secretario: ");
		String senha = scanner.next();
		Secretary secretary = new Secretary(email, senha);
		secretary.setName(name);
		System.out.print("Digite o numero de registro do secretario: ");
		int registerNumber = scanner.nextInt();
		secretary.setRegisterNumber(registerNumber);
		secretaryService.createSecretary(secretary);
		System.out.print("Secretario criado com sucesso!");
		restart();
	}

	private void showAllSecretaries() {
		ScreenShowUtils.clearScreen();
		List<Secretary> secreataries = secretaryService.getAllSecretaries();
		
		if(secreataries.isEmpty()) {
			System.out.println("Nao ha nenhum secretario cadastrado!");
			restart();
		}
		
		for(Secretary secretary : secreataries) {
			String secretaryLine = String.format("Name: %s\nRegister number:%s\n", 
					secretary.getName(),secretary.getRegisterNumber());
			System.out.println(secretaryLine + "\n");
		}
		restart();
	}

	private void showAllClients() {
		ScreenShowUtils.clearScreen();
		List<Client> listClient = clientService.getAllClients();
		
		if(listClient.isEmpty()) {
			System.out.println("Nao ha nenhum usuario cadastrado!");
			restart();
		}
		
		for(Client client : listClient) {
			String clientLine = String.format("Name: %s\nEmail:%s\n", 
					client.getName(),client.getEmail());
			System.out.println(clientLine + "\n");
		}
		
		restart();
	}

	private void createProcedure() {
		ScreenShowUtils.clearScreen();
		System.out.println("Qual o tipo de procedimento deve ser criado:");
		System.out.println("(1) Estetico");
		System.out.println("(2) Rotina");
		System.out.println("(3) Cirurgico");
		int choosenIndex = scanner.nextInt();
		if(choosenIndex == 1) {
			AestheticProcedure newProcedure = new AestheticProcedure(UUID.randomUUID());
			System.out.println("Qual eh o nome do procedimento estetico:");
			scanner.nextLine();
			String name = scanner.nextLine();
			newProcedure.setName(name);
			procedureService.createAestheticProcedure(newProcedure);
			System.out.println("Procedimento estetico criado com sucesso");
		}
		else if(choosenIndex == 2) {
			RoutineProcedure newProcedure = new RoutineProcedure(UUID.randomUUID());
			System.out.println("Qual eh o nome do procedimento de rotina:");
			scanner.nextLine();
			String name = scanner.nextLine();
			newProcedure.setName(name);
			procedureService.createRoutineProcedure(newProcedure);
			System.out.println("Procedimento de rotina criado com sucesso");
		}
		else {
			SurgicalProcedure newProcedure = new SurgicalProcedure(UUID.randomUUID());
			System.out.println("Qual eh o nome do procedimento cirurgico:");
			scanner.nextLine();
			String name = scanner.nextLine();
			newProcedure.setName(name);
			procedureService.createSurgicalProcedure(newProcedure);
			System.out.println("Procedimento cirurgico criado com sucesso");
		}
		restart();
		
	}

	private void showAllProcedures() {
		ScreenShowUtils.clearScreen();	
		System.out.println("Procedimentos esteticos:");
		showAestheticProcedures();
		System.out.println("\nProcedimentos de rotina:");
		showRoutineProcedures();
		System.out.println("\nProcedimentos cirurgico:");
		showSurgicalProcedures();
		restart();
	}
	
	private void showAestheticProcedures() {
		List<AestheticProcedure> aestheticProcedureList = procedureService.getAllAestheticProcedures();
		if(aestheticProcedureList.isEmpty()) {
			System.out.println("Nao ha procedimentos esteticos cadastrados.");
		} else {
			for(AestheticProcedure procedure : aestheticProcedureList) {
				String procedureLine = String.format("Name: %s\n", 
						procedure.getName());
				System.out.println(procedureLine);
			}
		}
	}
	
	private void showRoutineProcedures() {
		List<RoutineProcedure> routineProcedureList = procedureService.getAllRoutineProcedures();
		if(routineProcedureList.isEmpty()) {
			System.out.println("Nao ha procedimentos de rotina cadastrados.");
		} else {
			for(RoutineProcedure procedure : routineProcedureList) {
				String procedureLine = String.format("Name: %s\n", 
						procedure.getName());
				System.out.println(procedureLine);
			}
		}
	}
	
	private void showSurgicalProcedures() {
		List<SurgicalProcedure> surgicalProcedureList = procedureService.getAllSurgicalProcedures();
		if(surgicalProcedureList.isEmpty()) {
			System.out.println("Nao ha procedimentos sirurgicos cadastrados.");
		} else {
			for(SurgicalProcedure procedure : surgicalProcedureList) {
				String procedureLine = String.format("Name: %s\n", 
						procedure.getName());
				System.out.println(procedureLine);
			}
		}
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema. Ate a proxima!");
		viewController.getLoginScreen().show();		
	}

	private void createDentist() {
		ScreenShowUtils.clearScreen();
		System.out.print("Qual o nome do dentista: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.print("Qual o email do dentista: ");
		String email = scanner.next();
		System.out.print("Qual a senha do dentista: ");
		String senha = scanner.next();
		System.out.print("Qual o cpf do dentista: ");
		String cpf = scanner.next();
		System.out.print("Qual o numero de registro do dentista: ");
		int registerNumber = scanner.nextInt();
		Dentist newDentist = new Dentist(name, email, senha, cpf);
		newDentist.setRegisterNumber(registerNumber);
		dentistService.createDentist(newDentist);
		restart();
	}

	private void showAllDentists() {
		List<Dentist> listDentist = dentistService.getAllDentists();
		
		if(listDentist.isEmpty()) {
			System.out.println("Nao ha nenhum dentista cadastrado!");
			restart();
		}
		
		for(Dentist dentist : listDentist) {
			String dentistLine = String.format("Name: %s\nRegister number:%s\n", 
					dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
		}
		restart();
	}
	
	private void restart() {
		ScreenShowUtils.pressAnyButton();
		show();
	}

}
