package screen;

import java.util.List;
import java.util.Scanner;

import Services.ClientService;
import Services.ConsultService;
import Services.DentistService;
import Services.ProcedureService;
import Services.interfaces.IClientService;
import Services.interfaces.IConsultService;
import Services.interfaces.IDentistService;
import Services.interfaces.IProcedureService;
import controller.ViewController;
import model.AestheticProcedure;
import model.Client;
import model.Consult;
import model.Dentist;
import model.Procedure;
import model.RoutineProcedure;
import model.SurgicalProcedure;
import utils.ScreenShowUtils;

public class ClientScreen extends Screen {
	
	private IConsultService consultService;
	private IClientService clientService;
	private IDentistService dentistService;
	private IProcedureService procedureService;
	private Client client;

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		consultService = new ConsultService();
		clientService = new ClientService();
		dentistService = new DentistService();
		this.scanner = scanner;
		this.procedureService = new ProcedureService();
	} 
	
	public void show() {
		ScreenShowUtils.clearScreen();
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
		System.out.println("Obrigado por utilizar nosso sistema " + client.getName() + ". Ate a proxima!");
		viewController.getLoginScreen().show();
	}

	private void editMyAccount() {
		// TODO Auto-generated method stub
		
	}

	private void registerNewConsultation() {
		Procedure choosenProcedure;
		Dentist choosenDentist;
		
		System.out.println("Qual o tipo de procedimento deve ser criado:");
		System.out.println("(1) Estetico");
		System.out.println("(2) Rotina");
		System.out.println("(3) Cirurgico");
		int choosenIndex = scanner.nextInt();
		if(choosenIndex == 1) {
			int indexProcedure = 1;
			List<AestheticProcedure> aestheticProcedureList = procedureService.getAllAestheticProcedures();
			for(AestheticProcedure procedure : aestheticProcedureList) {
				String procedureLine = String.format("(%d) Name: %s\nID:%d\n", 
						indexProcedure, procedure.getName(),procedure.getId());
				indexProcedure++;
				System.out.println(procedureLine + "\n");
			}
			System.out.println("Escolha um procedimento: ");
			int choosenProcedureIndex = scanner.nextInt();
			choosenProcedure = aestheticProcedureList.get(choosenProcedureIndex-1);
		}
		else if(choosenIndex == 2) {
			int indexProcedure = 1;
			List<RoutineProcedure> routineProcedureList = procedureService.getAllRoutineProcedures();
			for(RoutineProcedure procedure : routineProcedureList) {
				String procedureLine = String.format("(%d) Name: %s\nID:%d\n", 
						indexProcedure, procedure.getName(),procedure.getId());
				indexProcedure++;
				System.out.println(procedureLine + "\n");
			}
			System.out.println("Escolha um procedimento: ");
			int choosenProcedureIndex = scanner.nextInt();
			choosenProcedure = routineProcedureList.get(choosenProcedureIndex-1);
		}
		else {
			int indexProcedure = 1;
			List<SurgicalProcedure> surgicalProcedureList = procedureService.getAllSurgicalProcedures();
			for(SurgicalProcedure procedure : surgicalProcedureList) {
				String procedureLine = String.format("(%d) Name: %s\nID:%d\n", 
						indexProcedure, procedure.getName(),procedure.getId());
				indexProcedure++;
				System.out.println(procedureLine + "\n");
			}
			System.out.println("Escolha um procedimento: ");
			int choosenProcedureIndex = scanner.nextInt();
			choosenProcedure = surgicalProcedureList.get(choosenProcedureIndex-1);
		}
		
		int index = 1;
		List<Dentist> dentistList = dentistService.getAllDentists();
		for(Dentist dentist : dentistList) {
			String dentistLine = String.format("(%d) Name: %s\nRegister number:%s\n", 
					index, dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
			index++;
		}
		System.out.println("Escolha um dentista: ");
		int choosenDentistIndex = scanner.nextInt();
		choosenDentist = dentistList.get(choosenDentistIndex-1);
		
		Consult consult = new Consult(1);
		consult.setProcedure(choosenProcedure);
		consultService.createConsult(consult, client.getEmail(), choosenDentist.getEmail());
		System.out.println("Consulta criada com sucesso");
		ScreenShowUtils.pressAnyButton();		
		show();		
	}

	private void showAllMyConsultation() {
		List<Consult> consultList = client.getConsults();
		if(consultList != null) {
			for(Consult consult : consultList) {
				String consultLine = String.format("Sala: %s\nDescricao:%s\n", 
						consult.getRoom(),consult.getDescription());
				System.out.println(consultLine + "\n");
			}			
		}
		ScreenShowUtils.pressAnyButton();
		show();
	}

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

	private void showAllDentists() {
		List<Dentist> dentistList = dentistService.getAllDentists();
		for(Dentist dentist : dentistList) {
			String dentistLine = String.format("Name: %s\nRegister number:%s\n", 
					dentist.getName(),dentist.getRegisterNumber());
			System.out.println(dentistLine + "\n");
		}
		ScreenShowUtils.pressAnyButton();
		show();
	}
}
