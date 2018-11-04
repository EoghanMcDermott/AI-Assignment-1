public class Main {

    public static void main(String[] args)
    {
        Tree t = new Tree(3,5,20,40,2);
        t.buildTree();

        //System.out.println("Total Nodes: " + t.nodeCount());
        AlphaBeta ab = new AlphaBeta(t);

        ab.search(4);
    }
}
