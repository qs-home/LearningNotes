| 关键字 |||||  
| :---: | :---: | :---: | :---: | :---: | 
| [abstract](#abstract) | assert | boolean | [break](#break) | byte |
| case | catch | char | class | const |
| [continue](#continue) | default | do | double | else |
| enum | [extends]（#extends） | [final](#final) | [finally](#finally) | float |
| for |	goto | if | implements | import |
| instanceof | int | interface | long	| native |
| new	| package |	private |	protected |	public |
| return | strictfp	 | short | [static](#static) |	super |
| switch | synchronized |	this |	throw |	throws |
| transient |	try |	void | volatile |	while |

## abstract
## assert
## boolean
## break
## byte

## case 
## catch 
## char 
## class 
## const

## continue 
## default 
## do 
## double	 
## else

## enum 
## extends 
## final 
> ### final特点
- 1. final可以修饰类、成员方法 和 成员变量。
- 2. final所修饰的类，不能被继承，不能有子类。
- 3. final所修饰的方法，不能被重写。
- 4. final所修饰的变量，是不可以修改的，是常量。

> ### final常量
- 声明数据为常量，可以是编译时常量，也可以是在运行时被初始化后不能被改变的常量。
- 对于基本类型，final 使数值不变。
- 对于引用类型，final 使引用不变，也就不能引用其它对象，但是被引用的对象本身是可以修改的。
```
final int x = 1;
// x = 2;  // cannot assign value to final variable 'x'
final A y = new A();
y.a = 1;
```
- 字面值常量：1、2、3
- 自定义常量：被 final 所修饰的成员变量，一旦初始化则不可改变。
```
final int NUM;    
public Dog() {
	NUM = 10;
}
```
注意：自定义常量必须初始化，可以选择显示初始化或者构造初始化

> ### final方法
- private 方法隐式地被指定为 final，如果在子类中定义的方法和基类中的一个 private 方法签名相同，此时子类的方法不是覆盖基类方法，而是在子类中定义了一个新的方法。

> ### final类
- 声明类不允许被继承。
---
## finally 
## float

## for	
## goto	
## if	
## implements 
## import 

## instanceof 
## int 
## interface 
## long 
## native 

## new	
## package 
## private	
## protected 
## public 

## return	
## strictfp	
## short	
## static	
## static
> ### static特点
- 1. static可以修饰成员变量 和 成员方法。
- 2. static成员是属于类的，是被类的所有对象所共享的。
- 3. static成员随着类的加载而加载，优先于对象存在。
- 4. static调用：类名.静态属性、对象.静态属性（不提倡）。

> ### static变量
- static变量在内存中只存在一份，只在类初始化时赋值一次。
	- 静态变量：类所有的实例都共享静态变量，可以直接通过类名来访问它。
  	- 实例变量：每创建一个实例就会产生一个实例变量，它与该实例同生共死。
```
public class A {
    private int x;        // 实例变量
    public static int y;  // 静态变量
}
```
注意：不能在成员函数内部定义static变量。

> ### static方法
- static方法在类加载的时候就存在了，它不依赖于任何实例，所以静态方法必须有实现，也就是说它不能是抽象方法（abstract）。

> ### static语句块
- static语句块在类初始化时运行一次。

> ### static内部类
- 内部类的一种，静态内部类不依赖外部类，且不能访问外部类的非静态的变量和方法。

> ### static导包
``` 
import static com.xxx.ClassName.* 
```
注意：在使用静态变量和方法时不用再指明 ClassName，从而简化代码，但可读性大大降低。

> ### 变量赋值顺序
- 静态变量的赋值和静态语句块的运行优先于实例变量的赋值和普通语句块的运行，静态变量的赋值和静态语句块的运行哪个先执行取决于它们在代码中的顺序。
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
- 父类（静态变量、静态语句块）
- 子类（静态变量、静态语句块）
- 父类（实例变量、普通语句块）
- 父类（构造函数）
- 子类（实例变量、普通语句块）
- 子类（构造函数）

> ### static总结　
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
- 成员变量：当所有对象的某个属性值都一样时，这个成员变量可以定义为静态的。
- 成员方法：工具方法。
---
## super 

## switch	
## synchronized	
## this	
## throw 
## throws

## transient
## try
## void 
## volatile 
## while














































































