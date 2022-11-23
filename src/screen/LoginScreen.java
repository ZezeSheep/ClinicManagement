package screen;

import Services.LoginService;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginScreen extends Screen {
	
	private LoginService _loginService;
	private Scanner _scanner;
	
	public LoginScreen(LoginService loginService) {
		_loginService = loginService;
		_scanner = new Scanner(System.in);
	}
	
	public void ShowOptions() {
		boolean userSelectedAnyOption = false;
		while(!userSelectedAnyOption) {
			System.out.print("(1) Realizar login\n (2) Criar conta\n (3) Alterar senha\n (4) Sair");
			String optionSelected = _scanner.next();
			userSelectedAnyOption = true;
			
			switch(optionSelected) {
				case "1":
					Login();
					break;
				case "2":
					CreateNewUser();
					break;
				case "3":
					ChangePassword();
					break;
				case "4":
					GetOut();
					break;
				default: 
					userSelectedAnyOption = false;
					break;
			}
		}
	}
	
	private void Login() {
		String userEmail, userPassword;
		
		userEmail = GetUserInputWithValidation(
				"Digite o seu endenreço de email: ", 
				"O email informado não é válido. Por favor, digite um endenreço de email válido: ", 
				Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
		);
		
		userPassword = "sasa"; //TODO
	}
	
	private void CreateNewUser() {
		
	}
	
	private void ChangePassword() {
		
	}

	private void GetOut() {
		System.out.print("Obrigado por utilizar nosso sistema. Até a próxima!");
		System.exit(0);
	}
	
	private String GetUserInputWithValidation(String starMessage, String onErrorMessage, Pattern pattern) {
		String userInput;
		boolean isValidInput;
		
		System.out.print(starMessage);	
		userInput = _scanner.next();
		isValidInput = pattern.matcher(userInput).matches();
		
		while(!isValidInput){
			System.out.print(onErrorMessage);
			userInput = _scanner.next();
			isValidInput = pattern.matcher(userInput).matches();
		}
		
		return userInput;
	}
	
}
