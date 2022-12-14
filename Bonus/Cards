import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Cards {
    ArrayList<String> suits = new ArrayList<>();
    ArrayList<Integer> ranks = new ArrayList<>();
    int score = 0;

    public void input() {
        try (Scanner sc = new Scanner(System.in)) {

            for (String str : sc.nextLine().split(",")) {
                suits.add(str);
            }

            for (String str : sc.nextLine().split(",")) {
                switch (str) {
                    case "A":
                        str = "1";
                        break;
                    case "J":
                        str = "11";
                        break;
                    case "Q":
                        str = "12";
                        break;
                    case "K":
                        str = "13";
                        break;
                }
                ranks.add(Integer.parseInt(str));
            }
            ranks.sort(Comparator.naturalOrder());
        }
    }

    private boolean sameSuit() { // 檢查花色相同
        boolean same = true;
        String sameSuit = suits.get(0);

        for (int i = 1; i < suits.size(); i++) {
            if (!sameSuit.equals(suits.get(i))) {
                same = false;
                break;
            }
        }

        return same;
    }

    private boolean serialPoint() { // 檢查數字連續
        boolean serial = true;

        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i - 1) == ranks.get(i) - 1 ||
                    ranks.get(i - 1) == ranks.get(i) - 9) {
                serial = true;
            } else {
                serial = false;
            }
        }

        return serial;
    }

    private void checkRule1() { // 計算與花色相同、數字連續相關規則
        if (sameSuit() && serialPoint()) {
            score += 100;
        } else if (serialPoint()) {
            score += 5;
        } else if (sameSuit()) {
            score += 3;
        }
    }

    private void checkRule2() { // 計算與數字相同相關規則
        HashMap<Integer, Integer> sameMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> set1 = new HashSet<Integer>(Arrays.asList(4, 1)); // 四條
        HashSet<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 2)); // 葫蘆
        HashSet<Integer> set3 = new HashSet<Integer>(Arrays.asList(2, 2, 1)); // 2對子
        HashSet<Integer> set4 = new HashSet<Integer>(Arrays.asList(3, 1, 1)); // 1對子-1
        HashSet<Integer> set5 = new HashSet<Integer>(Arrays.asList(2, 1, 1, 1)); // 1對子-2

        for (int i : ranks) {
            sameMap.put(i, sameMap.getOrDefault(i, 0) + 1);
        }

        for (int i : sameMap.values()) {
            set.add(i);
        }

        if (set.equals(set1)) { // 四條
            score += 20;
            if (sameMap.containsKey(1)) {
                if (sameMap.get(1) == 1) {
                    score++;
                }
            }

        } else if (set.equals(set2)) { // 葫蘆
            score += 10;

        } else if (set.equals(set3) && sameMap.values().size() == 3) { // 2對子
            score += 4;
            if (sameMap.containsKey(1)) {
                if (sameMap.get(1) == 1) {
                    score++;
                }
            }

        } else if (set.equals(set4)) { // 1對子-1
            if (sameMap.containsKey(1)) {
                score += 3;
            } else {
                score += 2;
            }

        } else if (set.equals(set5) && sameMap.values().size() == 4) { // 1對子-2
            score += 2;
            if (sameMap.containsKey(1)) {
                if (sameMap.get(1) == 1) {
                    score++;
                }
            }

        } else {
            if (sameMap.containsKey(1)) { // 可憐爛牌
                score++;
            }
        }

    }

    public int getScore() {
        if (sameSuit() || serialPoint()) {
            checkRule1();
        } else {
            checkRule2();
        }

        return score;
    }
}
