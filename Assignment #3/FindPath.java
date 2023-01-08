import java.io.IOException;

public class FindPath {

    private Map pyramidMap;

    // Initializes a Pyramid Map object
    public FindPath(String fileName) {

        try {
            pyramidMap = new Map(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // algorithm that leads to the the treasure map

    public DLStack path() {
        DLStack<Chamber> stackPath = new DLStack<Chamber>();

        // gets the Entrance Chamber
        Chamber entranceChamber = pyramidMap.getEntrance();

        // Gets the number of Treasures
        int numTreasureChambers = pyramidMap.getNumTreasures();
        int count = 0;

        // pushes the entrance chamber to the stack
        entranceChamber.markPushed();

        stackPath.push(entranceChamber);

        // Algorithm that pushes the path chambers onto the stack
        while (stackPath.isEmpty() != true) {
            Chamber currentChamber = stackPath.peek();
            Chamber bestNeighbouringChamber;

            if (currentChamber.isTreasure()) {
                count++;
                if (count == numTreasureChambers)
                    break;
            }

            bestNeighbouringChamber = bestChamber(currentChamber);

            if (bestNeighbouringChamber != null) {
                stackPath.push(bestNeighbouringChamber);
                bestNeighbouringChamber.markPushed();
            } else {
                stackPath.pop().markPopped();
                

            }

        }

        // Returns the path Stack
        return stackPath;
    }

    // Returns the Pyramid Map instance variable
    public Map getMap() {
        return this.pyramidMap;
    }

    // Checks if a chamber is Dim
    public Boolean isDim(Chamber currentChamber) {

        Boolean check = false;

        if (currentChamber != null && currentChamber.isSealed() == false && currentChamber.isLighted() == false) {

            for (int i = 0; i <= 5; i++) {
                if (currentChamber.getNeighbour(i) != null && currentChamber.getNeighbour(i).isLighted() == true)
                    check = true;
            }

        } else {
            check = false;
        }

        return check;

    }

    // Checks if the neighbouring Chamber is the best Chamber

    public Chamber bestChamber(Chamber currentChamber) {

        for (int i = 0; i <= 5; i++) {
            if (currentChamber.getNeighbour(i)!= null && currentChamber.getNeighbour(i).isTreasure()
                    && currentChamber.getNeighbour(i).isMarked()!= true)
                return currentChamber.getNeighbour(i);
        }

        for (int i = 0; i <= 5; i++) {
            if (currentChamber.getNeighbour(i)!= null && currentChamber.getNeighbour(i).isLighted()
                    && currentChamber.getNeighbour(i).isMarked()!= true)
                return currentChamber.getNeighbour(i);
        }

        for (int i = 0; i <= 5; i++) {
            if (currentChamber.getNeighbour(i)!= null && isDim(currentChamber.getNeighbour(i)) && currentChamber.getNeighbour(i).isMarked()!= true)
                return currentChamber.getNeighbour(i);
        }

        return null;

    }

}
