package feladat;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class ElsoFeladat {

    public static void main(String[] args) throws IOException {



        String tartalom = "";
        for (String sor : Files.readAllLines(Paths.get("elso-feladat/src/main/resources/karsor.txt"))) {
            tartalom = tartalom + sor;
        }




        feladatA(tartalom);
        feladatB(tartalom);
        feladatC(tartalom);



    }

    public static void feladatA(String szoveg) {




        int maxHossz = 0;
        char elso = ' ';
        char masodik = ' ';




        for (char c1 = 'a'; c1 <= 'd'; c1++) {

            for (char c2 = (char)(c1 + 1); c2 <= 'd'; c2++) {


                int hossz = 0;
                int maxPar = 0;



                for (int i = 0; i < szoveg.length(); i++) {



                    char ch = szoveg.charAt(i);
                    if (ch == c1 || ch == c2) {
                        hossz = hossz + 1;

                    } else {

                        if (hossz > maxPar) maxPar = hossz;
                        hossz = 0;


                    }
                }



                if (hossz > maxPar) maxPar = hossz;

                if (maxPar > maxHossz) {

                    maxHossz = maxPar;
                    elso = c1;
                    masodik = c2;


                }
            }
        }


        System.out.println("" + elso + masodik + maxHossz);


    }

    public static void feladatB(String szoveg) {


        int db = 0;

        for (int i = 0; i < szoveg.length(); i++) {


            if (szoveg.charAt(i) == 'a') {

                for (int j = i + 1; j < szoveg.length(); j++) {

                    if (szoveg.charAt(j) == 'b') {

                        for (int k = j + 1; k < szoveg.length(); k++) {


                            if (szoveg.charAt(k) == 'c') {


                                db = db + 1;


                            }
                        }
                    }
                }
            }
        }


        System.out.println(db);



    }

    public static void feladatC(String szoveg) {


        int x = 0;
        int y = 0;



        for (int i = 0; i < szoveg.length(); i++) {


            char ch = szoveg.charAt(i);


            if (ch == 'a') y = y + 1;
            if (ch == 'b') x = x + 1;
            if (ch == 'c') y = y - 1;
            if (ch == 'd') x = x - 1;



        }


        double t = Math.sqrt(x * x + y * y);
        System.out.println(Math.round(t));



    }
}
