//Eoghan McDermott - 15345451

import java.util.ArrayList;

public class Node {

    private Node parent;
    private ArrayList<Node> children;
    //using a list so can vary the branching factor of tree
    private int value;
    private boolean interesting = false;

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

    public boolean hasSiblings(){//might use this for traversal
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

    public boolean isInteresting() { return interesting; }

    public void makeInteresting() {
        interesting = true;
    }

    //getters and setters for parent and value
    public Node getParent() {
        return parent;
    }

    public void setValue(int value){
        this.value = value;
    }//can use this to add e+t (?)

    public int getValue() { return value;}

    public ArrayList<Node> getChildren(){
        return children;
    }

    private String childrenDetails(){

        String str = "Children: [";

        for(Node child:children)
            str+=child.value + ",";

        str = str.substring(0,str.length()-1) + "]";

        return str;
    }

    public String toString()
    {
       String str = "";
       //str+= "Parent Node: " + parent.toString();
       str+="\nNode: " + value;
       str+="\n" + childrenDetails();

       return str;
    }
}
