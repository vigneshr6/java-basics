package com.vignesh.basics.algo;

import org.junit.jupiter.api.Test;

public class MatchingBracesTest {

    @Test
    public void testCount() {
        String code = "int main()\n" +
                "{\n" +
                "\tint num=1;\n" +
                "\tif(num<10)\n" +
                "\t{\n" +
                "\t\tif(num==1)\n" +
                "\t\t{\n" +
                "\t\t\tprintf(\"The value is:%d\\n\",num);\n" +
                "\t\t}\n" +
                "\t\telse\n" +
                "\t\t{\n" +
                "\t\t\tprintf(\"The value is greater than 1\");\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\telse\n" +
                "\t{\n" +
                "\t\tprintf(\"The value is greater than 10\");\n" +
                "\t}\n" +
                "\treturn 0;\n" +
                "}\n";
        char[] chars = code.toCharArray();
        int validBraces=0;
        int open=0;
        for(int i=0;i< chars.length;i++){
            char c = chars[i];
            if(c == '{') {
                open++;
            } else if(c == '}' && open > 0) {
                open--;
                validBraces++;
            }
        }
        System.out.println("validBraces = " + validBraces);
    }
}
