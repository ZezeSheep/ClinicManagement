package screen;

import java.util.List;
import java.util.Scanner;

import Services.LoginService;
import Services.ProcedureService;
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
	private LoginService loginService;

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public DentistScreen(IViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		this.procedureService = new ProcedureService();
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
		List<Consult> consultList = dentist.getConsults();
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

	
}
