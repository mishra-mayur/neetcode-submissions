class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList();

        Stack<Double> stack = new Stack();

        for(int i = 0; i < position.length; i++) {
            list.add(new Pair(position[i], speed[i]));
        }

        Collections.sort(list, (a,b) -> b.key - a.key);

        for(Pair pair : list) {
            stack.push((double)(target - pair.key) / pair.value);

            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        
        return stack.size();

    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "{ key : "+key+" , value : "+value+" }";
    }
}
