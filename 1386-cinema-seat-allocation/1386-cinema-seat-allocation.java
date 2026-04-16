class Solution {
    public int maxNumberOfFamilies(int n, int[][] res) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();
        for (int[] seat : res) {
            reserved.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }
        int total = 2 * n;

        for (Set<Integer> seats : reserved.values()) {
            boolean leftFree = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
            boolean middleFree = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);
            boolean rightFree = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);

            if (leftFree && rightFree) {
                
            }
            else if (leftFree || middleFree || rightFree) {
                total -= 1;
            }
            else {
                total -= 2;
            }
        }
        return total;
    }
}