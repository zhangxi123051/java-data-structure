package com.tencent.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class S54 {


    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }
    }


    class Solution3 {

        public int[] antiSpiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int[] res = new int[matrix[0].length*matrix.length-1];

            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            //int[] res = new int[(r + 1) * (b + 1)];
            while(true) {
                for(int i = t; i <=b; i++) res[x++] = matrix[i][l]; // top  to bottom.
                if(++l > r) break;

                for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
                if(++t > b) break;

                for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
                if(l > --r) break;

                for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
                if(t > --b) break;

            }
            return res;
        }

        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int[] res = new int[matrix[0].length*matrix.length-1];

            int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
            //int[] res = new int[(r + 1) * (b + 1)];
            while(true) {
                for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
                if(++t > b) break;
                for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
                if(l > --r) break;
                for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
                if(t > --b) break;
                for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
                if(++l > r) break;
            }
            return res;
        }
    }


    class Solution2 {


        /*
        逆时针
         */
        public List<Integer> antiSpiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                for (int column = left; column <= right; column++) {
                    order.add(matrix[top][column]);
                }
                for (int row = top + 1; row <= bottom; row++) {
                    order.add(matrix[row][right]);
                }
                if (left < right && top < bottom) {
                    for (int column = right - 1; column > left; column--) {
                        order.add(matrix[bottom][column]);
                    }
                    for (int row = bottom; row > top; row--) {
                        order.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
