package btbst;

public class TestBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-2);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        BinaryTree bTree = new BinaryTree();
        System.out.println("Level of node: " + bTree.levelOfNode(root, 3, 0));
        System.out.println("Height of Tree: " + bTree.height(root));
        System.out.println("Diameter of Tree: " + bTree.diameterOfBinaryTree(root));
        System.out.println("Count of leaf nodes: " + bTree.countOfLeafNodes(root));
        System.out.println("Max node at given level: " + bTree.maxNodeAtGivenLevel(root, 2));
        System.out.println("Max node count at given level: " + bTree.maxNodeCountAtLevel(root));
        System.out.println("Level having maximum sum: " + bTree.findMaximumLevelSum(root));
        System.out.println("Max element in tree: " + bTree.findMaxElement(root));
        System.out.println("Size of tree: " + bTree.sizeOfTree(root));
        System.out.println("Level of a given node: " + bTree.levelOfNode(root, 3, 0));
        bTree.findDeepestLevelAndNode(root);
        bTree.findDeepestLeftNode(root);
    }
}
