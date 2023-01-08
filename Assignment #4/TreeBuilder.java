
// This class builds a Tree given a specified T array of data to be stored in the nodes of the tree
public class TreeBuilder <T> {

   
   
    public  LinkedBinaryTree  <T>  buildTree (T[] data){

        LinkedQueue <T> dataQueue= new LinkedQueue<>();
        LinkedQueue <BinaryTreeNode<T>> parentQueue = new LinkedQueue<>();

        // puts all elements in the T data array into a queue
        for (int i = 0; i < data.length; i ++){
            dataQueue.enqueue(data[i]);
        }

        // stores the first element in the queue into the root node of the binary tree
        T firstElement = dataQueue.dequeue();

        BinaryTreeNode <T> rootNode = new BinaryTreeNode<T>(firstElement);

        LinkedBinaryTree <T> binaryTree = new LinkedBinaryTree<>(rootNode);


        parentQueue.enqueue(rootNode);

        // Algorithm that builds a tree using queues as the auxilarry data structure
        while (!dataQueue.isEmpty()){
            T a = dataQueue.dequeue();
            T b = dataQueue.dequeue();
            
            BinaryTreeNode <T> parent = parentQueue.dequeue();

            if (a!= null){
                BinaryTreeNode <T> leftChild = new BinaryTreeNode<T>(a);
                parent.setLeft(leftChild);
                parentQueue.enqueue(leftChild);

            }

            if (b!= null){
                BinaryTreeNode <T> rightChild = new BinaryTreeNode<T>(b);
                parent.setRight(rightChild);
                parentQueue.enqueue(rightChild); 
            }

            

        }

        // Returns the binary tree
        return binaryTree;



    }
}
