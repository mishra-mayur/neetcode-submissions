class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                if(stack.isEmpty())
                    return false;
                if(chars[i] == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if(chars[i] == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(chars[i] == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
