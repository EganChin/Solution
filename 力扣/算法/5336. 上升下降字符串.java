//2020-03-07 22:31:35
class Solution {

    public String sortString(String s) {
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        Collections.sort(list);

        String ans = "";
        Character cur = null;
        int len = list.size();
        while (list.size() != 0 && ans.length() < len) {
            if(cur == null && list.size() > 0){
                cur = list.get(0);
                list.remove(cur);
            }
            while (cur != null) {
                ans += cur;
                cur = getMin(list, cur);
            }

            if(cur == null && list.size() > 0){
                cur = list.get(list.size()-1);
                list.remove(cur);
            }
            while (cur != null) {
                ans += cur;
                cur = getMax(list, cur);
            }
        }

        return ans;
    }

    Character getMin(List<Character> list, Character cur) {
        for (int i = 0; i < list.size(); i++) {
            Character s = list.get(i);
            if (s>cur) {
                list.remove(s);
                return s;
            }
        }
        return null;
    }

    Character getMax(List<Character> list, Character cur) {
        for (int i = list.size() - 1; i >= 0; i--) {
            Character s = list.get(i);
            if (s < cur) {
                list.remove(s);
                return s;
            }
        }
        return null;
    }


}

//2020-03-07 23:49:56