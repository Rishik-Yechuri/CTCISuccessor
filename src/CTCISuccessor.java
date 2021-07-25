public class CTCISuccessor {
    public static void main(String[] args) {
        try{
            CTCISuccessor obj = new CTCISuccessor();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creating dataset(Tree)
        Node node = new Node(14,null);
        node.leftNode = new Node(6,node);
        node.leftNode.leftNode = new Node(3,node.leftNode);
        node.leftNode.leftNode.leftNode = new Node(1,node.leftNode.leftNode);
        node.leftNode.leftNode.rightNode = new Node(5,node.leftNode.leftNode);
        node.leftNode.rightNode = new Node(8,node.leftNode);
        node.leftNode.rightNode.leftNode = new Node(7,node.rightNode);
        node.leftNode.rightNode.rightNode = new Node(11,node.leftNode.rightNode);
        node.rightNode = new Node(21,node);
        node.rightNode.leftNode = new Node(18,node.rightNode);
        node.rightNode.rightNode = new Node(25,node.rightNode);
        node.rightNode.leftNode.leftNode = new Node(15,node.rightNode.leftNode);
        node.rightNode.leftNode.rightNode = new Node(19,node.rightNode.leftNode);
        node.rightNode.rightNode.leftNode = new Node(24,node.rightNode.rightNode);
        node.rightNode.rightNode.rightNode = new Node(27,node.rightNode.rightNode);
        //Prints value
        System.out.println(getSuccessor(node.leftNode).num);
    }
    public Node getSuccessor(Node curr){
        if(curr.rightNode != null){
            curr = curr.rightNode;
            while(curr.leftNode != null){
                curr = curr.leftNode;
            }
            return curr;
        }
        if(curr.parent != null){
            boolean keepGoing = true;
            while(keepGoing){
                if(curr.parent == null){
                    return null;
                }else if(curr.parent.leftNode == curr){
                    return curr.parent;
                }
                curr = curr.parent;
            }
            return curr.parent;
        }
        return null;
    }
}
class Node {
    public int num;
    public Node leftNode;
    public Node rightNode;
    public Node parent;
    public Node(int num,Node parentNode){
        this.num = num;
        this.parent = parentNode;
    }
}