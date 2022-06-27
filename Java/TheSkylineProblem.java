import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] coordinates = new int[2*buildings.length][3];
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int maxHeight = 0;
        int i = 0;
        queue.put(0, 1);
        
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
                return (a[2] == 1 ? -a[1] : a[1]) - (b[2] == 1 ? -b[1] : b[1]);
            }
        });
        
        for (int[] coordinate : coordinates) {
            if (coordinate[2] == 1) {
                queue.compute(coordinate[1], (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else {
                queue.compute(coordinate[1], (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }
            
            int currentHeight = queue.lastKey();
            
            if (currentHeight != maxHeight) {
                result.add(Arrays.asList(coordinate[0], currentHeight));
                maxHeight = currentHeight;
            }
        }
        
        return result;
        
    }
}