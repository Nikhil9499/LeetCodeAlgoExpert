package phonePeHackathon;

import phonePeHackathon.dto.ContreteSortedProblems;
import phonePeHackathon.dto.ProblemUsersWIthAvgTime;
import phonePeHackathon.dto.SortedProblems;
import phonePeHackathon.models.LeaderboardEntry;
import phonePeHackathon.models.Problem;
import phonePeHackathon.service.PhonePeHackathonService;
import phonePeHackathon.service.impl.PhonePeHackathonServiceImpl;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Driver {
    public static void main(String[] args) throws Exception {
        PhonePeHackathonService hackathon = new PhonePeHackathonServiceImpl();
        hackathon.initialiseProblems();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {

            System.out.println("Enter your choice:");
            System.out.println("1. Register User");
            System.out.println("2. Fetch Problems");
            System.out.println("3. Solve a Problem");
            System.out.println("4. Fetch Solved Problems");
            System.out.println("5. Display Leaderboard");
            System.out.println("6. Add a Problem");
            System.out.println("7. Get users who solved a problem and avg time");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user name:");
                    String userName = scanner.next();
                    System.out.println("Enter department name:");
                    String departmentName = scanner.next();
                    hackathon.addUser(userName, departmentName);
                    System.out.println("User registered successfully");
                    break;
                case 2:
                    System.out.println("Enter difficulty level (easy/medium/hard):");
                    String difficultyLevel = scanner.next();
                    System.out.println("Enter tag:");
                    String tag = scanner.next();
                    System.out.println("Enter sortBy:");
                    String sortBy = scanner.next();
                    List<Problem> problems = hackathon.fetchProblems(tag, difficultyLevel, sortBy);
                    if (problems.isEmpty()) {
                        System.out.println("No problems found");
                    } else {
                        for (Problem problem : problems) {
                            System.out.println(problem);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter user name:");
                    userName = scanner.next();
                    System.out.println("Enter problem name:");
                    String problemName = scanner.next();
                    System.out.println("Enter time taken: ");
                    double timeTaken = scanner.nextDouble();
                    boolean solved = hackathon.solve(userName, problemName, timeTaken);
                    if (solved) {
                        System.out.println("Problem solved successfully");
                    } else {
                        System.out.println("Unable to solve problem");
                    }
                    break;
                case 4:
                    System.out.println("Enter user name:");
                    userName = scanner.next();
                    Set<Problem> solvedProblems = hackathon.fetchSolvedProblems(userName);
                    if (solvedProblems.isEmpty()) {
                        System.out.println("No problems solved by user");
                    } else {
                        for (Problem problem : solvedProblems) {
                            System.out.println(problem);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter leaderboard type (user/department):");
                    String leaderboardType = scanner.next();
                    System.out.println("Enter value of n");
                    int n = scanner.nextInt();
                    List<LeaderboardEntry> leaderboard = hackathon.displayLeaderboard("department".equalsIgnoreCase(leaderboardType), n);
                    if (leaderboard.isEmpty()) {
                        System.out.println("No entries found in leaderboard");
                    } else {
                        for (LeaderboardEntry entry : leaderboard) {
                            System.out.println(entry);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter Problem details as asked below");
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter description:");
                    String description = scanner.next();
                    System.out.println("Enter tag:");
                    tag = scanner.next();
                    System.out.println("Enter difficultyLevel:");
                    difficultyLevel = scanner.next();
                    System.out.println("Enter score:");
                    int score = scanner.nextInt();
                    boolean isProblemAdded = hackathon.addProblem(name, description, tag, difficultyLevel, score);
                    if (isProblemAdded) {
                        System.out.println("Problem added successfully");
                    } else {
                        System.out.println("Unable to add problem");
                    }
                    break;
                case 7:
                    System.out.println("Enter problem name for which you want to see avg time and users");
                    problemName = scanner.next();
                    ProblemUsersWIthAvgTime usersByProblem = hackathon.getUsersByProblem(problemName);
                    System.out.println(usersByProblem);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }
}