package morse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.*;

public class MorseChat
{
	private String name;
	private ArrayList<String> userInputs;
	private ArrayList<String> chatResponses;
	
	public MorseChat(String name) {
		this.name = name;
		this.userInputs = new ArrayList<String>();
		this.chatResponses = new ArrayList<String>();
		
		//alphabet hash map
		
		HashMap<String, String> morseAlphabet = new HashMap<String, String>();
		
		morseAlphabet.put("A", ".-");
		morseAlphabet.put("B", "-...");
		morseAlphabet.put("C", "-.-.");
		morseAlphabet.put("D", "-..");
		morseAlphabet.put("E", ".");
		morseAlphabet.put("F", "..-.");
		morseAlphabet.put("G", "--.");
		morseAlphabet.put("H", "....");
		morseAlphabet.put("I", "..");
		morseAlphabet.put("J", ".---");
		morseAlphabet.put("K", "-.-");
		morseAlphabet.put("L", ".-..");
		morseAlphabet.put("M", "--");
		morseAlphabet.put("N", "-.");
		morseAlphabet.put("O", "---");
		morseAlphabet.put("P", ".--.");
		morseAlphabet.put("Q", "--.-");
		morseAlphabet.put("R", ".-.");
		morseAlphabet.put("S", "...");
		morseAlphabet.put("T", "-");
		morseAlphabet.put("U", "..-");
		morseAlphabet.put("V", "..-");
		morseAlphabet.put("W", ".--");
		morseAlphabet.put("X", "-..-");
		morseAlphabet.put("Y", "-.--");
		morseAlphabet.put("Z", "--..");
		
		
		
	}
	
	//Alphabet random number 
	
	private static <String>
		String getRandomElement(Set<? extends String> set) {
			Random random = new Random();
			
			int randomNumber = random.nextInt(set.size());
			Iterator<? extends String> iterator = set.iterator();
			int currentIndex = 0;
			
			String randomElement = null;
			
			while(iterator.hasNext()) {
				randomElement = iterator.next();
				
				if(currentIndex == randomNumber) 
					return randomElement;
				
				
				currentIndex++;
			}
			return randomElement;
	}
	
	public static String processTextSentences(String text) {
		String response = "You said: ";
		
		response += text + "\n";
		
		return response;
	}
	
	public static String processTextAlphabet(String text) {
		String response = "You said: ";
		response += text + "\n";
		
		response += "Welcome to the Morse Code Alphabet, characters will be presented to you in either morse code or as letters, please type in the corresponding letter or morse code" + "\n";
		response += "For example: if the screen displays A please type in .-  , and visversa" + "\n";
		
		return response;
	}
	
	public ArrayList<String> getUserInputs() {
		return this.userInputs;
	}
	
	public ArrayList<String> getChatbotResponses() {
		return this.chatResponses;
	}
	
	
	public void setUserInputs(ArrayList<String> input) {
		this.userInputs = input;
	}
	
	public void setChatbotResponses(ArrayList<String> responses) {
		this.chatResponses = responses;
	}
	
}
