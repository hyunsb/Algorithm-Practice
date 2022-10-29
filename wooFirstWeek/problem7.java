package wooFirstWeek;

import java.util.*;

public class problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        System.out.println(solution(user, friends, visitors));

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, Vector<String>> friendList = new HashMap<String, Vector<String>>();

        for(List<String> list : friends){
            HashSet<String> set = new HashSet<String>();
            String name = list.get(0);

            for(List<String> temp : friends){
                if(temp.contains(name)) {
                    set.add(temp.get(0));
                    set.add(temp.get(1));
                }
            }
        }


        return answer;
    }

}