package pack1;
import java.util.ArrayList;
import java.util.List;

public class Encrypter {


	ArrayList<Listener> listeners = new ArrayList<Listener>();
	ArrayList<Encryption> AlgorithmsOfEncryption = new ArrayList<Encryption>();
	int key;
	
	public Encrypter register(Encryption encryption, int keyvalue, Listener listener) {

		Encrypter encrypter = new Encrypter();
		return encrypter;
	}
}

class ShiftEncryption implements Encryption {

	@Override
	public String encrypt(String plainText, int keyvalue) {

		String encryptedMessage = "";
		char[] charText = plainText.toCharArray();

		for (char c : charText) {
			c += keyvalue;
			encryptedMessage = encryptedMessage + c;
		}
		return encryptedMessage;
	}
}
class BinaryEncryption implements Encryption {

	@Override
	public String encrypt(String plainText, int keyvalue) {
		
		String text = plainText;  
		String outputString = ""; 
        
		for (int i = 0; i < text.length(); i++) {
			outputString = outputString + Character.toString((char) (text.charAt(i) ^ keyvalue));
		}
		return outputString;
	}
}
