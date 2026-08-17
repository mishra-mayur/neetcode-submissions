class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance , b.distance));

        for (int i = 0; i < points.length; i++) {
            pq.add(new Pair(getDistance(points[i]), points[i]));
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++) {
            Pair pair = pq.poll();
            result[i][0] = pair.points[0];
            result[i][1] = pair.points[1];
        }
        return result;
    }

    private long getDistance(int[] point) {
         return point[0] * point[0] + point[1] * point[1];
    }
}

class Pair {
    long distance;
    int[] points;

    public Pair(long distance, int[] points) {
        this.distance = distance;
        this.points = points;
    }
}
