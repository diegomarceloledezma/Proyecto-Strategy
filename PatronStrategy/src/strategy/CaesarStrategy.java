package strategy;

public class CaesarStrategy implements EncryptionStrategy{
	private final int shift;

    public CaesarStrategy(int shift) {
        this.shift = shift;
    }

    @Override
    public void init() {
    }

    @Override
    public byte[] encrypt(byte[] data) {
    	byte[] encryptedData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            byte originalByte = data[i];
            if (Character.isUpperCase(originalByte)) {
                encryptedData[i] = (byte) ((originalByte + shift - 65) % 26 + 65);
            }
            else if (Character.isLowerCase(originalByte)) {
                encryptedData[i] = (byte) ((originalByte + shift - 97) % 26 + 97);
            }
            else {
                encryptedData[i] = originalByte;
            }
        }
        return encryptedData;
    }

    @Override
    public String decrypt(byte[] data) {
    	byte[] decryptedData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            byte originalByte = data[i];
            if (Character.isUpperCase(originalByte)) {
                decryptedData[i] = (byte) ((originalByte - shift - 65 + 26) % 26 + 65);
            }
            else if (Character.isLowerCase(originalByte)) {
                decryptedData[i] = (byte) ((originalByte - shift - 97 + 26) % 26 + 97);
            }
            else {
                decryptedData[i] = originalByte;
            }
        }
        return new String(decryptedData);
    }
}
