# _Kotlin Final Project_

- _Colin Orian_
- colin.orian@uoit.net

## About the language

> Like Clojure, Kotlin is built off of the JVM. Kotlin has access to 100% of java libraries.However, Kotlin can also generate JavaScript instead of uing the JVM.
>
> - Kotlin is a fairly new programming language, the first public release came out in January 2012. The developers intended for the language to utilize tools from other languages while still making it easy to use.
> - Some interesting features

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

> _Organize your report according to the project description
document_
