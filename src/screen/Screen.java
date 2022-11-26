package screen;

import controller.ViewController;

public abstract class Screen {
	
	protected ViewController viewController;
	
	public Screen(ViewController viewController) {
		this.viewController = viewController;
	}
	
	protected abstract void show();
	
	protected void execute() {
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
