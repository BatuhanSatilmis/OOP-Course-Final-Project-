package pack1;

public class Listener implements Decryption {

	@Override
	public String decrypt(String plainText, int key) {
		// TODO Auto-generated method stub
		return null;
	}
}
class ShiftDecryption implements Decryption {
	@Override
	public String decrypt(String plainText, int keyvalue) {
        
		String decryptedMessage = "";

		char[] charText = plainText.toCharArray();
		for (char c : charText) {
			c -= keyvalue;
			decryptedMessage = decryptedMessage + c;
		}
		
		return decryptedMessage;
	}
}

class BinaryDecryption implements Decryption {
	@Override
	public String decrypt(String plainText, int keyvalue) {

		String text = plainText; 
		String decryptedMessage = ""; 
		for (int i = 0; i < text.length(); i++) {
			decryptedMessage = decryptedMessage + Character.toString((char) (text.charAt(i) ^ keyvalue));
		}

		return decryptedMessage;
	}
}