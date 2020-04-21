public class Job {

   public String n;
   public int t;
   public int burst;

   public Job(String name, int time, int CPUBurst) {
      n = name;
      t = time;
      burst = CPUBurst;
   }
   
   public String toString() {
      return "Job #" + n + " => Time in: " + t + "; CPU Burst: " + burst;
   }
   
}