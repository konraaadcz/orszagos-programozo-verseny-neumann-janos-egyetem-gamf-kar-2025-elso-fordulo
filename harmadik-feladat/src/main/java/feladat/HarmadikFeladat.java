package feladat;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;



public class HarmadikFeladat {



    public static void main(String[] args) throws IOException {



        List<String> sorok = Files.readAllLines(Paths.get("harmadik-feladat/src/main/resources/terkep.txt"));
        int n = 30;
        int[][] terkep = new int[n][n];




        for (int i = 0; i < n; i++) {
            String[] reszek = sorok.get(i).trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                terkep[i][j] = Integer.parseInt(reszek[j]);
            }
        }





        int huszonegy = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (terkep[i][j] == 21) huszonegy++;
        System.out.println("a) 21-es számok: " + huszonegy);





        boolean[][] vizes = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (terkep[i][j] == 21 && !vizes[i][j])
                    folytViz(terkep, vizes, i, j);




        int osszesVizes = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (vizes[i][j]) osszesVizes++;



        System.out.println("b) Összes vizes pont: " + osszesVizes);




        int kicsiVizes = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (vizes[i][j] && terkep[i][j] < 10) kicsiVizes++;
        System.out.println("c) Vizes pontok magasság < 10: " + kicsiVizes);
    }





    public static void folytViz(int[][] t, boolean[][] v, int i, int j) {


        int n = t.length;
        if (v[i][j]) return;
        v[i][j] = true;



        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};



        for (int d = 0; d < 4; d++) {



            int ni = i + di[d];
            int nj = j + dj[d];


            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {

                if (t[ni][nj] <= t[i][j]) {

                    folytViz(t, v, ni, nj);


                }
            }
        }
    }
}
