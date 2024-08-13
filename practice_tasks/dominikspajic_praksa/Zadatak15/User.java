package Zadatak15;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class User {
    File data = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/podaci.txt");

    String userName;
    String userRole;

    public User(String userName, String userRole){
        this.userName = userName;
        this.userRole = userRole;
    }

    public void UI(){
        System.out.println("WELCOME " + userName + "("+ userRole +")");
        System.out.print("Odaberite zeljenu radnju: ");
        System.out.println("");

        System.out.println("1.VIEW EMPLOYEE");
        System.out.println("2.VIEW TASKS");

        Scanner actionInput = new Scanner(System.in);
        Integer scannedInput = actionInput.nextInt();

        if(scannedInput == 1){
            viewEmployeeUI();
        }

        actionInput.close();
    }

    public void viewEmployeeUI(){
        System.out.println("Prikaz svih zaposlenika (OIB/Ime/Prezime/Radno mjesto)");
        System.out.println("");
        try{
            Scanner reader = new Scanner(data);
            while (reader.hasNextLine()) {
                String zaposlenik = reader.nextLine();
                System.out.println(zaposlenik);
                System.out.println("");
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        
    }
}

