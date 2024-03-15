package strategy;

public class Main {
	public static void main(String[] args) {
        String word = "Empleando Strategy";

        byte[] aesKey = "0123456789abcdef".getBytes(); 
        byte[] aesIV = "0123456789abcdef".getBytes();  
        EncryptionStrategy aesStrategy = new AESStrategy(aesKey, aesIV);
        StrategyContext aesContext = new StrategyContext(aesStrategy);

        byte[] aesEncrypted = aesContext.encryptText(word.getBytes());
        String aesDecrypted = aesContext.decryptText(aesEncrypted);

        EncryptionStrategy caesarStrategy = new CaesarStrategy(3);
        StrategyContext caesarContext = new StrategyContext(caesarStrategy);

        byte[] caesarEncrypted = caesarContext.encryptText(word.getBytes());
        String caesarDecrypted = caesarContext.decryptText(caesarEncrypted);

        System.out.println("AES:");
        System.out.println("Encriptado: " + new String(aesEncrypted));
        System.out.println("Desencriptado: " + aesDecrypted);

        System.out.println("Caesa:");
        System.out.println("Encriptado: " + new String(caesarEncrypted));
        System.out.println("Desencriptado: " + caesarDecrypted);
    }
}
