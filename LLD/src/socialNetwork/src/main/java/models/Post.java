package socialNetwork.src.main.java.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Post {
    private final int postId;
    private final String postContent;
    private final int userId;
    private final Date postedAt;
    @Setter
    private int upvoteCount;
    @Setter
    private int downVoteCount;

    public Post(int postId, String postContent, int userId, Date postedAt) {
        this.postId = postId;
        this.postContent = postContent;
        this.userId = userId;
        this.postedAt = postedAt;
        this.upvoteCount = 0;
        this.downVoteCount = 0;
    }

}
