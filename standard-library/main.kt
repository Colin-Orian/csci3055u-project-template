import kotlin.math.*

fun main (args: Array<String>){

    //Functional Program constructs
    var arrayList = ArrayList<Int>()
    arrayList.add(1)
    arrayList.add(2)
    arrayList.add(3)
    val max = arrayList.filter { num -> num < 3}.max()
    println(max)

    var grades:MutableMap<String, Int> = mutableMapOf()
    grades.put("Little Billy", 20)
    grades.put("John Cena", 100)
    var incGrades:List<Int?> =
            grades.map { it -> it.value + 1}
    println(incGrades)

    //Math Library
    println(4.sign)
    println(-4.sign)
    println(E)
    println(PI)

    var negative = -12.345f
    println(abs(negative))


}