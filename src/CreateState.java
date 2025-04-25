public class CreateState {

  public static byte[][] create(String string) {
    byte[] stringBytes = string.getBytes();

    byte[][] state = new byte[4][4];

    for(int col = 0; col < 4; col++) {
      for(int row = 0; row < 4; row++) {
        int index = col * 4 + row;
        state[row][col] = stringBytes[index];
      }
    }

    return state;
  }

}
