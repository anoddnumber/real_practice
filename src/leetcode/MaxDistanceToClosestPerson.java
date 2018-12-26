package leetcode;

import java.util.ArrayList;
import java.util.List;


public class MaxDistanceToClosestPerson {
    public int maxDistToClosest(int[] arr) {
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                s.add(i);
            }
        }
        
        List<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < s.size(); i++) {
            if (i == 0) {
                seats.add(new Seat(s.get(i), s.get(i)));
            }
            
            if (i == s.size() - 1) {
                if (s.get(i) != arr.length - 1) {
                    seats.add(new Seat(arr.length - 1, arr.length - s.get(i) - 1));
                }
            }
            
            System.out.println("i: " + i);
            System.out.println("s.size(): " + s.size());
            if (i != 0) {
                seats.add(new Seat((s.get(i) + s.get(i-1)) / 2, (s.get(i) - s.get(i-1)) / 2));
            }
        }
        
        
        
        int maxDist = 0;
        int maxIndex = 0;
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            System.out.println("seat.getDist(): " + seat.getDist());
            System.out.println("seat.getIndex(): " + seat.getIndex());
            if (seat.getDist() > maxDist) {
                maxDist = seat.getDist();
                maxIndex = seat.getIndex();
            }
        }
        return maxDist;
    }
    
    class Seat {
        int index;
        int dist;
        Seat(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
        
        int getDist() {
            return dist;
        }
        
        int getIndex() {
            return index;
        }
    }
    
    public static void main(String[] args) {
    	System.out.println("start");
    	MaxDistanceToClosestPerson test = new MaxDistanceToClosestPerson();
    	
    	int[] testArr = {1,0,1};
    	System.out.println(test.maxDistToClosest(testArr));
    }
}
