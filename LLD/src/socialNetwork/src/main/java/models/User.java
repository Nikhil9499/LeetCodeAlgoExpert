package socialNetwork.src.main.java.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import socialNetwork.src.main.java.strategy.DefaultSortingStrategy;
import socialNetwork.src.main.java.strategy.SortingStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString
public class User {
    private final int userId;
    private final String userName;
    private final SortingStrategy sortingStrategy;
    @Setter
    private List<Post> posts;
    @Setter
    private Set<User> followers;
    @Setter
    private List<Post> timelines;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.sortingStrategy = new DefaultSortingStrategy();
        this.posts = new ArrayList<>();
        this.timelines = new ArrayList<>();
        this.followers = new HashSet<>();
    }
}
