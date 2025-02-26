public class UpdateBit {
    public static void main(String[] args) {
        // updating the bit to either 0 or 1
        int n = 5; // 0101
        int pos = 1;

        // or 0
        // will be taking from user using scanner class
        int oper = 1;

        int bitMask = 1 << pos;

        if (oper == 1) {
            // set
            int newNumber = bitMask | n;
            System.out.println(newNumber);

        } else {

            // clear
            int newBitMask = ~(bitMask);
            int newNumber = newBitMask & n;
            System.out.println(newNumber);
        }
    }
}
