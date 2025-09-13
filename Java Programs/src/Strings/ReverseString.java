package Strings;
// revisions = 1
public class ReverseString {
    public String reverse(String A){
        // removing the leading and trailing spaces initially
        A = A.trim();

        // reversed string
        StringBuilder reversed = new StringBuilder();

        // splitting the string based on whitespace characters
        String[] str = A.split("\\s+");

        int i = str.length - 1;
        while (i >= 0) {
            reversed.append(str[i]);
            if(i > 0){
                reversed.append(" ");
            }
            i--;
        }

        return reversed.toString();
    }
}
