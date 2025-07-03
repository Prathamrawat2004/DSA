package Arrays;

import java.util.ArrayList;
import java.util.*;

public class HotelBookings {
    public boolean hotel(ArrayList<Integer> arrivals, ArrayList<Integer> departures, int rooms){
        // getting the size of bookings
        int n = arrivals.size();

        // sorting the bookings
        Collections.sort(arrivals);
        Collections.sort(departures);

        // initializing pointers
        int i = 0; // for arrivals
        int j = 0; // for departures
        int guestsInHotel = 0;

        while(i < n && j < n){
            if(arrivals.get(i) < departures.get(j)){
                // new guest arrived
                guestsInHotel++;

                if(guestsInHotel > rooms) return false;

                i++;

            }else{
                guestsInHotel--;

                j++;
            }
        }

        return true;
    }
}
