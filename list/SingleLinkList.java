package linkedList.list;

import linkedList.node.DoubleLinkNode;
import linkedList.node.ListNode;
import linkedList.node.SingleLinkNode;

public class SingleLinkList<N extends ListNode<T>,T> implements List<T> {

    N root; // The base (root) node
    public SingleLinkNode<T> head; //The starting node
    public int length; //The length of the linked list
    public boolean isEmpty() {
        return root == null;
    } //Checks if there is a root node (if there isn't, then there can't be any more nodes

    public void setRoot(N newRoot) {
        root = newRoot;
    } //Sets the root node to a given node

    public void add(int index, T value) throws ListAccessError{
        if (index == 0)
        {
            SingleLinkNode<T> newNode = new SingleLinkNode<>(value, head); //If the given index is 0, then the user must want the starting node to be set/replaced
        }
        else {
            SingleLinkNode<T> nodeAtLastIndex = getPreviousNode(index);//This gets the node at the index before the given node
            SingleLinkNode<T> newNode = new SingleLinkNode<>(value, nodeAtLastIndex.getNext()); //This creates a new node with the given value and at the index AFTER the previous one (in order)
            nodeAtLastIndex.setNext(newNode); //This sets the given node
            length++; //The length of the linked list is incremented by 1
        }



    }

    public T remove(int index) throws ListAccessError{

        if(isEmpty()){ //If the list is empty
            throw new ListAccessError("Sorry, the list is empty"); //Cannot empty the list/index if there is nothing there.
        }

        SingleLinkNode<T> previousNode = getPreviousNode(index); //This gets the last node before the one given
        SingleLinkNode<T> deletionNode; //A new node is made temporarily
        if (previousNode == null) {
            deletionNode = head;
            head = head.getNext();
            length--; //The size is decreased by 1 if the head is chosen to be deleted; as such, it is replaced by the node next to it
            return deletionNode.getValue();
        }
        else {
            deletionNode = previousNode.getNext();
            previousNode.setNext(deletionNode.getNext());
            length --; //The length is decreased by 1 when a node is deleted
            return deletionNode.getValue();
        }
    }

    public T get(int index) throws ListAccessError{

        return null; //Unfortunately, I could not implement this.
    }

    public SingleLinkNode<T> getPreviousNode(int index){
        return index > 0 ? getNode(index - 1) : null;
        //If index is greater than 0, getNode(index-1) is returned otherwise null is returned in its place.
        //A ternary operator was used to neaten things up a bit
    }

    public SingleLinkNode<T> getNode(int index){
        SingleLinkNode<T> current = head; //Starts at the head
        int a = 0; //Starts at 0
        while (a < index){ //As long as a is less than the given index
            current = current.getNext(); //Get the next index
            a++; //Increment this "counter"
        }
        return  current;
    }


}
