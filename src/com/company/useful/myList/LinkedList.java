package company.useful.myList;

/**
 * Created by OPER on 23.01.2017.
 */
public class LinkedList {
    private Node firstNode;

    enum DeleteMethod {RECURSE, LOOP}

    LinkedList(int firstNodeValue){    firstNode = new Node(firstNodeValue, null);    }

    boolean insertToEnd(int value){
       Node lastNode = getLastNode();
       if (lastNode == null){
           return false;
       }

       Node newNode = new Node(value, null);
       lastNode.nextNode = newNode;
       return true;
    }

    int length(){
        if (firstNode == null){
            return 0;
        }

        Node node = firstNode;
        int length = 1;
        while (node.nextNode != null){
            node = node.nextNode;
            length++;
        }
        return length;
    }

    private Node getLastNode(){
        if (firstNode == null){
            return null;
        }

        Node node = firstNode;
        while (node.nextNode != null){
            node = node.nextNode;
        }
        return node;
    }

    int[] getAllValues(){
        if (firstNode == null){
            return null;
        }
        int[] values = new int[length()];
        Node node = firstNode;

        for (int i = 0; i < length(); i++){
            values[i] = node.value;
            node = node.nextNode;
        }
        return values;
    }

    void deleteList(DeleteMethod method){
        if (method == DeleteMethod.RECURSE){
            deleteListRecurse(firstNode);
            this.firstNode = null;

        } else {
            deleteListLoop();
        }
    }
    private void deleteListRecurse(Node ptrNode){

        if (ptrNode.nextNode == null){ return; }
        else { deleteListRecurse(ptrNode.nextNode); }

        ptrNode.nextNode = null;
    }
    private void deleteListLoop(){

    }



    private class Node{
        private Node nextNode;
        private int value;

        Node(int value, Node nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }
        int getValue(){
            return this.value;
        }
        void setValue(int value){
            this.value = value;
        }
    }

}


