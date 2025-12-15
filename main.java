package binaryTree;

public class main{
	static int left=0;static int right=1;
	public static int zigZagTree(TreeNode A) {
		int bestLeft= ((A.left==null)?0:dfs(A.left,left));
		System.out.println(bestLeft);
		int bestRight=((A.right==null)?0:dfs(A.right,right));
		System.out.println(bestRight);
		return Math.max(bestRight,bestLeft);
	}
	
	private static int dfs(TreeNode A, int lastStep) {
		int turns=0;
		if(A.right!=null) {
			int currTurns=((lastStep==right)?0:1);
			turns=Math.max(turns,currTurns+dfs(A.right,right));
		}
		
		if(A.left!=null) {
			int currTurns=((lastStep==left)?0:1);
			turns=Math.max(turns, currTurns+dfs(A.left,left));
		}
		
		return turns;
	}
	
	public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(30);
        root.right.right.right = new TreeNode(8);
        root.right.right.left.right = new TreeNode(9);
        System.out.println(main.zigZagTree(root));

	}
}