package com.challenges

import spock.lang.Specification


/*
You are in charge of preparing a recently purchased lot for one of Amazon's new building.
The lot is covered with trenches and has a single obstacle that needs to be taken down before the foundation can be prepared for the building.
The demolition robot must remove the obstacle before progress can be made on the building.

Write an algorithm to determine the minimum distance required for the demolition robot to remove the obstacle.

1. The lot is flat, except for trenches, and can be represented as a 2-D grid.
2. The demolition robot must start from top left corner of the lot, which is always flat and can move one block up, down, right or left at a time.
3. The demolition robot cannot enter trenches and cannot leave the lot.
4. The flat areas are represented as 1, areas with trenches as 0 and obstacle by 9.

Solution:
Sum of row x times + column x times where lot[row][col] == 9 is found will given minimum distance.
Complexity: O(x*y)
 */

class CalculateRemoveObstacleTest extends Specification{

    def "Should calculate the minimum distance to remove the obstacle"(){

        given: "3 rows, 3 columns and lot [[1, 0, 0], [1, 0, 0], [1, 9, 1]]"

            Integer numRows = 3;
            Integer numColumns = 3;
            List<List<Integer>> lot = [[1, 0, 0], [1, 0, 0], [1, 9, 1]];

        when: "Call Service"

            Integer removeObstacle = AWSService.removeObstacle(numRows, numColumns, lot);

        then: "The minimum distance is equal 3"

            3 == removeObstacle;
    }

    def "Should calculate the minimum distance to remove the obstacle 2"(){

        given: "5 rows, 4 columns and lot [[1, 1, 1, 1], [0, 1, 1, 1], [0, 1, 0, 1], [1, 1, 9, 1], [0, 0, 1, 1]]"

            Integer numRows = 5;
            Integer numColumns = 4;
            List<List<Integer>> lot = [[1, 1, 1, 1], [0, 1, 1, 1], [0, 1, 0, 1], [1, 1, 9, 1], [0, 0, 1, 1]];

        when: "Call Service"

            Integer removeObstacle = AWSService.removeObstacle(numRows, numColumns, lot);

        then: "The minimum distance is equal 5"

            5 == removeObstacle;
    }

    def "Should not enter trenches"(){

        given: "0 rows, 0 columns and lot [[]]"

            Integer numRows = 0;
            Integer numColumns = 0;
            List<List<Integer>> lot = [[]];

        when: "Call Service"

           Integer removeObstacle = AWSService.removeObstacle(numRows, numColumns, lot);

        then: "return -1"

            -1 == removeObstacle;
    }

}

class AWSService{

    static Integer removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
        int[][] grid = new int[numRows][numColumns];
        boolean[][] visited = new boolean[numRows][numColumns];

        for(int i = 0  ;i < lot.size(); i++) {
            List<Integer> sub = lot.get(i);
            for(int j = 0 ; j < sub.size(); j++) {
                grid[i][j] = lot.get(i).get(j);
            }
        }

        int count = 0;

        List<List<Integer>>  directions = [[1,0], [-1,0], [0, 1], [0, -1]];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer([0,0]);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ;i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];

                if(row < 0 || column < 0 || row >= numRows || column>= numColumns || grid[row][column] == 0 || visited[row][column]) {
                    continue;
                }

                visited[row][column] = true;
                if(grid[row][column] == 9) {
                    return count;
                }

                for(int[] dir : directions) {
                    int nr = dir[0] + row;
                    int nc = dir[1] + column;
                    queue.offer([nr, nc]);
                }
            }
            count++;
        }
        return -1;



//        if (numRows < 1 || numColumns < 1)
//            return -1
//
//        for (Integer row = 0; row < numRows; row++) {
//            for (Integer col = 0; col < numColumns; col++) {
//                if (lot[row][col] == 9)
//                    return row + col
//            }
//        }
//        return -1;
    }

}
