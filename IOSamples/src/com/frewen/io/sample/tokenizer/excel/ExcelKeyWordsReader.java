package com.frewen.io.sample.tokenizer.excel;

import com.frewen.io.sample.tokenizer.IReader;
import com.frewen.io.sample.utils.IOStreamUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;


public class ExcelKeyWordsReader implements IReader {

    private static final List<String> sMergeKeyWordsList = new ArrayList<>();
    private static final List<String> sFirstKeyWordsList = new ArrayList<>();
    private static final List<String> sSecondKeyWordsList = new ArrayList<>();

    private Map<String, Integer> mapperKeyWordsMap = new HashMap<>();
    /**
     * 总共命中的个数
     */
    private long totalHitCount = 0L;
    /**
     * 总共query的条数
     */
    private long queryWordsCount;
    private String nameSuffix;
    private int resultFirstKeyWords;
    private int resultSecondKeyWords;
    private int resultMergeKeyWords;
    private int resultOtherKeyWords;


    //====================Excel的文件解析逻辑=============================

    @Override
    public void parseKeyWordsFromExcel(String filePath) {
        InputStream stream;
        try {
            stream = new FileInputStream(filePath);
            //获取Excel文件对象
            Workbook rwb = Workbook.getWorkbook(stream);
            //获取文件的指定工作表 默认的第一个sheet
            Sheet sheet = rwb.getSheet(0);
            //列数，我们从第0列进行遍历
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell = null;
                //行数。一般去掉表头，我们从第二行开始进行分析
                for (int j = 1; j < sheet.getRows(); j++) {
                    //获取第i列，第j行的值
                    cell = sheet.getCell(i, j);

                    // 把不同的关键字添加到对应list中
                    switch (i) {
                        case 0:
                            if (null != cell && !cell.getContents().isEmpty()) {
                                sFirstKeyWordsList.add(cell.getContents());
                            }
                            break;
                        case 1:
                            if (null != cell && !cell.getContents().isEmpty()) {
                                sMergeKeyWordsList.add(cell.getContents());
                            }
                            break;
                        case 2:
                            if (null != cell && !cell.getContents().isEmpty()) {
                                sSecondKeyWordsList.add(cell.getContents());
                            }
                            break;
                    }
                }
            }

            System.out.println("sFirstKeyWordsList == " + sFirstKeyWordsList.size());
            System.out.println("sMergeKeyWordsList == " + sMergeKeyWordsList.size());
            System.out.println("sSecondKeyWordsList == " + sSecondKeyWordsList.size());
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }


