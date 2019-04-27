package org.gmnz.hackerrank;

import java.util.Arrays;

/**
 * QueensAttack2
 */
public class QueensAttack2 {

    private static int Rq;
    private static int Cq;

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        Rq = r_q;
        Cq = c_q;
        int[] obstacle;
        int[] obstacleDistances = new int[9]; // uso gli indici 1..8

        for (int i = 1; i < obstacleDistances.length; i++) {
            switch (i) {
            case 1:
                obstacleDistances[i] = n - Rq;
                break;
            case 2:
                obstacleDistances[i] = Math.min(n - Rq, n - Cq);
                break;
            case 3:
                obstacleDistances[i] = n - Cq;
                break;
            case 4:
                obstacleDistances[i] = Math.min(Rq - 1, n - Cq);
                break;
            case 5:
                obstacleDistances[i] = Rq - 1;
                break;
            case 6:
                obstacleDistances[i] = Math.min(Rq - 1, Cq - 1);
                break;
            case 7:
                obstacleDistances[i] = Cq - 1;
                break;
            case 8:
                obstacleDistances[i] = Math.min(n - Rq, Cq - 1);
                break;
            }

        }

        for (int o = 0; o < k; o++) {
            obstacle = obstacles[o];
            int obstacleRegion = findObstaclePosition(obstacle[0], obstacle[1]);
            int oDistance;
            switch (obstacleRegion) {
            case 0:
                // l'ostacolo non è in traiettoria della regina
                // quindi continuo col prossimo
                continue;
            case 1:
                oDistance = Math.abs(obstacle[0] - Rq);
                if (oDistance < obstacleDistances[1]) {
                    obstacleDistances[1] = Math.max(oDistance - 1, 0);
                }
                break;
            case 2:
                oDistance = Math.abs(obstacle[0] - Rq);
                if (oDistance < obstacleDistances[2]) {
                    obstacleDistances[2] = Math.max(oDistance - 1, 0);
                }
                break;
            case 3:
                oDistance = Math.abs(obstacle[1] - Cq);
                if (oDistance < obstacleDistances[3]) {
                    obstacleDistances[3] = Math.max(oDistance - 1, 0);
                }
                break;
            case 4:
                oDistance = Math.abs(obstacle[1] - Cq);
                if (oDistance < obstacleDistances[4]) {
                    obstacleDistances[4] = Math.max(oDistance - 1, 0);
                }
                break;
            case 5:
                oDistance = Math.abs(obstacle[0] - Rq);
                if (oDistance < obstacleDistances[5]) {
                    obstacleDistances[5] = Math.max(oDistance - 1, 0);
                }
                break;
            case 6:
                oDistance = Math.abs(obstacle[0] - Rq);
                if (oDistance < obstacleDistances[6]) {
                    obstacleDistances[6] = Math.max(oDistance - 1, 0);
                }
                break;
            case 7:
                oDistance = Math.abs(obstacle[1] - Cq);
                if (oDistance < obstacleDistances[7]) {
                    obstacleDistances[7] = Math.max(oDistance - 1, 0);
                }
                break;
            case 8:
                oDistance = Math.abs(obstacle[1] - Cq);
                if (oDistance < obstacleDistances[8]) {
                    obstacleDistances[8] = Math.max(oDistance - 1, 0);
                }
                break;
            }
        }
        int allowedPositions = 0;
        for (int i = 1; i < obstacleDistances.length; i++) {
            allowedPositions += obstacleDistances[i];
        }
        return allowedPositions;
    }

    private static int findObstaclePosition(int r_o, int c_o) {
        if (r_o == Rq) {
            // stessa riga ==> a seconda della colonna dico a destra o a sinistra
            return c_o > Cq ? 3 : 7;
        }
        if (c_o == Cq) {
            // stessa colonna ==> a seconda della riga dico sopra o sotto
            return r_o > Rq ? 1 : 5;
        }
        if (Math.abs(c_o - Cq) != Math.abs(r_o - Rq)) {
            // l'ostacolo non è sulla diagonale
            return 0;
        }
        // a questo punto l'ostacolo è sulla diagonale della regina
        if (c_o > Cq) {
            // parte destra della scacchiera
            // ==> a seconda della riga dico diagonale alta o bassa
            return r_o > Rq ? 2 : 4;
        } else {
            // parte sinistra della scacchiera
            // ==> a seconda della riga dico diagonale alta o bassa
            return r_o > Rq ? 8 : 6;
        }
    }

    public static void main(String[] args) {
        /*
         * 5 3 4 3 5 5 4 2 2 3
         */

        int[][] obstacles = new int[3][2];
        obstacles[0] = new int[] { 5, 5 };
        obstacles[1] = new int[] { 4, 2 };
        obstacles[2] = new int[] { 2, 3 };

        System.out.println(QueensAttack2.queensAttack(5, 3, 4, 3, obstacles));
    }
}