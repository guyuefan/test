package com.uniubi.visitor.common.util;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author macos
 */
public class SceneImageUtil {


    private static int LOGO_SIZE = 580;

    @SneakyThrows
    public static byte[] generate(byte[] bkImg, byte[] qrImg, String title, String subTitle) {
        BufferedImage bk = JpegReader.readImage(bkImg);

        Graphics2D graphics = bk.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(Color.WHITE);

        // title
        if (StringUtils.isNotBlank(title)) {
            Font font = null;
            if (title.length() < 10) {
                font = new Font("思源黑体", Font.BOLD, 208);
            } else if (title.length() < 18) {
                font = new Font("思源黑体", Font.BOLD, 120);
            } else {
                title = title.substring(0, 18);
                font = new Font("思源黑体", Font.BOLD, 120);
            }
            //计算图片的宽
            int width = getWordWidth(font, title);

            graphics.setFont(font);
            int x = 2380 / 2 - width / 2;
            //图片上写文字
            graphics.drawString(title, x, 525);
        }

        // subTitle
        if (StringUtils.isNotBlank(subTitle)) {
            if (subTitle.length() > 10) {
                subTitle = subTitle.substring(0, 10);
            }

            Font font = new Font("思源黑体", Font.BOLD, 90);
            //计算图片的宽
            int width = getWordWidth(font, subTitle);

            graphics.setFont(font);
            int x = 2380 / 2 - width / 2;
            //图片上写文字
            graphics.drawString(subTitle, x, 680);
        }

        // qr
        qrImg = ImageUtil.reSize(qrImg, 1728, 1728, true);
        BufferedImage qr = JpegReader.readImage(qrImg);
        graphics.drawImage(qr, 328, 1276, qr.getWidth(), qr.getHeight(), null);

        graphics.dispose();

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bk, "png", arrayOutputStream);
        return arrayOutputStream.toByteArray();
    }


    public static byte[] generate(byte[] bjImg, byte[] logoImage) throws Exception {
        BufferedImage bk = JpegReader.readImage(bjImg);
        Graphics2D graphics = bk.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置背影为白色
        graphics.setColor(Color.WHITE);
        // qr
        logoImage = ImageUtil.reSize(logoImage, LOGO_SIZE, LOGO_SIZE, true);

        BufferedImage qr = JpegReader.readImage(logoImage);
        // 原有图册先删掉,按照圆形来删除
        graphics.fillOval(785, 1752, 799, 799);

        graphics.drawImage(qr, 907 + drawRelativePosition(qr.getWidth()), 1856 + drawRelativePosition(qr.getHeight()), qr.getWidth(), qr.getHeight(), null);

        graphics.dispose();

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bk, "png", arrayOutputStream);
        return arrayOutputStream.toByteArray();
    }

    private static int drawRelativePosition(int position) {
        if (position < LOGO_SIZE) {
            return (LOGO_SIZE - position) / 2;
        }
        return 0;
    }

    private static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }
}
