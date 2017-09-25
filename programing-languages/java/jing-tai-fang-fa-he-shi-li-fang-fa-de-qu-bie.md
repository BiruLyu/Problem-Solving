# [java 静态方法和实例方法的区别](http://www.cnblogs.com/shenliang123/archive/2011/10/27/2226923.html)

静态方法和实例方法的区别主要体现在两个方面：

在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。

静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；实例方法则无此限制。

下面几个例子展示了这一区别。

1. 调用静态方法示例。

```java
//-----------hasStaticMethod.java-----------------
public class hasStaticMethod{
    //定义一个静态方法
    public static void callMe(){
      System.out.println("This is a static method.");
    }
}

```

下面这个程序使用两种形式来调用静态方法。

```java
//-----------invokeStaticMethod.java-----------------
public class invokeStaticMethod{
    public static void main(String args[]){
    hasStaticMethod.callMe();  //不创建对象，直接调用静态方法    
    hasStaticMethod oa = new hasStaticMethod();   //创建一个对象
    oa.callMe();      //利用对象来调用静态方法
  }
} 
```

程序两次调用静态方法，都是允许的，程序的输出如下：

```
This is a static method.This is a static method. 
```

允许不创建对象而调用静态方法，是Java为了减少程序员调用某些常用方法时的麻烦，而允许程序员按照传统的C语言中使用函数的方式来使用方法。典型的例子是前面某些程序中使用"Math.ramdon()"来获取随机数。
还有一个很典型的代表就是数组的处理工具Arrays

2. 静态方法访问成员变量示例。

```java
//-----------accessMember.java-----------------

class accessMember{

    private static int sa; //定义一个静态成员变量
    private int ia;  //定义一个实例成员变量
    //下面定义一个静态方法
    static void statMethod(){
      int i = 0;    //正确，可以有自己的局部变量sa = 10;   
      //正确，静态方法可以使用静态变量
      otherStat();  
      //正确，可以调用静态方法
      ia = 20;   //错误，不能使用实例变量
      insMethod();  //错误，不能调用实例方法
    }

    static void otherStat(){} 

    //下面定义一个实例方法 
    void  insMethod(){
      int i = 0;    //正确，可以有自己的局部变量
      sa = 15;    //正确，可以使用静态变量
      ia = 30;    //正确，可以使用实例变量
      statMethod();   //正确，可以调用静态方法
    }
} 
```

本例其实可以概括成一句话：**静态方法只能访问静态成员，实例方法可以访问静态和实例成员。之所以不允许静态方法访问实例成员变量，是因为实例成员变量是属于某个对象的，而静态方法在执行时，并不一定存在对象。同样，因为实例方法可以访问实例成员变量，如果允许静态方法调用实例方法，将间接地允许它使用实例成员变量，所以它也不能调用实例方法。基于同样的道理，静态方法中也不能使用关键字this**。

main()方法是一个典型的静态方法，它同样遵循一般静态方法的规则，所以它可以由系统在创建对象之前就调用。