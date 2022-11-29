package screen;

import java.util.List;
import java.util.Scanner;

import controller.ViewController;
import controller.interfaces.IViewController;
import model.Dentist;
import repository.DentistRepository;
import utils.ScreenShowUtils;

public class DentistScreen extends CRUDScreen {
	
	private Dentist dentist;

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public DentistScreen(IViewController viewController, Scanner scanner) {
		super(viewController, scanner);
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

	@Override
	protected void showRecordedEntities() {
		/*List<Dentist> recordedDentists = dentistRepository.getAll();
		for(Dentist dentist : recordedDentists) {
			String dentistLine = String.format("Name: %s\nCRM:%s\n", 
					dentist.getName(),dentist.getCRM());
			System.out.println(dentistLine + "\n");
		}*/		
	}
/*
	@Override
	protected void changeScreen() {
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				createDentist();
				getViewController().getDentistScreen().execute(); break;
			case 2:
				editDentist();
				getViewController().getDentistScreen().execute(); break;
			case 3:
				removeDentist();
				getViewController().getDentistScreen().execute(); break;
			case 4: break;
			default: break;
		}		
	}
	
	private void removeDentist() {
		System.out.println("Digite o id do dentista a ser removido: ");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		dentistRepository.remove(id);
	}
	
	private void createDentist() {
		Dentist newDentist = new Dentist();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome do dentista:");
		String name = scanner.next();
		newDentist.setName(name);
		
		System.out.println("Digite o n�mero do CRM do dentista:");
		String crm = scanner.next();
		newDentist.setCRM(crm);
		
		dentistRepository.save(newDentist);
	}
	
	private void editDentist() {
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		Dentist currentDentist = dentistRepository.get(id);
		
		System.out.println("Digite o novo nome do dentista:");
		String name = scanner.next();
		currentDentist.setName(name);
		
		System.out.println("Digite o novo n�mero do CRM do dentista:");
		String crm = scanner.next();
		currentDentist.setCRM(crm);
		
		dentistRepository.save(currentDentist);
	}
	*/
}
