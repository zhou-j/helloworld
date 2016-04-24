abstract class Animal
{
    abstract void eat();
}

class Dog extends Animal
{
     void eat()
     {
          System.out.println("啃骨头");
      }
     void lookHome()
      {
           System.out.println("看家 ");
       }
}

class Cat extends Animal
{
      void eat()
      {
           System.out.println("吃鱼");
       }
       void catchMouse()
       {
            System.out.println("抓老鼠");
        }
}

class Pig extends Animal
{
       void eat()
       {
            System.out.println("饲料");
        }
        void gongDi()
        {
             System.out.println("拱地");
         }
}


class DuoTaiDemo
{
     public static void main(String[] args)
     {
          Cat c = new Cat();
          Dog d = new Dog();
          method(c);
          method(d);
          method(new Pig());
      }

      public static void method(Animal a)
      {
           a.eat();
       }
}
      