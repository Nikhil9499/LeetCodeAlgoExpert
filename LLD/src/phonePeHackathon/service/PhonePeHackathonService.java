package phonePeHackathon.service;


import phonePeHackathon.dto.ContreteSortedProblems;
import phonePeHackathon.dto.ProblemUsersWIthAvgTime;
import phonePeHackathon.dto.SortedProblems;
import phonePeHackathon.exceptions.InvalidDifficultyException;
import phonePeHackathon.models.LeaderboardEntry;
import phonePeHackathon.models.Problem;

import java.util.*;

public interface PhonePeHackathonService {
    public void addUser(String name, String department);
    public List<Problem> fetchProblems(String tag, String difficultyLevel, String sortBy);
    public boolean solve(String userName, String problemName, double timeTaken);
    public Set<Problem> fetchSolvedProblems(String userName);
    public List<LeaderboardEntry> displayLeaderboard(boolean byDepartment, int n);
    boolean addProblem(String name, String description, String tag, String difficultyLevel, int score) throws InvalidDifficultyException;
    ProblemUsersWIthAvgTime getUsersByProblem(String problemName);
    void initialiseProblems();
}