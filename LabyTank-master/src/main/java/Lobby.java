public class Lobby {
    private String name;
    private int currentCount;
    private int max;
    private int[][] a = new int[8][11];

    public Lobby(String name, int currentCount, int max, int q) {
        this.name = name;
        this.currentCount = currentCount;
        this.max = max;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 11; j++) {
                a[i][j] = 0;
            }
        }
        if (q == 0) {
            a[0][2] = 10;
            a[1][2] = 10;
            a[7][4] = 10;
            a[7][7] = 10;
            a[1][5] = 10;
            a[1][7] = 1;
            a[1][8] = 1;
            a[2][0] = 1;
            a[2][1] = 1;
            a[2][2] = 1;
            a[2][7] = 10;
            a[3][2] = 1;
            a[3][3] = 1;
            a[3][5] = 11;
            a[3][7] = 11;
            a[3][8] = 1;
            a[4][4] = 10;
            a[4][9] = 1;
            a[5][1] = 1;
            a[5][4] = 10;
            a[5][8] = 1;
            a[5][9] = 10;
            a[6][5] = 10;
            a[7][5] = 10;
            a[7][9] = 10;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int[][] getA() {
        return a;
    }

    public int getMax() {
        return max;
    }
}
