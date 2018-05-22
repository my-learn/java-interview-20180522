package edu.maskleo;

import java.util.LinkedList;
import java.util.List;

public class Test2 {


    public static void main(String[] args) {
        try {
            System.out.println(limitedCarCard("A1023,NB123,D12ZG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String limitedCarCard(String input) throws Exception {
        String[] arr = input.split(",");
        int limitDate = 3;
        List<String> result = new LinkedList<>();
        for (String str : arr) {
            if (str.length() != 5) {
                throw new Exception("length error!");
            }
            int le = 0;
            char at = '&';
            for (int k = str.toCharArray().length - 1; k >= 0; k--) {
                char c = str.toCharArray()[k];
                int i = (int) c;
                if (i < 48 || i > 58) {
                    le++;
                } else {
                    at = (at == '&' ? c : at);
                }
            }
            System.out.println(at);
            if (le == 5) {
                throw new Exception("length error!");
            }

            if (limitDate == 2 && !(at == '1' || at == '6')) {
                result.add(str);
                continue;
            }
            if (limitDate == 3 && !(at == '2' || at == '7')) {
                result.add(str);
                continue;
            }
            if (limitDate == 4 && !(at == '3' || at == '8')) {
                result.add(str);
                continue;
            }
            if (limitDate == 5 && !(at == '4' || at == '9')) {
                result.add(str);
                continue;
            }
            if (limitDate == 6 && !(at == '5' || at == '0')) {
                result.add(str);
                continue;
            }
        }
        return String.join(",", result);
    }

}
