//Eoghan McDermott - 15345451

public class Quiescence {

    private Tree tree;
    private int alpha = -10000;
    private int beta = 10000;
    private int count;

    public Quiescence(Tree tree)
    {
        this.tree = tree;
    }

    public int search(int val) {

        count = 0;//need to count number of evaluations

        selQ(tree.getRoot(), alpha, beta);

        return count;
    }

    private int selQ(Node node, int ach, int hope)
    {
        int score = node.getValue();

        if(score >= hope)
            return score;

        else
        {
            for(Node child: node.getChildren())
            {
                if(child.isInteresting())
                {
                    count++;

                    int temp = -1 * selQ(child, -1 * hope, -1 * ach);

                    if (temp > score)
                        score =  temp;

                    if(score >= ach)
                        ach = score;

                    if(score >= hope)
                        break;
                }
            }
        }

        return score;
    }
}
