package screen;

import java.util.Scanner;

import controller.ViewController;
import model.Secretary;
import repository.SecretaryRepository;

public class SecretaryScreen extends Screen {
	
	private Secretary secretary;

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public SecretaryScreen(ViewController viewController, Scanner scanner) {
		super(viewController, scanner);
	}

	@Override
	public void show() {
		System.out.println("> Exibindo menu do secretario.");
	}

}
