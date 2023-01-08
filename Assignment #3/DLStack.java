import javax.swing.text.html.HTMLDocument.RunElement;


// A stack implemented using a Doubly Linked List
public class DLStack<T> implements DLStackADT<T> {

    private DoubleLinkedNode<T> top;
    private int numItems;

    // sets the top pointer to null and
    // numItems to null
    public DLStack() {
        top = null;
        numItems = 0;
    }

    // Method that pushes an element on top of the stack
    // given a T data item.

    public void push(T dataItem) {

        // creates node containing T data item
        DoubleLinkedNode<T> node = new DoubleLinkedNode<>(dataItem);

        // adds a node to the top of the stack 
        if (top != null) {

            node.setPrevious(top);
            top.setNext(node);
            top = node;

            numItems++;

        }

        // Makes top point to the first node since the stack is empty
        else {
            top = node;
            numItems++;
        }

    }

    // Method that pops off element at the top of the stack
    public T pop() throws EmptyStackException {

        T dataItem;

        // Checks if stack is empty
        if (top == null)
            throw new EmptyStackException("Empty Stack");

        // sets top to null if there is only 1 element in the stack
        if (numItems == 1){
            dataItem = top.getElement();
            top = null;
            numItems --;
        }
            
        // Pops off the top element of the stack
        else {
            dataItem = top.getElement();
            top = top.getPrevious();
            top.setNext(null);
            numItems--; 
        }

        // returns the element from the top of the stack before removing
        return dataItem;
    }

    // Removes an element at the specified "k" value in the stack
    public T pop(int k) throws InvalidItemException {


        T dataItem;
        DoubleLinkedNode<T> current = top;

        int count = k;

        // Checks if we're not removing an element outside the stack
        if (k > numItems || k <= 0)
            throw new InvalidItemException("Invalid Item");

        // Determines how many times we iterate through the stack
        // depending on the value of K
        while (count > 1 ){
            current = current.getPrevious();
            count--;
        }
        // Removing the element from the top of the stack
        if (k == 1){
            if (numItems == 1){
                dataItem = top.getElement();
                top = null;
                numItems --;
            }
                
    
            else {
                dataItem = top.getElement();
                top = top.getPrevious();
                top.setNext(null);
                numItems--; 
            }
        }

        // Removing the last element in the the stack

        else if (k == numItems){
            dataItem = current.getElement();
            current.getNext().setPrevious(null);
            numItems --;
        }

        // Removing the element in the middle of the Stack
        else {
            dataItem = current.getElement();
            current.getNext().setPrevious(current.getPrevious());
            current.getPrevious().setNext(current.getNext());
            numItems --;
        }

        return dataItem;

    }

    // Returns the element at the top of the stack
    public T peek() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException("Empty Stack");

        else {
            return top.getElement();
        }

    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }

    // returns the size of the stack
    public int size() {
        return numItems;
    }

    // gets the top node of the stack

    public DoubleLinkedNode<T> getTop() {
        return top;
    }

    // Creates a String representation of the stack
    public String toString() {
        String s = "[";

        DoubleLinkedNode<T> current = top;

        while (current!= null){
            s = s + current.getElement() + ", ";
            current = current.getPrevious();
        }

        s = s + "]"; 

        return s;
    }

}
