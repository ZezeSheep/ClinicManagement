package screen;

import java.util.List;
import java.util.Scanner;
import Services.SecurityService;
import Services.interfaces.IDentistService;
import Services.interfaces.IProcedureService;
import controller.ViewController;
import model.AestheticProcedure;
import model.Dentist;
import model.Procedure;
import model.RoutineProcedure;
import model.Secretary;
import model.SurgicalProcedure;

public class SecretaryScreen extends Screen {
	
	private Secretary secretary;
	private IDentistService dentistService;
	private IProcedureService procedureService;

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public SecretaryScreen(ViewController viewController, Scanner scanner, IDentistService dentistService,
			IProcedureService procedureService) {
		super(viewController, scanner);
		this.dentistService = dentistService;
		this.procedureService = procedureService;
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
					+ "(6) Ver secretários\n"
					+ "(7) Cadastrar secretário\n"
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
					editDentist();
					break;
				case "4":
					showAllProcedures();
					break;
				case "5":
					createProcedure();
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
		// TODO Auto-generated method stub
		
	}

	private void showAllSecretaries() {
		// TODO Auto-generated method stub
		
	}

	private void showAllClients() {
		// TODO Auto-generated method stub
		
	}

	private void createProcedure() {
		System.out.print("Qual o tipo de procedimento deve ser criado:\n");
		System.out.print("(1) Estetco");
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
		
	}

	private void showAllProcedures() {
		List<AestheticProcedure> aestheticProcedureList = procedureService.getAllAestheticProcedures();
		List<RoutineProcedure> routineProcedureList = procedureService.getAllRoutineProcedures();
		List<AestheticProcedure> aestheticProcedureList = procedureService.getAllAestheticProcedures();
		for(Procedure procedure : procedureList) {
			String procedureLine = String.format("Name: %s\nID:%d\n", 
					procedure.getName(),procedure.getId());
			System.out.println(procedureLine + "\n");
		}
		System.out.println("Pressione qualquer tecla...");
		scanner.next();
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
		String senhaHash = SecurityService.getMD5Hash(senha);
		System.out.print("Qual o cpf do dentista: ");
		String cpf = scanner.nextLine();
		Dentist newDentist = new Dentist(name, email, senhaHash, cpf);
		dentistService.createDentist(newDentist);		
	}

	private void showAllDentists() {
		List<Dentist> listDentist = dentistService.getAllDentists();
		for(Dentist dentist : listDentist) {
			String dentistLine = String.format("Name: %s\nRegister number:%s\n", 
					dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
		}
		System.out.println("Pressione qualquer tecla...");
		scanner.next();
		show();
	}

}
