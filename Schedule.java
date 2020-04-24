import java.util.ArrayList;

public class Schedule {
   
   public Schedule() {}
   
   public String FCFS(Job e, ArrayList<Job> h) {
      int f = h.indexOf(e);
      if(f == 0) {
         e.remain = 0;
         e.turn = e.burst;
         e.complete = e.burst;
      } else {
         int o = h.get(f-1).complete;
         e.remain = 0;
         e.wait = FCFS_wait(o, e.t);
         e.arrival = e.t + e.wait;
         e.complete = e.arrival + e.burst;
         e.turn = FCFS_turn(e.burst, e.wait);
      }
      h.set(f, e);
      return e.toString();
   }
   
   public int FCFS_wait(int x, int y) {
      return (x - y);
   }
   
   public int FCFS_turn(int q, int w) {
      return (q + w);
   }
}