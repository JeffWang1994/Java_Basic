# 第4章 Java基础知识
## 基本概念
1. Java有什么优点？

2. Java与C++有什么异同？
   1. Java是解释性语言，可以跨平台运行；C++不能
   2. Java是纯面向对象，没有全局变量和全局函数
   3. Java没有指针
   4. Java不支持多重继承，但是可以实现多接口
   5. Java提供垃圾自动回收

3. 为什么需要 public static void main(String[] args) 这个方法？
   作为程序主入口。static表示静态方法，即方法中的代码是存储在静态存储区的，只要类被加载后，就可以不通过实例化类来访问该方法。
   **主函数的几种正确写法:**
        public static void main(String[] args)
        public static final void main(String[] args)
        static public void main(String[] args)
        static public synchronized void main(String[] args)
   **主函数的错误写法:**
        static public abstract void main(String[] args)

4. 如何实现在main()方法执行前输出"Hello World"
   问题实际在问：main()方法是程序运行的第一个执行模块吗？
   不是！在main()方法执行前，要先执行静态块！

5. Java程序初始化的顺序是怎么样的？
   初始化顺序3大原则:
        1) 静态 > 非静态
        2) 父类 > 子类
        3) 按照成员变量的定义顺序来初始化
   执行顺序:
        父类静态变量>父类静态方法>子类静态变量>子类静态方法
        >父类非静态变量>父类非静态方法>父类构造函数>子类非静态变量>子类非静态方法>子类构造函数

6. Java中的作用域有哪些？
   public, private, protected, default
   public: 说明该成员变量或方法对所有类或对象都是可见的
   private: 说明该成员变量或方法是私有的
   protected: 说明成员变量或方法对该类自身，与它在同一包内的其他类，在其他包中的该类的子类都可见
   default: 说明该成员变量或方法只有自己和与其位于同一包内的类可见

7. 一个Java文件中是否可以定义多个类？
   可以的哟，但是只能有一个public，而且在一个文件中定义多个，在编译的时候都多个class字节码文件

8. 什么是构造函数？
   构造函数是用于在对象实例化时初始化对象的成员变量。
   1. 构造函数必须与类同名，且没有返回值
   2. 可以有多个构造函数
   3. 可以有多个或者没有参数
   4. 总是伴随new操作一起调用，不能被直接调用
   5. 不能继承，不能覆盖
   6. 子类可以通过super关键字显式调用父类的构造函数
   7. 父类和子类都没有构造函数的时候，父类会自动生成一个默认的无参数的构造函数

9. 为什么Java中有些接口没有任何方法
    接口是抽象方法定义的集合，是一种特殊的抽象类。
    接口中常量值默认使用public static final修饰
    没有任何方法声明的接口叫标识接口。可以使用instanceof来判断实例对象的类型是否实现了一个给定的标识接口。

10. Java中的clone方法有什么作用？
    Java中没有指针。但实质上每个new语句返回的都是一个指针的引用。
    **Java在处理基本数据类型(int, char, double等)时，都是采用按值传递的方式执行，除此之外的其他类型都是按引用传递(传递的是对象的一个引用)的方式执行。**
    如何实现类的深复制？(clone)
        1. 实现clone的类首先要继承Cloneable接口。这是一个标识接口
        2. 在类中重写clone()方法
        3. 在clone方法中调用super.clone()
        4. 把浅复制的引用指向原型对象新的克隆体
   **浅复制和深复制的区别**
   Shallow Copy: 被复制对象的所有变量都含有与原来对象相同的值，而所有对其他对象的引用仍然指向原来的对象。
   Deep Copy: 被复制对象的所有变量都含有与原来对象相同的值，除去那些引用其他对象的变量。

11. 什么是反射机制？
    反射机制的功能是：
    1. 得到一个对象所属的类
    2. 获取一个类的所有成员变量和方法
    3. 在运行时，调用对象的方法
    **如何使用反射机制动态地创建对象？**
        Class c = Class.forName("Sub");
        Base b = (Base)c.newInstance();
    **Java创建对象的方法有哪些？**
        通过new语句实例化一个对象
        通过反射机制动态创建对象
        通过clone()创建一个对象
        通过反序列化的方式创建对象

12. package有什么几把用？
    1. 提供多层命名空间，解决命名冲突
    2. 对类按功能进行分类，使项目的组织更加清晰

