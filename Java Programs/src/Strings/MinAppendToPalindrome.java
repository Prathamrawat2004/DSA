package Strings;
// revisions = 1
public class MinAppendToPalindrome {
    public int solve(String A){
        // removing the leading and trailing spaces
        A = A.trim();

        int n = A.length();

        // finding the longest palindromic suffix
        for(int i = 0; i < n; i++){
            if(isPalindrome(A, i, n - 1)){
                return i;
            }
        }

        // worst case
        return n - 1;
    }

    public boolean isPalindrome(String A, int left, int right){
        while (left < right) {
            if(A.charAt(left) != A.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
}
