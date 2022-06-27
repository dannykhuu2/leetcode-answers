import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] coordinates = new int[2*buildings.length][3];
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int maxHeight = 0;
        int i = 0;
        maxPQ.add(0);
        
        for (int[] building : buildings) {
            coordinates[i][0] = building[0];
            coordinates[i][1] = building[2];
            coordinates[i][2] = 1;
            coordinates[i + 1][0] = building[1];
            coordinates[i + 1][1] = building[2];
            coordinates[i + 1][2] = 0;
            i += 2;
        }

        Arrays.sort(coordinates, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[2] - a[2];
            }
        });
        
        for (int[] coordinate : coordinates) {
            if (coordinate[2] == 1) {
                maxPQ.add(coordinate[1]);
            } else {
                maxPQ.remove(coordinate[1]);
            }
            
            int currentHeight = maxPQ.peek();
            
            if (currentHeight != maxHeight) {
                if (set.add(coordinate[0])) {
                    result.add(Arrays.asList(coordinate[0], currentHeight));
                } else {
                    result.set(result.size() - 1, Arrays.asList(coordinate[0], currentHeight));
                } 
                maxHeight = currentHeight;
            }
        }
        
        return result;
        
    }
}