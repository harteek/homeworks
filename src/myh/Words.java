package myh;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Words {
    public static void main(String[] args) {
        String s1 = "you you you you you he you";
        String s2 = "fuck fuck fuck no fuck her you";
        String[] S1 = s1.split(" ");
        String[] S2 = s2.split(" ");
        //<K,V>代表<字符串，出现次数>
        HashMap<String, Integer> H1 = new Words().StoH(S1);
        HashMap<String, Integer> H2 = new Words().StoH(S2);
        System.out.println(H1);
        System.out.println(H2);
        TreeSet<String> res = new Words().StrangeWord(H1, H2);
        System.out.println(res);
    }

    public HashMap<String, Integer> StoH(String[] s) {
        HashMap<String, Integer> HM = new HashMap<>();
        Set<String> keys = HM.keySet();
        for (int i = 0; i < s.length; i++) {
            if (keys.contains(s[i])) {
                Integer integer = HM.get(s[i]);
                HM.put(s[i], ++integer);
            } else {
                HM.put(s[i], 1);
            }
        }
        return HM;
    }

    public TreeSet<String> StrangeWord(HashMap<String, Integer> HM1, HashMap<String, Integer> HM2) {
        TreeSet<String> TS = new TreeSet<>();
        Set<String> string1 = HM1.keySet();
        Set<String> string2 = HM2.keySet();
        for (String s : string1) {
            if (HM1.get(s) == 1 && !string2.contains(s)) {
                TS.add(s);
            }
        }
        return TS;
    }
}

