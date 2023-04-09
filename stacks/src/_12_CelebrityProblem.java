/*
In a party of N people, only one person is known to everyone.
Such a person may be present at the party, if yes, (s)he doesn’t know anyone at the party.
We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party.
We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, and false otherwise. How can we solve the problem?

Some observations are based on elimination technique (Refer to Polya’s How to Solve It book).
If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
Repeat above two steps till there is only one person.
Ensure the remained person is a celebrity. (What is the need of this step?)
*/

import java.util.Stack;

public class _12_CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };

        // mat[i][j] = 1 => i knows j;
        System.out.println(isCelebrityExist(mat));
    }

    public static boolean isCelebrityExist(int[][]mat) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i< mat.length; i++) {
            stack.push(i);
        }

        while(stack.size() > 1) {
            int v1 = stack.pop();
            int v2 = stack.pop();

            if (knows(mat, v1, v2)) {
                stack.push(v2);
            } else {
                stack.push(v1);
            }
        }

        int probableAns = stack.pop();
//        System.out.println(probableAns);
        for (int i=0; i<mat[probableAns].length; i++) {
            if (i != probableAns && !knows(mat, i, probableAns)) {
                return false;
            }
        }
        System.out.println(probableAns);
        return true;
    }

    public static boolean knows(int[][]mat, int i, int j) {
        return mat[i][j] == 1;
    }
}
