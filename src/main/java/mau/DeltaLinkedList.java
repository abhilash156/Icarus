package mau;

/**
 * Project: Icarus by Artalos
 * Package: mau.linkedlist
 *
 * This is a  Class
 *
 * @author Abhilash
 * @since 1.0
 */
public class DeltaLinkedList<T> {
    private DeltaNode<T> rootNode = new DeltaNode<>();

    DeltaLinkedList(DeltaNode<T> deltaNode) {
        this.rootNode = deltaNode;
    }

    DeltaLinkedList() {
        this.rootNode = new DeltaNode<>();
    }

    public void insertNode(DeltaNode<T> deltaNode) {
        if (deltaNode == null) {
            System.out.println("Null node cannot be added.");
        } else {
            DeltaNode<T> tempNode = rootNode;
            while (tempNode.getNextNode() != null) {
                tempNode = tempNode.getNextNode();
            }
            tempNode.setNextNode(deltaNode);
        }
    }


    private int compareData(DeltaNode<T> nodeA, DeltaNode<T> nodeB) {
        String stringA = nodeA.getData().toString();
        String stringB = nodeB.getData().toString();
        System.out.println(stringA + stringB + " " + stringA.compareTo(stringB));
        return stringA.compareTo(stringB);
    }

    public void sort() {
        DeltaNode<T> i = rootNode;
        DeltaNode<T> j;
        while (i != null) {
            j = i.getNextNode();
            while (j != null) {
                if (compareData(i, j) > 0) {
                    DeltaNode<T> tempNode = j.getNextNode();
                    j.setNextNode(i);
                    i.setNextNode(tempNode);
                }
                j = j.getNextNode();
            }
            i = i.getNextNode();
        }
    }

    public void printList() {
        DeltaNode<T> tempNode = rootNode;
        while (tempNode != null) {
            System.out.print(tempNode.getData() + " -> ");
            tempNode = tempNode.getNextNode();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DeltaNode<String> deltaNode = new DeltaNode<>();
        deltaNode.setData("M");
        DeltaLinkedList<String> linkedList = new DeltaLinkedList<>(deltaNode);
        deltaNode = new DeltaNode<>();
        deltaNode.setData("A");
        linkedList.insertNode(deltaNode);
        deltaNode = new DeltaNode<>();
        deltaNode.setData("N");
        linkedList.insertNode(deltaNode);
        deltaNode = new DeltaNode<>();
        deltaNode.setData("A");
        linkedList.insertNode(deltaNode);
        deltaNode = new DeltaNode<>();
        deltaNode.setData("L");
        linkedList.insertNode(deltaNode);
        deltaNode = new DeltaNode<>();
        deltaNode.setData("I");
        linkedList.insertNode(deltaNode);
        linkedList.printList();
        linkedList.sort();
        linkedList.printList();
    }
}
