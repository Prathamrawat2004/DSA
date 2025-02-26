public class GetBit {
    public static void main(String[] args) {
        // indexing happens from right to left
        int n = 5; // number in decimal format
        int pos = 2;
        int bitMask = 1 << pos; // left shift

        if ((bitMask & n) == 0) {
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }
    }
}
