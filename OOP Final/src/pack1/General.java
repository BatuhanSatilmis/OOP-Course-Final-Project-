package pack1;

public class General extends Listener {

	@Override
	public String decrypt(String plainText, int keyvalue) {

		ShiftDecryption shiftDecryption = new ShiftDecryption();
		return shiftDecryption.decrypt(plainText, keyvalue);

	}
}
