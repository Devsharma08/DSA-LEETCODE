import java.util.*;

// Class definition
class Interval {
    int start;
    int end;
    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Main {

    public List<Interval> freeTimeInterval(List<List<Interval>> officeTime) {
        List<Interval> result = new ArrayList<>();
        if (officeTime == null || officeTime.isEmpty()) return result;

        // Sort all intervals by start time using a PriorityQueue
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (List<Interval> employeeSchedule : officeTime) {
            for (Interval interval : employeeSchedule) {
                pq.offer(interval);
            }
        }

        if (pq.isEmpty()) return result;

        // Initialize our tracking variable with the first interval's end
        Interval first = pq.poll();
        int prevLast = first.end;

        
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();

            // If the current shift starts AFTER the previous shift ended
            if (curr.start > prevLast) {
                // a common free interval!
                result.add(new Interval(prevLast, curr.start));
            }

            // Always update prevLast to be the furthest "work end" seen so far
            prevLast = Math.max(prevLast, curr.end);
        }

        return result;
    }

    public static void main(String[] args) {
       
        Main obj = new Main();
    List<List<Interval>> officeTime = new ArrayList<>();

    List<Interval> emp1 = new ArrayList<>();
    emp1.add(new Interval(1, 2));
    emp1.add(new Interval(5, 6));
    officeTime.add(emp1);


    List<Interval> emp2 = new ArrayList<>();
    emp2.add(new Interval(1, 3));
    officeTime.add(emp2);

    
    List<Interval> emp3 = new ArrayList<>();
    emp3.add(new Interval(4, 10));
    officeTime.add(emp3);

    List<Interval> soln = obj.freeTimeInterval(officeTime);

    System.out.print("Common Free Time: ");
    for (Interval interval : soln) {
        System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
    }
}