class Solution {
    public int evalRPN(String[] tokens) {

        int result = 0;

        Stack<Integer> tempStack = new Stack();

        for(int i = 0; i < tokens.length; i++) {

            String str = tokens[i];
            
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int a = Integer.valueOf(tempStack.pop());
                int b = Integer.valueOf(tempStack.pop());
                tempStack.push(getValue(b,str,a));
            } else {
                tempStack.push(Integer.valueOf(str));
            }
        }
        return tempStack.pop();

    }

    private int getValue(int result, String oprn, int value) {
        
        if(oprn.equals("+")) {
            result += value;
        } else if(oprn.equals("-")) {
            result -= value;
        } else if(oprn.equals("*")) {
            result *= value;
        }  else if(oprn.equals("/")) {
            result /= value;
        } else {
            return 0;
        }

        return result;
    }
}
