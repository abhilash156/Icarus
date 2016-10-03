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
public class DeltaNode<T> {
    private T data;
    private DeltaNode<T> nextNode = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DeltaNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DeltaNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
