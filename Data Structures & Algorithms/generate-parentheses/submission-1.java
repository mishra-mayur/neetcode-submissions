class Solution {
    public List<String> generateParenthesis(int n) {
        String paran = getParenthesis(n);
        //System.out.println("paranthesis : "+paran);
        char[] chars = paran.toCharArray();
        Set<String> result = new HashSet();
        List<Character> current = new ArrayList();

        backtrack(result, current, chars, 0, n);

        return new ArrayList(result);
    }

    private String getParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("()");
        }
        return sb.toString();
    }

    private void backtrack(
        Set<String> result, List<Character> current, char[] chars, int start, int n) {

        // System.out.println("result : "+result+" current : "+current+ " chars : "+Arrays.toString(chars));
        if (current.size() == 2 * n) {
            // System.out.println("current : "+current+" valid : "+isValidParenthesis(current));
            if (isValidParenthesis(current))
                result.add(getConcatenatedString(current));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            current.add(chars[i]);
            backtrack(result, current, chars, i, n);
            current.remove(current.size() - 1);
        }
    }

    private String getConcatenatedString(List<Character> current) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            sb.append(current.get(i));
        }
        return sb.toString();
    }

    private boolean isValidParenthesis(List<Character> current) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < current.size(); i++) {
            if (current.get(i) == '(') {
                stack.push(current.get(i));
            } else if (current.get(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
