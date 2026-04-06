class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDist = 0;
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add((long) obs[0] * 60001 + obs[1]);
        }
        int xCod = 0;
        int yCod = 0;
        int sign = 1;
        char active = 'y';
        boolean faceN = true;
        boolean faceE = false;
        boolean faceS = false;
        for (int com : commands) {
            if (com < 0) {
                if (com == -1) {
                    if (faceN) {
                        faceN = false;
                        faceE = true;
                        active = 'x';
                        sign = 1;
                    } else if (faceE) {
                        faceE = false;
                        faceS = true;
                        active = 'y';
                        sign = -1;
                    } else if (faceS) {
                        faceS = false;
                        active = 'x';
                        sign = -1;
                    } else {
                        faceN = true;
                        active = 'y';
                        sign = 1;
                    }
                }

                if (com == -2) {
                    if (faceN) {
                        faceN = false;
                        active = 'x';
                        sign = -1;
                    } else if (faceE) {
                        faceE = false;
                        faceN = true;
                        active = 'y';
                        sign = 1;
                    } else if (faceS) {
                        faceS = false;
                        faceE = true;
                        active = 'x';
                        sign = 1;
                    } else {
                        faceS = true;
                        active = 'y';
                        sign = -1;
                    }
                }
            } else {
                if (active == 'y') {
                    while (com > 0) {
                        yCod = yCod + (sign);
                        com--;
                        if (obstacleSet.contains((long) xCod * 60001 + yCod)) {
                            yCod -= sign;
                            break;
                        }
                    }
                } else {
                    while (com > 0) {
                        xCod = xCod + (sign);
                        com--;
                        if (obstacleSet.contains((long) xCod * 60001 + yCod)) {
                            xCod -= sign;
                            break;
                        }
                    }
                }
            }
            maxDist = Math.max(maxDist, (xCod * xCod + yCod * yCod));
        }
        return maxDist;
    }
}