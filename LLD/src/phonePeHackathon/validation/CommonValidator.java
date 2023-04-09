package phonePeHackathon.validation;

import phonePeHackathon.models.Contestant;
import phonePeHackathon.models.Problem;

import java.util.Map;

public class CommonValidator {
    public static boolean isUserPresent(String userName, Map<String, Contestant> userMap) {
        return userMap.get(userName) != null;
    }

    public static boolean isProblemExist(String problemName, Map<String, Problem> problemMap) {
        return problemMap.get(problemName) != null;
    }
}
