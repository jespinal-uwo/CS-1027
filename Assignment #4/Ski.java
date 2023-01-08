
// Ski class that determines a pathway taken by a skiier based on specific condtions on each node of the binary tree
public class Ski {
    private BinaryTreeNode<SkiSegment> root;

    public  Ski (String[] data){
        SkiSegment [] segments = new SkiSegment [data.length];

        // Stores a JumpSegment, SlalomSegment, or SkiSegment object into the segments array
        // depending of what the string array data contains
        for (int i = 0; i < data.length; i++){
            if (data[i] == null)
                segments[i] = null;

            else if (data[i].contains("jump") )
                segments[i] = new JumpSegment(String.valueOf(i), data[i]);

            else if (data[i].contains("slalom"))
                segments[i] = new SlalomSegment(String.valueOf(i), data[i]);

            else {
                segments[i] = new SkiSegment(String.valueOf(i), data[i]);
            }
            
        }

        // builds a binary tree based on the segments array we just created
        LinkedBinaryTree <SkiSegment> tree;
        TreeBuilder <SkiSegment> tb = new TreeBuilder<SkiSegment>();

        tree = tb.buildTree(segments);

        this.root = tree.getRoot();


    }

    // returns the root of the binary tree 

    public BinaryTreeNode <SkiSegment> getRoot(){
        return this.root;
    }

    public void skiNextSegment (BinaryTreeNode<SkiSegment> node, ArrayUnorderedList<SkiSegment> sequence){
        
       // sequence refers to the pathway taken by the skiier
        SkiSegment data = node.getData();
        sequence.addToRear(data); 


        // conditions that determines if the skiier must take a right path or a left path
        // in the binary tree
        if (node.getLeft()!= null && node.getRight() == null)
            skiNextSegment(node.getLeft(), sequence);

        else if (node.getRight()!= null && node.getLeft() == null)
            skiNextSegment(node.getRight(), sequence);

        else if (node.getLeft() == null && node.getRight() == null){
                return;
            }
        else{

            SkiSegment leftChild = node.getLeft().getData();
            SkiSegment rightChild = node.getRight().getData();

            if (leftChild instanceof JumpSegment &&  rightChild instanceof JumpSegment){
                
               if (((JumpSegment)leftChild).getHeight() > ((JumpSegment)rightChild).getHeight() )
                    skiNextSegment(node.getLeft(), sequence);
               else if (((JumpSegment)leftChild).getHeight() < ((JumpSegment)rightChild).getHeight() )
                    skiNextSegment(node.getRight(), sequence);
               else 
                    skiNextSegment(node.getRight(), sequence);

            }

            else if ( leftChild instanceof JumpSegment && rightChild instanceof JumpSegment == false)
                skiNextSegment(node.getLeft(), sequence);
            else if ( leftChild instanceof JumpSegment == false && rightChild instanceof JumpSegment)
                skiNextSegment(node.getRight(), sequence);

            else if (leftChild instanceof SlalomSegment && rightChild instanceof SlalomSegment){
                if ( ( (SlalomSegment) leftChild ).getDirection() == "L")
                    skiNextSegment(node.getRight(), sequence);
                else 
                    skiNextSegment(node.getLeft(), sequence);
            }

            else if ( leftChild instanceof SlalomSegment && rightChild instanceof SkiSegment){
                if ( ((SlalomSegment) leftChild ).getDirection() =="L")
                    skiNextSegment(node.getLeft(), sequence);
                else 
                    skiNextSegment(node.getRight(), sequence);
            }

            else if ( leftChild instanceof SkiSegment && rightChild instanceof SlalomSegment){
                if ( ((SlalomSegment) rightChild ).getDirection() == "L")
                    skiNextSegment(node.getRight(), sequence);
                else 
                    skiNextSegment(node.getLeft(), sequence);
            }

          
            else
                skiNextSegment(node.getRight(), sequence);

        }

        


    }


}
