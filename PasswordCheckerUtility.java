package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Nathan Assefa
 *
 */

public class PasswordCheckerUtility {

 public static int size=0;
/**
 * 
 * @param password
 * @return
 * @throws LengthException
 */
 	private static boolean passwordLength(String password) throws LengthException {
 		if(password.length() < 6)
 			throw new LengthException();
 		else
 			return false;
 	}
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws NoUpperAlphaException
 	 */
 	private static boolean hasUpper(String password) throws NoUpperAlphaException {
 		size = password.length();
 		int count = 0;
 		char[] hasUpper = new char[size];
 		for(int i=0; i<size; i++) {
 		hasUpper[i] = password.toCharArray()[i];
 		}
 		
 		for(int i=0; i<size; i++) {
 		if(hasUpper[i]>64 && hasUpper[i]<91)
 			count++;
 		}
 		if(count>0)
 			return true;
 		else
 			throw new NoUpperAlphaException();
 	}

 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws NoLowerAlphaException
 	 */
 	private static boolean hasLower(String password) throws NoLowerAlphaException {
 		size = password.length();
 		int count = 0;
 		char[] hasLower = new char[size];
 		for(int i=0; i<size; i++) {
 		hasLower[i] = password.toCharArray()[i];
 		}
 		
 		for(int i=0; i<size; i++) {
 		if(hasLower[i]>96 && hasLower[i]<123)
 			count++;
 		}
 		if(count>0)
 			return true;
 		else
 			throw new NoLowerAlphaException();
 	}
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws NoDigitException
 	 */
 	private static boolean hasNumber(String password) throws NoDigitException {
 		int count = 0;
 		char[] hasNumber = password.toCharArray();
 		
 		for(int i=0; i<size; i++) {
 		if(hasNumber[i]>47 && hasNumber[i]<58)
 			count++;
 		}
 		
 		if(count>0)
 			return true;
 		else
 			throw new NoDigitException();
 	}
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws NoSpecialCharacterException
 	 */
 	private static boolean hasSpecial(String password) throws NoSpecialCharacterException {
 		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
 		Matcher matcher = pattern.matcher(password);
 		boolean hasSpecial;

 		if(!(matcher.matches())) {
 			hasSpecial = (!matcher.matches());
 		}
 		else
 			throw new NoSpecialCharacterException();
		return hasSpecial;
 	}
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 */
 	public static boolean isWeakPassword(String password) {
		
 		if(password.length() <=9 && password.length() >=6)
 			return true;
 		else
 			return false;
		
	
	}
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws InvalidSequenceException
 	 */
 	static boolean hasDouble(String password) throws InvalidSequenceException {
 		int count = 0;
 		char[] hasDouble = password.toCharArray();
 		/*for(int i=0; i<size; i++) {
 			hasDouble[i] = password.toCharArray()[i];
 		}*/
 		
 		for(int i=0; i<password.length(); i++) {
 			if(i == password.length()-2)
 				break;
 			
 			else if(hasDouble[i] == hasDouble[i+1] && hasDouble[i]==hasDouble[i+2]) 
 	 			count++;
 		}
 		
 		if(count>0)
 			throw new InvalidSequenceException();
 		else
 			return false;	 	}
 	
 	
 	/**
 	 * 
 	 * @param password
 	 * @return
 	 * @throws LengthException 
 	 * @throws NoUpperAlphaException
 	 * @throws NoLowerAlphaException
 	 * @throws NoDigitException
 	 * @throws NoSpecialCharacterException
 	 * @throws InvalidSequenceException
 	 */

	public static boolean isValidPassword(String password) throws LengthException, 
	NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
	try {
		passwordLength(password);
		
	}
	catch(LengthException e) {
			throw new LengthException();
	}
	try {
		hasUpper(password);
		
	}
	catch(NoUpperAlphaException e) {
		throw new NoUpperAlphaException();
	}
	try {
		hasLower(password);
		
	}
	catch(NoLowerAlphaException e) {
		throw new NoLowerAlphaException();
	}
	try {
		hasNumber(password);
		
	}
	catch(NoDigitException e) {
		throw new NoDigitException();
	}
	try {
		hasSpecial(password);
		
	}
	catch(NoSpecialCharacterException e) {
		throw new NoSpecialCharacterException();
	}
	try {
		hasDouble(password);
	}
	catch(InvalidSequenceException e) {
		throw new InvalidSequenceException();
	}

		return true;
	}
	
	
	/**
	 * 
	 * @param invalidPass
	 * @return
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> invalidPass){
		ArrayList<String> wrongPasswords = new ArrayList<String>();
		for(int i=0; i<invalidPass.size(); i++) {
			try {
				isValidPassword(invalidPass.get(i));
			}
			catch(Exception e){
				wrongPasswords.add(invalidPass.get(i) + " " + e.getMessage());
			}
		}
		
		return wrongPasswords;
	}
	
}
