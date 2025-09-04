
package feladat;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;




public class MasodikFeladat {


    public static void main(String[] args) throws IOException {


        String szoveg = new String(Files.readAllBytes(Paths.get("masodik-feladat/src/main/resources/szoveg.txt")));
        szoveg = szoveg.replaceAll("\\s+", " ").trim();




        String[] szavak = szoveg.split(" ");
        String leghosszabbSzo = "";
        for (String szo : szavak) {
            if (mindenKarakterEgyedi(szo) && szo.length() > leghosszabbSzo.length()) {
                leghosszabbSzo = szo;
            }
        }





        System.out.println("a) Leghosszabb egyedi karakteres szó: " + leghosszabbSzo);




        int maxTavolsag = 0;
        int tavolsag = 0;
        boolean elsoNelvoMegvolt = false;



        for (String szo : szavak) {
            if (szo.equals("A") || szo.equals("AZ")) {
                if (elsoNelvoMegvolt) {
                    if (tavolsag > maxTavolsag) maxTavolsag = tavolsag;
                }
                tavolsag = 0;
                elsoNelvoMegvolt = true;
            } else {
                tavolsag += szo.length() + 1;
            }
        }




        System.out.println("b) Legnagyobb távolság névelők között: " + maxTavolsag);





        Set<String> palindromok = new HashSet<>();
        for (String szo : szavak) {
            if (szo.length() >= 2 && szo.equals(new StringBuilder(szo).reverse().toString())) {
                palindromok.add(szo);
            }
        }

        System.out.println("c) Palindrom szavak száma: " + palindromok.size());

    }






    public static boolean mindenKarakterEgyedi(String szo) {


        Set<Character> karakterek = new HashSet<>();
        for (char c : szo.toCharArray()) {
            if (!karakterek.add(c)) return false;
        }
        return true;


    }
}
