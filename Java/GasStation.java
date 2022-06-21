class Solution {
    // O(n) solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int index = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                index = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? index : -1;
    }
}

// less efficient, unnecesary nested while loops
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         int i = 0;
//         while (i < n) {
//             int tank = 0;
//             int j = i;
//             while (j < i + n) {
//                 tank += gas[j % n] - cost[j % n];
//                 if (tank < 0) {
//                     i = j;
//                     break;
//                 }
//                 if (j == i + n - 1 && tank >= 0) {
//                     return i;
//                 }
//                 j++;
//             }
//             i++;
//         }
//         return -1;
//     }
// }

// brute force solution O(n^2)
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int totalGas = 0;
//         int totalCost = 0;
//         int tank = 0;
//         int index = 0;
        
//         for (int i = 0; i < gas.length; i++) {
//             totalGas += gas[i];
//             totalCost += cost[i];
//             tank += gas[i] - cost[i];
//             if (tank < 0) {
//                 index = i + 1;
//                 tank = 0;
//             }
//         }
//         return totalGas >= totalCost ? index : -1;
//     }
// }