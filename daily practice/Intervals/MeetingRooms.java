import java.util.List;

public class MeetingRooms {
    public class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        int i = 1;
        intervals.sort((a, b) -> Integer.compare(a.end, b.end));
        int lastEnd = intervals.get(0).end;
        if (intervals.size() == 0) {
            return true;
        }
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            if (lastEnd > curr.start) {
                return false;
            } else {
                lastEnd = curr.end;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
