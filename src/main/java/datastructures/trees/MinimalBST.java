package datastructures.trees;

//Given a sorted array, create a minimal binary search tree.
public class MinimalBST {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 78, 89, 99, 100};

        Node minimalBST = createMinimalBST(arr, 0, arr.length-1);

        StringBuilder sb = new StringBuilder();
        TreeUtils.traversePreOrder(sb, "", "", minimalBST);
        System.out.println(sb.toString());
    }

    public static Node createMinimalBST(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = createMinimalBST(arr, start, mid-1);
        node.right = createMinimalBST(arr, mid+1, end);
        return node;
    }
}
