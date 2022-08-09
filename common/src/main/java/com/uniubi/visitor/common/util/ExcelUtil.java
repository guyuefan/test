package com.uniubi.visitor.common.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;


/**
 * @author yuPh
 * @date 2019-08-12
 */
public class ExcelUtil {
    /**
     * 　　* @param entityClass excel中每一行数据的实体类
     * 　　* @param in          excel文件
     * 　　* @param fields     字段名字
     * 　　*             需要注意的是这个方法中的map中：
     * 　　*             excel表格中每一列名为键，每一列对应的实体类的英文名为值
     * 　　 * @throws Exception
     */
    public static <T> List<T> excelToList(InputStream in, Class<T> entityClass,
                                          Integer titleRows,
                                          Map<String, String> fields) throws Exception {

        List<T> resultList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        // excel中字段的中英文名字数组
        String[] entitles = new String[fields.size()];
        String[] canticles = new String[fields.size()];
        Iterator<String> it = fields.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            String canticle = it.next();
            String entitle = fields.get(canticle);
            entitles[count] = entitle;
            canticles[count] = canticle;
            count++;
        }
        // 得到excel中sheet总数
        int sheetCount = workbook.getNumberOfSheets();

        if (sheetCount == 0) {
            workbook.close();
            throw new Exception("Excel文件中没有任何数据");
        }
        // 数据的导出
        for (int i = 0; i < sheetCount; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            // 每页中的第一行为标题行，对标题行的特殊处理
            XSSFRow firstRow = sheet.getRow(titleRows);
            int cellLength = firstRow.getLastCellNum();
            String[] excelFieldNames = new String[cellLength];
            LinkedHashMap<String, Integer> colMap = new LinkedHashMap<>();
            // 获取Excel中的列名
            for (int f = 0; f < cellLength; f++) {
                XSSFCell cell = firstRow.getCell(f);
                excelFieldNames[f] = cell.getStringCellValue().trim();
                // 将列名和列号放入Map中,这样通过列名就可以拿到列号
                for (int g = 0; g < excelFieldNames.length; g++) {
                    colMap.put(excelFieldNames[g], g);
                }
            }
            // 由于数组是根据长度创建的，所以值是空值，这里对列名map做了去空键的处理
            colMap.remove(null);
            // 判断需要的字段在Excel中是否都存在
            // 需要注意的是这个方法中的map中：中文名为键，英文名为值
            boolean isExist = true;
            List<String> excelFieldList = Arrays.asList(excelFieldNames);
            for (String cnName : fields.keySet()) {
                if (!excelFieldList.contains(cnName)) {
                    isExist = false;
                    break;
                }
            }
            // 如果有列名不存在，则抛出异常，提示错误
            if (!isExist) {
                workbook.close();
                throw new Exception("Excel中缺少必要的字段，或字段名称有误");
            }
            // 将sheet转换为list
            for (int j = titleRows + 1; j <= sheet.getLastRowNum(); j++) {
                XSSFRow row = sheet.getRow(j);
                if (null == row) {
                    continue;
                }
                // 根据泛型创建实体类
                T entity = entityClass.newInstance();
                // 给对象中的字段赋值
                for (Entry<String, String> entry : fields.entrySet()) {
                    // 获取中文字段名
                    String cnNormalName = entry.getKey();
                    // 获取英文字段名
                    String enNormalName = entry.getValue();
                    // 根据中文字段名获取列号
                    int col = colMap.get(cnNormalName);
                    // 获取当前单元格中的内容
                    String content = "";
                    if (null != row.getCell(col)) {
                        content = getCellValue(row.getCell(col));
                    }
                    // 给对象赋值
                    setFieldValueByName(enNormalName, content, entity);
                }
                resultList.add(entity);
            }
        }
        workbook.close();
        return resultList;
    }

    /**
     * @param fieldName  字段名
     * @param fieldValue 字段值
     * @param o          对象
     * @MethodName : setFieldValueByName
     * @Description : 根据字段名给对象的字段赋值
     */
    private static void setFieldValueByName(String fieldName,
                                            Object fieldValue, Object o) throws Exception {

        Field field = getFieldByName(fieldName, o.getClass());
        if (field != null) {
            field.setAccessible(true);
            // 获取字段类型
            Class<?> fieldType = field.getType();

            // 根据字段类型给字段赋值
            if (String.class == fieldType) {
                field.set(o, String.valueOf(fieldValue));
            } else if ((Integer.TYPE == fieldType)
                    || (Integer.class == fieldType)) {
                field.set(o, Integer.parseInt(fieldValue.toString()));
            } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                field.set(o, Long.valueOf(fieldValue.toString()));
            } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                field.set(o, Float.valueOf(fieldValue.toString()));
            } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                field.set(o, Short.valueOf(fieldValue.toString()));
            } else if ((Double.TYPE == fieldType)
                    || (Double.class == fieldType)) {
                field.set(o, Double.valueOf(fieldValue.toString()));
            } else if (Character.TYPE == fieldType) {
                if ((fieldValue != null)
                        && (fieldValue.toString().length() > 0)) {
                    field.set(o,
                            Character.valueOf(fieldValue.toString().charAt(0)));
                }
            } else if (Date.class == fieldType) {
                field.set(o, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .parse(fieldValue.toString()));
            } else {
                field.set(o, fieldValue);
            }
        } else {
            throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 "
                    + fieldName);
        }
    }

    /**
     * @param fieldName 字段名
     * @param clazz     包含该字段的类
     * @return 字段
     * @MethodName : getFieldByName
     * @Description : 根据字段名获取字段
     */
    private static Field getFieldByName(String fieldName, Class<?> clazz) {
        // 拿到本类的所有字段
        Field[] selfFields = clazz.getDeclaredFields();

        // 如果本类中存在该字段，则返回
        for (Field field : selfFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        // 否则，查看父类中是否存在此字段，如果有则返回
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null && superClazz != Object.class) {
            return getFieldByName(fieldName, superClazz);
        }
        // 如果本类和父类都没有，则返回空
        return null;
    }

    private static String getCellValue(Cell cell) {
        String cellmate;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                        // 如果是Date类型则，取得该Cell的Date值
                        // 对2014-02-02格式识别不出是日期格式
                        Date date = cell.getDateCellValue();
                        DateFormat forMater = new SimpleDateFormat("yyyy-MM-dd");
                        cellmate = forMater.format(date);
                    } else { // 如果是纯数字
                        // 取得当前Cell的数值
                        cellmate = NumberToTextConverter.toText(cell.getNumericCellValue());

                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellmate = cell.getStringCellValue().replaceAll("'", "''");
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellmate = null;
                    break;
                // 默认的Cell值
                default: {
                    cellmate = " ";
                }
            }
        } else {
            cellmate = "";
        }
        return cellmate;
    }
}

