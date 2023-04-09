package socialNetwork.src.main.java.service;

import socialNetwork.src.main.java.exceptions.InvalidUserIdPassedException;
import socialNetwork.src.main.java.models.Post;
import socialNetwork.src.main.java.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    // in-memory db store
    private final Map<Integer, User> userMap = new HashMap<>();

    public String login(int userId, String userName) {
        if (!userMap.containsKey(userId)) {
            System.out.println("User with id " + userId + " does not exist in the system. So creating one .....");
            User user = new User(userId, userName);
            userMap.put(userId, user);
        }
        return "login('" + userName + "')";
    }

    public User getUser(int userId) {
        if (!userMap.containsKey(userId)) {
            throw new InvalidUserIdPassedException("User with is " + userId + " doesn't exist");
        }
        return userMap.get(userId);
    }

    public String follow(int followeeUserId, int followerUserId) {
        User followeeUser = getUser(followeeUserId);
        User followerUser = getUser(followerUserId);

        if (followeeUser.getFollowers().contains(followerUser)) {
            System.out.println(followeeUserId + " already following " + followerUserId);
            return followeeUserId + " already following " + followerUserId;
        }

        followeeUser.getFollowers().add(followerUser);
        followeeUser.getTimelines().addAll(followerUser.getPosts());

        return "follow(" + followeeUser.getUserName() + "," + followerUser.getUserName() + ")";
    }

    public String unFollow(int followeeUserId, int followerUserId) {
        User followeeUser = getUser(followeeUserId);
        User followerUser = getUser(followerUserId);

        if (!followeeUser.getFollowers().contains(followerUser)) {
            System.out.println(followeeUserId + " not following " + followerUserId);
            return followeeUserId + " not following " + followerUserId;
        }

        followeeUser.getFollowers().remove(followerUser);
        followeeUser.getTimelines().removeAll(followerUser.getPosts());

        return "unfollow(" + followeeUser.getUserName() + "," + followerUser.getUserName() + ")";
    }

    public List<Post> getAllUserPosts(int userId) {
        User user = getUser(userId);
        return user.getPosts();
    }

}
