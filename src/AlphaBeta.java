//Eoghan McDermott - 15345451

public class AlphaBeta {

    private Tree tree;
    private int alpha = -10000;
    private int beta = 10000;

    public AlphaBeta(Tree tree)
    {
        this.tree = tree;
    }

    public int search(int val) {

        int count = 0;//need to count number of evaluations

        Node start = tree.getRoot();

        return 0;
    }

    private int ab(Node node, int ht, int achievable, int hope)
    {
        if(ht == 0 || node.hasChildren() == false)
        //if no children then no moves available
            return node.getValue();
        else
        {
            for(Node child: node.getChildren())
            {
                int temp = -1* ab(child, ht-1,-1*hope, -1*achievable);

                if(temp >= hope)
                    return temp;//beta cutoff

                achievable = Integer.max(temp,achievable);
            }
        }

        return achievable;
    }
}
