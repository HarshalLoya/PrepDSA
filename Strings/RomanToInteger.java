
public class RomanToInteger {

    // TC: O(N), SC: O(1)
    // public static int romanToInt(String s) {
    //     int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //     String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    //     int result = 0;
    //     for (int i = 0; i < values.length; i++) {
    //         while (s.indexOf(roman[i]) == 0) {
    //             result += values[i];
    //             s = s.substring(roman[i].length());
    //         }
    //     }
    //     return result;
    // }
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            char cm = i > 0 ? s.charAt(i - 1) : 0;
            switch (c) {
                case 'V' -> {
                    if (i > 0 && cm == 'I') {
                        result += 4;
                        i--;
                    } else {
                        result += 5;
                    }
                }
                case 'X' -> {
                    if (i > 0 && cm == 'I') {
                        result += 9;
                        --i;
                    } else {
                        result += 10;
                    }
                }
                case 'L' -> {
                    if (i > 0 && cm == 'X') {
                        result += 40;
                        --i;
                    } else {
                        result += 50;
                    }
                }
                case 'C' -> {
                    if (i > 0 && cm == 'X') {
                        result += 90;
                        --i;
                    } else {
                        result += 100;
                    }
                }
                case 'D' -> {
                    if (i > 0 && cm == 'C') {
                        result += 400;
                        --i;
                    } else {
                        result += 500;
                    }
                }
                case 'M' -> {
                    if (i > 0 && cm == 'C') {
                        result += 900;
                        --i;
                    } else {
                        result += 1000;
                    }
                }
                case 'I' ->
                    result += 1;
                default -> {
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
