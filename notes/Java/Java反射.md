## 3. 反射

### 先看一个知乎回答

　　首先看一个在知乎上的优秀回答吧：

　　反射是什么呢？当我们的程序在运行时，需要动态的加载一些类这些类可能之前用不到所以不用加载到 JVM，而是在运行时根据需要才加载，这样的好处对于服务器来说不言而喻。

　　举个例子我们的项目底层有时是用 mysql，有时用 oracle，需要动态地根据实际情况加载驱动类，这个时候反射就有用了，假设 com.java.dbtest.myqlConnection，com.java.dbtest.oracleConnection 这两个类我们要用，这时候我们的程序就写得比较动态化，通过 Class tc = Class.forName("com.java.dbtest.TestConnection"); 通过类的全类名让 JVM 在服务器中找到并加载这个类，而如果是 Oracle 则传入的参数就变成另一个了。这时候就可以看到反射的好处了，这个动态性就体现出 Java 的特性了！

　　举多个例子，大家如果接触过 spring，会发现当你配置各种各样的 bean 时，是以配置文件的形式配置的，你需要用到哪些 bean 就配哪些，spring 容器就会根据你的需求去动态加载，你的程序就能健壮地运行。



### 什么是反射

　　反射 (Reflection) 是 Java 程序开发语言的特征之一，它允许运行中的 Java 程序获取自身的信息，并且可以操作类或对象的内部属性。通过 Class 获取 class 信息称之为反射（Reflection）

　　简而言之，通过反射，我们可以在运行时获得程序或程序集中每一个类型的成员和成员的信息。

　　程序中一般的对象的类型都是在编译期就确定下来的，而 Java 反射机制可以动态地创建对象并调用其属性，这样的对象的类型在编译期是未知的。所以我们可以通过反射机制直接创建对象，即使这个对象的类型在编译期是未知的。

　　反射的核心是 JVM 在运行时才动态加载类或调用方法/访问属性，它不需要事先（写代码的时候或编译期）知道运行对象是谁。

　　Java 反射框架主要提供以下功能：

　　1. 在运行时判断任意一个对象所属的类

　　2. 在运行时构造任意一个类的对象

　　3. 在运行时判断任意一个类所具有的成员变量和方法（通过反射甚至可以调用 private 方法）

　　4. 在运行时调用任意一个对象的方法

　　**重点**：是运行时而不是编译时



### 主要用途

　　很多人都认为反射在实际的 Java 开发应用中并不广泛，其实不然。

当我们在使用 IDE （如Eclipse，IDEA）时，当我们输入一个对象或类并想调用它的属性或方法时，一按点号，编译器就会自动列出它的属性或方法，这里就会用到反射。

　　**反射最重要的用途就是开发各种通用框架**

　　很多框架（比如 Spring ）都是配置化的（比如通过 XML 文件配置 JavaBean,Action 之类的），为了保证框架的通用性，它们可能需要根据配置文件加载不同的对象或类，调用不同的方法，这个时候就必须用到反射——运行时动态加载需要加载的对象。

　　对与框架开发人员来说，反射虽小但作用非常大，它是各种容器实现的核心。而对于一般的开发者来说，不深入框架开发则用反射用的就会少一点，不过了解一下框架的底层机制有助于丰富自己的编程思想，也是很有益的。

### 获得Class对象

1. 调用运行时类本身的 `.class` 属性

```java
Class clazz1 = Person.class;
System.out.println(clazz1.getName());
```

2. 通过运行时类的对象获取 `getClass();`

```java
Person p = new Person();
Class clazz3 = p.getClass();
System.out.println(clazz3.getName());
```
3. 使用 Class 类的 `forName` 静态方法

```java
public static Class<?> forName(String className)
// 在JDBC开发中常用此方法加载数据库驱动:
Class.forName(driver);
```
4. （了解）通过类的加载器 ClassLoader

```java
ClassLoader classLoader = this.getClass().getClassLoader();
Class clazz5 = classLoader.loadClass(className);
System.out.println(clazz5.getName());
```



参考资料：

- [深入解析Java反射（1） - 基础 | 「浮生若梦」 - sczyh30's blog](https://www.sczyh30.com/posts/Java/java-reflection-1/#%E4%B8%80%E3%80%81%E5%9B%9E%E9%A1%BE%EF%BC%9A%E4%BB%80%E4%B9%88%E6%98%AF%E5%8F%8D%E5%B0%84%EF%BC%9F)
- [学习java应该如何理解反射？ - 知乎](https://www.zhihu.com/question/24304289/answer/147529485)

