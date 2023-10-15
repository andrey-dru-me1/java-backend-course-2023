package edu.hw1;

public class Task7 {
    private Task7() {
    }

    private static int calculateBinaryRadix(int number) {
        int i;
        int n = number;
        for (i = 0; n != 0; i++) {
            n >>= 1;
        }
        return i;
    }

    public static int rotateLeft(int n, int shift) {
        int sh = shift;
        if (sh < 0) {
            return rotateRight(n, -sh);
        }
        int bitCount = calculateBinaryRadix(n);
        if (bitCount == 0) {
            return 0;
        }
        sh %= bitCount;
        int shiftMask = ((1 << sh) - 1) << (bitCount - sh);
        int numberMask = (1 << bitCount) - 1;
        int res = (n << sh) | ((n & shiftMask) >> (bitCount - sh));
        return res & numberMask;
    }

    public static int rotateRight(int n, int shift) {
        int sh = shift;
        if (sh < 0) {
            return rotateLeft(n, -sh);
        }
        int bitCount = calculateBinaryRadix(n);
        if (bitCount == 0) {
            return 0;
        }
        sh %= bitCount;
        int shiftMask = (1 << sh) - 1;
        return (n >> sh) | ((n & shiftMask) << (bitCount - sh));
    }
}
