package pack1;

public class Spy extends Listener {

	@Override
	public String decrypt(String plainText, int keyvalue) {
		BinaryDecryption binaryDecryption = new BinaryDecryption();
		return binaryDecryption.decrypt(plainText, keyvalue);
	}

}
