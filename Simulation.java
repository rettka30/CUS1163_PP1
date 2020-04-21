import java.io.*;
import java.util.Scanner;
public class Simulation {

   public static void main(String[] args) throws FileNotFoundException {
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
         System.out.println(j.toString());
      }
   }

}
