package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=p6isrVxNy2M&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=25
//  notes @ https://photos.google.com/photo/AF1QipNWvXpouw8UkD-u4RSCMK0APf6KUmgF4oPxmznT
public class _24PreToPost {

    public static void main(String[] args) {
        List<Integer> preOrder = Arrays.asList(40, 30, 35, 80, 100);
        List<Integer> postOrder = new ArrayList<>();

        preToPost(preOrder, postOrder, 0, preOrder.size() - 1);
        System.out.println("PostOrder is:");
        postOrder.forEach(integer -> System.out.print(integer + " "));
    }

    private static void preToPost(List<Integer> preOrder, List<Integer> postOrder, int l, int r) {
        if (l > r)
            return;

        int g = findNextGreaterIndex(preOrder, l, r);
        //  L
        preToPost(preOrder, postOrder, l + 1, g - 1);
        //  R
        preToPost(preOrder, postOrder, g, r);
        //  N
        postOrder.add(preOrder.get(l));
    }

    private static int findNextGreaterIndex(List<Integer> preOrder, int l, int r) {
        int i;
        for (i = l; i <= r; i++) {
            if (preOrder.get(i) > preOrder.get(l))
                return i;
        }
        return i;
    }
}
