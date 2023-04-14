import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean cont = true;
		Stack s1 = new Stack();
		while(cont) {
		    int choice;
		    System.out.println("1.Push an Element on to Stack");
		    System.out.println("2.Pop an Element");
		    System.out.println("3.Display Stack");
		    System.out.println("4.Exit");
		    System.out.print("Enter Choice: ");
		    choice = Integer.parseInt(sc.nextLine());
		    switch(choice) {
		        case 1:
		            System.out.print("Enter the Element to push: ");
		            int d = Integer.parseInt(sc.nextLine());
		            s1.push(d);
		            break;
		        case 2:
		            s1.pop();
		            break;
		        case 3:
		            s1.display();
		            break;
		        case 4:
		            cont = false;
		            break;
		        default:
		            System.out.println("Enter valid option!!!");
		    }
		    
		}
	}
}

class Stack {
    Node top;
    
    Stack() {
        this.top = null;
    }
    
    class Node {
        int data;
        Node next;
        
        Node (int d) {
            this.data = d;
        }
    }
    
    void push(int d) {
        Node newNode = new Node(d);
        newNode.next = top;
        top = newNode;
    }
    
    boolean isEmpty() {
        if(top == null)
            return true;
        else
            return false;
    } 
    
    void pop() {
        if(this.isEmpty()) {
            System.out.println("Underflow");
        }
        else {
            System.out.println("Popped: " + this.top.data);
            top = top.next;
        }
    }
    
    void display() {
        Node temp = this.top;
        
        if(this.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        else {
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}



