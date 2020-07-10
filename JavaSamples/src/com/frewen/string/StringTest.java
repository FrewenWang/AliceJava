package com.frewen.string;


public class StringTest {

    public static String cookies = "{\n" +
            "    \"sid\": \"sid123\",\n" +
            "    \"code\": \"200\",\n" +
            "    \"desc\": \"\",\n" +
            "    \"cookies\": [\n" +
            "      {\n" +
            "        \"val\": \"1\",\n" +
            "        \"max_age\": -1,\n" +
            "        \"key\": \"personality_id\"\n" +
            "      }\n" +
            "    ]\n" +
            "}";

    public static void main(String[] args) {
        String testStr = "/233579438/20180514/3d4bc800-0fab-431c-9ec3-e94fe7b6e531/wasu.mp4";

//        System.out.println("subString(1)==" + testStr.substring(1));
//        System.out.println("subString(1)==" + testStr.substring(1,testStr.lastIndexOf("/")));


        System.out.println(String.valueOf(-5));


        /**
         * 我们可以看到String 拼接boolean值。是字符串
         *
         * 1.1.0##true
         */
        String versionCode = "1.1.0";
        System.out.println(versionCode + "##" + true);


    }
}
