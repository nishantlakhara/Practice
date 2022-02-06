package datastructures.trees;

public class RandomNumberFinderEfficient {
    public static void main(String[] args) {
        int[] arr = {50,40,25,60,70,65,55,44,11,22,33,55,77,88};

        TreeNode treeNode = new TreeNode(arr[0], 1);
        for(int i=1; i<arr.length; i++) {
            treeNode.insertInorder(arr[i]);
        }

        print(treeNode);

        
    }

    private static void print(TreeNode treeNode) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", treeNode);
        System.out.println(sb.toString());
    }

    public static void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }
}
