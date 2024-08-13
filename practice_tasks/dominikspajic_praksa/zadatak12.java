import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.util.HashMap;
import java.util.Map;

public class zadatak12 {
    public static void main(String[] args){

        System.out.print("Unesite datoteku: ");
        Scanner dataInput = new Scanner(System.in);
        String dataSelected = dataInput.nextLine();
        dataInput.close();

        File selectedFile = new File(dataSelected);

        HashMap<String, Integer> totalData = new HashMap<String, Integer>();

        try {
            Scanner readFile = new Scanner(selectedFile);
            while(readFile.hasNextLine()){
                String data = readFile.nextLine();
                for( String word : data.split(" ")){

                    if(totalData.get(word) == null){
                        totalData.put(word, 1);
                    }
                    else{
                        int newValue = totalData.get(word) + 1;
                        totalData.put(word, newValue);
                    }
                }
            }
            readFile.close();
            
            System.out.println("");
            System.out.println("U datoteci " + selectedFile.getName() + " nalaze se sljedece rijeci: ");
            System.out.println("------------------------");
            System.out.println("Rijec (broj ponavljanja)");
            System.out.println("------------------------");

            for(Map.Entry<String, Integer> entry : totalData.entrySet()){
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key + " (" + value + ")");
            }

            System.out.println("------------------------");

        }
        catch(FileNotFoundException e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
