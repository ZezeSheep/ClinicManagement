package screen;

import Services.LoginService;
import Services.interfaces.ILoginService;
import controller.interfaces.IViewController;
import model.Constants;
import model.User;
import utils.UserInputUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginScreen extends Screen {
	
	private ILoginService loginService;
	
	public LoginScreen(IViewController viewController, Scanner scanner) {
		super(viewController, scanner);
		loginService = new LoginService();
		this.scanner = scanner;
	}
	
	public void show() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println("(1) Realizar login\n(2) Criar conta\n(3) Alterar senha\n(4) Sair");
			String optionSelected = scanner.next();
			userSelectedAnyOption = true;
			
			switch(optionSelected) {
				case "1":
					login();
					break;
				case "2":
					createNewUser();
					break;
				case "3":
					changePassword();
					break;
				case "4":
					getOut();
					break;
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}
	
	private void login(){
		String userEmail, userPassword;
		
		userEmail = UserInputUtils.getUserInputWithValidation(
				"Digite o seu endereco de email: ", 
				"O email informado nao eh valido. Por favor, digite um endenreco de email valido: ", 
				Pattern.compile(Constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE),
				scanner
		);
		
		System.out.println("Agora digite a sua senha: ");
		userPassword = scanner.next();
		
		User user = loginService.login(userEmail, userPassword);
		
		if(user == null) {
			System.out.println("Dados de login invalidos! Por favor, tente novamente com outras credenciais.");
			show();
		} else {
			System.out.println("Usuario logado com sucesso!");
			goToUserScreen(user);			
		}
	}
	
	private void createNewUser() {
		String userEmail, userPassword;
		
		userEmail = UserInputUtils.getUserInputWithValidation(
				"Digite o seu endenreço de email: ", 
				"O email informado não é válido. Por favor, digite um endenreço de email valido: ", 
				Pattern.compile(Constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE),
				scanner
		);
		
		userPassword = getUserPasswordWithVerification();
		
		try {
			loginService.createUser(userEmail, userPassword);
			System.out.println("Usuário criado com sucesso!");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar o novo usuario! Por favor, tente novamente mais tarde.");
		} finally {
			show();
		}	
	}
	
	private String getUserPasswordWithVerification() {
		String userPassword;
		boolean isValidPassword;
		System.out.println("Digite a nova senha: ");	
		userPassword = scanner.next();
		isValidPassword = loginService.verifyPasswordRoles(userPassword);
		
		while(!isValidPassword){
			System.out.println("Senha invalida! Sua senha deve possuir ao menos 8 caracteres.");
			System.out.println("Por favor, digite uma nova senha: ");
			userPassword = scanner.next();
			isValidPassword = loginService.verifyPasswordRoles(userPassword);
		}
		
		return userPassword;
	}

	
	private void changePassword() {
		System.out.println("O processo de mudanca de senha eh realizado pelo nosso portal. Acesse www.clinicmanagement.com.br/contas/alterar-senha e siga as instrucoes.");
		show();
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema. Ate a proxima!");
		System.exit(0);
	}
	
	private void goToUserScreen(User user) {
		user.showMenu(viewController);
	}
	
}
