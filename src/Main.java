public class Main {

    public static void main(String[] args)
    {
        Tree t = new Tree(3,13,20,40,2);
        t.buildTree();

        System.out.println("Total Nodes: " + t.nodeCount());
    }
}
