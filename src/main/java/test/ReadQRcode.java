package test;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReadQRcode {
    public static void main(String[] args) {
        MultiFormatReader formatReader = new MultiFormatReader();
        File file = new File("E:/img.png");

        try {
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println("解析结果： " + result.toString());
            System.out.println("二维码的格式类型：" + result.getBarcodeFormat());
            System.out.println("二维码文本内容： " + result.getText() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


    }

}
