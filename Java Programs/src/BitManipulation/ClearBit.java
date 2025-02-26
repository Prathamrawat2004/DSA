public class ClearBit {
    public static void main(String[] args) {
        // setting the given positioned bit = 0
        int n = 5; // number in decimal format
        int pos = 2;
        int bitMask = 1 << pos; // left shift
        int notBitMask = ~(bitMask);

        int newNumber = notBitMask & n;
        System.out.println(newNumber);
    }

}
