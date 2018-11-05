//Eoghan McDermott - 15345451

public class AlphaBeta {

    private Tree tree;
    private int alpha = -10000;
    private int beta = 10000;
    private int count;

    public AlphaBeta(Tree tree)
    {
        this.tree = tree;
    }

    public int search(int val) {

        count = 0;//need to count number of evaluations


        ab(tree.getRoot(), tree.getHorizon(), alpha, beta);

        return count;
    }

    private int ab(Node node, int ht, int ach, int hope)
    {
        if(ht == 0 || node.hasChildren() == false)
        //if no children then no moves available
            return node.getValue();
        else
        {
            for(Node child: node.getChildren())
            {
                count++;

                int temp = -1* ab(child, ht-1,-1*hope,-1*ach);

                if(temp >= hope)
                    return temp;//beta cutoff

                ach = Integer.max(temp,ach);
            }
        }

        return ach;
    }
}
