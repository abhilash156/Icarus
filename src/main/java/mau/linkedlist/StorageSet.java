package mau.linkedlist;
//import java.util.Scanner;

public class StorageSet<T> implements StorageInterface<T>{
	MyLinkedList<T> headll = new MyLinkedList<T>();
	
	StorageSet(){
		headll = new MyLinkedList<T>();
		}
	@Override
	public void insert(Node<T> newNode) {
		// TODO Auto-generated method stub
		if(contains(newNode)){
			System.out.println("Value is already present.");
		}
		else{
			if(newNode == null){
				System.out.println("Null node cannot be added.");
			}
			else{
				 
	    		  Node<T> temp;
	    		  temp = headll.headNode;
	    		  while(temp.nextAddress != null){
	    			  temp = temp.nextAddress; //i will traverse till last node
	    		  }
	    		  temp.nextAddress = newNode; //as soon as i reach to the end, i append new node
			}
		}
	}

	@Override
	public boolean contains(Node<T> node) {
		// TODO Auto-generated method stub
		 Node<T> temp = headll.headNode.nextAddress;
   	  while(temp != null){
   		  if(headll.compareToMy(temp, node)==0){//if match is found
   			  return true;
   		  }
   		  temp = temp.nextAddress;
   	  }
   	  return false;
	}

	@Override
	public void delete(Node<T> newNode) {
		// TODO Auto-generated method stub
		if(newNode == null){
  		  System.out.println("Null node cannot be deleted.");
  	  }
  	  else{
  		   Node<T> temp1,temp2;
  		   temp1 = headll.headNode;
  		   temp2 = headll.headNode.nextAddress;
  		   
  		   while(temp2 != null){
  			   if(headll.compareToMy(temp2, newNode)==0){
  				   temp1.nextAddress = temp2.nextAddress;
  				   temp2.nextAddress = null;
  			   }
  			   temp1 = temp2;
  			   temp2 = temp2.nextAddress;
  		   }
  	  }
	}

	@Override
	public int findLength() {
		// TODO Auto-generated method stub
		Node<T> temp = headll.headNode.nextAddress;
  	  int len=0;
  	  if(temp == null)
  		  return 0;
  	  while(temp!=null){
  		  len++;
  		  temp = temp.nextAddress;
  	  }
  	  return len;
	}

	@Override
	public Node<T> hasNextElement() {
		// TODO Auto-generated method stub
		if (headll.headNode == null)
      		return null;
      	else return headll.headNode;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(headll.headNode.nextAddress != null)
      		return true;
      	else return false;
	}

	/*public static void main(String args[]){
		int ch=0;Scanner sc = new Scanner(System.in);
		StorageSet<Integer> set = new StorageSet<Integer>();
		while(ch!=5){
  		  System.out.println("\n1. Insert\n2. Delete \n3. Sort \n4. Print \n5. Exit");
  		  ch = sc.nextInt();
  		  switch(ch){
  		  case 1:  System.out.println("Val: ");
  		           int val = sc.nextInt();
  		           Node<Integer> temp =new Node<Integer>(val);
  		           set.insert(temp);
  		           break;
  		  case 2:  if(set.findLength()==0)
  			          break;
  			       System.out.println("Val: ");
  		  		   int value = sc.nextInt();
  		  		   Node<Integer> temp1 =new Node<Integer>(value);
  		  		   set.delete(temp1);
  		           break;
  		  case 3:  //head.sort();
  		           break;
  		  case 4:  set.headll.printList();
  		           break;
  		  case 5:  System.exit(0);
  		  }
  	  }
  	  System.out.println();
  	  sc.close();
	}//main
*/}
