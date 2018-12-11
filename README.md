# _Kotlin Final Project_

- _Colin Orian_
- colin.orian@uoit.net

## About the language

> Like Clojure, Kotlin is built off of the JVM. Kotlin has access to 100% of java libraries.However, Kotlin can also generate JavaScript instead of uing the JVM.
>
> - Kotlin is a fairly new programming language, the first public release came out in January 2012. The developers intended for the language to utilize tools from other languages while still making it easy to use. A major update for Kotlin came out in September 2018 and included stable support for coroutines.

 >*Interesting Features*
 >- Kotlin supports tail recursion and is able to optimize recursion out at compile time
 >- Kotlin has data classes and are used for classes that only contain data. It will automatically generate methods, like getters, for you. Compared to Java, data classes are much faster to write since data classes remove significant amounts of bolier plate code
 >- Functions are treated as classes. This means that functions can be assigned to variables and passed into other functions. This makes functional programming easier in kotlin compared to Java.

## About the syntax

*Hello World*
```kotlin
fun main(args: Array<String>){
  println("Hello World")
}
```

*Factorial using tail recursion*

```kotlin
tailrec fun fact(n:Int): Int{
  if(n == 0){
    return 1
  }else{
    return n*fact(n-1)
  }
}
```
*Switch Statements*
```kotlin
  val x:Int = 4
  when(x){
    1 -> println("x is 1")
    2 -> println("x is 2")
    else -> {
      println("x is not 1 or 2")
    }
  }
```
## About the tools

> The compiler tools needed depends on what you're targeting.
>- JVM: Kotlin will need the Java Virtual Machine to compile
>- JavaScript: Can use Gradle, Intellij, Maven, or the Command Line (the command line will need kotlinc-js installed)
>- Native: The compiler can be downloaded from GitHub

## About the standard library

> _Give some examples of the functions and data structures
> offered by the standard library_.
*ArrayList*

```kotlin
var arrayList = ArrayList<Int>()
arrayList.add(1)
arrayList.add(2)
arrayList.add(3)
val max = arrayList.filter { num -> num < 3}.max()
```

*Map*
```kotlin
var grades:MutableMap<String, Int> = mutableMapOf()
grades.put("Little Billy", 20)
grades.put("John Cena", 100)

var incGrades:List<Int?> =
  grades.map { it -> it.value + 1}
```

## About open source library

> _Kotlinx.coroutines is a library that is used to create coroutines. Coroutines are a form of concurrent programing. However, coroutines run on the same thread instead of multithreading which creates multiple threads. Coroutines has advantages over multithreading. Coroutines use less memory. In an example on the Kotlin website, 100 000 coroutines were created and it ran. The developers suggest that doing the same but with threads would result in an OutofMemoryError._

# Analysis of the language

>Kotlin supports functional programming and OOP. Although Kotlin does support functional programming by allowing functions to be passed into and out of functions, I find functional programming is easier in a more pure functional programming language, such as Clojure.

>Kotlin doesn't support meta programming directly. However, meta programming can be achieved through the functional programming aspects of Kotlin.

>Kotlin is fairly strict about symbol resolution compared to languages like Clojure (for example you can't change what a ```for ``` keyword does). However, Kotlin allows for operator overloading and can overloading operators like indexing. Kotlin has support for closure. Varity of functions and classes have closures. They are able to access and modify variables in outer closures.

>Kotlin does have some scoping rules. The ```run``` keyword will create a new scope and variable created in that scope can't be seen outside of the scope. Inside the new scope, ```this``` keyword will refer to the scope. The ```let``` keyword is the same to ```run``` but ```this``` will refer to the class that the scope is in. The ```it``` keyword will refer to the scope.

>Functional programming constructs are avaliable through kotlin.collections. It contains a varity of ways to store data like ```ArrayList``` and ```Map```. The different containers have functional programming functions such as ```filter()``` and ```map()```.

>Kotlin is statically typed

> Strengths
>- Runs on the JVM and has access to Java libraries
>- Removes significant amounts of boiler plate code compared to Java
>- Less chances of Null Pointer Exceptions
>- Allows for both Functional Programming and OOP, unlike Java which is designed for OOP.

> Weaknesses
>- Doesn't have namespaces.
>- In my opinion, Kotlin's functional programming constructs are significantly more confusing than languages like Clojure.
>- You can't have static methods or variables
