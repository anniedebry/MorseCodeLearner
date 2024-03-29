package morse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.*;


public class MorseChat
{
	private ArrayList<String> userInputs;
	private ArrayList<String> chatResponses;
	private String currentMorse;
	
	public MorseChat() {
		this.userInputs = new ArrayList<String>();
		this.chatResponses = new ArrayList<String>();
		this.currentMorse = "";
		
		//alphabet hash map
		
	}
	
	//Alphabet random number 
	public String alphabetMap() {
		
		String letter = new String(); 
		
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
		
		List<Object> valuesList = new ArrayList<Object>(morseAlphabet.keySet());
		Collections.shuffle(valuesList);
		
		currentMorse = (String)valuesList.get(0);
		letter = (String)morseAlphabet.get(currentMorse);
		
		return letter;
		
	}
	
	
	public String processTextSentences(String text) {
		String response = "";
		
		response += text + "\n";
		
		return response;
	}
	
	public String processTextAlphabet(String text) {
		String response = "";
		
<<<<<<< Updated upstream
		response += text + "\n";
=======
>>>>>>> Stashed changes
		
		if(text.equals(currentMorse)) {
			response += "Correct!" + "\n";
		} else {
			response += "Incorrect" + "\n";
		}
		
<<<<<<< Updated upstream
=======
		response += text + "\n";
		
		
		
>>>>>>> Stashed changes
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
