import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 


public class zadatak10 {
    public static void main(String[] args){
        System.out.print("Unesite frazu koju zelite pronaci: ");
        Scanner phraseInput = new Scanner(System.in);
        String myPhrase = phraseInput.nextLine();
        phraseInput.close();
        System.out.print("Trazimo frazu: ");
        System.out.println(myPhrase);

        File path = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/podaci");
        File [] files = path.listFiles();

        for(int i = 0; i < files.length; i++){
            try {
                File currFile = files[i];
                Scanner myReader = new Scanner(currFile);
                while(myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    if(data.equals(myPhrase)){
                        System.out.print("Fraza se nalazi u file-u: ");
                        System.out.println(currFile.getName());
                    }
                }
                myReader.close();
            }
            catch(FileNotFoundException e){
                System.out.println("Error!");
                e.printStackTrace();
            }
        }
    }

}
