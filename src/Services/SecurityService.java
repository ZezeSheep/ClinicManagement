package Services;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Services.interfaces.ISecurityService;

public class SecurityService implements ISecurityService {
	
	public static String getMD5Hash(String input)
    {
		int startIndex = 1;
		int seedLength = 16;
		int hashLength = 32;
		
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger seed = new BigInteger(startIndex, messageDigest);
            String hashCode = seed.toString(seedLength);
            while (hashCode.length() < hashLength) {
                hashCode = "0" + hashCode;
            }
            return hashCode;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
