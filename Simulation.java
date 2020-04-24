import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*; 

public class Simulation {

   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Job> a = new ArrayList<Job>();
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
         Job j = new Job(id, time, burst, null);
         a.add(j);
         q.add(j);
      }
      Schedule sch = new Schedule();
      Iterator<Job> iter = q.iterator();
      int size = 0;
      int total_wait = 0;
      int total_turn = 0;
      System.out.println("First Come First Serve: ");
      while(iter.hasNext()) {
         Job temp = iter.next();
         String ho = sch.FCFS(temp, a);
         size++;
         total_wait += temp.wait;
         total_turn += temp.turn;
         System.out.println(ho);
      }
      System.out.println("Average Wait time: " + (total_wait/size));
      System.out.println("Average Turnaround time: " + (total_turn/size));
      System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
      System.out.println();
      System.out.println("Shortest Job First: Non-preemptive: ");
      PriorityQueue<Job> pq = new PriorityQueue<Job>();
   }

}