    /**
     * 进行Excel中的query语句通过关键词进行分析解析
     *
     * @param filePath
     */
    @Override
    public void parseQueryFromExcel(String filePath) {

        queryWordsCount = 0;
        resultFirstKeyWords = 0;
        resultSecondKeyWords = 0;
        resultMergeKeyWords = 0;
        resultOtherKeyWords = 0;

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        // write string to file

        try {
            nameSuffix = filePath.replace(".xls", ".txt");
            // 合并关键词匹配query
            FileWriter mergeWriter = new FileWriter("合并关键词匹配结果_" + nameSuffix);
            BufferedWriter mergeWriterBuffer = new BufferedWriter(mergeWriter);
            // 一级关键词匹配query
            FileWriter firstWriter = new FileWriter("一级关键词匹配结果_" + nameSuffix);
            BufferedWriter firstWriterBuffer = new BufferedWriter(firstWriter);
            // 二级关键词匹配query
            FileWriter secondWriter = new FileWriter("二级关键词匹配结果_" + nameSuffix);
            BufferedWriter secondWriterBuffer = new BufferedWriter(secondWriter);

            // 其他关键词匹配query
            FileWriter otherWriter = new FileWriter("未匹配到结果_" + nameSuffix);
            BufferedWriter otherWriterBuffer = new BufferedWriter(otherWriter);

            // 实例化文件输入流
            inputStream = new FileInputStream(filePath);

            //获取Excel文件对象
            Workbook rwb = Workbook.getWorkbook(inputStream);
            //获取文件的指定工作表 默认的第一个sheet
            Sheet sheet = rwb.getSheet(0);
            String query;
            System.out.println("QueryList (Columns,Rows) = " + sheet.getColumns() + "," + sheet.getRows());
            //列数，我们从第0列进行遍历
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell = null;
                //行数
                for (int j = 1; j < sheet.getRows(); j++) {
                    //获取第i列，第j行的值
                    cell = sheet.getCell(i, j);
                    query = cell.getContents();
                    //
                    if (null != query && !query.isEmpty() && query.length() > 2) {
                        ++queryWordsCount;

                        String matchedKeyWords;
                        // 首先匹配合并关键词
                        if ((matchedKeyWords = isMatchMergeKeyWords(query)).length() > 0) {
                            mergeWriterBuffer.write(query + "#关键词:" + matchedKeyWords + "\t\n");
                            ++resultMergeKeyWords;
                            // 其次匹配一级关键词
                        } else if ((matchedKeyWords = isMatchFirstKeyWords(query)).length() > 0) {
                            firstWriterBuffer.write(query + "#关键词:" + matchedKeyWords + "\t\n");
                            ++resultFirstKeyWords;
                            // 其次匹配二级关键词
                        } else if ((matchedKeyWords = isMatchSecondKeyWords(query)).length() > 0) {
                            secondWriter.write(query + "#关键词:" + matchedKeyWords + "\t\n");
                            ++resultSecondKeyWords;
                            // 最后匹配Other关键词
                        } else {
                            otherWriterBuffer.write(query + "\t\n");
                            ++resultOtherKeyWords;
                        }
                    }
                }


                System.out.println("==================all the query counts ============== " + queryWordsCount);
                System.out.println("resultMergeKeyWords = " + resultMergeKeyWords);
                System.out.println("resultFirstKeyWords = " + resultFirstKeyWords);
                System.out.println("resultSecondKeyWords = " + resultSecondKeyWords);
                System.out.println("resultOtherKeyWords = " + resultOtherKeyWords);

            }

            inputStream.close();

            IOStreamUtils.flushAll(mergeWriterBuffer, firstWriterBuffer
                    , secondWriterBuffer, otherWriterBuffer);

            IOStreamUtils.closeAll(mergeWriterBuffer, firstWriterBuffer
                    , secondWriterBuffer, otherWriterBuffer);

            IOStreamUtils.closeAll(mergeWriter, firstWriter
                    , secondWriter, secondWriter);


        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parseHitCountResult() {
        // 合并关键词匹配query
        FileWriter mergeWriter = null;
        try {
            /**
             * 往文件里面写入数据。
             */
            mergeWriter = new FileWriter("关键词匹配结果排序_" + nameSuffix);

            BufferedWriter hitWriterBuffer = new BufferedWriter(mergeWriter);


            List<Map.Entry<String, Integer>> list =
                    new ArrayList<>(mapperKeyWordsMap.entrySet());

            //2：调用Collections.sort(list,comparator)方法把Entry-list排序
            Collections.sort(list, new MyComparator());


            for (Map.Entry<String, Integer> entry : list) {
                hitWriterBuffer.write("关键词:" + entry.getKey() + ",                命中次数 = " + entry.getValue());
                hitWriterBuffer.newLine();

                totalHitCount += entry.getValue();
            }

            System.out.println("==============================================");
            hitWriterBuffer.write("==============================================");
            hitWriterBuffer.newLine();


            System.out.println("合并关键词共命中次数：" + resultMergeKeyWords);
            hitWriterBuffer.write("合并关键词共命中次数：" + resultMergeKeyWords);
            hitWriterBuffer.newLine();

            System.out.println("一级关键词命中次数：" + resultFirstKeyWords);
            hitWriterBuffer.write("一级关键词命中次数：" + resultFirstKeyWords);
            hitWriterBuffer.newLine();

            System.out.println("二级关键词命中次数：" + resultSecondKeyWords);
            hitWriterBuffer.write("二级关键词命中次数：" + resultSecondKeyWords);
            hitWriterBuffer.newLine();

            System.out.println("未命中次数：" + resultOtherKeyWords);
            hitWriterBuffer.write("未命中次数：" + resultOtherKeyWords);
            hitWriterBuffer.newLine();

            System.out.println("总共命中次数：" + totalHitCount);
            hitWriterBuffer.write("总共命中次数：" + totalHitCount);
            hitWriterBuffer.newLine();

            System.out.println("总共query条数：" + queryWordsCount);
            hitWriterBuffer.write("总共query条数：" + queryWordsCount);
            hitWriterBuffer.newLine();

            double ratio = (double) totalHitCount / (double) queryWordsCount;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数

            System.out.println("关键词命中占比：" + format.format(ratio));
            hitWriterBuffer.write("关键词命中占比：" + format.format(ratio));
            hitWriterBuffer.newLine();


            hitWriterBuffer.flush();
            hitWriterBuffer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<String> getFirstKeyWords() {
        return sFirstKeyWordsList;
    }

    public List<String> getSecondKeyWords() {
        return sSecondKeyWordsList;
    }

    public List<String> getMergeKeyWords() {
        return sMergeKeyWordsList;
    }


    /**
     * 是否匹配合并关键词
     *
     * @param query
     * @return
     */
    private String isMatchMergeKeyWords(String query) {
        for (String mergeKeyWord : sMergeKeyWordsList) {
            // 根据中文分号或者英文分号继续拆分合并关键词
            String[] tempKeyWords = mergeKeyWord.split("；|;");
            boolean isMatchThisKeyWords = true;
            // 遍历所有的拆分出来的单个关键字
            for (int i = 0; i < tempKeyWords.length; i++) {
                if (!query.contains(tempKeyWords[i])) {
                    isMatchThisKeyWords = false;
                }
            }

            if (isMatchThisKeyWords) {
                putHitCountMap(mergeKeyWord);
                return mergeKeyWord;
            } else {
                continue;
            }
        }
        return "";
    }

    /**
     * 根据关键词。来存储关键词命中次数
     *
     * @param mergeKeyWord
     */
    private void putHitCountMap(String mergeKeyWord) {

        Integer hitCount = mapperKeyWordsMap.get(mergeKeyWord);
        if (null != hitCount) {
            ++hitCount;
        } else {
            hitCount = 1;
        }
        mapperKeyWordsMap.put(mergeKeyWord, hitCount);
    }

    /**
     * 是否匹配一级关键词
     *
     * @param query
     * @return
     */
    private String isMatchFirstKeyWords(String query) {
        for (String firstKeyWord : sFirstKeyWordsList) {
            if (query.contains(firstKeyWord)) {
                putHitCountMap(firstKeyWord);
                return firstKeyWord;
            }
        }
        return "";
    }

    /**
     * 是否匹配二级关键词
     *
     * @param query
     * @return
     */
    private String isMatchSecondKeyWords(String query) {
        for (String secondKeyWord : sSecondKeyWordsList) {
            if (query.contains(secondKeyWord)) {
                putHitCountMap(secondKeyWord);
                return secondKeyWord;
            }
        }
        return "";
    }


    //自定义Entry对象的比较器。每个Entry对象可通过getKey()、
    // getValue()获得Key或Value用于比较。换言之：我们也可以通过Entry对象实现按Key排序。
    class MyComparator implements Comparator<Map.Entry> {
        public int compare(Map.Entry o1, Map.Entry o2) {
            return ((Integer) o2.getValue()).compareTo((Integer) o1.getValue());
        }
    }
}
