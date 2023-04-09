package socialNetwork.src.main.java.strategy;


import socialNetwork.src.main.java.models.Post;

import java.util.List;

public class DefaultSortingStrategy implements SortingStrategy {

    @Override
    public void sort(List<Post> posts) {
        posts.sort((p1, p2) -> p1.getPostedAt().before(p2.getPostedAt()) ? +1 : -1);
    }
}
