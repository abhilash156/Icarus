package mau.linkedlist;

import java.util.Scanner;

public class MyLinkedList<T> {
    Node<T> headNode = new Node<T>();

    MyLinkedList(Node<T> newNode) {
        this.headNode = newNode;
    }

    MyLinkedList() {
        this.headNode = new Node<T>();
    }

    public void insert(Node<T> newNode) {
        if (newNode == null) {
            System.out.println("Null node cannot be added.");
        } else {

            Node<T> temp;
            temp = this.headNode;
            while (temp.nextAddress != null) {
                temp = temp.nextAddress; //i will traverse till last node
            }
            temp.nextAddress = newNode; //as soon as i reach to the end, i append new node
        }//if the node is not null
    }//insert method


    public int compareToMy(Node<T> node1, Node<T> node2) {
        String a, b;
        if (node1.data instanceof Integer || node1.data instanceof Double) {
            a = node1.data.toString();
            b = node2.data.toString();
        } else {
            a = (String) node1.data;
            b = (String) node2.data;
        }
        if (a.compareTo(b) > 0)
            return 1;
        else if (a.compareTo(b) < 0)
            return -1;//i am checking their data fields
        else
            return 0;
    }//compare to method

    public boolean contains(Node<T> node) {

        Node<T> temp = this.headNode;
        while (temp != null) {
            if (compareToMy(temp, node) == 0) {//if match is found
                return true;
            }
            temp = temp.nextAddress;
        }
        return false;
    }//checks if the element is present in the list

    public void delete(Node<T> newNode) {
        if (newNode == null) {
            System.out.println("Null node cannot be deleted.");
        } else {
            Node<T> temp1, temp2;
            temp1 = this.headNode;
            temp2 = this.headNode.nextAddress;

            while (temp2 != null) {
                if (compareToMy(temp2, newNode) == 0) {
                    temp1.nextAddress = temp2.nextAddress;
                    temp2.nextAddress = null;
                }
                temp1 = temp2;
                temp2 = temp2.nextAddress;
            }
        }
    }//delete method

    public int findLength() {
        Node<T> temp = this.headNode.nextAddress;
        int len = 0;
        if (temp == null)
            return 0;
        while (temp != null) {
            len++;
            temp = temp.nextAddress;
        }
        return len;
    }

    public void sort() {
        Node<T> temp, i, j, k, l, m;
        temp = this.headNode;
        i = temp;
        j = temp.nextAddress;
        m = temp;
        //int len = findLength();
        while (i != null) {
            System.out.println("i" + i.data);
            j = i;
            while (j != null) {
                System.out.println("j" + j.data);
                if (compareToMy(i, j) > 0) {
                    System.out.println("Here" + i.data + j.data);
                    k = i;
                    l = j;
                    i = l;
                    i.nextAddress = k.nextAddress;
                    j = k;
                    j.nextAddress = l.nextAddress;
                    m.nextAddress = j;
                }
                j = j.nextAddress;
                m = m.nextAddress;
            }
            i = i.nextAddress;
        }
    }

    public void printList() {
        Node<T> temp;
        temp = this.headNode.nextAddress;
        while (temp != null) {
            System.out.printf(" %s ", temp.data);
            temp = temp.nextAddress;
        }
    }

    public Node<T> hasNextElement() {
        // TODO Auto-generated method stub
        if (this.headNode == null)
            return null;
        else return this.headNode;
    }

    public boolean hasNext() {
        if (this.headNode.nextAddress != null)
            return true;
        else return false;
    }

    public static void main(String args[]) {
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter head node: ");
//    	  int hd = sc.nextInt();
        Node<Integer> node = new Node<Integer>();
        MyLinkedList<Integer> head = new MyLinkedList<Integer>(node);
        while (ch != 5) {
            System.out.println("\n1. Insert\n2. Delete \n3. Sort \n4. Print \n5. Exit");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Val: ");
                    int val = sc.nextInt();
                    Node<Integer> temp = new Node<Integer>(val);
                    head.insert(temp);
                    break;
                case 2:
                    if (head.findLength() == 0)
                        break;
                    System.out.println("Val: ");
                    int value = sc.nextInt();
                    Node<Integer> temp1 = new Node<Integer>(value);
                    head.delete(temp1);
                    break;
                case 3:  //head.sort();
                    break;
                case 4:
                    head.printList();
                    break;
                case 5:
                    System.exit(0);
            }
        }
        System.out.println();
        sc.close();
    }//main

}//class
