package com.smile.yx.demo2;

import com.google.zxing.NotFoundException;
import com.smile.yx.demo1.utils.QrCodeUtil;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: qing.wang.o
 * @create: 2019-03-03 12:53
 **/
public class QrCodeTest {
    public static void main(String[] args) throws IOException, NotFoundException {
//        QrCodeUtil.readQrCodeV1(new File("D:\\1233-0.jpg"));
//        QrCodeUtil.readQrCodeV1(new File("D:\\12331-0.jpg"));
        QrCodeUtil.readQrCodeV1(new File("C:\\Users\\qing.wang.o\\Desktop\\1.jpg"));
    }
}
