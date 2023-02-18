package medium.greedy;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {
    public String predictPartyVictory(String senate) {
        // 循环队列
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++)
            if (senate.charAt(i) == 'R')
                radiant.offer(i);
            else
                dire.offer(i);
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex)
                radiant.offer(radiantIndex + n);
            else
                dire.offer(direIndex + n);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
