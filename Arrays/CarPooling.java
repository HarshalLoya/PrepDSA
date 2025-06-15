import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarPooling {

    // approach 1: event based line sweep
    // TC: O(NlonN) (sorting), SC: O(N)
    static class Event implements Comparable<Event> {

        int distance;
        int passengers;

        public Event(int distance, int passengers) {
            this.distance = distance;
            this.passengers = passengers;
        }

        @Override
        public int compareTo(Event other) {
            if (this.distance != other.distance) {
                return Integer.compare(this.distance, other.distance);
            }
            return Integer.compare(this.passengers, other.passengers);
        }
    }

    public static boolean carPooling(int capacity, int[][] trips) {
        List<Event> events = new ArrayList<>();
        for (int[] trip : trips) {
            events.add(new Event(trip[1], trip[0]));
            events.add(new Event(trip[2], -trip[0]));
        }
        Collections.sort(events);
        int currLoad = 0;
        for (Event e : events) {
            currLoad += e.passengers;
            if (currLoad > capacity) {
                return false;
            }
        }
        return true;
    }

    // approach 2: using difference array (prefix sum via difference array)
    // TC: O(N + M) (M = time range if bounded), SC: O(M)
    // public static boolean carPooling(int capacity, int[][] trips) {
    //     int[] diff = new int[1001];

    //     for (int[] trip : trips) {
    //         int num = trip[0], from = trip[1], to = trip[2];
    //         diff[from] += num;
    //         diff[to] -= num;
    //     }

    //     int load = 0;
    //     for (int i : diff) {
    //         load += i;
    //         if (load > capacity) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
        int[][][] testTrips = {
            {{2, 1, 5}, {3, 5, 7}},
            {{2, 1, 5}, {3, 3, 7}},
            {{3, 2, 7}, {2, 4, 6}},
            {{4, 2, 2}}
        };

        int[] capacities = {5, 4, 5, 3};
        boolean[] expected = {true, false, true, true};

        for (int i = 0; i < testTrips.length; i++) {
            boolean result = carPooling(capacities[i], testTrips[i]);
            System.out.printf("Test %d: Expected = %b, Got = %b → %s\n",
                    i + 1, expected[i], result, result == expected[i] ? "PASS" : "FAIL");
        }
    }
}
