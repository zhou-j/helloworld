/*class Fu
{ 
 }
class Zi extends Fu
{
}

*/

class Person
{
      private int age;
      Person (int age)
      {
           this.age = age;
       }

       public boolean equals(Object obj )
       {
           if(!(obj instanceof Person))
           {
                throw new ClassCastException("¿‡–Õ¥ÌŒÛ");
            }

            Person p = (Person)obj;
            return this.age == p.age;
        }
}

class Demo
{
}


class  ObjectDemo
{
      public static void main(String[] args)
      {
             Person p1 = new Person(60);
             Person p2 = new Person(20);
             Demo d = new Demo();
             System.out.println(p1);
             System.out.println(p1.equals(p2));
             System.out.println(Integer.toHexString(p1.hashCode()));

             Class clazz1 = p1.getClass();
             Class clazz2 = p2.getClass();
             System.out.println(clazz1==clazz2);
       }
}