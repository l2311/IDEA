package test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class CreateQRcode {
    public static void main(String[] args) {
        /** 二维码大小 */
        int width = 300;
        int height = 300;
        /** 二维码格式 */
        String format = "png";
        /** 二维码内容 */
        String content = "https://baidu.com";

        /**
         *  定义二维码参数
         *
         *  CHARACTER_SET           编码类型
         *  ERROR_CORRECTION        纠错等级
         *      L < M < Q < H  纠错能力越高，可存储的越少
         *  MARGIN                  边距
         **/
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);


        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new File("E:/img.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
