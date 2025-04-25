import java.util.Arrays;
import java.util.Base64;

public class Main {

  public static void main(String[] args) {
    /*Criptografar*/

    String message = "Mensagem secreta";
    String key = "AES muito brabo.";

    byte[][] messageState = CreateState.create(message);
    byte[][] keyState = CreateState.create(key);

    byte[][][] roundSubkeys = KeyExpansion.expand(keyState);

    byte[][] encryptedState = AES.encrypt(messageState, roundSubkeys);

    String encryptedString = convertToBase64(encryptedState);

    System.out.println("Mensagem original: " + message);
    System.out.println("String encriptada: " + encryptedString);
    System.out.println("Estado criptografado: " + Arrays.deepToString(encryptedState));

    /*Descriptografar*/

    System.out.println("-------------------------------------------------");
    System.out.println("Descriptografar:");

    byte[][] stateFromBase64 = convertFromBase64(encryptedString);
    byte[][] decryptedState = DecryptAES.decrypt(stateFromBase64, roundSubkeys);

    String decryptedMessage = convertStateToString(decryptedState);

    System.out.println("Mensagem descriptografada: " + decryptedMessage);
  }

  public static String convertToBase64(byte[][] state) {
    byte[] array = new byte[16];

    for(int col = 0; col < 4; col++) {
      for(int row = 0; row < 4; row++) {
        array[col * 4 + row] = state[row][col];
      }
    }

    return Base64.getEncoder().encodeToString(array);
  }

  public static byte[][] convertFromBase64(String base64String) {
    byte[] array = Base64.getDecoder().decode(base64String);

    byte[][] state = new byte[4][4];

    for (int col = 0; col < 4; col++) {
      for (int row = 0; row < 4; row++) {
        state[row][col] = array[col * 4 + row];
      }
    }

    return state;
  }

  public static String convertStateToString(byte[][] state) {
    byte[] array = new byte[16];

    for(int col = 0; col < 4; col++) {
      for(int row = 0; row < 4; row++) {
        array[col * 4 + row] = state[row][col];
      }
    }

    return new String(array);
  }
}