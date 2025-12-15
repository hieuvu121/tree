package binaryTree;

public class Tree {
    public TreeNode root;

    public int height(TreeNode node) {
        return node==null?0:node.height;
    }

    public int getBalance(TreeNode node) {
        return node==null ? 0 : height(node.left) - height(node.right);
    }

    public TreeNode rightRotate(TreeNode y) {
        TreeNode x=y.left;
        TreeNode T2=x.right;

        x.right=y;
        y.left=T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public void buildFromArray(int[] arr) {
        for (int x : arr) {
            root = insert(root, x);
        }
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public void inorderPrint() {
        inorder(root);
        System.out.println();
    }

    public TreeNode search(int value) {
        TreeNode curr = root;
        while (curr != null) {
            if (value == curr.value) return curr;
            if (value < curr.value) curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }


}
