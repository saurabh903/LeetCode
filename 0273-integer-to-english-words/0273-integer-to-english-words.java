class Solution {
    private String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    private String lessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }

    private String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    private String two(int n) {
        if (n == 0) return "";
        if (n < 10) return one(n);
        if (n < 20) return lessThan20(n);
        int tenner = n / 10;
        int rest = n % 10;
        if (tenner != 0 && rest != 0) return ten(tenner) + " " + one(rest);
        if (tenner != 0) return ten(tenner);
        if (rest != 0) return one(rest);
        return "";
    }

    private String three(int num) {
        if (num == 0) return "";
        int hundred = num / 100;
        int rest = num % 100;
        String res = "";
        if (hundred != 0) res += one(hundred) + " Hundred";
        if (rest != 0) res += " " + two(rest);
        return res.trim();
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int billion = num / 1000000000;
        num = num % 1000000000;
        int million = num / 1000000;
        num = num % 1000000;
        int thousand = num / 1000;
        num = num % 1000;

        String res = "";
        if (billion != 0) {
            res += three(billion) + " Billion";
        }
        if (million != 0) {
            res += " " + three(million) + " Million";
        }
        if (thousand != 0) {
            res += " " + three(thousand) + " Thousand";
        }
        if (num != 0) {
            res += " " + three(num);
        }
        return res.trim();
    }
}
