
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {

    static class Meeting {

        int start, end, index;

        public Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

    }

    // TC: O(N) + O(NlogN) + O(N) (adding, sorting, picking), SC: O(N) + O(N) (storing, returning)
    public static List<Integer> scheduler(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();
        int n = start.length;

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        meetings.sort(Comparator.comparingInt(m -> m.end));

        List<Integer> schedule = new ArrayList<>();
        int lastEnd = -1;

        for (Meeting m : meetings) {
            if (m.start > lastEnd) {
                schedule.add(m.index);
                lastEnd = m.end;
            }
        }

        return schedule;
    }

    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8}, end = {5, 4, 2, 9, 7, 9};
        System.out.println(scheduler(start, end));
    }
}
