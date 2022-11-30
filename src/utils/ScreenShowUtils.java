package utils;

import java.io.IOException;

public class ScreenShowUtils {
	
	public static void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n");		
	}
	
	public static void pressAnyButton() {
		System.out.print("Aperte Enter pra continuar...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
