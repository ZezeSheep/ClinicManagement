package screen;

import Services.LoginService;
import controller.ViewController;
import model.Constants;
import utils.UserInputUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginScreen extends Screen {
	
	private LoginService _loginService;
	private Scanner _scanner;
		 
	
	public LoginScreen(ViewController viewController) {
		super(viewController);
		_loginService = new LoginService();
		_scanner = new Scanner(System.in);
		System.out.println("> Iniciando tela de login.");
	}
	
	public void show() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.println("(1) Realizar login\n(2) Criar conta\n(3) Alterar senha\n(4) Sair");
			String optionSelected = _scanner.next();
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
	
	private void login() {
		String userEmail, userPassword;
		
		userEmail = UserInputUtils.getUserInputWithValidation(
				"Digite o seu endenreço de email: ", 
				"O email informado não é válido. Por favor, digite um endenreço de email válido: ", 
				Pattern.compile(Constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE),
				_scanner
		);
		
		System.out.println("email é " + userEmail);
		
		System.out.println("Agora digite a sua senha: ");
		userPassword = _scanner.next();
		
		if(_loginService.verifyLogin(userEmail, userPassword)) {
			System.out.println("Usuário logado com sucesso!");
		}
		
		show();
	}
	
	private void createNewUser() {
		String userEmail, userPassword;
		
		userEmail = UserInputUtils.getUserInputWithValidation(
				"Digite o seu endenreço de email: ", 
				"O email informado não é válido. Por favor, digite um endenreço de email válido: ", 
				Pattern.compile(Constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE),
				_scanner
		);
		
		userPassword = getUserPasswordWithVerification();
		try {
			_loginService.createUser(userEmail, userPassword);
			System.out.println("Usuário criado com sucesso!");
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar o novo usuário! Por favor, tente novamente mais tarde.");
		} finally {
			show();
		}	
	}
	
	private String getUserPasswordWithVerification() {
		String userPassword;
		boolean isValidPassword;
		System.out.println("Digite a nova senha: ");	
		userPassword = _scanner.next();
		isValidPassword = _loginService.verifyPasswordRoles(userPassword);
		
		while(!isValidPassword){
			System.out.println("Senha invalida. Sua senha deve possuir 8 caracteres, sendo pelo menos 1 letra minuscula, 1 letra maiuscula e 1 caractere especial.");
			System.out.println("Por favor, digite uma nova senha: ");
			userPassword = _scanner.next();
			isValidPassword = _loginService.verifyPasswordRoles(userPassword);
		}
		
		return userPassword;
	}

	
	private void changePassword() {
		System.out.println("O processo de mudança de senha é realizado pelo nosso portal. Acesse www.clinicmanagement.com.br/contas/alterar-senha e siga as instruções.");
		show();
	}

	private void getOut() {
		System.out.println("Obrigado por utilizar nosso sistema. Até a próxima!");
		System.exit(0);
	}
	
}
