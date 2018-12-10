/* It's common that classes are used solely to hold data and not have any methods
   A Data class will make Kotlin automatically generate several methods related to data:
   equals(), hashCode()
   toString()
   copy()
   componentN()
        Getters for each parameter. component1 is the first parameter.
        component2 is the second parameter, etc.
 */
data class Colour(val red:Int, val green:Int, val blue:Int, val alpha:Int)

/* Kotlin allows for nested classes.
*/
class Person(val n:String, val age:Int, val job:String){
    private val name:String = n
    inner class getters(){
        fun getName():String{return name}
    }
}


/*
* Kotlin supports delegation patterns natively.
* The Rude class implements the speak interface. However, instead of implementing
* the interface, it reuses the implementation that Yelling used.*/
interface speak{
    fun talk()
}

class Yelling(): speak{
    override fun talk() {
        println("CAN YOU HEAR ME???")
    }
}

class Rude(y: Yelling): speak by y{

}

/*
class ParamDelegate(){
    operator fun getValue(thisRef: Any?, property: KProperty<*>){

    }
}*/


/*
Kotlin has inline classes. This is useful when you're creating a wrapper for a primitive type.
The intetion of inline classes is to greatly increase performance by representing inline classes
as the primitive type. inline classes are experimental and are only avaliable in Kotlin 1.3 so this is
commented out

inline class Name(val s:String){
    fun greet(){
        println("Hello $s")
    }
}*/

fun main(args: Array<String>){
    println(fact(4))
    nullSafety()
    classExample()
    deriveExample()
}


//To reduce the chances of Null Pointer Exceptions, kotlin has built in
//null safety
fun nullSafety(){
    var value = 123
    //This can't happen. It'll have a compile error instead of potentially having a run-time error
    //value = null

    var number: Int? = 123
    number = null
    println(number)

    //Will check if number is null. They assign the -1 one to it
    val anotherNumber = number ?: -1
    println(anotherNumber)
}
//Kotlin supports tail recursion and will optimize the recursion out
tailrec fun fact(n: Int): Int {
    if(n == 0) {
        return 1
    }
    return n * fact(n-1)
}


/*
* In Kotlin, functions can be treated as objects and can do many things objects can
* (passed into functions, put into variables, etc). However, this can make functions effect
* runtime performance. Inline functions resolve the performance issue
* */

inline fun helloThere(name:String){
    println("Hello there $name!")
}
fun classExample(){
    val rgba = Colour(255, 0, 0, 0)
    println("The red colour is " + rgba.component1())


    val person = Person("Colin Orian", 20, "Student")
    helloThere(person.getters().getName())
}


fun deriveExample(){
    val rude = Rude(Yelling())
    rude.talk()


}
