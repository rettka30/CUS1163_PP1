import java.util.ArrayList;
import java.util.*; 

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
         e.finish = false;
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
   
   public Job findMin(ArrayList<Job> h, int tempus) {
      int small = 0;
      int previous = 0;
      int min = 0;
      for(int i = 0; i < h.size(); i++) {
            Job temp = h.get(i);
            if((temp.finish) && (temp.t <= tempus) && (temp.burst < min)) {
               if(tempus == 0) {
                  small = i;
                  min = temp.burst;
               } else {
                  previous = small;
                  small = i;
                  min = temp.burst;
               }
            }
      }
      Job s = h.get(small);
      Job p = h.get(previous);
      if(min == h.size()) {
         tempus++;
      } else {
         updateSJF(h, s, p, tempus);
      }
      return s;
   }
   
   public void updateSJF(ArrayList<Job> h, Job e, Job last, int time) {
      e.complete = time + e.burst;
      e.arrival = e.complete - e.burst;
      if(h.indexOf(e) == 0) {
         e.wait = 0;
      } else {
         e.wait = last.complete - e.t;
      }
      e.remain = 0;
      e.turn = e.burst + e.wait;
   }
   
   public Job minPre(ArrayList<Job> h, int tempus) {
      int small = 0;
      int min = 0;
      for(int i = 0; i < h.size(); i++) {
            Job temp = h.get(i);
            if((temp.finish) && (temp.t <= tempus) && (temp.remain < min)) {
                  small = i;
                  min = temp.remain;
            }
      }
      Job s = h.get(small);
      if(min == h.size()) {
         tempus++;
      } else {
         updatePre(h, s, tempus);
      }
      return s;
   }
   
   public void updatePre(ArrayList<Job> h, Job e, int time) {
      int index = h.indexOf(e);
      h.get(index).remain--;
      time++;
      if(h.get(index).remain == 0) {
         h.get(index).complete = time;
         h.get(index).finish = false;
      }
   }
   
   public int get_turn(ArrayList<Job> h, int index) {
      Job d = h.get(index);
      h.get(index).turn = d.complete - d.t;
      return h.get(index).turn;
   }
   
   public int get_wait(ArrayList<Job> h, int index) {
      Job d = h.get(index);
      h.get(index).wait = d.turn - d.burst;
      return h.get(index).wait;
   }
}