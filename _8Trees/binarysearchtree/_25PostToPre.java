package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=cneIaM03_PE&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=26
//  notes @ https://photos.google.com/photo/AF1QipNp675zF32prusJvPF3PSQEZ0UPLPEFgzbGR0NN
public class _25PostToPre {

    public static void main(String[] args) {
        List<Integer> postOrder = Arrays.asList(35, 30, 100, 80, 40);
        List<Integer> preOrder = new ArrayList<>();

        postToPre(postOrder, preOrder, 0, postOrder.size() - 1);
        System.out.println("PreOrder is:"); //  40 30 35 80 100
        preOrder.forEach(integer -> System.out.print(integer + " "));
    }

    private static void postToPre(List<Integer> postOrder, List<Integer> preOrder, int l, int r) {
        if (l > r)
            return;

        int s = findNextSmallerIndex(postOrder, l, r);
        //  N
        preOrder.add(postOrder.get(r));
        //  L
        postToPre(postOrder, preOrder, l, s);
        //  R
        postToPre(postOrder, preOrder, s + 1, r - 1);
    }

    private static int findNextSmallerIndex(List<Integer> preOrder, int l, int r) {
        int i;
        for (i = r; i >= l; i--) {
            if (preOrder.get(i) < preOrder.get(r))
                return i;
        }
        return i;
    }
}
