package Zadatak15;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;  
import java.io.IOException;


public class Superuser extends User{
    File data = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/podaci.txt");

    public Superuser(String userName, String userRole){
        super(userName,userRole);
    }

    public void UI(){
        System.out.println("WELCOME " + userName + "("+ userRole +")");
        System.out.print("Odaberite zeljenu radnju: ");
        System.out.println("");

        System.out.println("1.POST EMPLOYEE");
        System.out.println("2.VIEW EMPLOYEES");

        System.out.println("3.POST TASK");
        System.out.println("4.VIEW TASK");
        Scanner actionInput = new Scanner(System.in);
        Integer scannedInput = actionInput.nextInt();
        
        
        if(scannedInput == 1){
            postEmployeeUI();
        }

        else if(scannedInput == 2){
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

    public void postEmployeeUI(){
        System.out.print("Unesite ime: ");
        Scanner nameInput = new Scanner(System.in);
        String scannedName = nameInput.nextLine();
        System.out.println("");
        

        System.out.print("Unesite prezime: ");
        Scanner surnameInput = new Scanner(System.in);
        String scannedSurname = surnameInput.nextLine();
        System.out.println("");
        

        System.out.print("Unesite radno mjesto: ");
        Scanner workInput = new Scanner(System.in);
        String scannedWork = workInput.nextLine();
        System.out.println("");
        

        System.out.print("Unesite OIB: ");
        Scanner oibInput = new Scanner(System.in);
        Long scannedOib = oibInput.nextLong();
        System.out.println("");
        

        postEmployee(scannedName, scannedSurname, scannedWork, scannedOib);

        nameInput.close();
        surnameInput.close();
        workInput.close();
        oibInput.close();
    }

    public void postEmployee(String firstName, String lastName, String workPlace, Long OIB){
        String oibString = Long.toString(OIB);
        String dataInsert = oibString + "/" + firstName + "/" + lastName + "/" + workPlace;

        try{
            FileWriter writer = new FileWriter(data, true);
            writer.write(dataInsert);
            writer.write("\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
      
    }


}
