## lecture 1. Java 8 New Features

1. Lambda Expressions
2. Functional Interfaces
3. Default methods in interfaces
4. Static methods in interfaces
5. Predicate (predefined functional interface)
6. Function (predefined functional interface)
7. Consumer (predefined function interface)
8. double colon (::) for Method Reference & Constructor Reference by using double colon
9. Stream API (To perform bulk operation on collections). more readable code
10. Date & Time API introduced by joda.org. also known as Joda API

## purpose of these features

- To simplify programming. with less code do many things.
- provide more
- java is object oriented programming but we have n number of benefits with functional and procedural programming also. to get those benefits lamda expressions is introduced.
- still java is OOP just we will getting benefits of Functional programming.
- To get benefits of `multicore processors`,`parallel programming` or `parallel processing` came into picture in java 8

## lecture 2.Lambda Expressions

- LISP is first programming language which uses lambda expressions
- other language also use this C, C++, C-Sharp, SCALA, Ruby
- Java is the last one start using it.

### benefits of using lambda expression

1. to enable functional programming benefits in java.
2. with less code we can meet our requirements. to write more readable, maintainable & concise code
3. To use APIs very easily & effectively.
4. to enable `parallel processing` lambda expression can be used.

## lecture 3. How to write Lambda expressions part - 1

in single line `lambda expression` is an `anonymous function`. anonymous function is a`nameless function`.

- not having a name.
- not having modifiers.
- not having any return type.

### Example 1

write lambda expression which prints `Hello world`.

so normal java method is like this below
````
public void m1()
{
System.out.println('Hello World');
}
````
so when we apply the above rules of lambda expression and add an arrow in between it become.

````
() -> {
System.out.println('Hello World');
}
````
### Example 2

we have to provide 2 int value and lambda expression either return or print its sum.

so normal java method would be
````
public void add(int a, int b)
{
System.out.println(a+b);
}
````
with lambda expression
````
(int a, int b) -> {
System.out.println(a+b);
}
````
### Example 3

we have to provide a string and lambda expression will return its length.

so normal java method would be
````
public int add(String s)
{
return s.length();
}
````
with lambda expression remove modifier, return type, method name
````
(String s) -> {
return s.length();
}
````
## lecture 4 How to write lambda expressions part 2

if the body of lambda expression contain only one statement than `{}` are optional. we can remove it.

### Example 1

This lambda expression 
````
() -> {
System.out.println('Hello World');
}
````
can be simplified as below
````
() -> System.out.println('Hello World');
````

### Example 2

This lambda expression
````
(int a, int b) -> {
System.out.println(a+b);
}
````
can be simplified as below
````
(int a, int b) -> System.out.println(a+b);
````
we can simplify this further. sometime based on the context compiler can guess the types of input here we have `int` for example. This is called `Type Inference`.
so we can remove the types if compiler can guess and get the below simplified version
````
(a,b) -> System.out.println(a+b);
````
### Example 3

This lambda expression
````
(String s) -> {
return s.length();
}
````
can be simplified as below
````
(String s) -> return s.length();
````
we can simplify this further. sometime based on the context compiler can guess the types of input here we have `String` for example. This is called `Type Inference`.
so we can remove the types if compiler can guess and get the below simplified version
````
(s) -> return s.length();
````
also we are not required to write the `return` expression. so we can further simplified as
````
(s) -> s.length();
````
also we can simplified it further, if we have only one input we can remove the parenthesis `()`
````
s -> s.length();
````
so the biggest advantage of lambda expression is that the code become more concise, and readable

## lecture 5 Functional Interface

once I wrote the lambda expression, we have to call the lambda expression also same as method based on our requirements. for that we need to understand `Function Interface`
concept.

`Runnable` contains only one `run()` method,
`Callable` contains only one `call()` method,
`ActionListener` contains only one `actionPerformed()` method
`Comparable` contains only `compareTo()` method

The above interfaces are all `Functional Interface`.

### what is a Functional Interface

if an interface contain `only one abstract method` it is called `Functional Interface` or `Single Abstract Method (SAM)`.

- in functional interface we can take any number of default methods
- in function interfaces we can take any number of static methods
- abstract method must be only one in function interfaces.

### Example

example of functional interface
````
interface FunctionalInterf
{
public void m1(); // This by default is abstract method must be only one in Functional Interface
default void m2() // we can take any number of these
{ 

}
public static void m3() // we can take any number of these
{
}
}
````
example of normal interface because we have 2 `abstract methods` in it.
````
interface NormalInterf
{
public void m1();
public void m2();
}
````
### purpose of Functional Interface

Functional interface is used to invoke or to call the `lambda methods`

## lecture 6 @FunctionalInterface Annotation

in java 1.8 to specify explicity that it is a functional interface an annotation is introduced `@FunctionalInterface`. so when we use this if we are making any 
mistake the compiler will use this information and give error if we are doing any mistake.

### Example

compiler will be happy for the below one.
````
@FunctionalInterface
interface FunctionalInter
{
    public void m1();
    default void m2(){};
    public static void m3(){};
}
````
for the below one compiler will not be happy it will give `CE: unexpected @FunctionalInterface annotation, multiple non-overriding abstract methods present in interface NormalInterf`
````
@FunctionalInterface
interface NormalInterf
{
public void m1();
public void m2();
}
````
for the below one compiler will not be happy it will give `CE: unexpected @FunctionalInterface annotation, no abstract method found in interface Interf1`
````
@FunctionalInterface
interface Interf1
{
}
````
## lecture 7 @FunctionalInterface Annotation wrt Inheritance

### case 1 

if an interface extends Functional Interface and child interface does not contain any abstract method, then child interface is always Functional interface

### Example perfectly valid scenario
````
@FunctionalInterface
interface p
{
public void m1();
}

@FunctionalInterface
interface c extends p
{
}
````
### Case 2

in the child interface, we can define exactly same parent interface abstract method is perfectly valid

````
@FunctionalInterface
interface p
{
public void m1();
}

@FunctionalInterface
interface c extends p
{
public void m1();
}
````
### Case 3

in the child interface, we can't define any new abstract methods otherwise we will get `CE: unexpected @FunctionalInterface annotation, multiple non-overriding abstract methods present in interface c`

````
@FunctionalInterface
interface p
{
public void m1();
}

@FunctionalInterface
interface c extends p
{
public void m2();
}
````
### Case 4

if child interface is normal interface not a Functional interface than it is valid

````
@FunctionalInterface
interface p
{
public void m1();
}

interface c extends p
{
public void m2();
}
````
## lecture 8. Invoking Lambda Expression By using Functional Interface example-1

## Setting path for java binary executables

check this video

`https://www.youtube.com/watch?v=VOqfsDdalI8`

write in terminal
````
set path=C:\program Files\java\jdk-17\bin
````
in my case in `envirnoment variable` I have a variable `java_home` which is equal to `C:\program Files\java\jdk-17`

First we will write an example without lambda expression.

### without lambda expression

