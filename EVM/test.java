import java.io.*;
import java.util.*;

public class test {
    public static void main(String[] args){
  /*      Scanner sc = new Scanner(System.in);
        System.out.println("give");
        String userID = sc.next();
        File data = new File("Voter id.txt");
        try{
            Scanner in = new Scanner(data);
            while(in.hasNext()){
                String line = in.nextLine();
                if( line.contains(userID))
                    System.out.println(line);
            }
            in.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


   */
        System.out.println("These are the list of candidates:");
        File candidates = new File("Candidates.txt");
        int index = 1;
        Scanner scan = null;
        try {
            scan = new Scanner(candidates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(scan.hasNext()){
            String candidateName = scan.next();
            System.out.println(index + candidateName);
            index += 1;}
}
}
// "C:\Users\Admin\COMSATS\Semester II\CSC103\Semester Project\src\Candidates"