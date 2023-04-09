package socialNetwork.src.main.java.service;

import socialNetwork.src.main.java.models.Post;
import socialNetwork.src.main.java.models.User;

import java.util.List;

public class TimelineService {

    private final UserService userService;
    private final PostService postService;

    public TimelineService(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    public List<Post> getUserTimeLine(int userId) {
        User user = userService.getUser(userId);

        List<Post> timelines = user.getTimelines();
        user.getSortingStrategy().sort(timelines);

        return timelines;
    }

}
