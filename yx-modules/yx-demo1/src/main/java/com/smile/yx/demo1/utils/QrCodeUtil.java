package com.smile.yx.demo1.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: 二维码工具类
 * @author: qing.wang.o
 * @create: 2018-11-29 10:21
 **/
@Slf4j
public class QrCodeUtil {

    /**
     * 黑色
     */
    private static final int BLACK = 0xFF000000;
    /**
     * 白色
     */
    private static final int WHITE = 0xFFFFFFFF;
    /**
     * 宽
     */
    private static final int WIDTH = 400;
    /**
     * 高
     */
    private static final int HEIGHT = 400;

    /**
     * 图片高度增加60
     */
    private static final int PIC_HEIGHT = HEIGHT + 60;

    /**
     * 二维码传图片
     *
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();

        BufferedImage image = new BufferedImage(width, PIC_HEIGHT, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < PIC_HEIGHT; y++) {
                image.setRGB(x, y, WHITE);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     * 生成二维码
     *
     * @param content 扫描二维码的内容
     * @param format  图片格式 jpg
     *                文件
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static BufferedImage generateQrCode(String content, String format) throws Exception {

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        @SuppressWarnings("rawtypes")
        Map hints = new HashMap();
        // 设置UTF-8， 防止中文乱码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置二维码四周白色区域的大小
        hints.put(EncodeHintType.MARGIN, 1);
        // 设置二维码的容错性
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 画二维码
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        BufferedImage image = toBufferedImage(bitMatrix);
        return image;
    }


    /**
     * 把生成的图片写到本地磁盘
     *
     * @param qrcFile       路径
     * @param qrCodeContent 二维码内容
     * @param pressText     增加的文字
     * @throws Exception
     */
    public static void generateQrCode(File qrcFile, String qrCodeContent, String pressText) throws Exception {


        BufferedImage image = generateQrCode(qrCodeContent, "jpg");

        Graphics g = image.getGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //设置字体
        Font font = new Font(null, Font.PLAIN, 16);
        g.setFont(font);
        g.setColor(Color.black);
        FontMetrics metrics = g.getFontMetrics(font);
        // 文字在图片中的坐标 这里设置在中间
        int startX = (WIDTH - metrics.stringWidth(pressText)) / 2;
        int startY = HEIGHT + (PIC_HEIGHT - HEIGHT) / 2;
        g.drawString(pressText, startX, startY);

        g.dispose();
        image.flush();
        try {
            ImageIO.write(image, "jpg", qrcFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * @param outputStream
     * @param qrCodeContent
     * @param pressText
     * @param fileName
     * @throws Exception
     */
    public static void generateQrCode(ZipOutputStream outputStream, String qrCodeContent, String pressText, String fileName) throws Exception {
        BufferedImage image = generateQrCode(qrCodeContent, "jpg");

        Graphics g = image.getGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //设置字体
        Font font = new Font("微软雅黑", Font.PLAIN, 16);
        g.setFont(font);
        g.setColor(Color.black);
        FontMetrics metrics = g.getFontMetrics(font);
        // 文字在图片中的坐标 这里设置在中间
        int startX = (WIDTH - metrics.stringWidth(pressText)) / 2;
        int startY = HEIGHT + (PIC_HEIGHT - HEIGHT) / 2;
        g.drawString(pressText, startX, startY);
        g.dispose();
        image.flush();
        ZipEntry entry = new ZipEntry(fileName + ".jpg");
        outputStream.putNextEntry(entry);
        try {
            ImageIO.write(image, "jpg", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成二维码并使用Base64编码
     *
     * @param content 二维码内容
     * @return 返回base64图片
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static String getBase64QRCode(String content) throws Exception {


        String format = "png";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        @SuppressWarnings("rawtypes")
        Map hints = new HashMap();

        // 设置二维码四周白色区域的大小
        hints.put(EncodeHintType.MARGIN, 1);
        // 设置二维码的容错性
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 画二维码
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

        ByteArrayOutputStream os = new ByteArrayOutputStream();//新建流。
        ImageIO.write(image, format, os);//利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
        byte b[] = os.toByteArray();//从流中获取数据数组。
        String base64String = new BASE64Encoder().encode(b);

        // Base64编码
        return base64String;

    }


    //读取二维码
    public static String readQrCode(File file) throws IOException, NotFoundException {
        MultiFormatReader reader = new MultiFormatReader();
        BufferedImage image = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置编码
//            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
//            hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
        Result result = reader.decode(binaryBitmap, hints);
        log.info("解析结果:" + result.toString());
        log.info("二维码格式:" + result.getBarcodeFormat());
        log.info("二维码文本内容:" + result.getText());
        return result.getText();
    }


    public static void readQrCodeV1(File file) {
        BufferedImage image;
        try {
            image = ImageIO.read(file);
//            BufferedImage cropedImage = image.getSubimage(0, 0, 914, 400);
            LuminanceSource source = new BufferedImageLuminanceSource(image);

            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<DecodeHintType, Object>(
                    DecodeHintType.class);
            tmpHintsMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            tmpHintsMap.put(DecodeHintType.POSSIBLE_FORMATS,
                    EnumSet.allOf(BarcodeFormat.class));

//            tmpHintsMap.put(DecodeHintType.PURE_BARCODE, Boolean.FALSE);
            Result result = new MultiFormatReader().decode(binaryBitmap, tmpHintsMap);// 对图像进行解码
            System.out.println("图片中内容：  " + result.getText());
            System.out.println("图片中格式：   " + result.getBarcodeFormat());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
