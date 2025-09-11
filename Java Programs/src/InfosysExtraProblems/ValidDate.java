package InfosysExtraProblems;

public class ValidDate {
    public boolean isValidDate(int d, int m, int y) {
        int minYearRange = 1800, maxYearRange = 9999;
        int minMonthRange = 1, maxMonthRange = 12;
        int minDayRange = 1, maxDayRange = 31;

        // checking if the date is in valid range
        if (y < minYearRange || y > maxYearRange) {
            return false;
        }
        if (m < minMonthRange || m > maxMonthRange) {
            return false;
        }
        if (d < minDayRange || d > maxDayRange) {
            return false;
        }

        // checking MONTH
        if (m == 2) {
            // february month
            if (isLeap(y)) {
                return (d <= 29);
            } else {
                return (d <= 28);
            }
        }

        // if the months are april, june, sept, nov
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            return (d <= 30);
        }

        return true;

    }

    // function to check if the year is a leap year or not
    public boolean isLeap(int year) {
        // if the year is divisible by 4 & if the year is NOT divisible by 100 -> LEAP
        // YEAR
        // if the year is divisible by 400 -> LEAP YEAR

        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

    }
}
