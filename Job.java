public class Job implements Comparable<Job> {

   public String n;
   public int t;
   public int burst;
   public int remain;
   public int wait;
   public int turn;
   public int arrival;
   public int complete;

   public Job(String name, int time, int CPUBurst, Job nxt) {
      n = name;
      t = time;
      burst = CPUBurst;
      remain = CPUBurst;
      wait = 0;
      turn = 0;
      arrival = 0;
      complete = 0;
   }
   
   public boolean equals(Job other) {
      return this.burst == other.burst;
   }
   
   public int compareTo(Job other) {
      if(this.equals(other)) {
         return 0;
      } else if(this.burst > other.burst) {
         return 1;
      } else {
         return -1;
      }
   }
   
   public String toString() {
      return "Job #" + n + " => Time in: " + t + "; CPU Burst: " + burst + "; Arrival: " + arrival + "; Completion: " + complete +  "; Remaining: " + remain + "; Wait: " + wait + "; Turnaround: " + turn;
   }
   
}