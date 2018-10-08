public class Main {


     public static void main(String[] args) {

        Node root = new Node(null, 0);

        Tree gameTree = new Tree(root, 2);

        gameTree.buildTree(3);

        System.out.println(gameTree.toString());
    }
}
