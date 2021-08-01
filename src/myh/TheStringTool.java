package myh;

public class TheStringTool {
    public static void main(String[] args) {
        String ini = "adsdffg,5562555517,SSDFGG,RRTggd,255ssdT,5555523,asdsfERERERss,FFFFGGwwqws";
        String[] arr = new String[8];
        arr = ini.split(",");
        //System.out.println(arr[0]);
        CharTool ct = new CharTool();
        ct.isAllNumber(arr);
        ct.isAllBig(arr);
        ct.isAllSmall(arr);
        ct.Change(arr);
    }

}

class CharTool {
    //判断是否全是数字
    public void isAllNumber(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            char ch = ' ';
            for (int j = 0; j < arr[i].length(); j++) {
                ch = arr[i].charAt(j);
                if (ch >= '0' && ch <= '9') {
                    if ((arr[i].charAt(arr[i].length() - 1)) >= '0' && (arr[i].charAt(arr[i].length() - 1) <= '9')) {
                        System.out.println(arr[i] + "全是数字！");
                    }
                } else {
                    break;
                }
            }

        }

    }

    //判断是否全是大写
    public void isAllBig(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            char ch = ' ';
            for (int j = 0; j < arr[i].length(); j++) {
                ch = arr[i].charAt(j);
                if (ch >= 'A' && ch <= 'Z') {
                    if ((arr[i].charAt(arr[i].length() - 1)) >= 'A' && (arr[i].charAt(arr[i].length() - 1) <= 'Z')) {
                        System.out.println(arr[i] + "全是大写字母！");
                    }
                } else {
                    break;
                }
            }

        }

    }

    //判断是否全是小写
    public void isAllSmall(String[] arr) {
        for (String s : arr) {
            char ch = ' ';
            for (int j = 0; j < s.length(); j++) {
                ch = s.charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    if (ch == s.charAt(s.length() - 1)) {
                        if (ch >= 'a' && ch <= 'z') {
                            System.out.println(s + "全是小写");
                        }
                    } else {
                        continue;
                    }
                } else {
                    break;
                }

            }

        }

    }

    //将全是字母的字符串中的小写转换为大写
    public void Change(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            char ch = ' ';
            for (int j = 0; j < arr[i].length(); j++) {
                ch = arr[i].charAt(j);
                if(ch >='a' && ch <='z'){
                    ch -= 32;
                    System.out.print(ch);
                }
                else{
                    System.out.print(arr[i].charAt(j));
                }
            }
            System.out.println();
        }
    }

}
