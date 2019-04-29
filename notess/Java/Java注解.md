## 4. 注解

### 什么是注解

　　Annontation 是 Java5 开始引入的新特征，中文名称叫注解。它提供了一种安全的类似注释的机制，用来**将任何的信息或元数据（metadata）与程序元素（类、方法、成员变量等）进行关联**。为程序的元素（类、方法、成员变量）加上更直观更明了的说明，这些说明信息是与程序的业务逻辑无关，并且供指定的工具或框架使用。Annontation 像一种修饰符一样，应用于包、类型、构造方法、方法、成员变量、参数及本地变量的声明语句中。

　　Java 注解是附加在代码中的一些元信息，用于一些工具在编译、运行时进行解析和使用，起到说明、配置的功能。注解不会也不能影响代码的实际逻辑，仅仅起到辅助性的作用。包含在 ` java.lang.annotation` 包中。

　　简单来说：注解其实就是**代码中的特殊标记**，这些标记可以**在编译、类加载、运行时被读取，并执行相对应的处理**。 



### 为什么要用注解

传统的方式，我们是通过配置文件 `.xml` 来告诉类是如何运行的。

有了注解技术以后，我们就可以通过注解告诉类如何运行

例如：我们以前编写 Servlet 的时候，需要在 web.xml 文件配置具体的信息。我们使用了注解以后，可以直接在 Servlet 源代码上，增加注解...Servlet 就被配置到 Tomcat 上了。也就是说，注解可以给类、方法上注入信息。

明显地可以看出，这样是非常直观的，并且 Servlet 规范是推崇这种配置方式的。 



### 基本Annotation

在 java.lang 包下存在着5个基本的 Annotation，重点掌握前三个。

1. @Override 重写注解
   - 如果我们使用IDE重写父类的方法，我们就可以看见它了。
   - @Override是告诉编译器要检查该方法是实现父类的，可以帮我们避免一些低级的错误。
   - 比如，我们在实现 equals() 方法的时候，把 euqals() 打错了，那么编译器就会发现该方法并不是实现父类的，与注解 @Override 冲突，于是就会给予错误。

2. @Deprecated 过时注解
   - 该注解也非常常见，Java 在设计的时候，可能觉得某些方法设计得不好，为了兼容以前的程序，是不能直接把它抛弃的，于是就设置它为过时。
   - Date对象中的 toLocalString() 就被设置成过时了
   - 当我们在程序中调用它的时候，在 IDE 上会出现一条横杠，说明该方法是过时的。

```java
@Deprecated
public String toLocaleString() {
    DateFormat formatter = DateFormat.getDateTimeInstance();
    return formatter.format(this);
}
```

3. @SuppressWarnings 抑制编译器警告注解
   - 该注解在我们写程序的时候并不是很常见，我们可以用它来让编译器不给予我们警告
   - 当我们在使用集合的时候，如果没有指定泛型，那么会提示安全检查的警告
   - 如果我们在类上添加了@SuppressWarnings这个注解，那么编译器就不会给予我们警告了 

4. @SafeVarargs Java 7“堆污染”警告
   - 什么是堆污染呢？？当把一个不是泛型的集合赋值给一个带泛型的集合的时候，这种情况就很容易发生堆污染。
   - 这个注解也是用来抑制编译器警告的注解，用的地方并不多。

5. @FunctionalInterface 用来指定该接口是函数式接口
   - 用该注解显式指定该接口是一个函数式接口。



### 自定义注解类编写规则

1. Annotation 型定义为 @interface, 所有的 Annotation 会自动继承 java.lang.Annotation 这一接口，并且不能再去继承别的类或是接口.
2. 参数成员只能用 public 或默认(default)这两个访问权修饰
3. 参数成员只能用基本类型 byte,short,char,int,long,float,double,boolean 八种基本数据类型和 String、Enum、Class、annotations 等数据类型，以及这一些类型的数组
4. 要获取类方法和字段的注解信息，必须通过 Java 的反射技术来获取 Annotation 对象，因为你除此之外没有别的获取注解对象的方法
5. 注解也可以没有定义成员, 不过这样注解就没啥用了
    PS：自定义注解需要使用到元注解



### 自定义注解实例

```java
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果名称注解
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
```

 参考资料：[注解Annotation实现原理与自定义注解例子](https://www.cnblogs.com/acm-bingzi/p/javaAnnotation.html)

