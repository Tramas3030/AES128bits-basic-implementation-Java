public class SubstituteBytes {

  public static byte[][] execute(byte[][] state) {
    byte[][] result = new byte[4][4];

    for(int row = 0; row < 4; row++) {
      for(int col = 0; col < 4; col++) {
        int r = (state[row][col] & 0xF0) >> 4;
        int c = state[row][col] & 0x0F;

        result[row][col] = KeyExpansion.SBOX[r][c];
      }
    }

    return result;
  }

}
