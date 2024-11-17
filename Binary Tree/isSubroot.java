public class isSubroot {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node node, Node subtree) {
        if(node == null && subtree == null) {
            return true;
        } else if(node == null || subtree == null|| node.data != subtree.data) {
            return false;
        }

        if(!isIdentical(node.left, subtree.left)) {
            return false; 
        }

        if(!isIdentical(node.right, subtree.right)) {
            return false;
        }
        
        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
        //check whether subtree lies in tree
        if(root == null) {
            return false;
        }
        if(root.data == subroot.data) {
            if(isIdentical(root, subroot)) {
                return true;
            }
        }

        boolean leftAns = isSubtree(root.left, subroot); //subtree -> true
        boolean rightAns = isSubtree(root.right, subroot);

        return leftAns || rightAns;
    }
    public static void main(String[] args) {
         /*
         *    1
         *  /  \
         * 2    3
         * / \ / \
         * 4 5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

         /*
         *  2
         * / \
         * 4  5 
         */

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        // subroot.right = new Node(5);

        System.out.println(isSubtree(root, subroot));
    }
}
