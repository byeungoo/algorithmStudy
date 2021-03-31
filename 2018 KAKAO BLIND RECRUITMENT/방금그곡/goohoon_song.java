import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

class Solution {

    private int maxTime = 0;

    public String solution(String m, String[] musicinfos) {

        AtomicReference<String> answer = new AtomicReference<>("");

        Iterator<String> iterator = Arrays.stream(musicinfos).iterator();

        iterator.forEachRemaining(musicinfo ->{
            String[] split = musicinfo.split(",");
            String start = split[0];
            String end = split[1];
            String title = split[2];
            String music = split[3];

            int time = getTime(start, end);
            String makedMusic = makeMusic(changeMusic(music), time);

            if (makedMusic.contains(changeMusic(m))) {
                if (maxTime < time) {
                    maxTime = time;
                    answer.set(title);
                }
            }

        });

        if (maxTime == 0) {
            answer.set("(None)");
        }

        return answer.get();
    }

    private int getTime(String start, String end){
        String[] startTime = start.split(":");
        int startHour = Integer.valueOf(startTime[0]);
        int startMin = Integer.valueOf(startTime[1]);

        String[] endTime = end.split(":");
        int endHour = Integer.valueOf(endTime[0]);
        int endMin = Integer.valueOf(endTime[1]);

        int totalTime = (endHour-startHour)*60 + (endMin-startMin);

        return totalTime;
    }

    private String changeMusic(String music){
        music = music.replaceAll("C#", "c");
        music = music.replaceAll("D#", "d");
        music = music.replaceAll("F#", "f");
        music = music.replaceAll("G#", "g");
        music = music.replaceAll("A#", "a");
        return music;
    }

    private String makeMusic(String s, int t) {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

}