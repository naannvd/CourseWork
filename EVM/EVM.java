import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EVM {

    // public variables defined to minimize redundancy of code

    public static String voterID = "";
    public static String username = "admin";
    public static String password = "admin";
    public static int constituencyChoice;
    public static Hashtable<String, Integer> candidates = new Hashtable<>();
    public static int ptiVotes, mqmVotes, pmlnVotes, tlpVotes, harambeVotes;

    public static void main(String[] args) {
        candidates.put("PTI", ptiVotes);
        candidates.put("MQM", mqmVotes);
        candidates.put("Pak Muslim League-N", pmlnVotes);
        candidates.put("Tehreek Labaik", tlpVotes);
        candidates.put("Harambe", harambeVotes);

        System.out.println("\nWelcome to General Elections \n\n");
        startVote(username, password);
    }

    static void menu() {

        // presents 2 options and gives relevant output

        Scanner in = new Scanner(System.in);
        System.out.println("1. Cast vote: ");
        System.out.println("2. Close Voting: ");
        int userChoice = in.nextInt();
        switch (userChoice) {
            case (1) -> {
                IDCheck();
                castVote();
            }
            case (2) -> closeVote(username, password);
        }
    }

    static void startVote(String username, String password) {
        // verifies RO confidential details and proceeds to menu
        Scanner in = new Scanner(System.in);
        System.out.println("Enter officer login details:");
        int tries = 1;
        while (tries <= 3) {
            String userInput = in.next();
            String userPass = in.next();

            if (userInput.equals(username) && userPass.equals(password)) {
                System.out.println("\nPlease select a constituency: ");
                System.out.println(" 1. Sindh \n 2. Punjab \n 3. Balochistan \n 4. KPK \n 5. Islamabad");
                constituencyChoice = in.nextInt();
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yy");
                String localDate = date.format(formatDate);
                System.out.println("\nThe voting process for " + constituencySelect(constituencyChoice) + " has been selected on " + localDate);
                menu();
            } else {
                tries += 1;
                System.out.println("Incorrect login details");
                if (tries == 3)
                    System.out.println("You have been locked out");
            }
        }
    }

    static String constituencySelect(int constituencyChoice) {
        // method defined to call the selected constituency in different methods
        return switch (constituencyChoice) {
            case (1) -> "Sindh";
            case (2) -> "Punjab";
            case (3) -> "Balochistan";
            case (4) -> "KPK";
            case (5) -> "Islamabad";
            default -> "";
        };
    }

    static void IDCheck() {
        // checks the registration number entered by user
        Scanner in = new Scanner(System.in);
        System.out.println("\nPlease enter your registration number: ");
        voterID = in.next();
        while (true) {
            if (verifiedVoter(voterID))
                break;
            else {
                System.out.println("Invalid registration number");
                System.out.println("Please enter again : ");
                voterID = in.next();
            }
        }
    }

    public static void castVote() {
        // method to collect votes from the user for a candidate
        registeredVoter(voterID);
        Scanner in = new Scanner(System.in);
        System.out.println("These are the list of candidates:");
        File candidateNames = new File("C:\\Users\\Admin\\COMSATS\\Semester II\\CSC103\\Semester Project\\src\\Candidates.txt");
        Scanner scan = null;
        int candidateNum = 1;
        try {
            scan = new Scanner(candidateNames);
        } catch (FileNotFoundException exceptionError) {
            exceptionError.printStackTrace();
        }
        while (scan.hasNext()) {
            String candidateName = scan.next();
            System.out.println(candidateNum + "." + candidateName);
            candidateNum++;
        }
        int userVote = in.nextInt();
        switch (userVote) {
            case (1) -> {
                candidates.put("PTI", candidates.get("PTI") + 1);
                ptiVotes++;
                System.out.println("Your vote has been casted");
                System.out.println("Thank you for voting");
            }
            case (2) -> {
                candidates.put("MQM", candidates.get("MQM") + 1);
                mqmVotes++;
                System.out.println("Your vote has been casted");
                System.out.println("Thank you for voting");
            }
            case (3) -> {
                candidates.put("Pak Muslim League - N", candidates.get("Pak Muslim League-N") + 1);
                pmlnVotes++;
                System.out.println("Your vote has been casted");
                System.out.println("Thank you for voting");
            }
            case (4) -> {
                candidates.put("Tehreek Labaik", candidates.get("Tehreek Labaik") + 1);
                tlpVotes++;
                System.out.println("Your vote has been casted");
                System.out.println("Thank you for voting");
            }
            case (5) -> {
                candidates.put("Harambe", candidates.get("Harambe") + 1);
                harambeVotes++;
                System.out.println("\nYour vote has been casted");
                System.out.println("Thank you for voting\n");
            }
        }
        /*File IDs = new File("C:\\Users\\Admin\\COMSATS\\Semester II\\CSC103\\Semester Project\\src\\" + constituencySelect(constituencyChoice) + ".txt");
        Scanner read = null;
        boolean flag = false;
        try {
            FileWriter writer = new FileWriter(IDs);
            read = new Scanner(IDs);
        } catch (IOException exceptionError) {
            exceptionError.printStackTrace();
        }
        while (read.hasNext()) {
            String line = read.nextLine();
            if (line.contains(voterID)) {

                break;
            }
        }*/

            try {
                Path path = Paths.get("C:\\Users\\Admin\\COMSATS\\Semester II\\CSC103\\Semester Project\\src\\" + constituencySelect(constituencyChoice) + ".txt");
                Stream<String> lines = Files.lines(path);
                List<String> replaced = lines.map(line -> line.replaceAll(voterID, "-")).collect(Collectors.toList());
                Files.write(path, replaced);
                lines.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            menu();
        }

        static void registeredVoter (String voterID){
            // if entered registration number is a part of the selected constituency
            File IDs = new File("C:\\Users\\Admin\\COMSATS\\Semester II\\CSC103\\Semester Project\\src\\" + constituencySelect(constituencyChoice) + ".txt");
            boolean flag = false;
            Scanner in = null;
            String check = "-";
            boolean flag2 = false;
            try {
                in = new Scanner(IDs);
            } catch (FileNotFoundException exceptionError) {
                exceptionError.printStackTrace();
            }
            while (in.hasNext()) {
                String line = in.nextLine();
                if (line.contains(voterID)) {
                    flag = true;
                    break;
                }
                if (line.contains(check))
                    flag2 = true;

            }

            if (flag)
                System.out.println("You are registered for this constituency\n");
            else if (flag2) {
                System.out.println("You have already casted your vote\n");
                menu();
            }
            else {
                System.out.println("You are not registered for this constituency\n");
                menu();
            }
        }

        static boolean verifiedVoter (String voterID){
            // verifies the proper format of the registration number
            return (voterID.length() == 12) && (Character.isAlphabetic(voterID.charAt(0)) && Character.isAlphabetic(voterID.charAt(1)) &&
                    Character.isDigit(voterID.charAt(2)) && Character.isDigit(voterID.charAt(3)) &&
                    (voterID.charAt(4) == '-') &&
                    Character.isAlphabetic(voterID.charAt(5)) && Character.isAlphabetic(voterID.charAt(6)) &&
                    Character.isAlphabetic(voterID.charAt(7)) &&
                    (voterID.charAt(8) == '-') &&
                    Character.isDigit(voterID.charAt(9)) && Character.isDigit(voterID.charAt(10)) &&
                    Character.isDigit(voterID.charAt(11)));
        }

        static void closeVote (String username, String password){
            // RO details entered to close the voting process
            Scanner in = new Scanner(System.in);
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
            String localTime = time.format(formatTime);
            System.out.println("Enter RO credentials ");
            String userInput = in.next();
            String userPass = in.next();
            if (userInput.equals(username) && userPass.equals(password)) {
                System.out.println("The voting process for " + constituencySelect(constituencyChoice) + " has been closed at " + localTime + "\n");
                results();
            } else {
                System.out.println("Invalid login credentials. Unable to close vote");
                menu();
            }
        }

        static void results () {
            // displays the election winner and total votes for each candidate
            String dash = "*";
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MMMM-yy");
            String localDate = date.format(formatDate);
            try {
                FileWriter votes = new FileWriter("C:\\Users\\Admin\\COMSATS\\Semester II\\CSC103\\Semester Project\\src\\votes.txt", true);
                votes.write("\nThe total votes for each candidate from " + constituencySelect(constituencyChoice) + " on " + localDate);
                votes.write("\nPTI Votes - " + ptiVotes);
                votes.write("\nMQM Votes - " + mqmVotes);
                votes.write("\nPak Muslim League-N Votes - " + pmlnVotes);
                votes.write("\nTehreek Labaik Votes - " + tlpVotes);
                votes.write("\nHarambe Votes - " + harambeVotes);
                votes.write("\n");
                votes.write(dash.repeat(69));
                votes.close();
            } catch (IOException exceptionError) {
                exceptionError.printStackTrace();
            }
                /*
                printStackTrace method used to handle exceptions/errors
                    prints throwable exception along with line number and class
                diff. between s.o.p(exceptionError) and exceptionError.printStackTrace()
                is that s.o.p may only print an error occurred whereas printStackTrace prints
                the exact line numbers on which the error occurred
                 */

            int castedVotes = ptiVotes + mqmVotes + tlpVotes + pmlnVotes + harambeVotes;
            int totalVoters = 20;
            double voterTurnout = (((double) castedVotes) / (double) totalVoters) * 100;
            int[] candidateVotes = new int[]{ptiVotes, mqmVotes, pmlnVotes, tlpVotes, harambeVotes};
            String[] candidateNames = new String[]{"PTI", "MQM", "Pak Muslim League-N", "Tehreek Labaik", "Harambe"};

            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (candidateVotes[i] < candidateVotes[j]) {
                        int temp = candidateVotes[i];
                        candidateVotes[i] = candidateVotes[j];
                        candidateVotes[j] = temp;
                        String temp2 = candidateNames[i];
                        candidateNames[i] = candidateNames[j];
                        candidateNames[j] = temp2;
                    }
                }
            }
            for (int i = 1; i < 3; i++) {
                if (candidateVotes[0] == candidateVotes[i]) {
                    System.out.println(candidateNames[i] + " got " + candidateVotes[i] + " votes");
                }
            }
            System.out.println(candidateNames[0] + " won the election with " + candidateVotes[0] + " votes\n");

            for (String candidate : candidates.keySet())
                System.out.println(candidate + " : " + candidates.get(candidate));
            System.out.printf("\nVoter turnout %.2f", voterTurnout);
            System.out.print("%");
            System.exit(0);
        }
    }
