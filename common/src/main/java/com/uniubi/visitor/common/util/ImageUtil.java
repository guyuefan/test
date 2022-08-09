package com.uniubi.visitor.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * ImageUtil
 *
 * @author x
 */
@Slf4j
public class ImageUtil {

    /**
     * @param srcImg     原图片
     * @param width      期望宽
     * @param height     期望高
     * @param equalScale 是否等比例缩放
     */
    public static byte[] reSize(byte[] srcImg, int width,
                              int height, boolean equalScale) {
        if (width < 0 || height < 0) {
            return null;
        }

        BufferedImage srcImage = null;
        try {
            srcImage = ImageIO.read(new ByteArrayInputStream(srcImg));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.notNull(srcImage, "srcImage is null");

        // targetW，targetH分别表示目标长和宽
        BufferedImage target = null;
        double sx = (double) width / srcImage.getWidth();
        double sy = (double) height / srcImage.getHeight();
        // 等比缩放
        if (equalScale) {
            if (sx > sy) {
                sx = sy;
                width = (int) (sx * srcImage.getWidth());
            } else {
                sy = sx;
                height = (int) (sy * srcImage.getHeight());
            }
        }
        ColorModel cm = srcImage.getColorModel();
        WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
        boolean alphaPremultiplied = cm.isAlphaPremultiplied();

        target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        Graphics2D g = target.createGraphics();
        // smoother than exlax:
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.drawRenderedImage(srcImage, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        // 将转换后的图片保存
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(target, "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文件后缀不带.
     *
     * @param file 文件后缀名
     * @return
     */
    private static String getImageType(File file) {
        if (file != null && file.exists() && file.isFile()) {
            String fileName = file.getName();
            int index = fileName.lastIndexOf(".");
            if (index != -1 && index < fileName.length() - 1) {
                return fileName.substring(index + 1);
            }
        }
        return null;
    }
}
