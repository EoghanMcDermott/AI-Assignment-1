//Eoghan McDermott - 15345451

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Tree {

    private int branching;
    private int horizon, value, approx, interesting;
    private Node root;
    private Random random = new Random();

    private int nodeCount = 0;


    public Tree(int branching, int horizon, int value, int approx, int interesting)
    {
        this.branching = branching;
        this.horizon = horizon;
        this.value = value;
        this.approx = approx;
        this.interesting = interesting;
    }

    private int generateValue(){
        return random.nextInt(5001)-2500;//in the range -2500 -> +2500
    }

    private int generateBranchingFactor(){
        //can use to dynamically generate branching factor

        int b = branching;//don't want to change the original branching value given
        int chance = random.nextInt(100);

        //using percentages in specification to change branching factor accordingly
        if(chance <= 0 && chance >= 3)
            b = branching+2;
        else if(chance > 3 && chance <= 9)
            b = branching+1;
        else if(chance > 9 && chance <= 89)
            return b;
        else if(chance > 89 && chance <= 96)
            b = branching-1;
        else b = branching-2;

        if(b < 0)
            b = 0;

        return b;
    }

    private ArrayList<Node> generateChildren(Node n, int depth){
        //generate children of node n, i.e. node will be parent of generated nodes
        //passing depth as well to be used to check if node is interesting or not

        ArrayList<Node> children = new ArrayList<>();

        int bound = -1 * n.getValue();//using negamax so need to negate value

        Node first = new Node(n, bound);
        interestingCheck(first, depth);
        children.add(first);
        //one daughter node has negated T value of its parent node
        nodeCount++;

        for (int j=0;j<generateBranchingFactor()-1;j++)
        {
            Node daughter = new Node(n, bound + random.nextInt(10000 - bound));
            interestingCheck(daughter, depth);
            nodeCount++;
            children.add(daughter);
            //other daughter nodes have value >= new negated value with max of 10000
        }

        Collections.shuffle(children);
        //shuffle list so first daughter not necessarily best

        n.addChildren(children);

        return children;//returning list so can add it to temp building list
    }

    private void interestingCheck(Node n, int depth)
    {
        int rand = random.nextInt(99);//random number 0-99
        int check = interesting+(horizon-depth)*30;

        if(rand < check)
            n.makeInteresting();
    }

    private int generateApprox()
    {
      return (random.nextInt(2*approx + 1)-approx);
    }//generate random number in range -approx, approx


    public void buildTree()
    {
        int depth = 0;//want to reach the horizon
        int chance;

        root = new Node(null, value);
        //root node has desired value - it's what we want to find

        ArrayList<Node> tempChildren1 = new ArrayList<>();
        ArrayList<Node> tempChildren2 = new ArrayList<>();
        tempChildren1.add(root);//2nd temp contains just root node initially
        
        while(depth != horizon)
        {
            if(depth >= horizon)
                break;//check if after last addition of children horizon is reached


            for (Node child : tempChildren1)
            {
                chance = random.nextInt(10);
                //10% chance to not give a node daughter nodes - non-uniform depth
                if(chance != 1)
                    tempChildren2.addAll(generateChildren(child, depth));
                    //generate children and add to temp list 2
            }
            if(depth >= horizon)
                break;//again checking if horizon reached - e.g. odd number horizon

            depth++;

            tempChildren1.clear();//clear out 1st list so can add to it again

            for (Node child : tempChildren2)
            {
                chance = random.nextInt(10);
                //10% chance to not give a node daughter nodes - non-uniform depth
                if(chance != 1)
                    tempChildren1.addAll(generateChildren(child, depth));
                    //generate children and add to temp list 1
            }

           depth++;

           tempChildren2.clear();//clear out 2nd list so can add to it again
        }

        addNoise();
    }

    private void addNoise()
    {
        int depth = 0;//want to reach the horizon

        ArrayList<Node> tempChildren1 = new ArrayList<>();
        ArrayList<Node> tempChildren2 = new ArrayList<>();
        tempChildren1.add(root);//2nd temp contains just root node initially

        while(depth != horizon)
        {
            if(depth >= horizon)
                break;//check if after last addition of children horizon is reached


            for (Node child : tempChildren1)
                tempChildren2.addAll(child.getChildren());
            //generate children and add to temp list 2

            if(depth >= horizon)
                break;//again checking if horizon reached - e.g. odd number horizon

            depth++;

            tempChildren1.clear();//clear out 1st list so can add to it again

            for (Node child : tempChildren2)
                tempChildren1.addAll(child.getChildren());
            //generate children and add to temp list 1

            depth++;

            tempChildren2.clear();//clear out 2nd list so can add to it again
        }

        //want to reach the level of leaf nodes
        //so now either temp list 1 or 2 contains all leaf nodes
        //biggest list is the one that contains leaf nodes

        ArrayList<Node> temp;
        if(tempChildren1.size() > tempChildren2.size())
            temp = tempChildren1;
        else
            temp = tempChildren2;

        tempChildren1.clear();
        tempChildren2.clear();//just clearing out both lists so can start fresh

        tempChildren1 = temp;
        int approxVal;

        while(depth > 0)//working back up the tree now
        {
            if(depth == 1)
                break;//stop before root node

            approxVal = generateApprox();
            for (Node n : tempChildren1)
            {
                tempChildren2.add(n.getParent());//keep track of parent nodes
                if(n.hasChildren() == true)//add noise if not a leaf node
                    n.setValue(n.getValue() + approxVal);//update values

            }
            //now have list of all parent nodes - need to add some noise

            depth--;//reduce depth as we move back up the tree
            tempChildren1.clear();

            if(depth == 1)
                break;//stop before root node

            approxVal = generateApprox();
            for (Node n : tempChildren2) {
                n.setValue(n.getValue() + approxVal);//update values
                tempChildren1.add(n.getParent());//keep track of parent nodes
            }
            depth--;//reduce depth as we move back up the tree
            tempChildren2.clear();
        }
    }


    public int getApprox(){return approx;}

    public int getHorizon(){return horizon;}

    public Node getRoot(){return root;}

    public String nodeCount(){return String.valueOf(nodeCount);}
}
