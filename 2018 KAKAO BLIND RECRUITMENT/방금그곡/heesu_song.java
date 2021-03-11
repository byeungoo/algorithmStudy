class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        // musicinfo 별 실제재생악보 구하기
        int max = 0;
        for(int i=0;i<musicinfos.length;i++){
            String musicinfo = musicinfos[i];
            String songTitle = musicinfo.split(",")[2];

            String realPlayedMelody = getRealPlayedMelody(musicinfo);

            if(realPlayedMelody.contains(convertSharpStr(m))) {
                if (max < realPlayedMelody.length()) {
                    max = realPlayedMelody.length();
                    answer = songTitle;
                }
            }
        }

        return answer;
    }

    public String convertSharpStr(String targetStr){
        /* 편의를 위해서 다음과 같이 변환
         C# ->V
         D# ->W
         F# ->X
         G# ->Y
         A# ->Z
         */
        targetStr = targetStr.replaceAll("C#", "V");
        targetStr = targetStr.replaceAll("D#", "W");
        targetStr = targetStr.replaceAll("F#", "X");
        targetStr = targetStr.replaceAll("G#", "Y");
        targetStr = targetStr.replaceAll("A#", "Z");

        return targetStr;
    }

    public String getRealPlayedMelody(String musicinfo){
        String[] splitedMusicinfo = musicinfo.split(",");
        int strtTime = Integer.parseInt(splitedMusicinfo[0].split(":")[0]);
        int strtMin = Integer.parseInt(splitedMusicinfo[0].split(":")[1]);
        int endTime = Integer.parseInt(splitedMusicinfo[1].split(":")[0]);
        int endMin = Integer.parseInt(splitedMusicinfo[1].split(":")[1]);

        int musicPlayedMin = (endTime*60 + endMin) - (strtTime*60 + strtMin); // 재생된 음악 길이(분)
        int musicLength = convertSharpStr(splitedMusicinfo[3]).length();

        StringBuilder playedMelody = new StringBuilder();
        String musicMelody = convertSharpStr(splitedMusicinfo[3]); // # 컨버팅처리

        for(int i=0;i<musicPlayedMin/musicLength;i++){
            playedMelody.append(musicMelody); // 재생된 음악길이가 실제음악보다 길다면 그만큼 실제음악악보 append
        }
        playedMelody.append(musicMelody, 0, musicPlayedMin%musicLength);

        return playedMelody.toString();
    }
}