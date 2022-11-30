package screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Services.ConsultService;
import Services.LoginService;
import Services.ProcedureService;
import Services.interfaces.IConsultService;
import Services.interfaces.IDentistService;
import Services.interfaces.IProcedureService;
import controller.ViewController;
import controller.interfaces.IViewController;
import model.AestheticProcedure;
import model.Consult;
import model.Dentist;
import model.RoutineProcedure;
import model.SurgicalProcedure;
import repository.DentistRepository;
import utils.ScreenShowUtils;

public class DentistScreen extends Screen {
	
	private Dentist dentist;
	private IProcedureService procedureService;
	private IConsultService consultService;

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public DentistScreen(IViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		this.procedureService = new ProcedureService();
		consultService = new ConsultService();
	}
	
	public void show() {
		ScreenShowUtils.clearScreen();
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println("(1) Ver procedimentos\n(2) Ver minhas consultas\n(3) Sair");
			String optionSelected = scanner.next();
			userSelectedAnyOption = true;
			
			switch(optionSelected) {
				case "1":
					showAllProcedures();
					break;
				case "2":
					showAllMyConsultation();
					break;
				case "3":
					getOut();
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema " + dentist.getName() + ". Ate a proxima!");
		viewController.getLoginScreen().show();
	}

	private void showAllMyConsultation() {
		List<Consult> consultList = consultService.getAllConsultsOfDentist(dentist.getEmail());
		
		try {
			if(consultList.isEmpty()) {
				System.out.println("Voce nao possui consultas agendadas.");
				restart();
			}
		} catch (Exception e) {
			dentist.setConsults(new ArrayList<Consult>());
		}
		
		if(consultList != null) {
			for(Consult consult : consultList) {
				String consultLine = String.format("Sala: %s\nDescricao:%s\n", 
						consult.getRoom(),consult.getDescription());
				System.out.println(consultLine + "\n");
			}			
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

	private void restart() {
		ScreenShowUtils.pressAnyButton();
		show();
	}
	
}
