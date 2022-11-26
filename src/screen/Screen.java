package screen;

import java.util.Scanner;

import controller.ViewController;

public abstract class Screen {
	
	protected ViewController viewController;
	protected Scanner scanner;
	
	public Screen(ViewController viewController, Scanner scanner) {
		this.viewController = viewController;
		this.scanner = scanner;
	}
	
	public abstract void show();
	
	public void execute() {
		show();
	};
	
	protected void changeScreen(Screen screen) {
		System.out.print("Mudando para a tela " + screen.toString());
		screen.show();
	}

	public ViewController getViewController() {
		return viewController;
	}

	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}
	
	

}
