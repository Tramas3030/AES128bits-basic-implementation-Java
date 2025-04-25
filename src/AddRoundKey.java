public class AddRoundKey {

  public static byte[][] execute(byte[][] messageState, byte[][] keyState) {
    byte[][] state = new byte[4][4];

    for(int row = 0; row < 4; row++) {
      for(int col = 0; col < 4; col++) {
        state[row][col] = (byte) (messageState[row][col] ^ keyState[row][col]);
      }
    }

    return state;
  }

}
