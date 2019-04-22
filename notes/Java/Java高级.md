# 二、面向对象

## 1. Java的四个基本特性，对多态的理解，在项目中哪些地方用到多态

- **Java的四个基本特性**
  - **抽象**：抽象是将一类对象的共同特征总结出来构造类的过程，包括<u>数据抽象</u>和<u>行为抽象</u>两方面。抽象只关注对象有哪些属性和行为，并不关注这些行为的细节是什么。  
  - **封装**：通常认为封装是把数据和操作数据的方法绑定起来，对数据的访问只能通过已定义的接口。面向对象的本质就是将现实世界描绘成一系列完全自治、封闭的对象。我们在类中编写的方法就是对实现细节的一种封装；我们编写一个类就是对数据和数据操作的封装。可以说，封装就是隐藏一切可隐藏的东西，只向外界提供最简单的编程接口。 
  - **继承**：继承是从已有类得到继承信息创建新类的过程。提供继承信息的类被称为父类（超类、基类）；得到继承信息的类被称为子类（派生类）。继承让变化中的软件系统有了一定的延续性，同时继承也是封装程序中可变因素的重要手段。
  - **多态**：多态性是指允许不同子类型的对象对同一消息作出不同的响应。 
- **多态的理解(多态的实现方式)** 
  - **方法重载**（overload）：实现的是**编译时的多态性**（也称为前绑定）。 
  - **方法重写**（override）：实现的是**运行时的多态性**（也称为后绑定）。运行时的多态是面向对象最精髓的东西。 
  - 要实现多态需要做两件事：
    - 1)  **方法重写**（子类继承父类并重写父类中已有的或抽象的方法）；
    - 2)  **对象造型**（用父类型引用引用子类型对象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为）。 
- **项目中对多态的应用** 
  - 举一个简单的例子，在物流信息管理系统中，有两种用户：订购客户和卖房客户，两个客户都可以登录系统，他们有相同的方法 Login，但登陆之后他们会进入到不同的页面，也就是在登录的时候会有不同的操作，两种客户都继承父类的 Login 方法，但对于不同的对象，拥有不同的操作。 
- **面相对象开发方式优点（B65）**
  - 较高的**开发效率**：可以把事物进行抽象，映射为开发的对象。
  - 保证软件的**鲁棒性**：高重用性，可以重用已有的而且在相关领域经过长期测试的代码。
  - 保证软件的**高可维护性**：代码的可读性非常好，设计模式也使得代码结构清晰，拓展性好。



## 2. 什么是重载和重写

- **重载**：重载发生在同一个类中，同名的方法如果有不同的参数列表（参数类型不同、参数个数不同或者二者都不同）则视为重载。 
- **重写**：重写发生在子类与父类之间，重写要求子类被重写方法与父类被重写方法有相同的返回类型，比父类被重写方法更好访问，不能比父类被重写方法声明更多的异常（里氏代换原则）。根据不同的子类对象确定调用的那个方法。 

 <div align="center"> <img src="assets/overloading-vs-overriding.png" width="700"/></div>




## 3. 面向对象和面向过程的区别？用面向过程可以实现面向对象吗？

- 面向对象和面向过程的区别 
  - **面向过程**就像是一个细心的管家，事无具细的都要考虑到。而**面向对象**就像是个家用电器，你只需要知道他的功能，不需要知道它的工作原理。 
  - **面向过程**是一种是“事件”为中心的编程思想。就是分析出解决问题所需的步骤，然后用函数把这些步骤实现，并按顺序调用。**面向对象**是以“对象”为中心的编程思想。 
  - 简单的举个例子：汽车发动、汽车到站 
    - 这对于 **面向过程** 来说，是两个事件，汽车启动是一个事件，汽车到站是另一个事件，**面向过程**编程的过程中我们关心的是事件，而不是汽车本身。针对上述两个事件，形成两个函数，之 后依次调用。（事件驱动，动词为主）
    - 然而这对于**面向对象**来说，我们关心的是汽车这类对象，两个事件只是这类对象所具有的行为。而且对于这两个行为的顺序没有强制要求。（对象驱动，名词为主，将问题抽象出具体的对象，而这个对象有自己的属性和方法，在解决问题的时候是将不同的对象组合在一起使用）
