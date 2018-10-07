//Eoghan McDermott - 15345451

import java.util.ArrayList;
import java.util.Random;

public class Tree {

    private Node root;
    private Random random = new Random();

    public Tree(Node root){//creating the base of a tree with a given root node
        this.root = root;
    }

    private int generateValue(){
        return 0;//placeholder method for now
    }

    private Node generateNode(Node parent){//generate a node and assign it a parent and value
        int value = generateValue();
        return new Node(parent, value);
    }

    public void buildTree(int height){//generate the game tree

        Node current = root;//start at the beginning of the tree
        int branchingFactor = 3;//need to dynamically generate this
        int count = 0;

        while(count != height)//need to figure out a way to build out level by level
        {
            //make new node(s) and add it to the tree
            ArrayList<Node> children = new ArrayList<>();

            for(int i=0;i<branchingFactor;i++)
            {
                children.add(generateNode(current));
            }

            current.addChildren(children);
        }

    }
}
