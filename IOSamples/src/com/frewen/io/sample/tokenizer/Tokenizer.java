package com.frewen.io.sample.tokenizer;

import com.frewen.io.sample.tokenizer.excel.ExcelKeyWordsReader;

import java.io.IOException;

public class Tokenizer {

    public static void main(String[] args) throws IOException {

        processExcelKeyWordsTokenizer();


    }

    /**
     * 进行Excel版本的关键词分词解析
     */
    private static void processExcelKeyWordsTokenizer() {
        IReader reader = new ExcelKeyWordsReader();
        // 解析关键词
        reader.parseKeyWordsFromExcel("key_words_list_library.xls");
        // 通过query语句进行关键词匹配
        reader.parseQueryFromExcel("query-0601-0615_library.xls");
        reader.parseHitCountResult();
    }
}
