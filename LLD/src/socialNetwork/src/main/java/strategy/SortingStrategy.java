package socialNetwork.src.main.java.strategy;

import socialNetwork.src.main.java.models.Post;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Post> posts);
}
