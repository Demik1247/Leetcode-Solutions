import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0, startC = 0;
        int litterCount = 0;

        // Give every litter an index
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        /*
         * State:
         * row
         * col
         * energy
         * mask
         */
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{startR, startC, energy, 0});

        /*
         * visited[row][col][energy][mask]
         *
         * energy can be from 0 to energy
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        visited[startR][startC][energy][0] = true;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // Process one BFS level = one number of moves
            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int currEnergy = curr[2];
                int mask = curr[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // Cannot make a move with 0 energy
                    if (currEnergy == 0) {
                        continue;
                    }

                    int newEnergy = currEnergy - 1;

                    // Collect litter
                    int newMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    // Reset energy
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.offer(new int[]{
                                nr,
                                nc,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}