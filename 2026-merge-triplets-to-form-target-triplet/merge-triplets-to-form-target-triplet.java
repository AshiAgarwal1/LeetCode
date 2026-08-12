class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;
//we dont change x,y,z values in loop , they continue their value to next iteration
        for (int[] t : triplets) {
            // Can this triplet give us target[0]?
            if (t[0] == target[0] &&
                t[1] <= target[1] &&
                t[2] <= target[2]) {
                x = true;
            }
            // Can this triplet give us target[1]?
            if (t[0] <= target[0] &&
                t[1] == target[1] &&
                t[2] <= target[2]) {
                y = true;
            }
            // Can this triplet give us target[2]?
            if (t[0] <= target[0] &&
                t[1] <= target[1] &&
                t[2] == target[2]) {
                z = true;
            }
        }
        return x && y && z;
    }
}