/*An Implentation of Perlin Noise*/
package procedualGeneration

import java.util.*

public class PerlinNoise(){
    //Hash look up table defined in Perlin's Algorithm
    private val permutations:IntArray = intArrayOf(151,160,137,91,90,15,
            131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,142,8,99,37,240,21,10,23,
            190, 6,148,247,120,234,75,0,26,197,62,94,252,219,203,117,35,11,32,57,177,33,
            88,237,149,56,87,174,20,125,136,171,168, 68,175,74,165,71,134,139,48,27,166,
            77,146,158,231,83,111,229,122,60,211,133,230,220,105,92,41,55,46,245,40,244,
            102,143,54, 65,25,63,161, 1,216,80,73,209,76,132,187,208, 89,18,169,200,196,
            135,130,116,188,159,86,164,100,109,198,173,186, 3,64,52,217,226,250,124,123,
            5,202,38,147,118,126,255,82,85,212,207,206,59,227,47,16,58,17,182,189,28,42,
            223,183,170,213,119,248,152, 2,44,154,163, 70,221,153,101,155,167, 43,172,9,
            129,22,39,253, 19,98,108,110,79,113,224,232,178,185, 112,104,218,246,97,228,
            251,34,242,193,238,210,144,12,191,179,162,241, 81,51,145,235,249,14,239,107,
            49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,127, 4,150,254,
            138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,156,180)

    private var doublePermutation:IntArray = IntArray(512)
    init{
        for(i in 0..permutations.size-1){
            doublePermutation[i] = permutations[i]
            doublePermutation[256+i] = permutations[i]

        }
    }

    private fun fade(x:Double): Double{
        return x * x * x *(x * (x * 6-15) + 10)
    }

    private fun lerp(a:Double, b:Double, x:Double):Double{
        return a + x * (b-a)
    }

    private fun grad(hash:Int, x:Double, y:Double): Double{
        val hashBitString:String = Integer.toBinaryString(hash)
        var output:Double = if(hashBitString.last() == '1') x else -x
        if(hashBitString.length < 2){
            output += if(hashBitString.last() == '1') x else -x
        }else{
            output += if(hashBitString.get(hashBitString.length-2) == '1') y else -y
        }
        return output
    }

    fun noise(x:Double, y:Double): Double {

        val xMod:Int = x.toInt() % 255
        val yMod:Int = y.toInt() %255

        val xRemainder:Double = x - x.toInt()
        val yRemainder:Double = y - y.toInt()

        val xFade:Double = fade(xRemainder)
        val yFade:Double = fade(yRemainder)

        //Hash values correspond to the vertices of a square
        val bottomLeft:Int = doublePermutation[doublePermutation[xMod] + yMod]
        val topLeft:Int = doublePermutation[doublePermutation[xMod] + yMod +1]
        val topRight:Int = doublePermutation[doublePermutation[xMod +1] + yMod +1]
        val bottomRight:Int = doublePermutation[doublePermutation[xMod+1] + yMod]

        /*
        * First finds the dot product between the pseudorandom gradVector and the distance
        * vector between the verticies and the original co-ord. Then interpolates between
        * the dot products*/
        var interBottom:Double
        var interTop:Double
        var interFinal:Double

        //Interpolating between bottom points
        var temp1:Double = grad(bottomLeft, xRemainder, yRemainder)
        var temp2:Double = grad(bottomRight, xRemainder-1, yRemainder)
        interBottom = lerp(temp1, temp2, xFade)

        //Interpolating between top points
        temp1 = grad(topLeft, xRemainder, yRemainder-1)
        temp2 = grad(topRight, xRemainder-1, yRemainder-1)
        interTop = lerp(temp1, temp2, xFade)

        //Interpolating between results and bound it between 0 and 1
        interFinal = lerp(interBottom, interTop, yFade)
        return (interFinal+1)/2

    }

}