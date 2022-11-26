package screen;

import java.util.List;
import java.util.Scanner;

import controller.ViewController;
import model.Dentist;
import repository.DentistRepository;

public class DentistScreen extends CRUDScreen {
	
	private DentistRepository dentistRepository;
	private Dentist dentist;

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public DentistScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		dentistRepository = new DentistRepository("");
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
		
		System.out.println("Digite o número do CRM do dentista:");
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
		
		System.out.println("Digite o novo número do CRM do dentista:");
		String crm = scanner.next();
		currentDentist.setCRM(crm);
		
		dentistRepository.save(currentDentist);
	}
	*/
}
