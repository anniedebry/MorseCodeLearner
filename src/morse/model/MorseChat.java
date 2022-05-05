package morse.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.*;


public class MorseChat
{
	private ArrayList<String> userInputs;
	private ArrayList<String> chatResponses;
	
	public MorseChat() {
		this.userInputs = new ArrayList<String>();
		this.chatResponses = new ArrayList<String>();
		
		//alphabet hash map
		
	}
	
	//Alphabet random number 
	private String alphabetMap() {
		
		String letter = "";
		
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
//		
//		Random generator = new Random();
//		Object[] values = morseAlphabet.values().toArray();
//		
//		for(int index = 0; index < values.length; index++) {
//			System.out.println(values[index]);
//		}
		
		List<Object> valuesList = new ArrayList<Object>(morseAlphabet.values());
		Collections.shuffle(valuesList);
		
		letter = (String)valuesList.get(0);
	
		
		return letter;
		
	}
	
	
	public String processTextSentences(String text) {
		String response = "";
		
		response += text + "\n";
		
		return response;
	}
	
	public String processTextAlphabet(String text) {
		String response = "";
		response += text + "\n";
		
		response += alphabetMap() + "\n";
		
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
