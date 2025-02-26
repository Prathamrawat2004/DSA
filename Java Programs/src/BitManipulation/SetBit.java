public class SetBit {
    // setbit operation means setting the given positioned bit = 1
    public static void main(String[] args) {
        int n = 5; // number in decimal format
        int pos = 2;
        int bitMask = 1 << pos; // left shift

        int newNumber = bitMask | n;
        System.out.println(newNumber);
    }
}