- 用面向过程可以实现面向对象吗 ？
  - 如果是 C 语言来展现出面向对象的思想，C 语言中是不是有个叫结构体的东西，这个里面有自己定义的变量 可以通过函数指针就可以实现对象



## 4. 面向对象开发的六个基本原则，在项目中用过哪些原则

- **六个基本原则**（参考《设计模式之禅》）

  - **单一职责**（Single Responsibility Principle 简称 SRP）：**一个类应该仅有一个引起它变化的原因**。在面向对象中，如果只让一个类完成它该做的事，而不涉及与它无关的领域就是践行了高内聚的原则，这个类就只有单一职责。 

  - **里氏替换**（Liskov Substitution Principle 简称 LSP）：**任何时候子类型能够替换掉它们的父类型**。子类一定是增加父类的能力而不是减少父类的能力，因为子类比父类的能力更多，把能力多的对象当成能力少的对象来用当然没有任何问题。 

  - **依赖倒置**（Dependence Inversion Principle 简称 DIP）：**要依赖于抽象，不要依赖于具体类**。要做到依赖倒置，应该做到：①高层模块不应该依赖底层模块，二者都应该依赖于抽象；②抽象不应该依赖于具体实现，具体实现应该依赖于抽象。

  - **接口隔离**（Interface Segregation Principle 简称 ISP）：**不应该强迫客户依赖于他们不用的方法** 。接口要小而专，绝不能大而全。臃肿的接口是对接口的污染，既然接口表示能力，那么一个接口只应该描述一种能力，接口也应该是高度内聚的。 

  - **最少知识原则**（Least Knowledge Principle 简称 LKP）：**只和你的朋友谈话**。迪米特法则又叫最少知识原则，一个对象应当对其他对象有尽可能少的了解。 

  - **开闭原则**（Open Closed Principle 简称 OCP）：**软件实体应当对扩展开放，对修改关闭**。要做到开闭有两个要点：①抽象是关键，一个系统中如果没有抽象类或接口系统就没有扩展点；②封装可变性，将系统中的各种可变因素封装到一个继承结构中，如果多个可变因素混杂在一起，系统将变得复杂而换乱。 

- 其他原则

  - 合成聚和复用：优先使用聚合或合成关系复用代码
  - 面向接口编程
  - 优先使用组合，而非继承
  - 一个类需要的数据应该隐藏在类的内部
  - 类之间应该零耦合，或者只有传导耦合，换句话说，类之间要么没关系，要么只使用另一个类的接口提供的操作
  - 在水平方向上尽可能统一地分布系统功能



- 项目中用到的原则 
  - 单一职责、开放封闭、合成聚合复用(最简单的例子就是String类)、接口隔离



## 5. 内部类有哪些

可以将一个类的定义放在另一个类的定义内部，这就是内部类。

在 Java 中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类

### （一）成员内部类

成员内部类也是最普通的内部类，它是外围类的一个成员，所以他是可以**无限制的访问外围类的所有成员属性和方法，尽管是private的**，但是外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问。

```java
public class OuterClass {
    private String str;
   
    public void outerDisplay(){
        System.out.println("outerClass...");
    }
    
    public class InnerClass{
        public void innerDisplay(){
            str = "chenssy..."; //使用外围内的属性
            System.out.println(str);
            outerDisplay();  //使用外围内的方法
        }
    }
    
    // 推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
    public InnerClass getInnerClass(){
        return new InnerClass();
    }
    
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.getInnerClass();
        inner.innerDisplay();
    }
}
--------------------
chenssy...
outerClass...
```

在成员内部类中要注意两点：

- 成员内部类中不能存在`static`方法, 但是可以存在`static`域, 前提是需要使用`final`关键字进行修饰.

- 成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。   



### （二）局部内部类

有这样一种内部类，它是嵌套在方法和作用于内的，对于这个类的使用主要是应用与解决比较复杂的问题，想创建一个类来辅助我们的解决方案，到那时又不希望这个类是公共可用的，所以就产生了局部内部类，局部内部类和成员内部类一样被编译，只是它的作用域发生了改变，它只能在该方法和属性中被使用，出了该方法和属性就会失效。 

