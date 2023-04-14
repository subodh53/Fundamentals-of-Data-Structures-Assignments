import java.util.Scanner;

public class Main
{
public static void main (String[]args)
{
Scanner scan = new Scanner(System.in);
EmployeeDatabase e1 = new EmployeeDatabase(5);
boolean cont = true;
while(cont)
{
int choice = 0;
System.out.println("1.Add Record: ");
System.out.println("2.Display Record");
System.out.println("3.Search Record");
System.out.println("4.Delete Record");
System.out.println("5.Exit");
System.out.println("Select the operation to perform: ");
choice = scan.nextInt();
System.out.println();
switch(choice)
{
case 1:
e1.addData();
break;
case 2:
e1.displayDatabase();
break;
case 3:
int id;
System.out.print("Enter Id of Employee: ");
id = scan.nextInt();
e1.Search(id);
break;
case 4:
int id1;
System.out.print("Enter Id of Employee: ");
id1 = scan.nextInt();
e1.delete(id1);
break;
case 5:
cont = false;
break;
default:
System.out.println("Enter valid option");
}

}

scan.close();
}
}

class EmployeeData
{
  String name;
  int id;
  double salary;
}

class EmployeeDatabase
{
EmployeeData emp[];
  int empNum = 0,currentEmp;
    EmployeeDatabase (int empNum)
    {
    this.empNum = empNum;
    emp = new EmployeeData[empNum];
    for (int i = 0; i < empNum; i++)
    {
        emp[i] = new EmployeeData();
    }
    currentEmp = 0;
  }

    void addData ()
  {
 Scanner sc = new Scanner(System.in);
    System.out.print ("Enter employee name: ");
    emp[this.currentEmp].name = sc.nextLine ();
    System.out.print ("Enter employee ID: ");
    emp[this.currentEmp].id = sc.nextInt ();
    System.out.print ("Enter employee salary: ");
    emp[this.currentEmp++].salary = sc.nextDouble();
  }

  void displayDatabase ()
  {
 System.out.println();
      System.out.println("Employee Data: ");
      for (EmployeeData s:emp)
      {
      if (s.name != null)
      {
      System.out.println ("Employee Name: " + s.name);
      System.out.println ("Employee ID: " + s.id);
      System.out.println ("Employee Salary: " + s.salary);
      }
      }
      System.out.println();
  }
 
  void Search(int id)
  {
  boolean found = false;
  for(EmployeeData s: emp)
  {
  if(s.id == id)
  {
  System.out.println();
  System.out.println ("Employee Name: " + s.name);
      System.out.println ("Employee ID: " + s.id);
      System.out.println ("Employee Salary: " + s.salary);
      System.out.println();
      found = true;
      break;
  }
  }
 
  if(!found)
  System.out.println("Employee Record not found in database");
  }
 
  void delete(int id)
  {
  boolean found = false;
  int loc = 0;
  for(EmployeeData s: emp)
  {
  if(s.id == id)
  {
  found = true;
  break;
  }
  loc++;
  }
 
  if(found)
  {
  int i;
  for(i = loc; i < this.empNum - 1; i++)
    {
    emp[i] = emp[i+1];
    }
  emp[i] = new EmployeeData();
  }
 
  if(!found)
  System.out.println("Employee Record not found in database");
 
  }
}











