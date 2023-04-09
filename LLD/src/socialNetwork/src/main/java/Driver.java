package socialNetwork.src.main.java;


import socialNetwork.src.main.java.service.PostService;
import socialNetwork.src.main.java.service.TimelineService;
import socialNetwork.src.main.java.service.UserService;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PostService postService = new PostService(userService);
        TimelineService timelineService = new TimelineService(userService, postService);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose from below options");
            System.out.println("1. Login user");
            System.out.println("2. Create post");
            System.out.println("3. Follow user");
            System.out.println("4. Unfollow user");
            System.out.println("5. Upvote post");
            System.out.println("6. Downvote post");
            System.out.println("7. User Timeline");
            System.out.println("8. All user posts");
            System.out.println("9. Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter userId");
                    int userId = sc.nextInt();
                    System.out.println("Enter userName");
                    String userName = sc.next();
                    System.out.println(userService.login(userId, userName));
                    break;
                case 2:
                    System.out.println("Enter userId");
                    userId = sc.nextInt();
                    System.out.println("Enter postContent");
                    String postContent = sc.next();
                    System.out.println(postService.createPost(userId, postContent));
                    break;
                case 3:
                    System.out.println("Enter followeeUserId");
                    int followeeUserId = sc.nextInt();
                    System.out.println("Enter followerUserId");
                    int followerUserId = sc.nextInt();
                    System.out.println(userService.follow(followeeUserId, followerUserId));
                    break;
                case 4:
                    System.out.println("Enter followeeUserId");
                    followeeUserId = sc.nextInt();
                    System.out.println("Enter followerUserId");
                    followerUserId = sc.nextInt();
                    System.out.println(userService.unFollow(followeeUserId, followerUserId));
                    break;
                case 5:
                    System.out.println("Enter userId");
                    userId = sc.nextInt();
                    System.out.println("Enter postId");
                    int postId = sc.nextInt();
                    System.out.println(postService.upVotePost(userId, postId));
                    break;
                case 6:
                    System.out.println("Enter userId");
                    userId = sc.nextInt();
                    System.out.println("Enter postId");
                    postId = sc.nextInt();
                    System.out.println(postService.downVotePost(userId, postId));
                    break;
                case 7:
                    System.out.println("Enter userId");
                    userId = sc.nextInt();
                    System.out.println(timelineService.getUserTimeLine(userId));
                    break;
                case 8:
                    System.out.println("Enter userId");
                    userId = sc.nextInt();
                    System.out.println(userService.getAllUserPosts(userId));
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }
}
