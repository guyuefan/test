package com.uniubi.visitor.common.util;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author zqp
 */
public class PdfUtils implements Serializable {

    private static final String path = "filepath";

    public static String fillPdfContent(String customer, String person, String phone, String address) throws Exception {
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        PdfReader reader = new PdfReader(ResourceUtils.getFile("classpath:宇泛智能访客系统软件服务合同.pdf").getPath());
        String localHostAddress = file.getAbsolutePath()+"/"+ UUID.randomUUID().toString()+".pdf";
        FileOutputStream out = new FileOutputStream(localHostAddress);
        PdfStamper stamper;
        stamper = new PdfStamper(reader, out);
        AcroFields form = stamper.getAcroFields();
        BaseFont baseFont = BaseFont.createFont(ResourceUtils.getFile("classpath:simsun.ttc") + ",1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        form.addSubstitutionFont(baseFont);
        String[] params = new String[]{customer, address, person, phone, ""};
        int i = 0;
        for (String k : form.getFields().keySet()) {
            form.setFieldProperty(k, "textfont", baseFont, null);
            form.setField(k, params[i++]);
        }
        //设置为无法编辑
        stamper.setFormFlattening(true);
        stamper.close();
        return localHostAddress;
    }


}
