package com.xiaoyagao;

public class NC1 {

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        System.out.println(solve("1231241254125215125125215125215125125125125125", "125451256437457458569856956956956956956956956956950560560560"));
        long endtime = System.currentTimeMillis();
        System.out.println("耗时" + (endtime - starttime) + "ms");
    }

    public static String solve(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        String longstring, shortstring, tempresult;
        int longer, shorter;
        int temp = 0;
        int jinwei = 0;
        StringBuilder result = new StringBuilder();
        if (slength > tlength) {
            longer = slength;
            shorter = tlength;
            longstring = s;
            shortstring = t;
        } else {
            longer = tlength;
            shorter = slength;
            longstring = t;
            shortstring = s;
        }
        for (int i = shorter - 1; i >= 0; i--) {
            int a = longstring.charAt(i + (longer - shorter)) - '0';
            int b = shortstring.charAt(i) - '0';
            temp = a + b + jinwei;
            if (temp >= 10) {
                jinwei = temp / 10;
                tempresult = String.valueOf(temp - 10);
                result.insert(0, tempresult);
            } else {
                jinwei = 0;
                tempresult = String.valueOf(temp);
                result.insert(0, tempresult);
            }
        }
        if (jinwei == 0) {
            for (int j = longer - shorter - 1; j >= 0; j--) {
                result.insert(0, String.valueOf(longstring.charAt(j) - '0'));
            }
            return result.toString();
        }
        for (int j = longer - shorter - 1; j >= 0; j--) {
            temp = longstring.charAt(j) - '0' + jinwei;
            if (temp >= 10) {
                if (j == 0) {
                    tempresult = String.valueOf(temp - 10);
                    jinwei = temp / 10;
                    result.insert(0, tempresult);

                } else {
                    jinwei = temp / 10;
                    tempresult = String.valueOf(temp - 10);
                    result.insert(0, tempresult);
                }
            } else {
                if (j == 0) {
                    tempresult = String.valueOf(temp);
                    result.insert(0, tempresult);
                } else {
                    jinwei = 0;
                    tempresult = String.valueOf(temp);
                    result.insert(0, tempresult);
                }
            }
        }
        if (jinwei != 0) {
            result.insert(0, jinwei);
        }
        return result.toString();
    }
}
