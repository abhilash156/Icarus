package mau.linkedlist;
public interface StorageInterface<T> {
	public void insert(Node<T> newNode);
	public boolean contains(Node<T> node);
	public void delete(Node<T> newNode);
	public int findLength();
	public Node<T> hasNextElement();
	public boolean hasNext();
	/***************need to add copy.. last function*****************/
	
}
