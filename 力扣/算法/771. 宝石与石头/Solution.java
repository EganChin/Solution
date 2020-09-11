
/*
771. 宝石与石头 re.0 i E
T: 2020-09-11 13:50:29 - 

Q: 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。

A:使用hashset去重判断
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for(Character ch : J.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for(Character ch : S.toCharArray()){
            if(set.contains(ch)){
                count++;
            } 
                
        }
        return count;
    }
}
//2020-09-11 13:55:01 EW
//2020-09-11 14:04:06 AC