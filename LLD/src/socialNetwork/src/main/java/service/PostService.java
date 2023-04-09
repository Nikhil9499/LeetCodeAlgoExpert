package socialNetwork.src.main.java.service;

import socialNetwork.src.main.java.exceptions.InvalidPostIdPassedException;
import socialNetwork.src.main.java.models.Post;
import socialNetwork.src.main.java.models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PostService {

    // in-memory db store
    private final Map<Integer, Post> postMap = new HashMap<>();
    private final UserService userService;

    private int postIdCounter = 1;

    public PostService(UserService userService) {
        this.userService = userService;
    }

    public Post createPost(int userId, String postContent) {
        User user = userService.getUser(userId);
        Post post = new Post(postIdCounter++, postContent, userId, new Date());
        user.getPosts().add(post);
        postMap.put(post.getPostId(), post);

        for (User userFollower : user.getFollowers()) {
            userFollower.getTimelines().add(post);
        }
        return post;
    }

    public Post getPost(int postId) {
        if (!postMap.containsKey(postId)) {
            throw new InvalidPostIdPassedException("Post with is " + postId + " doesn't exist");
        }
        return postMap.get(postId);
    }


    public String upVotePost(int userId, int postId) {
        User user = userService.getUser(userId);
        for (Post timeline : user.getTimelines()) {
            if (timeline.getPostId() == postId) {
                int upvoteCount = timeline.getUpvoteCount();
                timeline.setUpvoteCount(upvoteCount + 1);
                return "Post with id " + postId + " is up-voted by user " + user.getUserName();
            }
        }
        throw new InvalidPostIdPassedException("PostId given is invalid since there is no post in users timeline with postId=" + postId);
    }

    public String downVotePost(int userId, int postId) {
        User user = userService.getUser(userId);
        for (Post timeline : user.getTimelines()) {
            if (timeline.getPostId() == postId) {
                int downVoteCount = timeline.getDownVoteCount();
                timeline.setDownVoteCount(downVoteCount - 1);
                return "Post with id " + postId + " is down-voted by user " + user.getUserName();
            }
        }
        throw new InvalidPostIdPassedException("PostId given is invalid since there is no post in users timeline with postId=" + postId);
    }

}
