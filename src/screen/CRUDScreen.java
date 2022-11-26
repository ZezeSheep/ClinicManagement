package screen;

import controller.ViewController;

public abstract class CRUDScreen extends Screen {

	public CRUDScreen(ViewController viewController) {
		super(viewController);
	}

	@Override
	public void show() {
		showRecordedEntities();
		showOptions();		
	}
	
	private void showOptions() {
		System.out.println("(1) Cadastar novo");
		System.out.println("(2) Editar existente");
		System.out.println("(3) Remover existente");
		System.out.println("(4) Voltar");
	}
	
	protected abstract void showRecordedEntities();

}
