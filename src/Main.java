public class Main {

    public static void main(String[] args)
    {
        Tree[] trees = new Tree[12];
        for(Tree t: trees)
        {
            t = new Tree(3, 4, 20, 100, 20);
            t.buildTree();
            AlphaBeta ab = new AlphaBeta(t);
            int eval = ab.search(20);
            System.out.println("Total Eval: " + eval);
        }

        //System.out.println("Total Nodes: " + t.nodeCount());
//        AlphaBeta ab = new AlphaBeta();
//        Quiescence q = new Quiescence();
//
//        int eval = ab.search(20);
//        int q_eval = q.search(20);
//
//        System.out.println("Total Nodes: " + t.nodeCount());
//
//        System.out.println("Total Eval: " + eval);
//        System.out.println("Total Quiescence Eval: " + q_eval);
    }
}
