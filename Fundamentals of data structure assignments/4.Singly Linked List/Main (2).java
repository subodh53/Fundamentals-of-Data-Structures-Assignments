import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList s1 = new SinglyLinkedList();
        boolean cont = true;
        while(cont) {
            int choice;
            System.out.println("1.Insert");
            System.out.println("2.Deletion");
            System.out.println("3.Search");
            System.out.println("4.Modify");
            System.out.println("5.Display");
            System.out.println("6.Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                	sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    s1.addNode(name, id, salary);
                    break;
                case 2:
                	System.out.print("Enter Employee ID to delete: ");
                	int id1 = sc.nextInt();
                	s1.deleteNode(id1);
                    break;
                case 3:
                	System.out.print("Enter Employee ID to search: ");
                	int id2 = sc.nextInt();
                	s1.searchNode(id2);
                    break;
                case 4:
                	System.out.print("Enter Employee ID to search: ");
                	int id3 = sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter new employee details:");
                	System.out.print("Name: ");
                	String n = sc.nextLine();
                	System.out.print("Salary: ");
                	double s = sc.nextDouble();
                	s1.modifyNode(id3, n, s);
                    break;
                case 5:
                	s1.displayData();
                	break;
                case 6:
                    cont = false;
                    break;
                default:
                    System.out.println("Enter valid choice!");
            }
        }
        sc.close();
    }
}

class SinglyLinkedList {
    class Node {
        String name;
        double salary;
        int id;
        Node next;
        Node(String n, int i, double s) {
            this.name = n;
            this.id = i;
            this.salary = s;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addNode(String n, int i, double s) {
        Node temp = new Node(n, i, s);
        if(head == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            tail = temp;
        }
    }

    void displayData() {
        Node temp = this.head;
        while(temp != null) {
            System.out.println();
            System.out.println("Employee Name: " + temp.name);
            System.out.println("Employee ID: " + temp.id);
            System.out.println("Employee Salary: " + temp.salary);
            System.out.println();
            temp = temp.next;
        }
    }
    
    void deleteNode(int i) {
    	Node temp = this.head.next;
    	Node ptemp = this.head;
    	boolean found = false;
    	if(this.head.id == i) {
    		head = head.next;
    		found = true;
    	}
    	else {
    		while(temp != null) {
        		if(temp.id == i) {
        			ptemp.next = temp.next;
        			found = true;
        			System.out.println("Employee data deleted successfully!!");
        			break;
        		}
    		}
    	}
    	
    	if(!found)
    		System.out.println("Employee ID not found!!");
    }
    
    void searchNode(int i) {
    	Node temp = head;
    	while(temp != null) {
    		if(temp.id == i) {
    			System.out.println();
                System.out.println("Employee Name: " + temp.name);
                System.out.println("Employee ID: " + temp.id);
                System.out.println("Employee Salary: " + temp.salary);
                System.out.println();
                break;
    		}
    		temp = temp.next;
    	}
    }
    
    void modifyNode(int i, String n, double s) {
    	Node temp = head;
    	boolean found = false;
    	while(temp != null) {
    		if(temp.id == i) {
    			temp.name = n;
    			temp.salary = s;
                break;
    		}
    		temp = temp.next;
    	}
    	if(!found)
    		System.out.println("Employee ID not found!!");
    }
}