13. 如何实现类似于C语言中函数指针的功能
    1. 定义一个接口
    2. 在接口中声明要调用的方法
    3. 实现该接口
    4. 把这个实现类的一个对象作为参数传递给调用程序
    5. 调用程序通过这个参数来调用指定的函数，来实现回调函数的功能

## 面向对象技术
1. 面向对象和面向过程有什么区别？

2. 面向对象有哪些特征？
   1. 抽象
   2. 继承
   3. 封装
   4. 多态

3. 面向对象的开发方式有什么优点？

4. 什么是继承？
   通过继承，子类可以使用父类中的一些成员变量与方法，从而能够提高代码的复用性。
        class 子类名 extends 父类名
   继承的特性：
        1. Java不支持多重继承
        2. 子类只能继承父类非私有成员变量和方法
        3. 当子类中定义的成员变量和父类中定义的成员变量同名时，子类中的成员变量会覆盖父类的成员变量。
        4. 当子类中的方法与父类中的方法有相同的函数签名时，子类会覆盖父类。

5. 组合和继承有什么区别？
   组合是指在新类里面创建原有类的对象重复利用已有类的功能。
   组合是“has-a”关系
   继承是“is-a”关系

6. 多态的实现机制是什么？
   多态的两种表现方式：方法的重载，方法的覆盖
   **Java提供了哪两种用于多态的机制？**
        编译时的多态：通过方法的重载实现。
        运行时的多态：通过方法的覆盖实现。

7. 重载和覆盖有什么区别？
   使用重载需要注意3点：
        1. 重载通过不同的方法参数来区分
        2. 不能通过方法的访问权限，返回值类型和抛出异常类型
        3. 如果基类方法的访问权限是private，那么就不能在派生类对其重载
   使用覆盖需要注意4点：
        1. 覆盖类需要相同函数名和参数
        2. 返回值相同
        3. 抛出异常相同
        4. 被覆盖的方法不能式private，否则子类只定义了一个方法，不能进行覆盖
   重载和覆盖的区别：
        1. 重载是水平关系，在同一个类内的不同方法；覆盖是垂直关系，在父类和子类的不同方法；
        2. 覆盖要求参数相同，重载要求参数不同
        3. 覆盖，调用方法体是根据对象类型；重载，调用方法体是根据参数数量和类型。

8. 抽象类和接口有什么异同？
   相同点：
        1. 抽象类和接口都不能被实例化
        2. 子类必须实现类所有抽象方法或接口才能被实例化
   不同点：
        1. 接口只有定义，方法不能在接口中定义；抽象类既有定义又有实现，方法可以在抽象类内实现
        2. 接口需要实现(implements)，抽象类只能继承(extends)
        3. 接口强调特定功能的实现，其设计理念是"has-a"关系，抽象类是"is-a"关系
        4. 接口中的成员变量默认是public static final，而且必须赋初值。成员方法必须是public, abstract
        5. 抽象类的成员变量默认是default, 抽象方法不能是private, static,synchronized, native，
        6. 抽象类的抽象方法不能有方法体，不能有大括号！

9. 内部类有哪些？
    内部类就是套在外部类内部的内部类。主要有：静态内部类(static inner class)，成员内部类(member inner class)，局部内部类(local inner class)，匿名内部类(anonymous inner class)。
    class outerClass{
            static class innerClass{}  //静态内部类
            class innerClass{}   //成员内部类(普通内部类)
            public void memberFunction(){
                    class innerClass{}   //局部内部类
            }
    }
    public class MyFrame extends Frame{
            public MyFrame(){
                    addWindowListener(new WindowAdapter(){   //匿名内部类
                            public void windowClosing(WindowEvent e){
                                    dispose();
                                    System.exit(0);
                            }
                    })
            }
    }
    1. 静态内部类只能调用外部类的静态成员和静态方法，同时它不依赖外部类实例而被实例化。
    2. 成员内部类可以自由地调用外部类的属性和方法，但它自己不能有静态成员。
    3. 匿名内部类不能有构造函数，不能定义静态成员，方法和类，不能是public，protected，private，static。只能创建匿名内部类的一个实例，一定要在new的后面，。。。一堆条件，记不住，面试的时候随缘吧

10. 如何获取父类的类名？
    获取本类的类名: this.getClass().getName(); super.getClass().getName()
    获取父类的类名: this.getClass().getSuperclass().getName()

11. this和super有什么区别？
    
