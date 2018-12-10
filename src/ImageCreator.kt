package imageSaving

import java.awt.image.BufferedImage
import java.awt.Graphics2D
import javax.imageio.ImageIO
import java.awt.Color
import java.io.File
import java.io.IOException
import java.util.Random

public fun genImage(width:Int,height:Int, fileName:String){
    var buffImage:BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    randomRGB(width, height, 10, 10, buffImage.createGraphics())
    saveImage(buffImage, "png", "Test")
}

private fun randomRGB(width:Int,height:Int, gridWidth:Int, gridHeight:Int, graphics:Graphics2D){
    graphics.color = Color(0,0,0)
    graphics.drawRect(0,0, width, height)
    var random:Random = Random()

    for(i in 0..(width / gridWidth)){
        for(j in 0..(height / gridHeight)){
            var r:Int = random.nextInt(256)
            var g:Int = random.nextInt(256)
            var b:Int = random.nextInt(256)
            graphics.color = Color(r,g,b)
            graphics.drawRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight)
            graphics.fillRect(i*gridWidth, j*gridHeight, gridWidth, gridHeight)
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