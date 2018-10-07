//Eoghan McDermott - 15345451

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
