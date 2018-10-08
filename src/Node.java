//Eoghan McDermott - 15345451

//constructing a tree that will give us a specific T value when searched to its full depth
//E value should be opposite of T value (wait maybe no)
//don't store T value for interior nodes - use estimates
//only have leaf nodes store T values
// interior nodes hold estimated values of leaf nodes - add some noise to T values
//make sure the branching factor isn't static
//maybe use a vector to store nodes?
//no need to put parent nodes in there(uh oh?)
//RECURSION - :^(
//estimate and not the real value
//make sure you don't change the tree
//can ignore the bit about placing the daughter randomly - don't change their ordering
//don't change the tree when you're searching it - maybe pass as an argument
//since we're using random numbers we don't need any test cases - do it manually basically
//make sure you properly generate the random numbers, inclusive, uniform distribution

import java.util.ArrayList;

public class Node {

    private Node parent;
    private ArrayList<Node> children;//using a list so can vary the branching factor of tree
    private int value;

    public Node(Node parent, int value){
        //constructor where you can specify parent node & value
        this.parent = parent;
        this.value = value;
        children = new ArrayList<>();
    }

    public boolean hasChildren(){//use to check if a node is a leaf node

        if(children.size() == 0)
            return false;
        else
            return true;
    }

    public boolean hasSiblings(){//might use this
        if(parent.getChildren().size() > 1)
            return true;
        else
            return false;
    }

    public void addChildren(ArrayList<Node> children){
        //variable argument to allow for different amount of children nodes
        for(Node newChild: children)
            this.children.add(newChild);
    }

    //getters and setters for parent and value
    public void setParent(Node parent){
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Node> getChildren(){
        return children;
    }
}
