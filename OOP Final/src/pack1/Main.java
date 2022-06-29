package pack1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int keyvalue = 5;
	public static void main(String[] args) throws FileNotFoundException {

		Scanner run = new Scanner(new File("src/text.txt"));
		String plainText = "";

		while (run.hasNextLine()) {
			plainText = run.nextLine();
		}
	
		System.out.println("Unencrypted message from TextFile:" + plainText+"\n");
		Encrypter encrypter = new Encrypter();
		Listener general = new General();
		Listener spy = new Spy();
		
		encrypter.listeners.add(general);
		encrypter.listeners.add(spy);

		ShiftEncryption shiftEncryption = new ShiftEncryption();
		BinaryEncryption binaryEncryption = new BinaryEncryption();
		
		encrypter.AlgorithmsOfEncryption.add(shiftEncryption);
		encrypter.AlgorithmsOfEncryption.add(binaryEncryption);
		
		String shiftEncryptedMessage = shiftEncryption.encrypt(plainText, keyvalue);
		String binaryEncryptedMessage = binaryEncryption.encrypt(plainText, keyvalue);
		                                                        //I was able to do it manually.
		encrypter.register(shiftEncryption, keyvalue, general); // if general wants shift encryption
		encrypter.register(binaryEncryption, keyvalue, spy);    // if the spy that wants binary encryption
	
		String shiftDecryptedMessage = general.decrypt(shiftEncryptedMessage, keyvalue);
		String binaryDecryptedMessage = spy.decrypt(binaryEncryptedMessage, keyvalue);
		
		System.out.println("The encrypted message received by the General is shown as follows;  " + shiftEncryptedMessage);
		System.out.println("The decrypted message that General decrypted: " + shiftDecryptedMessage);
		
		System.out.println("The encrypted message received by the Spy is shown as follows;:      " + binaryEncryptedMessage);
		System.out.println("The decrypted message that Spy decrypted:     " + binaryDecryptedMessage);


	}

}