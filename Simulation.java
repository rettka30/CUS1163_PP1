import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*; 

public class Simulation {

   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Job> a = new ArrayList<Job>();
      ArrayList<Job> b = new ArrayList<Job>();
      ArrayList<Job> c = new ArrayList<Job>();
      Queue<Job> q = new LinkedList<Job>();
      File fd = new File("JobsToRun.txt");
      Scanner in = new Scanner(fd);
      while(in.hasNextLine()) {
         String id = in.nextLine();
         int time = Integer.parseInt(in.nextLine());
         int burst = Integer.parseInt(in.nextLine());
         if(in.hasNextLine()) {
            String blank = in.nextLine();
         }
         Job j = new Job(id, time, burst);
         a.add(j);
         b.add(j);
         c.add(j);
         q.add(j);
      }
      Schedule sch = new Schedule();
      Iterator<Job> iter = q.iterator();
      int total_wait = 0;
      int total_turn = 0;
      System.out.println("First Come First Serve: ");
      while(iter.hasNext()) {
         Job temp = iter.next();
         String ho = sch.FCFS(temp, a);
         total_wait += temp.wait;
         total_turn += temp.turn;
         System.out.println(ho);
      }
      System.out.println("Average Wait time: " + (total_wait/a.size()));
      System.out.println("Average Turnaround time: " + (total_turn/a.size()));
      System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
      System.out.println();
      System.out.println("Shortest Job First: Non-preemptive: ");
      int total_wai = 0;
      int total_tur = 0;
      boolean queued = true;
      int space = 0;
      int time = 0;
      while(queued) {
         if(space == b.size()) {
            queued = false;
         }
         Job temp = sch.findMin(b, time);
         int find = b.indexOf(temp);
         b.get(find).finish = false;
         time += temp.burst;
         System.out.println(temp.toString());
         space++;
         total_wai += temp.wait;
         total_tur += temp.turn;
      }
      System.out.println("Average Wait time: " + (total_wai/b.size()));
      System.out.println("Average Turnaround time: " + (total_tur/b.size()));
      System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
      System.out.println();
      System.out.println("Shortest Job First: Preemptive: ");
      int total_w = 0;
      int total_t = 0;
      boolean qu = true;
      int sp = 0;
      int ti = 0;
      while(qu) {
         if(sp == c.size()) {
            qu = false;
         }
         Job t = sch.findMin(c, ti);
         System.out.println(t.toString());
         sp++;
      }
      for(int v = 0; v < c.size(); v++) {
         total_t += sch.get_turn(c, v);
         total_w += sch.get_wait(c, v);
      }
      System.out.println("Average Wait time: " + (total_w/c.size()));
      System.out.println("Average Turnaround time: " + (total_t/c.size()));
   }

}

