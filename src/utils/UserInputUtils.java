package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputUtils {
	
	public static String getUserInputWithValidation(String starMessage, String onErrorMessage, Pattern pattern, Scanner scanner) {
		String userInput;
		boolean isValidInput;
		System.out.print(starMessage);	
		userInput = scanner.next();
		isValidInput = pattern.matcher(userInput).matches();
		
		while(!isValidInput){
			System.out.print(onErrorMessage);
			userInput = scanner.next();
			isValidInput = pattern.matcher(userInput).matches();
		}
		
		return userInput;
	}

}