## 关键字
1. 变量命名有哪些规则？
   1. 不能是保留字，int，char，double等等
   2. 不能有空格
   3. 不能以数字开头
   4. *,.不能作为标识符

2. break, continue, return 有什么区别？
   break：用于直接强行跳出当前循环，不再执行剩余代码。
   continue：用于停止当次循环，回到循环起始处，进入下一次循环操作。
   return：用于标识从一个方法返回，可以使程序控制返回到调用该方法的地方。
   **如何使用break跳出多重循环？**
        public class Break{
                public static void main(String[] args){
                        out:
                        for(int i=0; i<5; i++){
                                for(int j=0; j<5; j++){
                                        if(j>=2){
                                                break out;
                                                System.out.println(j);
                                        }
                                }
                                System.out.println("break");
                        }
                }
        }

3. final, finally和finalize有什么区别？
   1. final用于声明属性不可变，方法不可覆盖，类不可被继承。
   2. finally作为异常处理的一部分，只能用于try/catch语句中，并且附带一个语句块，表示这段语句最终一定被执行，经常被用在需要释放资源的情况下。
   3. finalize是Object类的一个方法，在垃圾回收器执行时会调用被回收对象的finalize()方法，可以覆盖此方法来实现对其他资源的回收，例如关闭文件等。需要注意的是，一旦垃圾回收器准备好释放对象占用的空间，将首先调用其finalize()方法，并且在下一次垃圾回收动作发生时，才会真正回收对象占用的垃圾。

4. assert有什么作用？
   断言(assert)作为一种软件调试方法，提供了一种在代码中进行正确性检查的机制。
   public class Test{
           public static void main(String[] args){
                   assert 1+1==2;
                   System.out.println("assert1 ok");
                   assert 1+1==3 : "assert failed, exit."
                   System.out.println("assert2 ok");
           }
   }
   在执行了java -ea Test时，会输出Exception in thread "main" Java.lang.AssertionError: assert failed exit at Test.main(Test.Java:5)

5. static关键字有哪些作用？
   为某特定数据类型或对象分配单一的存储空间，而与创建对象的个数无关。
   实现某个方法或属性与类而不是对象关联在一起。
   1. static成员变量
   2. static成员方法
   3. static代码块
   4. static内部类
   **static和final一起使用，表示什么？**
        对于变量，表示全局变量，且不能改变；对于方法就是全局方法，且不能覆盖

6. 使用switch时有哪些注意事项？
   switch(expr)中expr只能是一个枚举常量或一个整数表达式。
   **注意：long, float, double类型不能隐式转化为int类型，所以不能用于switch的expr。但是byte, short, char类型可以。**
   **注意：case后接的数值必须是常量数值，或常量表达式，不能是a-1这类的**
   **注意：对String类型的支持是源于Hash，String会转化为HashCode。**

7. volatile有什么作用？
   volatile是一个类型修饰符(type specifier)，是被设计用来修饰被不同线程访问和修改的变量。
   被volatile类型定义的变量，系统每次用到它时都是直接从对应的内存当中提取，而不会利用缓存。
   public class MyThread implements Runnable{
           private volatile Boolean flag;
           public void stop(){
                   flag=false;
           }
           public void run(){
                   while(flag)
                   ;   // do something
           }
   }
   上述示例是用来停止线程的最常用的一种方法。

8. instanceof有什么作用？
   instanceof是Java语言中的一个二元运算符，它的作用是判断一个引用类型的变量所指向的对象是否是一个类(或接口，抽象类，父类)的实例，即它左边的对象是否是它右边的类的实例该运算符返回boolean类型的数据
   常用的用法：result=object instanceof class

9. strictfp有什么作用？
    strictfp是strict float point的缩写，指的是精确浮点，用来确保浮点数运算的准确度。
    public strictfp class Test{
            public static void testStrictfp(){
                    float f = 0.12365f;
                    double d = 0.03496421d;
                    double sum = f + d;
                    System.out.println(sum);
            }
            public static void main(String[] args){
                    testStrictfp();
            }
    }

## 基本数据类型与运算
1. Java提供了哪些基本数据类型？
   8种：byte(8 bit), short(16 bit), int(32 bit), long(64 bit), float(32 bit), double(64 bit), char(16 bit), boolean(1 bit)
   **在Java语句中null值是什么？在内存中null是什么？**
        null不是一个合法的Object实例， 所以编译器并没有为