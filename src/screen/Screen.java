package screen;

import java.util.Scanner;

import controller.ViewController;
import controller.interfaces.IViewController;
import screen.interfaces.IScreen;

public abstract class Screen implements IScreen {
	
	protected IViewController viewController;
	protected Scanner scanner;
	
	public Screen(IViewController viewController, Scanner scanner) {
		this.viewController = viewController;
		this.scanner = scanner;
	}
	
	public abstract void show();
	
	public void execute() {
		show();
	};

	public IViewController getViewController() {
		return viewController;
	}

	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}
}
