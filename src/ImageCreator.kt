package imageSaving

import procedualGeneration.PerlinNoise
import java.awt.image.BufferedImage
import java.awt.Graphics2D
import javax.imageio.ImageIO
import java.awt.Color
import java.io.File
import java.io.IOException
import java.util.Random

public fun genImage(width:Int,height:Int, fileName:String){
    var buffImage:BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    noise(width, height, 1, 1, buffImage.createGraphics())
    saveImage(buffImage, "png", "noise")
}

private fun noise(width:Int, height:Int, gridWidth:Int, gridHeight:Int, graphics:Graphics2D){
    val noiseGen:PerlinNoise = PerlinNoise()
    for(i in 0..(width/gridWidth)){
        for(j in 0..(height/gridHeight)){
            var rgb:Double = noiseGen.noise(i.toDouble()+0.45,j.toDouble()+0.45)
            rgb *= 255.0
            graphics.color = Color(rgb.toInt(), rgb.toInt(), rgb.toInt())
            graphics.drawRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight)
            graphics.fillRect(i*gridWidth,j*gridHeight, gridWidth, gridHeight)
        }
    }
}

private fun saveImage(image:BufferedImage, fileFormat:String, fileName:String){
    if(fileFormat=="png" || fileFormat=="jpg" || fileFormat=="gif"){
        try{
            var outFile:File = File(fileName + "."+fileFormat)
            ImageIO.write(image, fileFormat, outFile)
        }catch(e: IOException){
            e.printStackTrace()
        }
    }else{
        error("Invalid file format! Valid formats: png, jpg, gif")
    }
}