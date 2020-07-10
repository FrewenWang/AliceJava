package com.frewen.io.sample;


import com.frewen.io.sample.tokenizer.excel.ExcelKeyWordsReader;
import com.frewen.io.sample.utils.IOStreamUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KeyWordsReader {

    private static final List<String> sMergeKeyWordsList = new ArrayList<>();
    private static final List<String> sFirstKeyWordsList = new ArrayList<>();
    private static final List<String> sSecondKeyWordsList = new ArrayList<>();




    public static void main(String[] args) throws IOException {

        /**
         * 从Excel表格中读取关键词文件
         */
        //parseKeyWordsFromExcel("key_words_list_hotel.xls");
        /**
         *  从Excel表格中读取Other Query语句进行关键词匹配
         */
        //parseQueryWordsFromExcel();


        /**
         * 读取合并关键词
         */
//        readKeyWords("2_firstKeyWords.txt");
//        readKeyWords("3_secondKeyWords.txt");
//        readKeyWords("1_mergeKeyWords.txt");
//        keyWordsParser("4_queryWords.txt");

    }

//    private static void parseQueryWordsFromExcel() {
//        QueryExcelReader queryExcelReader = new QueryExcelReader();
//        queryExcelReader.setFirstKeyWordsList(sFirstKeyWordsList);
//        queryExcelReader.setSecondKeyWordsList(sSecondKeyWordsList);
//        queryExcelReader.setMergeKeyWordsList(sMergeKeyWordsList);
//
//        queryExcelReader.parseKeyWordsFromExcel("1-other_query0415_0430.xls");
//
//    }

    private static void parseKeyWordsFromExcel(String path) {
        ExcelKeyWordsReader reader = new ExcelKeyWordsReader();
        reader.parseKeyWordsFromExcel(path);
        sFirstKeyWordsList.addAll(reader.getFirstKeyWords());
        sSecondKeyWordsList.addAll(reader.getSecondKeyWords());
        sMergeKeyWordsList.addAll(reader.getMergeKeyWords());
        System.out.println("sFirstKeyWordsList == " + sFirstKeyWordsList.size());
        System.out.println("sMergeKeyWordsList == " + sMergeKeyWordsList.size());
        System.out.println("sSecondKeyWordsList == " + sSecondKeyWordsList.size());
    }


    /**
     * 关键词分词解析
     */
    private static void keyWordsParser(String fileName) {

        long queryWordsCount = 0;
        long resultFirstKeyWords = 0;
        long resultSecondKeyWords = 0;
        long resultMergeKeyWords = 0;
        long resultOtherKeyWords = 0;

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        // write string to file

        try {
            // 合并关键词匹配query
            FileWriter mergeWriter = new FileWriter("result_mergeKeyWords_query.txt");
            BufferedWriter mergeWriterBuffer = new BufferedWriter(mergeWriter);
            // 一级关键词匹配query
            FileWriter firstWriter = new FileWriter("result_firstKeyWords_query.txt");
            BufferedWriter firstWriterBuffer = new BufferedWriter(firstWriter);
            // 二级关键词匹配query
            FileWriter secondWriter = new FileWriter("result_secondKeyWords_query.txt");
            BufferedWriter secondWriterBuffer = new BufferedWriter(secondWriter);

            // 其他关键词匹配query
            FileWriter otherWriter = new FileWriter("result_otherKeyWords_query.txt");
            BufferedWriter otherWriterBuffer = new BufferedWriter(otherWriter);

            // 实例化文件输入流
            inputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String query;
            while ((query = bufferedReader.readLine()) != null) {
                // System.out.println("query == " + query);
                ++queryWordsCount;
                /**
                 * 针对非空的query的进行关键字匹配计算
                 */
                if (null != query && !query.isEmpty()) {
                    // 首先匹配合并关键词
                    if (isMatchMergeKeyWords(query)) {
                        //System.out.println("isMatchMergeKeyWords = " + query);
                        mergeWriterBuffer.write(query);
                        mergeWriterBuffer.write("\t\n");
                        ++resultMergeKeyWords;
                        // 其次匹配一级关键词
                    } else if (isMatchFirstKeyWords(query)) {
                        //System.out.println("isMatchFirstKeyWords = " + query);
                        firstWriterBuffer.write(query);
                        firstWriterBuffer.write("\t\n");
                        ++resultFirstKeyWords;
                        // 最后匹配二级关键词
                    }  else {
                        //System.out.println("isMatchOtherKeyWords = " + query);
                        otherWriterBuffer.write(query);
                        otherWriterBuffer.write("\t\n");
                        ++resultOtherKeyWords;
                    }
                }

            }

            System.out.println("==================all the query counts ============== " + queryWordsCount);
            System.out.println("resultMergeKeyWords = " + resultMergeKeyWords);
            System.out.println("resultFirstKeyWords = " + resultFirstKeyWords);
            System.out.println("resultSecondKeyWords = " + resultSecondKeyWords);
            System.out.println("resultOtherKeyWords = " + resultOtherKeyWords);

            //close
            inputStream.close();
            bufferedReader.close();

            IOStreamUtils.closeAll(mergeWriterBuffer, firstWriterBuffer
                    , secondWriterBuffer, otherWriterBuffer);

            IOStreamUtils.closeAll(mergeWriter, firstWriter
                    , secondWriter, secondWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readKeyWords(String fileName) {
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = null;
        try {
            // 实例化文件输入流
            inputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                //System.out.println(str);
                if (null != str && !str.isEmpty()) {
                    switch (fileName) {
                        case "2_firstKeyWords.txt":
                            sFirstKeyWordsList.add(str);
                            break;
                        case "1_mergeKeyWords.txt":
                            sMergeKeyWordsList.add(str);
                            break;
                        case "3_secondKeyWords.txt":
                            sSecondKeyWordsList.add(str);
                            break;
                    }

                }
            }


            //close
            inputStream.close();
            bufferedReader.close();

            System.out.println("sFirstKeyWordsList == " + sFirstKeyWordsList.size());
            System.out.println("sMergeKeyWordsList == " + sMergeKeyWordsList.size());
            System.out.println("sSecondKeyWordsList == " + sSecondKeyWordsList.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 是否匹配合并关键词
     *
     * @param query
     * @return
     */
    private static boolean isMatchMergeKeyWords(String query) {

        for (String mergeKeyWord : sMergeKeyWordsList) {

            String[] tempKeyWords = mergeKeyWord.split("；|;");
            boolean isMatchThisKeyWords = true;

            // 遍历所有的拆分出来的单个关键字
            for (int i = 0; i < tempKeyWords.length; i++) {
                if (!query.contains(tempKeyWords[i])) {
                    isMatchThisKeyWords = false;
                }
            }

            if (isMatchThisKeyWords) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    /**
     * 是否匹配一级关键词
     *
     * @param query
     * @return
     */
    private static boolean isMatchFirstKeyWords(String query) {
        for (String secondKeyWord : sFirstKeyWordsList) {
            if (query.contains(secondKeyWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否匹配二级关键词
     *
     * @param query
     * @return
     */
    private static boolean isMatchSecondKeyWords(String query) {
        for (String secondKeyWord : sSecondKeyWordsList) {
            if (query.contains(secondKeyWord)) {
                return true;
            }
        }
        return false;
    }

}
