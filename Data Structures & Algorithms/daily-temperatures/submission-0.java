class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nextGreater = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for(int i = temperatures.length - 1; i>=0; i--) {

            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            nextGreater[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        return getResult(temperatures, nextGreater);
    }

    private int[] getResult(int[] temperatures, int[] nextGreater) {
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            result[i] = nextGreater[i] == 0 ? 0 : nextGreater[i] - i;
        }
        return result;
    }
}
