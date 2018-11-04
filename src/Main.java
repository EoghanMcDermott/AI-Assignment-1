public class Main {

    public static void main(String[] args)
    {
        Tree t = new Tree(3,13,20,40,2);
        t.buildTree();

        //System.out.println("Total Nodes: " + t.nodeCount());
        AlphaBeta ab = new AlphaBeta(t);

        int eval = ab.search(20);

        System.out.println("Total Nodes: " + t.nodeCount());

        System.out.println("Total Eval: " + eval);
    }
}
