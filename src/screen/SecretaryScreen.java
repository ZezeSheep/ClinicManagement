package screen;

import java.util.List;
import java.util.Scanner;

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
import model.Dentist;
import model.Procedure;
import model.RoutineProcedure;
import model.Secretary;
import model.SurgicalProcedure;
import utils.ScreenShowUtils;

public class SecretaryScreen extends Screen {
	
	private Secretary secretary;
	private IDentistService dentistService;
	private IProcedureService procedureService;
	private IConsultService consultService;
	private IClientService clientSerivce;
	private ISecretaryService secretaryService;

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public SecretaryScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		this.dentistService = new DentistService();
		this.procedureService = new ProcedureService();
		secretaryService = new SecretaryService();
		clientSerivce = new ClientService();
		consultService = new ConsultService();
	}

	@Override
	public void show() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println(
					  "(1) Ver dentistas\n"
					+ "(2) Cadastrar dentista\n"
					+ "(3) Editar dentista\n"
					+ "(4) Ver procedimentos\n"
					+ "(5) Cadastrar procedimento\n"
					+ "(6) Editar procedimento\n"
					+ "(7) Ver pacientes\n"
					+ "(8) Ver secretarios\n"
					+ "(9) Cadastrar secretário\n"
					+ "(10) Editar secretário\n"
					+ "(11) Sair\n");
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
					editDentist();
					break;
				case "4":
					showAllProcedures();
					break;
				case "5":
					//createProcedure();
					break;
				case "6":
					//editProcedure();
					break;
				case "7":
					showAllClients();
					break;
				case "8":
					showAllSecretaries();
					break;
				case "9":
					createSecretary();
					break;
				case "10":
					//editSecretary();
					break;
				case "11":
					getOut();
					break;
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}

	private void createSecretary() {
		System.out.println("Certo, vamos cadastrar um novo secretário!");
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
		ScreenShowUtils.pressAnyButton();
		show();
	}

	private void showAllSecretaries() {
		List<Secretary> secreataries = secretaryService.getAllSecretaries();
		for(Secretary secretary : secreataries) {
			String secretaryLine = String.format("Name: %s\nRegister number:%s\n", 
					secretary.getName(),secretary.getRegisterNumber());
			System.out.println(secretaryLine + "\n");
		}
		ScreenShowUtils.pressAnyButton();
		show();
	}

	private void showAllClients() {
		// TODO Auto-generated method stub
		
	}

	/*private void createProcedure() {
		System.out.print("Qual o tipo de procedimento deve ser criado:\n");
		System.out.print("(1) Estetico");
		System.out.print("(2) Rotina");
		System.out.print("(3) Cirurgico");
		int choosenIndex = scanner.nextInt();
		if(choosenIndex == 1) {
			AestheticProcedure newProcedure = new AestheticProcedure(1);
			newProcedure.setName("Procedimento estetico");
			procedureService.createAestheticProcedure(newProcedure);
		}
		else if(choosenIndex == 2) {
			RoutineProcedure newProcedure = new RoutineProcedure(2);
			newProcedure.setName("Procedimento de rotina");
			procedureService.createRoutineProcedure(newProcedure);
		}
		else {
			SurgicalProcedure newProcedure = new SurgicalProcedure(3);
			newProcedure.setName("Procedimento cirigico");
			procedureService.createSurgicalProcedure(newProcedure);
		}
		
	}*/

	private void showAllProcedures() {
		List<AestheticProcedure> aestheticProcedureList = procedureService.getAllAestheticProcedures();
		List<RoutineProcedure> routineProcedureList = procedureService.getAllRoutineProcedures();
		List<SurgicalProcedure> surgicalProcedureList = procedureService.getAllSurgicalProcedures();
		System.out.println("Procedimentos esteticos:");
		for(AestheticProcedure procedure : aestheticProcedureList) {
			String procedureLine = String.format("Name: %s\nID:%d\n", 
					procedure.getName(),procedure.getId());
			System.out.println(procedureLine + "\n");
		}
		System.out.println("Procedimentos de rotina:");
		for(RoutineProcedure procedure : routineProcedureList) {
			String procedureLine = String.format("Name: %s\nID:%d\n", 
					procedure.getName(),procedure.getId());
			System.out.println(procedureLine + "\n");
		}
		System.out.println("Procedimentos cirurgico:");
		for(SurgicalProcedure procedure : surgicalProcedureList) {
			String procedureLine = String.format("Name: %s\nID:%d\n", 
					procedure.getName(),procedure.getId());
			System.out.println(procedureLine + "\n");
		}
		ScreenShowUtils.pressAnyButton();
		show();
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema. Até a próxima!");
		System.exit(0);		
	}

	private void editDentist() {
		List<Dentist> listDentist = dentistService.getAllDentists();
		int index = 1;
		for(Dentist dentist : listDentist) {
			String dentistLine = String.format("(%d) Name: %s\nRegister number:%s\n", 
					index, dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
			index++;
		}
		System.out.print("Selecione o dentista: ");
		int choosenIndex = scanner.nextInt();
		Dentist choosenDentist = listDentist.get(choosenIndex-1);
		dentistService.removeDentist(choosenDentist);
		
		System.out.print("Qual o novo nome do dentista: ");
		String name = scanner.nextLine();
		System.out.print("Qual o novo email do dentista: ");
		String email = scanner.nextLine();
		System.out.print("Qual a novo senha do dentista: ");
		String senha = scanner.nextLine();
		String senhaHash = SecurityService.getMD5Hash(senha);
		System.out.print("Qual o novo cpf do dentista: ");
		String cpf = scanner.nextLine();
		choosenDentist.setCpf(cpf);
		choosenDentist.setName(name);
		choosenDentist.setEmail(email);
		choosenDentist.setPasswordHash(senhaHash);
		dentistService.createDentist(choosenDentist);
		
	}

	private void createDentist() {
		System.out.print("Qual o nome do dentista: ");
		String name = scanner.nextLine();
		System.out.print("Qual o email do dentista: ");
		String email = scanner.nextLine();
		System.out.print("Qual a senha do dentista: ");
		String senha = scanner.nextLine();
		System.out.print("Qual o cpf do dentista: ");
		String cpf = scanner.nextLine();
		Dentist newDentist = new Dentist(name, email, senha, cpf);
		dentistService.createDentist(newDentist);
	}

	private void showAllDentists() {
		List<Dentist> listDentist = dentistService.getAllDentists();
		for(Dentist dentist : listDentist) {
			String dentistLine = String.format("Name: %s\nRegister number:%s\n", 
					dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
		}
		ScreenShowUtils.pressAnyButton();
		show();
	}

}
