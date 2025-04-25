public class AES {

  public static byte[][] encrypt(byte[][] messageState, byte[][][] roundSubkeys) {
    byte[][] state = AddRoundKey.execute(messageState, roundSubkeys[0]);

    for(int round = 0; round < 9; round++) {
      state = SubstituteBytes.execute(state);
      state = ShiftRows.execute(state);
      state = MixColumns.execute(state);
      state = AddRoundKey.execute(state, roundSubkeys[round + 1]);
    }

    state = SubstituteBytes.execute(state);
    state = ShiftRows.execute(state);
    state = AddRoundKey.execute(state, roundSubkeys[10]);

    return state;
  }

}
