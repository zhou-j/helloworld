
class Person
{
   String name;
   int age;
}





class Student extends/*ผฬณะ*/Person
{
 // String name;
  //int age;
  void study()
  {
    System.out.println(name+"....student study.."+age);
   }
}
 
class Worker extends Person
{
 //  String name;
 //   int age; 
   void work()
   {
     System.out.println("worker work");
    }
}

class ExtendsDemo
{
    public static void main (String[] args)
   {
     Student s = new Student();
     s.name = "zhangshan";
     s.age = 22;
     s.study();
    }
}
