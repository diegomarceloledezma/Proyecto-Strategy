package strategy;

public class StrategyContext {
	private EncryptionStrategy strategy;

    public StrategyContext(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public byte[] encryptText(byte[] bs) {
        strategy.init();
        return strategy.encrypt(bs);
    }

    public String decryptText(byte[] encryptedData) {
        strategy.init();
        return strategy.decrypt(encryptedData);
    }

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }
}
