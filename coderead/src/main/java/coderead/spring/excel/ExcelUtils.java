package coderead.spring.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ExcelUtils {

    /**
     * 导出Excel
     * @param fileName
     * @param headerList
     * @param contentList
     * @param response
     */
    public static void exportExcel(String fileName, List<String> headerList,
                                   List<List<String>> contentList, HttpServletResponse response) {

        try {

            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/octet-stream");

            WritableWorkbook wwb = null;
            wwb = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = wwb.createSheet("数据明细表", 0);
            //处理头部
            for (int i = 0; i < headerList.size(); i++) {
                sheet.addCell(new Label(i, 0, headerList.get(i)));
            }
            //处理内容
            int contentSize = contentList.size();
            for (int i = 0; i < contentSize; i++) {
                List<String> rowList = contentList.get(i);//过去该行
                int rowSize = rowList.size();
                for (int j = 0; j < rowSize; j++) {
                    sheet.addCell(new Label(j, i + 1, headerList.get(i)));
                }
            }
            wwb.write();
            wwb.close();
        } catch (Exception e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 解析上传的excel数据
     *
     * @param request
     * @param uploadFile
     * @return
     */
    public static List<LinkedHashMap<String, String>> getExcelData(HttpServletRequest request, String uploadFile) throws Exception {

        if (!(request instanceof MultipartHttpServletRequest)) {
            return Lists.newArrayList();
        }
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multiRequest.getFile(uploadFile);// 文件对象
        org.apache.poi.ss.usermodel.Workbook workbook =null;
        try {
            /**较低版本*/
            InputStream inputStream = multipartFile.getInputStream();
            workbook = new HSSFWorkbook(inputStream);

        } catch (OfficeXmlFileException e) {
            /**2007版本*/
            InputStream inputStream = multipartFile.getInputStream();
            workbook=new XSSFWorkbook(inputStream);
        }
        Sheet sheet = workbook.getSheetAt(0);
        List<String> keyList = Lists.newArrayList();
        Row headArr = sheet.getRow(0);
        for (Cell cell : headArr) {
            if (!StringUtils.isBlank(cell.getStringCellValue())) {
                keyList.add(cell.getStringCellValue());
            }
        }
        List<LinkedHashMap<String, String>> resultList = Lists.newArrayList();

        int rows = sheet.getLastRowNum()+1;
        for (int i = 1; i < rows; i++) {
            LinkedHashMap<String, String> map = Maps.newLinkedHashMap();
            Row cellArr = sheet.getRow(i);
            if(Objects.isNull(cellArr)){
                continue;
            }
            boolean isAllEmpty = true;
            for (int j = 0; j < keyList.size(); j++) {
                String value = getCellValue(cellArr.getCell(j));
                if (!StringUtils.isBlank(value)) {
                    map.put(keyList.get(j), value);
                    isAllEmpty = false;
                }
            }
            if (!isAllEmpty) {
                resultList.add(map);
            }
        }
        return resultList;
    }



    private static String getCellValue(Cell cell) {
        if(cell==null) {
            return null;
        }
        String cellValue=null;
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cellValue  =cell.getRichStringCellValue().getString().trim();
        return cellValue;
    }

    /**
     * 字符过滤
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        // 清除掉所有特殊字符  
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
