import java.util.*;
import java.util.stream.Collectors;

// begin at 2020/3/1 10:53
class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(String v : votes){
            char[] arr = v.toCharArray();
            for(int i=0; i<v.length(); i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add( i);
            }
        }

        List<Map.Entry<Character, List<Integer>>> list = map.entrySet().stream().sorted((en1, en2)->{
            List<Integer> val1 = en1.getValue();
            List<Integer> val2 = en2.getValue();
            Collections.sort(val1);
            Collections.sort(val2);
            for(int i=0; i<val1.size(); i++){
                if(val1.get(i) != val2.get(i))
                    return val1.get(i).compareTo(val2.get(i));
            }
            return en1.getKey().compareTo(en2.getKey());
        }).collect(Collectors.toList());

        StringBuilder res = new StringBuilder();
        list.stream().forEach(e->res.append(e.getKey()));
        return res.toString();
    }


}

// finish at 2020/3/1 13:18