```java
//定义在方法里：
public class Parcel5 {
    public Destionation destionation(String str){
        class PDestionation implements Destionation{
            private String label;
            private PDestionation(String whereTo){
                label = whereTo;
            }
            public String readLabel(){
                return label;
            }
        }
        return new PDestionation(str);
    }
    
    public static void main(String[] args) {
        Parcel5 parcel5 = new Parcel5();
        Destionation d = parcel5.destionation("chenssy");
    }
}

//定义在作用域内:
public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip(){
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("chenssy");
            String string = ts.getSlip();
        }
    }
    
    public void track(){
        internalTracking(true);
    }
    
    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
```



### （三）匿名内部类

匿名内部类也就是没有名字的内部类。正因为没有名字，所以匿名内部类只能使用一次，它通常用来简化代码编写。但使用匿名内部类还有个前提条件：必须继承一个父类或实现一个接口



**实例1：不使用匿名内部类来实现抽象方法**

```java
abstract class Person {
    public abstract void eat();
}
 
class Child extends Person {
    public void eat() {
        System.out.println("eat something");
    }
}
 
public class Demo {
    public static void main(String[] args) {
        Person p = new Child();
        p.eat();
    }
}
```

**运行结果**：eat something



可以看到，我们用 Child 继承了 Person 类，然后实现了 Child 的一个实例，将其向上转型为 Person 类的引用

但是，如果此处的 Child 类只使用一次，那么将其编写为独立的一个类岂不是很麻烦？

这个时候就引入了匿名内部类

 

**实例2：匿名内部类的基本实现**

```java
abstract class Person {
    public abstract void eat();
}
 
public class Demo {
    public static void main(String[] args) {
        Person p = new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        };
        p.eat();
    }
}
```

**运行结果**：eat something



可以看到，我们直接将抽象类 Person 中的方法在大括号中实现了，这样便可以省略一个类的书写，并且，匿名内部类还能用于接口上。



**实例3：在接口上使用匿名内部类**

```java
interface Person {
    public void eat();
}
 
public class Demo {
    public static void main(String[] args) {
        Person p = new Person() {
            public void eat() {
                System.out.println("eat something");
            }
        };
        p.eat();
    }
}
```

**运行结果**：eat something

 

由上面的例子可以看出，只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现

最常用的情况就是在多线程的实现上，因为要实现多线程必须继承 Thread 类或是继承 Runnable 接口

 

**实例4：Thread类的匿名内部类实现**

```java

public class Demo {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();
    }
}
```

**运行结果**：1 2 3 4 5

 

**实例5：Runnable接口的匿名内部类实现**

```java
public class Demo {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
```

**运行结果**：1 2 3 4 5



### （四）静态内部类

关键字 static 中提到 static 可以修饰成员变量、方法、代码块，其他它还可以修饰内部类，使用 static 修饰的内部类我们称之为静态内部类，不过我们更喜欢称之为嵌套内部类。静态内部类与非静态内部类之间存在一个最大的区别，我们知道非静态内部类在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围内，但是静态内部类却没有。

1. 它的创建是不需要依赖于外围类的。

2. 它不能使用任何外围类的非 static 成员变量和方法。

```java
public class OuterClass {
    private String sex;
    public static String name = "chenssy";
    
    // 静态内部类 
    static class InnerClass1{
        // 在静态内部类中可以存在静态成员
        public static String _name1 = "chenssy_static";
        
        public void display(){ 
            // 静态内部类只能访问外围类的静态成员变量和方法
		   // 不能访问外围类的非静态成员变量和方法
            System.out.println("OutClass name :" + name);
        }
    }
    

    // 非静态内部类
    class InnerClass2{
        // 非静态内部类中不能存在静态成员
        public String _name2 = "chenssy_inner";
        // 非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的
        public void display(){
            System.out.println("OuterClass name：" + name);
        }
    }
    
    // 外围类方法
    public void display(){
        // 外围类访问静态内部类：内部类
        System.out.println(InnerClass1._name1);
        // 静态内部类 可以直接创建实例不需要依赖于外围类
        new InnerClass1().display();
        
        // 非静态内部的创建需要依赖于外围类
        OuterClass.InnerClass2 inner2 = new OuterClass().new InnerClass2();
        // 方位非静态内部类的成员需要使用非静态内部类的实例
        System.out.println(inner2._name2);
        inner2.display();
    }
    
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.display();
    }
}
----------------
Output:
chenssy_static
OutClass name :chenssy
chenssy_inner
OuterClass name：chenssy
```



## 6. 组合、继承和代理的区别

