//2020-03-18 20:31:32
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        return calculate(s.toCharArray(), 0, s.length());
    }

    public int calculate(char[] s, int start, int end) {
        int num = 0;
        for (int i = start; i < end; i++) {
            switch (s[i]) {
                case '+':
                case '-':
                    int op = i++;
                    //找到下一个加减符号
                    while (i < s.length && s[i] != '+' && s[i] != '-') {
                        i++;
                    }
                    int num2 = calculate(s, op + 1, i);
                    num = (s[op] == '+') ? num + num2 : num - num2;
                    i--;
                    break;
                case '/':
                case '*':
                    op = i++;
                    //找到下一个运算符号
                    while (i < s.length && s[i] >= '0' && s[i] <= '9') {
                        i++;
                    }
                    num2 = calculate(s, op + 1, i);
                    num = (s[op] == '*') ? num * num2 : num / num2;
                    i--;
                    break;
                default:
                    num = num * 10 + (s[i] - '0');
            }
        }
        return num;
    }
}
//2020-03-18 21:28:27