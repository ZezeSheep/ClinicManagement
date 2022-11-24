package screen;

import controller.ViewController;

public abstract class Screen {
	
	private ViewController viewController;
	
	public Screen(ViewController viewController) {
		this.viewController = viewController;
	}
	
	protected abstract void show();
	protected abstract void changeScreen();
	
	public void execute() {
		show();
		changeScreen();
	}

	public ViewController getViewController() {
		return viewController;
	}

	public void setViewController(ViewController viewController) {
		this.viewController = viewController;
	}
	
	

}