### 定义

- 组合：在新类中 new 另外一个类的对象，以添加该对象的特性。
- 继承：从基类继承得到子类，获得父类的特性。
- 代理：在代理类中创建某功能的类，调用类的一些方法以获得该类的部分特性。

### 使用场合

- 组合：各部件之间没什么关系，只需要组合即可。例如组装电脑，需要 new CPU(),new RAM(),new Disk()

  ```java
  public class Computer {
      public Computer() {
          CPU cpu=new CPU();
          RAM ram=new RAM();
          Disk disk=new Disk();
      }
  }
  class CPU{    }
  class RAM{    }
  class Disk{    }
  ```

- 继承：子类需要具有父类的功能，各子类之间有所差异。例如 Shape 类作为父类，子类有 Rectangle，CirCle，Triangle……代码不写了，大家都经常用。

- 代理：飞机控制类，我不想暴露太多飞机控制的功能，只需部分前进左右转的控制（而不需要暴露发射导弹功能）。通过在代理类中 new 一个飞机控制对象，然后在方法中添加飞机控制类的各个需要暴露的功能。

  ```java
  public class PlaneDelegation{    
      private PlaneControl planeControl;    //private外部不可访问
  	
      // 飞行员权限代理类，普通飞行员不可以开火
      PlaneDelegation(){
          planeControl = new PlaneControl();
      }
      public void speed(){
          planeControl.speed();
      }
      public void left(){
          planeControl.left();
      }
      public void right(){
          planeControl.right();
      }
  }
  
  final class PlaneControl {// final表示不可继承，控制器都能继承那还得了
      protected void speed() {}
      protected void fire() {}
      protected void left() {}
      protected void right() {}
  }
  ```

**说明：**

- 继承：代码复用，引用不灵活；
- 组合：代码复用，
- 接口：引用灵活； 
- 推荐组合+接口使用，看 IO 中包装流 FilterInputStream 中的策略模式



## 7. 什么是构造函数

构造函数是函数的一种特殊形式。特殊在哪里？构造函数中不需要定义返回类型（void 是无需返回值的意思，请注意区分两者），且构造函数的名称与所在的类名完全一致，其余的与函数的特性相同，可以带有参数列表，可以存在函数的重载现象。 

一般用来初始化一些成员变量，当要生成一个类的对象（实例）的时候就会调用类的构造函数。如果不显示声明类的构造方法，会自动生成一个默认的不带参数的空的构造函数。

```java
public class Demo{
    private int num=0;

    //无参构造函数
    Demo()
    {
        System.out.println("constractor_run");
    }

    //有参构造函数
    Demo(int num)
    {
        System.out.println("constractor_args_run");
    }

    //普通成员函数
    public void demoFunction()
    {
        System.out.println("function_run");
    }
}
```

在这里要说明一点，如果在类中我们不声明构造函数，JVM 会帮我们默认生成一个空参数的构造函数；如果在类中我们声明了带参数列表的构造函数，JVM 就不会帮我们默认生成一个空参数的构造函数，我们想要使用空参数的构造函数就必须自己去显式的声明一个空参的构造函数。 



**构造函数的作用**

　　通过开头的介绍，构造函数的轮廓已经渐渐清晰，那么为什么会有构造函数呢？构造函数有什么作用？构造函数是面向对象编程思想所需求的，它的主要作用有以下两个：

- **创建对象**。任何一个对象创建时，都需要初始化才能使用，所以任何类想要创建实例对象就必须具有构造函数。
- **对象初始化**。构造函数可以对对象进行初始化，并且是给与之格式（参数列表）相符合的对象初始化，是具有一定针对性的初始化函数。





## 8. 向上造型和向下造型

父类引用能指向子类对象，子类引用不能指向父类对象；

**向上造型**

父类引用指向子类对象，例如：

```java
Father f1 = new Son();
```

**向下造型**

把指向子类对象的父类引用赋给子类引用，需要强制转换，例如：

```java
Father f1 = new Son();
Son s1 = (Son)f1;
```

但有运行出错的情况：

```java
Father f2 = new Father();
Son s2 = (Son)f2; //编译无错但运行会出现错误
```

在不确定父类引用是否指向子类对象时，可以用 instanceof 来判断：

```java
if(f3 instanceof Son){
     Son s3 = (Son)f3;
}
```
