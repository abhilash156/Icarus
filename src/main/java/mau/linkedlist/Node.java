package mau.linkedlist;

/**
 * Implementation of linked list class
 * @author manalik
 *
 * @param <T>
 */
public class Node<T> {
   //Variables used in the linked list
   T data; //stores data of any type
   int head; //1 if head, 0 if not a head
   Node<T> nextAddress;  //stores next node in the list
   public static int size = 1;
   //ComparableNodes obj = new ComparableNodes();
  
   // default constructor
   Node (){
	   this.data = null;
	   this.head = 0;
	   this.nextAddress = null;
	   
   }
   //parametrized constructor will always need a head
   Node (T t){
	   this.data = t;
	   this.head = 0;
	   this.nextAddress = null;
   }
  
 //  @Override
 /*  public Node<T> add(T t, int loc, Node<T> myHead) {
	   // TODO Auto-generated method stub
	//if list is empty   
	   System.out.printf("\nCurrent head received in add method: %s ",myHead.data);
   	System.out.println("");
	   //Node<T> traverse = new Node<T>();
	   Node<T> traverseTemp = new Node<T>();
	   //Node<T> traverseTemp2 = new Node<T>();
	   int len = findLength(myHead);
	   System.out.println("Current Length received: "+len);
	if (len==0){
		myHead.data = t;
		myHead.head = 1;
		myHead.nextAddress = null;
	}//if
	else{ //Add first or add last
		if (loc == 0){ //add in the beginning
			Node<T> temp = new Node<T>(t);	
			temp.nextAddress = myHead;
			myHead.head = 0;
			return temp;
		}//if
		else if(len == loc || len < loc){//add in the end
				Node<T> temp = new Node<T>();
				temp.data = t;
				temp.head = 0;
				temp.nextAddress = null;
			//traverse till end
			traverseTemp = myHead;
			while(traverseTemp!= null){
			    if (traverseTemp.nextAddress == null){
			    	traverseTemp.nextAddress = temp;
			    	return myHead;
			    }
				traverseTemp = traverseTemp.nextAddress;
			     
			}//while
		}//elseif
		else{//add at the location
			int tempLoc = 0;
			Node<T> temp = new Node<T>();
			temp.data = t;
			temp.head = 0;
			temp.nextAddress = null;
			traverseTemp = myHead;
			//traverseTemp2 = myHead.nextAddress;
			while(traverseTemp!= null){
			    if (tempLoc == loc-1){
			    	temp.nextAddress = traverseTemp.nextAddress;
			    	traverseTemp.nextAddress = temp;
			        //break;//??do i need this?
			    }
				traverseTemp = traverseTemp.nextAddress;
				//traverseTemp2 = traverseTemp2.nextAddress;
			    tempLoc++;
			}//while
		}//else
	}//length is not empty
return myHead;
}//add method

@Override
public boolean compareTo(T t1, T t2) {
	// TODO Auto-generated method stub
	return(t1.equals(t2));
}
@Override
public int findLength(Node<T> myHead) {
	// TODO Auto-generated method stub
	int length = 1;
	Node<T> temp;
	temp = myHead;
	
	if(myHead.nextAddress == null && myHead.head == 1)
		return 1;
	else if (myHead.nextAddress == null && myHead.head == 0)
		return 0;
	while(temp.nextAddress != null){
		length++;
		temp = temp.nextAddress;
	}//while
	return length;
}
@Override
public void printList(Node<T> head) {
	// TODO Auto-generated method stub
	Node<T> temp = new Node<>();
	temp = head;
	while(temp!=null){
		System.out.printf(" %s ",temp.data);
		temp = temp.nextAddress;
	}//while
}
 
@Override
public Node<T> deleteByVal(T t, Node<T> myHead) {
	// TODO Auto-generated method stub
	Node<T> temp1 = new Node<>();
	Node<T> temp2 = new Node<>();
	temp1 = myHead;
	temp2 = myHead.nextAddress;
	System.out.printf("Compare %s,%s",temp1.data,t);
	int len = findLength(myHead);
	//only one node
	if(len==1){
		if(compareTo(temp1.data,t))
			return null;
	}
	if(compareTo(temp1.data,t)){
		temp2.head = 1;
		temp1.nextAddress = null;
		temp1.head = 0;
		System.out.printf("\nHead sending in delete: %s",temp2.data);
		return temp2;
	}//delete head
	
	while(temp2!=null){
		if(compareTo(temp2.data,t)){
			temp1.nextAddress = temp2.nextAddress;
			temp2.nextAddress = null;
			return myHead;
		}//if match is found
		temp1=temp2;
		temp2=temp2.nextAddress;
	}//while
	return myHead;
}
@Override
public boolean containsVal(T t, Node<T> myHead) {
	// TODO Auto-generated method stub
	Node<T> temp = new Node<T>();
	temp = myHead;
	while(temp!=null){
	    if(compareTo(t,temp.data))//match found
		   return true;
	    temp = temp.nextAddress;
	}
	return false;
}//caontains method true if contains, false if does not contains
@Override
public Node<T> hasNextElement(Node<T> myHead) {
	// TODO Auto-generated method stub
	if (myHead == null)
		return null;
	else return myHead;
}
@Override
public boolean hasNext(Node<T> myHead) {
	if(myHead.nextAddress != null)
		return true;
	else return false;
}

@Override
public Node<T> copyElements(Node<T> myHead) {
	// TODO Auto-generated method stub
	
	if(myHead == null){
		System.out.println("No nodes found to copy.");
		return null;
	}//if
	else{
		  //int len = findLength(myHead);
		  Node<T> temp = new Node<T>();
		  temp = myHead;
		  while(temp!=null){
			  Node<T> temp1 = new Node<T>();
			  temp1 = temp.nextAddress;
			  temp.nextAddress = temp1;
			  temp = temp1;
		  }//while
		  return myHead;
	}//else
	
}
public static void main(String args[]){
    int  loc;
    int data;
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value for head node: ");
    int i = sc.nextInt();
    int ch = 1;
    Node<Integer> myHead = new Node<Integer>(i);
    while(ch!=8){
    	System.out.println("\nOperations offered: \n1. Add \n2. Delete by value \n3. Print list"
    			+ "\n4. Contains \n5. Size of the list \n6. Make a Copy\n7. Each object\n8. Exit");
    	ch = sc.nextInt();
    	switch(ch){
    	case 1: if(myHead==null){
    		       System.out.println("Enter the head node value: ");
	               data = sc.nextInt();
	               Node<Integer> newNode = new Node<Integer>(data);
	               myHead = newNode;
    	        }
    	        else{
    		    System.out.println("Enter the next node to be added: ");
    	        data = sc.nextInt();
    	        System.out.println("Enter the location at which node is to be added: ");
    	        loc = sc.nextInt();
    	        System.out.printf("\nCurrent head: %s ",myHead.data);
    	        System.out.println("");
    	        myHead = myHead.add(data, loc, myHead);
    	        myHead.printList(myHead);
    	        //System.out.println("Do you wanna continue? 1/0: ");
    	        }
    	        break;
    	case 2: System.out.println("Enter the value to be deleted: ");
    			data = sc.nextInt();
    			myHead=myHead.deleteByVal(data, myHead);
    			if (myHead == null)
    				System.out.println("List is empty.");
    			else{
    			myHead.printList(myHead);
    			System.out.printf("Head received: %s",myHead.data);
    			}
    			break;
    	case 3: if(myHead==null) System.out.println("No list to display.");
            	else
    		    myHead.printList(myHead);
                break;
    	case 4: if(myHead==null) System.out.println("List is empty. No search performed.");
    	        else{
    		    System.out.println("Enter the value you want to search: ");
    	        data = sc.nextInt();
    	        if(myHead.containsVal(data, myHead))
    	        	System.out.println("Value is present in the list.");
    	        else
    	        	System.out.println("Value is not present in the list.");
    	        }
    	        break;
    	case 5: if(myHead==null) System.out.println("List is empty.");
    	        else 
    	        System.out.println("List contains "+myHead.findLength(myHead)+" elements.");
    	        break;
    	case 6: Node<Integer> tempHead = new Node<Integer>();
    	        tempHead = myHead.copyElements(myHead);
    	        tempHead.printList(tempHead);
    	        break;
    	case 7: Node<Integer> nextNode = new Node<Integer>();
    	        nextNode = myHead;
    	        if (myHead == null){
    	        	System.out.println("List is empty");
    	        }
    	        else{
    	        	System.out.println("Printing individual nodes: ");
    	        	System.out.println(nextNode.data);
    	        	while(nextNode !=null){
    	        		if(nextNode.hasNext(nextNode)){
    	        			System.out.println((nextNode.hasNextElement(nextNode.nextAddress)).data);
    	        			
    	        		}
    	        		nextNode = nextNode.nextAddress;
    	        		//System.out.println("Herewhile");
    	        	}
    	        }
    	        //System.out.println("Here");
    	        break;
    	case 8: System.exit(0);		
    	
    	}
    }//while
}//main
@Override
public Node<T> sort(Node<T> myHead) {
	// TODO Auto-generated method stub
	return null;
}


*/
}//class
