import java.util.ArrayList;
import java.util.List;

public class MeetingRoomsII {
    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        intervals.sort((a, b) -> Integer.compare(a.end, b.end));
        List<List<Interval>> alInterval = new ArrayList<>();
        List<Interval> a1 = new ArrayList<>();
        a1.add(intervals.get(0));
        alInterval.add(a1);
        int i = 1;
        while (i < intervals.size()) {
            boolean flag = false;
            for (List<Interval> list : alInterval) {
                if (list.get(list.size() - 1).end <= intervals.get(i).start) {
                    flag = true;
                    list.add(intervals.get(i));
                    break;
                }
            }
            if (!flag) {
                List<Interval> a2 = new ArrayList<>();
                a2.add(intervals.get(i));
                alInterval.add(a2);
            }
            i++;
        }
        return alInterval.size();
    }

    public static void main(String[] args) {

    }
}
