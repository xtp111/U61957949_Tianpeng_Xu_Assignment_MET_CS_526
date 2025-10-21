package HomeWork4;

import java.util.*;

public class TreeTraversal {
    public static void preOrder(TreeNode root, List<Character> result) {

        if (root == null) return;
        result.add(root.val);
        for (TreeNode child : root.children) {
            preOrder(child, result);
        }
    }

    public static List<Character> bfs(TreeNode root) {
        List<Character> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            queue.addAll(node.children); // add all child node
        }
        return result;


    }

    public static void postorder(TreeNode root, List<Character> result) {
        if (root == null) return;
        for (TreeNode child : root.children) {
            postorder(child, result);
        }
        result.add(root.val);
    }

    public static void main(String[] args) {

        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');

        A.children.add(B);
        A.children.add(C);
        B.children.add(D);
        B.children.add(E);
        C.children.add(F);
        C.children.add(G);
        D.children.add(H);
        D.children.add(I);

        List<Character> pre = new ArrayList<>();
        preOrder(A, pre);
        System.out.println("Preorder: " + pre);
        List<Character> bfs = bfs(A);
        System.out.println("Breadth-First: " + bfs);
        List<Character> post = new ArrayList<>();
        postorder(A, post);
       System.out.println("Postorder: " + post);

        BinaryTreeNode a = new BinaryTreeNode('a');
        BinaryTreeNode b = new BinaryTreeNode('b');
        BinaryTreeNode c = new BinaryTreeNode('c');
        BinaryTreeNode d = new BinaryTreeNode('d');
        BinaryTreeNode e = new BinaryTreeNode('e');
        BinaryTreeNode f = new BinaryTreeNode('f');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.right = f;

        inOrder(a);

    }

    public static class TreeNode {
        char val;
        List<TreeNode> children;

        TreeNode(char val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

    }

    public static class BinaryTreeNode {

        char val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(char val) {
            this.val = val;
        }
    }

    public static void inOrder(BinaryTreeNode root) {
        if (root == null) return;
        inOrder(root.left);              // 先左子树
        System.out.print(root.val + " "); // 再根
        inOrder(root.right);
    }
}


