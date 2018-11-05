//Eoghan McDermott - 15345451

import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        Tree[] trees = new Tree[12];
        for(Tree t: trees)
        {
            Random random = new Random();
            int val = random.nextInt(5001)-2500;
            //random int in range -2500,2500
            t = new Tree(11, 7, val, 100, 20);
            t.buildTree();

            AlphaBeta ab = new AlphaBeta(t);

            String str = "";
            int eval = ab.search(20,0);//search to depth h
            str += "Evals at h: " +  String.valueOf(eval);

            int eval_h1 = ab.search(20,1);//search to depth h-1
            str+="\t\t" + "Evals at h-1: " +  String.valueOf(eval_h1);

            int eval_h2 = ab.search(20,2);//search to depth h-2
            str+= "\t\t" + "Evals at h-2: " + String.valueOf(eval_h2);

            System.out.println(str);
        }

    }
}
