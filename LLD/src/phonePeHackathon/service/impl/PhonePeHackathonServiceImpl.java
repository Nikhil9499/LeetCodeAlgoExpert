package phonePeHackathon.service.impl;
import phonePeHackathon.dto.ContreteSortedProblems;
import phonePeHackathon.dto.ProblemUsersWIthAvgTime;
import phonePeHackathon.dto.SortedProblems;
import phonePeHackathon.exceptions.InvalidDifficultyException;
import phonePeHackathon.exceptions.UserDoesNotExistException;
import phonePeHackathon.models.Contestant;
import phonePeHackathon.models.DepartmentScore;
import phonePeHackathon.models.LeaderboardEntry;
import phonePeHackathon.models.Problem;
import phonePeHackathon.models.enums.Difficulty;
import phonePeHackathon.service.PhonePeHackathonService;
import phonePeHackathon.validation.CommonValidator;

import java.util.*;

public class PhonePeHackathonServiceImpl implements PhonePeHackathonService {

    private final Map<String, Contestant> userMap = new HashMap<>();
    private final Map<String, Problem> problemMap = new HashMap<>();
    private final Map<String, Set<Contestant>> problemUserMap = new HashMap<>();

    @Override
    public void addUser(String name, String departmentName) {
        Contestant contestant = new Contestant(name, departmentName);
        userMap.put(name, contestant);
    }

    @Override
    public List<Problem> fetchProblems(String tag, String difficultyLevel, String sortBy) {
        List<Problem> result = new ArrayList<>();

        for (Problem problem : problemMap.values()) {
            if (tag != null && !tag.equals(problem.getTag())) {
                continue;
            }

            if (difficultyLevel != null && !difficultyLevel.equals(problem.getDifficulty().name())) {
                continue;
            }

            result.add(problem);
        }
        // use sorting strategy here instead
        if (sortBy!= null && sortBy.equalsIgnoreCase("score"))
            result.sort((p1, p2) -> p2.getScore() - p1.getScore());
        return result;
    }

    @Override
    public boolean solve(String userName, String problemName, double timeTaken) {
        if (!CommonValidator.isUserPresent(userName, userMap) || !CommonValidator.isProblemExist(problemName, problemMap)) {
            System.out.println("Either user or problem doesn't exist. Enter right values.");
            return false;
        }
        Contestant contestant = userMap.get(userName);
        Problem problem = problemMap.get(problemName);
        contestant.solveProblem(problem, timeTaken);
        if (problemUserMap.get(problemName) == null) {
            Set<Contestant> contestants = new HashSet<>();
            problemUserMap.put(problemName, contestants);
        }
        problemUserMap.get(problemName).add(contestant);
        return true;
    }

    @Override
    public Set<Problem> fetchSolvedProblems(String userName) throws UserDoesNotExistException {
        if (!CommonValidator.isUserPresent(userName, userMap)) {
            System.out.println("User doesn't exist. Enter right value.");
            throw new UserDoesNotExistException("User doesn't exist with name "+userName);
        }
        Contestant contestant = userMap.get(userName);
        return contestant.getSolvedProblems();
    }

    @Override
    public List<LeaderboardEntry> displayLeaderboard(boolean byDepartment, int n) {
        List<LeaderboardEntry> leaderboard = new ArrayList<>();

        if (byDepartment) {
            Map<String, DepartmentScore> departmentScoreMap = new HashMap<>();

            for (Contestant contestant : userMap.values()) {
                String departmentName = contestant.getDepartmentName();
                int score = contestant.getTotalScore();

                if (departmentScoreMap.containsKey(departmentName)) {
                    departmentScoreMap.get(departmentName).addScore(score);
                } else {
                    departmentScoreMap.put(departmentName, DepartmentScore.builder()
                            .name(departmentName)
                            .score(score)
                            .build());
                }
            }
            departmentScoreMap.values().forEach(departmentScore -> leaderboard.add(LeaderboardEntry.builder()
                            .name(departmentScore.getName())
                            .score(departmentScore.getScore())
                    .build()));
            leaderboard.sort((d1, d2) -> (int) (d2.getScore() - d1.getScore()));
        } else {
            List<Contestant> contestants = new ArrayList<>(userMap.values());
            contestants.sort((u1, u2) -> u2.getTotalScore() - u1.getTotalScore());

            for (int i = 0; i < Math.min(contestants.size(), 10); i++) {
                Contestant contestant = contestants.get(i);
                LeaderboardEntry entry = new LeaderboardEntry(contestant.getName(), contestant.getTotalScore(), contestant.getSolvedProblems());
                leaderboard.add(entry);
            }
        }

        return leaderboard.subList(0, Math.min(n, leaderboard.size()));
    }

    public boolean addProblem(String name, String description, String tag, String difficultyLevel, int score) throws InvalidDifficultyException {
        if (Difficulty.getDifficulty(difficultyLevel) == null) {
            throw new InvalidDifficultyException("Invalid difficulty level passed " + difficultyLevel);
        }
        Problem problem = Problem.builder()
                .name(name)
                .description(description)
                .tag(tag)
                .difficulty(Difficulty.getDifficulty(difficultyLevel))
                .score(score)
                .build();
        problemMap.put(name, problem);
        return true;
    }

    @Override
    public ProblemUsersWIthAvgTime getUsersByProblem(String problemName) {
        if (!CommonValidator.isProblemExist(problemName, problemMap)) {
            System.out.println("Problem doesn't exist with name " + problemName);
            return ProblemUsersWIthAvgTime.builder().build();
        }
        double avgTime = problemMap.get(problemName).getAvgTime();
        Set<Contestant> contestants = problemUserMap.get(problemName);

        return ProblemUsersWIthAvgTime.builder()
                .contestants(contestants)
                .avgTime(avgTime)
                .build();
    }

    public void initialiseProblems() {
        addProblem("p1", "description1", "tag1", "EASY", 10);
        addProblem("p2", "description2", "tag2", "MEDIUM", 20);
        addProblem("p3", "description3", "tag3", "HARD", 30);
        addProblem("p4", "description4", "tag1", "MEDIUM", 15);
        addProblem("p5", "description5", "tag2", "EASY", 25);
    }
}
