| 关键字 |||||  
| :---: | :---: | :---: | :---: | :---: | 
| [abstract](#abstract) | [assert](#assert) | boolean | [break](#break) | byte |
| case | catch | char | class | const |
| [continue](#continue) | default | do | double | else |
| enum | [extends](#extends) | [final](#final) | [finally](#finally) | float |
| for |	goto | if | implements | import |
| [instanceof](#instanceof) | int | interface | long	| [native](#native) |
| new	| package |	private |	protected |	public |
| [return](#return) | [strictfp](#strictfp)	 | short | [static](#static) |	super |
| switch | synchronized |	this |	throw |	throws |
| [transient](#transient) |	try |	void | [volatile](#volatile) |	while |
---

## abstract
> 用于修饰方法和类。
```
抽象方法：不同类的方法是相似，但是具体内容又不太一样，所以我们只能抽取他的声明，没有具体的方法体，没有具体方法体的方法就是抽象方法、
```
```
抽象类：有抽象方法的类必须是抽象类
```

- 注意：一个类继承了抽象类需要重写他所有的抽象方法，否则这个类就得是抽象类。

> ### 抽象特点

- 1. 一般把父类定义为抽象类。
- 2. 抽象方法必须放在抽象类中，抽象类和抽象方法必须被 abstract 修饰。
- 3. 抽象类中不一定有抽象方法，抽象类中可以有非抽象的方法。
- 4. 子类必须重写父类的抽象方法，不然子类就变成抽象类。
- 5. 抽象类不能创建对象（不能实例化）。
- 6. 抽象类有构造方法？为什么要有？因为抽象类是父类，在创建子类对象时，要先调用父类的构造方法，所以抽象类的构造就是给子类用的。

> ### 抽象类 和 类区别？

- 1. 抽象类和类的关系也是继承（一个类继承了抽象类要么重写所有的抽象方法，要么他自己是抽象类）。
- 2. 抽象类不能创建对象，普通类可以创建对象。
- 3. 抽象类可以有抽象方法，普通类不能有抽象方法。

> ### 抽象类作用？

- 1. 抽象类让我们不需要写方法体（可是这个优点很小，所以如果不定义抽象类也可以）。
---

## assert
> 断言（assert）作为一种软件调试的方法，提供了一种在代码中进行正确性检查的机制，目前很多开发语言都支持这种机制。

```
在实现中，assertion 就是在程序中的一条语句，它对一个 boolean 表达式进行检查，一个正确程序必须保证这个 boolean 表达式的值为 true；如果该值为 false，说明程序已经处于不正确的状态下，系统将给出警告并且退出。一般来说，assertion 用于保证程序最基本、关键的正确性。assertion 检查通常在开发和测试时开启。为了提高性能，在软件发布后，assertion 检查通常是关闭的。下面简单介绍一下 Java 中 assertion 的实现。
```
- 在语法上，为了支持 assertion，Java 增加了一个关键字 assert。它包括两种表达式，分别如下：

assert <boolean表达式> : <错误信息表达式> 
```
如果 <boolean表达式> 为 true 则程序继续执行。如果为 false 则程序抛出 java.lang.AssertionError，并输入<错误信息表达式>。
```
assert <boolean表达式>
```
如果 <boolean表达式> 为 true，则程序继续执行。如果为 false，则程序抛出 AssertionError，并终止执行。 
```
```
public static void main(String[] args) {
    System.out.println("123");
    
    int a = 0;
    int b = 1;
    assert a == b; // 需显示开启，默认为不开启状态 
    assert a == b : "执行失败！";

    System.out.println("1234");
}
```
assert 的应用范围很多，主要包括：
- 检查控制流
- 检查输入参数是否有效
- 检查函数结果是否有效
- 检查程序不变

> ### 什么是断言
> 断言是编程术语，表示为一些布尔表达式，程序员相信在程序中的某个特定点该表达式值为真，可以在任何时候启用和禁用断言验证，因此可以在测试时启用断言而在部署时禁用断言。同样，程序投入运行后，最终用户在遇到问题时可以重新启用断言。

> 使用断言可以创建更稳定、品质更好且 不易于出错的代码。当需要在一个值为 `false` 时中断当前操作的话，可以使用断言。单元测试必须使用断言（Junit/JunitX）。

> ### 常用断言方法

| 断言 | 描述 |
| --- | --- |
| void assertEquals([String message], expected value, actual value) | 断言两个值相等。值可能是类型有 int, short, long, byte, char or java.lang.Object. 第一个参数是一个可选的字符串消息 |
| void assertTrue([String message], boolean condition)         | 断言一个条件为真                                             |
| void assertFalse([String message],boolean condition)         | 断言一个条件为假                                             |
| void assertNotNull([String message], java.lang.Object object) | 断言一个对象不为空(null)                                     |
| void assertNull([String message], java.lang.Object object)   | 断言一个对象为空(null)                                       |
| void assertSame([String message], java.lang.Object expected, java.lang.Object actual) | 断言，两个对象引用相同的对象                                 |
| void assertNotSame([String message], java.lang.Object unexpected, java.lang.Object actual) | 断言，两个对象不是引用同一个对象                             |
| void assertArrayEquals([String message], expectedArray, resultArray) | 断言预期数组和结果数组相等。数组的类型可能是 int, long, short, char, byte or java.lang.Object. |
---

## break
> 跳出当前循环；但是如果是嵌套循环，则只能跳出当前的这一层循环，只有逐层 break 才能跳出所有循环。

```
for (int i = 0; i < 10; i++) {
    // 在执行i==6时强制终止循环，i==6不会被执行 
    if (i == 6)
        break;
    System.out.println(i);  
}  
```
```
输出结果为0 1 2 3 4 5 ；6以后的都不会输出
```
---

## continue 
> 终止当前循环，但是不跳出循环（在循环中 continue 后面的语句是不会执行了），继续往下根据循环条件执行循环。

```
for (int i = 0; i < 10; i++) {  
    // i==6不会被执行，而是被中断了    
    if(i == 6) 
        continue;   
    System.out.println(i);  
}
```
```
输出结果为0 1 2 3 4 5 7 8 9； 只有6没有输出
```
---

## extends 
> ### 继承概念

- 类和类的一种关系，在父类中定义的非私有成员可以在子类中直接使用。
- 提高代码的复用性。
- 多个类有共同的成员变量和成员方法，抽取到另外一个类中（父类），再让多个类去继承这个父类，我们的多个类就可以获取到父类中的成员了。

> ### 继承特点

- 1. 子类和父类应该是有关系（所属）的。
- 2. Java语言只支持单一继承，只能继承一个父类（一个儿子只能有一个亲爹）。
- 3. Java语言支持多层继承（一个儿子可以有一个亲爹，还可以有一个亲爷爷）。

> ### 继承成员变量特点

- 1. 就近原则：谁离我近我就用谁。
```
如果有局部变量就使用局部变量。
如果没有局部变量，有子类的成员变量就使用子类的成员变量。
如果没有局部变量和子类的成员变量，有父类的成员变量就使用父类的成员变量。啥都没有，出错了！！！
```
- 2. 子类只能获取父类非私有成员。
- 3. 子父类中成员变量的名字不一样直接获取父类的成员变量。
- 4. 子父类中成员变量名字是一样的获取的是子类的成员变量。

关键字 | 描述
---|---
this | 调用当前类的成员变量。
super | 调用当前类父类的成员（可以获取父类的成员变量和成员方法，用法和this是相似的）。

> ### 继承成员方法特点

- 1. 子类中没有这个方法，调用父类的。
- 2. 子类中重写了这个方法，调用子类的。

重点 | 描述
---|---
方法重载 | 在一个类中，有多个重名的方法，但是其参数不一样（参数个数、参数类型、参数顺序），和返回值无关。
方法重写 | 在子父类当中，子类的方法和父类的完全一样，子类重写了父类的方法（覆盖），当子类重写了父类的方法之后，使用子类对象调用的就是子类的方法。
> 方法重写的应用场景

```
当父类的方法不能完全满足子类使用，这个时候子类重写父类的方法，并可以在方法中使用关键字super调用父类的方法，这样做即可以保有父类的功能，也可以拥有子类特有的功能
```
> 方法重写的注意事项：

```
1. 不能重写父类私有的方法
2. 权限必须大于等于父类方法的权限
```
	
> ### 继承构造方法执行顺序

```
1. 创建子类对象
2. 调用子类的构造方法
3. 在子类的构造方法的第一行代码如果没有调用父类的构造或者没有调用子类的其他构造，则默认调用父类无参构造，手动调用构造方法 this()、super()，并且必须出现在构造方法的第一行。
```
> ### 为什么要调用父类构造？
> 因为需要给父类的成员变量初始化，肯定会先把父类的构造执行完毕，再去执行子类构造中的其他代码。
    
> ### this 和 super 区别？

- this：当前对象的引用。
```
1. 调用子类的成员变量。
2. 调用子类的成员方法。
3. 在子类的构造方法第一行调用子类其他构造方法。
```
- super：子类对象的父类引用。
```
1. 调用父类的成员变量。
2. 调用父类的成员方法。
3. 在子类的构造方法第一行调用父类的构造方法。
```
> ### 继承优缺点

- 优点：
```
1. 提高了代码的复用性。
2. 提高了代码的可维护性。
3. 是多态的前提。
```
- 缺点：
```
1. 增强了类之间的耦合性。
```
- 开发的原则： 
```
1. 高内聚 低耦合。
```
---

## final 
> ### final特点
> final可以修饰类、成员方法 和 成员变量。

- 1. final所修饰的类，不能被继承，不能有子类。
- 2. final所修饰的方法，不能被重写。
- 3. final所修饰的变量，是不可以修改的，是常量。

> ### final常量
>  声明数据为常量，可以是编译时常量，也可以是在运行时被初始化后不能被改变的常量。

- 对于基本类型
```
final 使数值不变。
```
- 对于引用类型
```
final 使引用不变，也就不能引用其它对象，但是被引用的对象本身是可以修改的。
```
```
final int x = 1;
// x = 2;  // cannot assign value to final variable 'x'
final A y = new A();
y.a = 1;
```
- 字面值常量
```
1、2、3
```
- 自定义常量
```
被 final 所修饰的成员变量，一旦初始化则不可改变。
```
```
final int NUM;    
public Dog() {
	NUM = 10;
}
```
注意：自定义常量必须初始化，可以选择显示初始化或者构造初始化

> ### final方法
> private 方法隐式地被指定为 final，如果在子类中定义的方法和基类中的一个 private 方法签名相同，此时子类的方法不是覆盖基类方法，而是在子类中定义了一个新的方法。

> ### final类
> 声明类不允许被继承。
---

## finally 
> 在异常处理的时候，提供 finally 块来执行任何的清除操作。如果抛出一个异常，那么相匹配的 catch 字句就会执行，然后控制就会进入 finally 块，前提是有 finally 块。例如：数据库连接关闭操作上

> finally 作为异常处理的一部分，它只能用在 try/catch 语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。

> ### 异常情况说明：

- 在执行 try 语句块之前已经返回或抛出异常，所以 try 对应的 finally 语句并没有执行。 
 - 我们在 try 语句块中执行了 System.exit (0) 语句，终止了 Java 虚拟机的运行。那有人说了，在一般的 Java 应用中基本上是不会调用这个 System.exit(0) 方法的 
  - 当一个线程在执行 try 语句块或者 catch 语句块时被打断（interrupted）或者被终止（killed），与其相对应的 finally 语句块可能不会执行 
  - 还有更极端的情况，就是在线程运行 try 语句块或者 catch 语句块时，突然死机或者断电，finally 语句块肯定不会执行了。可能有人认为死机、断电这些理由有些强词夺理，没有关系，我们只是为了说明这个问题。 
---

## instanceof
> instanceof 是 Java 的一个二元操作符，类似于 ==，>，< 等操作符。

> instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。

```
public class Main {
    public static void main(String[] args) {
        Object testObject = new ArrayList();
        displayObjectClass(testObject);
    }
    public static void displayObjectClass(Object o) {
        if (o instanceof Vector)
            System.out.println("对象是 java.util.Vector 类的实例");
        else if (o instanceof ArrayList)
            System.out.println("对象是 java.util.ArrayList 类的实例");
        else
            System.out.println("对象是 " + o.getClass() + " 类的实例");
    }
}
```
---

## native
> native（即 JNI，Java Native Interface），凡是一种语言，都希望是纯。比如解决某一个方案都喜欢就单单这个语言来写即可。Java 平台有个用户和本地 C 代码进行互操作的 API，称为 Java Native Interface (Java本地接口)。 

<div align="center"> <img src="assets/java-native-interface.png" width="500"/></div><br/>

参考资料：
- [java中native的用法](https://www.cnblogs.com/b3051/p/7484501.html)
---

## return
- return 从当前的方法中退出，返回到该调用的方法的语句处，继续执行。
- return 返回一个值给调用该方法的语句，返回值的数据类型必须与方法的声明中的返回值的类型一致。
- return 后面也可以不带参数，不带参数就是返回空，其实主要目的就是用于想中断函数执行，返回调用函数处。

特别注意：返回值为 void 的方法，从某个判断中跳出，必须用 return。

---

## strictfp
> strictfp，即 **strict float point** (精确浮点)。 

```
strictfp 关键字可应用于类、接口或方法。使用 strictfp 关键字声明一个方法时，该方法中所有的 float 和 double 表达式都严格遵守 FP-strict 的限制，符合 IEEE-754 规范。当对一个类或接口使用 strictfp 关键字时，该类中的所有代码，包括嵌套类型中的初始设定值和代码，都将严格地进行计算。严格约束意味着所有表达式的结果都必须是 IEEE 754 算法对操作数预期的结果，以单精度和双精度格式表示。
```
提示：如果你想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果不一致的话，可以用关键字strictfp.

---
## static
> ### 静态特点
> static可以修饰成员变量 和 成员方法。

- 1. static成员是属于类的，是被类的所有对象所共享的。
- 2. static成员随着类的加载而加载，优先于对象存在。

static调用：类名.静态属性、对象.静态属性（不提倡）。

> ### 静态变量
> 静态变量在内存中只存在一份，只在类初始化时赋值一次。

- 静态变量：类所有的实例都共享静态变量，可以直接通过类名来访问它。
- 实例变量：每创建一个实例就会产生一个实例变量，它与该实例同生共死。
```
public class A {
    private int x;        // 实例变量
    public static int y;  // 静态变量
}
```
注意：不能在成员函数内部定义static变量。

> ### 静态方法
> 静态方法在类加载的时候就存在了，它不依赖于任何实例，所以静态方法必须有实现，也就是说它不能是抽象方法（abstract）。

> ### 静态语句块
> 静态语句块在类初始化时运行一次。

> ### 静态内部类
> 内部类的一种，静态内部类不依赖外部类，且不能访问外部类的非静态的变量和方法。

> ### 静态导包
``` 
import static com.xxx.ClassName.* 
```
注意：在使用静态变量和方法时不用再指明 ClassName，从而简化代码，但可读性大大降低。

> ### 变量赋值顺序
> **静态变量的赋值** 和 **静态语句块** 的运行优先于 **实例变量的赋值** 和 **普通语句块** 的运行，**静态变量的赋值** 和 **静态语句块** 的运行哪个先执行取决于它们在代码中的顺序。

```
public static String staticField = "静态变量";
```
```
static {
    System.out.println("静态语句块");
}
```
```
public String field = "实例变量";
```
```
{
    System.out.println("普通语句块");
}
```
```
// 最后才运行构造函数
public InitialOrderTest() {
    System.out.println("构造函数");
}
```
```
父类（静态变量、静态语句块）
子类（静态变量、静态语句块）
父类（实例变量、普通语句块）
父类（构造函数）
子类（实例变量、普通语句块）
子类（构造函数）
```

> ### 静态总结　

- 1. 静态能直接调用静态。
- 2. 静态不能调用非静态（如果要调用非静态：先创建对象，再调用非静态成员）。
- 3. 静态成员方法，只能访问静态的成员（非静态方法，能够直接调用所有成员）。
```
Person p = new Person();
p.eat();
```
- 1. 加载Person这个类进入方法区，Person类中的静态成员也进入方法区等待被调用。
- 2. 创建Person对象p，普通成员变量随着对象进入堆内存，等待被调用。
- 3. 通过对象调用普通成员方法。

> ### 什么时候把成员定义成static？

重点 | 描述
---|---
成员变量 | 当所有对象的某个属性值都一样时，这个成员变量可以定义为静态的。
成员方法 | 工具方法。
---

## transient
> 我们都知道一个对象只要实现了 Serilizable 接口，这个对象就可以被序列化，Java 的这种序列化模式为开发者提供了很多便利，我们可以不必关心具体序列化的过程，只要这个类实现了 Serilizable 接口，这个类的所有属性和方法都会自动序列化。

> 然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，而其他属性不需要被序列化，打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），为了安全起见，不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，这些信息对应的变量就可以加上 **transient** 关键字。换句话说，这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。

总之，Java 的 transient 关键字为我们提供了便利，你只需要实现 Serilizable 接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。

参考资料：
- [Java transient关键字使用小记 ](https://www.cnblogs.com/lanxuezaipiao/p/3369962.html)
---

## volatile
> 每次都读错，美式发音：volatile /'vɑlətl/ adj. [化学] 挥发性的；不稳定的；爆炸性的；反复无常的 

> volatile 是一个**类型修饰符**（type specifier），它是被设计用来修饰被不同线程访问和修改的变量。在使用 volatile 修饰成员变量后，所有线程在任何时间所看到变量的值都是相同的。此外，使用 volatile 会组织编译器对代码的优化，因此会降低程序的执行效率。所以，除非迫不得已，否则，能不使用 volatile 就尽量不要使用 volatile。

- 每次访问变量时，总是获取主内存的最新值
- 每次修改变量后，立刻写回到主内存中

 <div align="center"> <img src="assets/java-volatile.png" width="400"/></div>

参考资料：
- [理解java Volatile 关键字 - 个人文章 - SegmentFault 思否](https://segmentfault.com/a/1190000015087945)
---














































































