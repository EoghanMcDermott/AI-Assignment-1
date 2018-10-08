//Eoghan McDermott - 15345451

import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Tree {

    private Node root;
    private int branching;
    private Random random = new Random();

    public Tree(Node root, int branching){//creating the base of a tree with a given root node
        this.root = root;
        this.branching = branching;
    }

    private int generateValue(){
        return random.nextInt(5001)-2500;//in the range -2500 -> +2500
    }

    private Node generateNode(Node parent){//generate a node and assign it a parent and value
        int value = generateValue();
        return new Node(parent, value);
    }

    private int generateBranchingFactor(){//can use to dynamically generate branching factor

        int chance = random.nextInt(100);

        if(chance <= 0 && chance >= 3)
            branching = branching+2;
        else if(chance > 3 && chance <= 9)
            branching = branching+1;
        else if(chance > 9 && chance <= 89)
            return branching;
        else if(chance > 89 && chance <= 96)
            branching = branching-1;
        else branching = branching-2;

        if(branching < 0)
            branching = 0;

        return branching;
    }

    public void buildTree(int height){//generate the game tree

        Node current = root;//start at the beginning of the tree
        int count = 0;

        while(count != height)//need to figure out a way to build out level by level
        {
            //make new node(s) and add it to the tree
            ArrayList<Node> children = new ArrayList<>();

            int b = generateBranchingFactor();
            System.out.println("Branching Factor:   " + b);
            for(int i=0;i<b;i++)
            {
                Node daughter = generateNode(current);
                System.out.println(daughter.toString());
                children.add(daughter);
            }

            current.addChildren(children);

            if(children.size() > 0)
                current = children.get(0);
            //need to update current to next child or move to next level
            count ++;
        }

        return;

    }

    public String toString(){
        String str = "";

        str += "Root:    " +  root.toString() + "\n";

        Node current = root;

        for(Node child: current.getChildren())
            str += child.toString() + "     "; //prints everything on one level

        //move to next level

        return str;
    }
}
