package calculator;

public class Calculator {
    public int run(String input) {
        return cal(input);
    }

    public int cal(String str) {
        // 2. 빈 문자열 입력 처리
        if (str.isEmpty()) return 0;

        // 3. 기본 구분자(쉼표, 콜론)로 문자열 분리
        String delimiter = ",|:";
        String input = str;

        //4. 커스텀 구분자로 문장 분리
        int customIndex = isCustom(str);
        if (customIndex != -1) {
            String customDelimiter = input.substring(2, customIndex);
            delimiter += "|" + customDelimiter;
            input = input.substring(customIndex + 2);
        }
        String[] numbers = input.split(delimiter);
    }

    // 4. 커스텀 구분자로 문장 분리
    private int isCustom(String str) {
        if (str.startsWith("//")) {
            return str.indexOf("\\n");
        }
        return -1;
    }
}
