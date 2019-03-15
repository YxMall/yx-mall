//package com.smile.yx.demo1.utils;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Hashtable;
//
//import javax.imageio.ImageIO;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.DecodeHintType;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.LuminanceSource;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.ReaderException;
//import com.google.zxing.Result;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.client.j2se.MatrixToImageConfig;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriterEx;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
//
///**
// * 带logo的二维码
// */
//public class QRCoder {
//
//	public void createQrCode(String content, int width, int height,
//			String imageSavePath, String formate) throws IOException {
//		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
//		//指定纠错级别--共有四个级别L M Q H， L 7% M 15% Q 25% H 30%
//		hints.put(EncodeHintType.MARGIN, 1);
//		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//		BitMatrix matrix = null;
//		try {
//			matrix = new MultiFormatWriter().encode(content,
//					BarcodeFormat.QR_CODE, width, height,hints);
//			writeToFile(matrix, formate, imageSavePath);
//		} catch (WriterException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void createQrCode(String content, int width, int height,
//			String imageSavePath, File logoPath, String formate,
//			int fontColor, int bgColor,int logoCent) throws IOException {
//		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
//		hints.put(EncodeHintType.MARGIN, 1);
//		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//		BitMatrix matrix = null;
//		try {
//			matrix = new MultiFormatWriter().encode(content,
//					BarcodeFormat.QR_CODE, width, height, hints);
//			writeToFile(matrix, formate, imageSavePath, logoPath, fontColor,
//					bgColor,logoCent);
//		} catch (WriterException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void writeToFile(BitMatrix matrix, String format,
//			String imagePath) throws IOException {
//		File file = new File(imagePath);
//		MatrixToImageWriter.writeToFile(matrix, format, file);
//	}
//
//	public static void writeToFile(BitMatrix matrix, String formate,
//			String imageSavePath, File logoPath, int fontColor, int bgColor ,int logoCent)
//			throws IOException {
//		BufferedImage image = MatrixToImageWriterEx.write2File(matrix, formate,
//				imageSavePath, new MatrixToImageConfig(fontColor, bgColor));
//		MatrixToImageWriterEx.overlapImage(image, imageSavePath, logoPath,
//				formate,logoCent);
//	}
//
//	@SuppressWarnings({ "unchecked", "finally" })
//	public String decode(String imgPath) {
//		String content = "";
//		try {
//			File file = new File(imgPath);
//			if (!file.exists()) {
//				return content;
//			}
//			BufferedImage image = null;
//			try {
//				image = ImageIO.read(file);
//				if (null == image) {
//					return content;
//				}
//				LuminanceSource source = new BufferedImageLuminanceSource(image);
//				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
//						source));
//				@SuppressWarnings("rawtypes")
//				Hashtable hints = new Hashtable();
//				hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
//				hints.put(EncodeHintType.ERROR_CORRECTION,
//						ErrorCorrectionLevel.H);
//				Result result = new MultiFormatReader().decode(bitmap, hints);
//				content = result.getText();
//			} catch (IOException e1) {
//				content = "";
//			} catch (ReaderException e2) {
//				content = "";
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			return content;
//		}
//	}
//}
