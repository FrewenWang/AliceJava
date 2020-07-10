package com.frewen.io.sample.tokenizer;

public interface IReader {
    /**
     * 关键词文本解析
     *
     * @param path
     */
    void parseKeyWordsFromExcel(String path);

    /**
     * query列表数据解析
     *
     * @param patch
     */
    void parseQueryFromExcel(String patch);

    /**
     * 解析整个数据处理过程中，每个关键词命中的次数
     */
    void parseHitCountResult();
}
