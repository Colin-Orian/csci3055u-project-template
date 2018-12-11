/* Programmer Name: Colin Orian
 *Program Description: File for image creation and saving
* */

package imageSaving

import procedualGeneration.PerlinNoise
import java.awt.image.BufferedImage
import java.awt.Graphics2D
import javax.imageio.ImageIO
import java.awt.Color
import java.io.File
import java.io.IOException


/* Generates an image using perlin noise
* @param width: The width of the image
 * @param height: The height of the image
 * @param fileName: The name of the file*/
fun genImage(width:Int,height:Int, fileFormat: String,fileName:String){
    var buffImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    noise(width, height, 1, 1, buffImage.createGraphics())
    saveImage(buffImage, fileFormat, fileName)
}
/* Draws the perlin noise onto the image
* @param width: Width of image
* @param height: The height of the image
* @param gridWidth: How wide the rectangle should be for each iteration
* @param gridHeight: How tall the rectangle should be for each iteration
* @param graphics: What you're drawing on
* */
fun noise(width:Int, height:Int, gridWidth:Int, gridHeight:Int, graphics:Graphics2D){
    val noiseGen = PerlinNoise()

    for(i in 0..(width/gridWidth)){
        for(j in 0..(height/gridHeight)){
            //The noise function needs to have a decimal
            var rgb:Double = noiseGen.noise(i.toDouble()+0.45,j.toDouble()+0.45)
            rgb *= 255.0 //Colours are bounded from 0 to 255 (inclusive)
            graphics.color = Color(rgb.toInt(), rgb.toInt(), rgb.toInt())
            graphics.drawRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight)
            graphics.fillRect(i*gridWidth,j*gridHeight, gridWidth, gridHeight)
        }
    }
}

/* Saves an image
* @param image: The image you want to save
* @param fileFormat: What file format you want to save the image as
* @param fileName: The name of the file
* */
fun saveImage(image:BufferedImage, fileFormat:String, fileName:String){
    if(fileFormat=="png" || fileFormat=="jpg" || fileFormat=="gif"){ //Is the file format valid?
        try{
            var outFile = File(fileName + "."+fileFormat)
            ImageIO.write(image, fileFormat, outFile)
        }catch(e: IOException){
            e.printStackTrace()
        }
    }else{
        error("Invalid file format! Valid formats: png, jpg, gif")
    }
}