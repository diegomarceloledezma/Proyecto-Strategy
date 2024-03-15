package strategy;

public interface EncryptionStrategy {
	void init();
    byte[] encrypt(byte[] bs);
    String decrypt(byte[] data);
}
