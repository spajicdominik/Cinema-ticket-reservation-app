package Zadatak15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.IOException;
import java.nio.Buffer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Admin extends User {
    File data = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/podaci.txt");
    File tasks = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/tasks.txt");

    public Admin(String userName, String userRole){
        super(userName, userRole);
    }

    public void UI(){
        System.out.println("WELCOME " + userName + "("+ userRole +")");
        System.out.print("Odaberite zeljenu radnju: ");
        System.out.println("");

        System.out.println("1.POST EMPLOYEE");
        System.out.println("2.DELETE EMPLOYEE");
        System.out.println("3.VIEW EMPLOYEES");
        System.out.println("4.CHANGE EMPLOYEES");

        System.out.println("5.POST TASK");
        System.out.println("6.DELETE TASK");
        System.out.println("7.VIEW TASK");
        System.out.println("8.CHANGE TASK");

        System.out.println("9.WORKPLACE REPORT");
        Scanner actionInput = new Scanner(System.in);
        Integer scannedInput = actionInput.nextInt();
        
        
        if(scannedInput == 1){
            postEmployeeUI();
        }

        else if(scannedInput == 2){
            deleteEmployeeUI();
        }

        else if(scannedInput == 3){
            viewEmployeeUI();
        }

        else if(scannedInput == 4){
            changeEmployeeUI();
        }

        else if(scannedInput == 5){
            postTaskUI();
        }

        else if(scannedInput == 8){
            changeTaskUI();
        }

        else if(scannedInput == 9){
            workplaceReport();
        }

        actionInput.close();
    }

    public void changeTaskUI(){
        Scanner readChange = new Scanner(System.in);
        System.out.print("Molimo unesite naziv zadatka koji zelite izmjeniti: ");
        String changeItem = readChange.nextLine();

        System.out.println("Molimo unesite broj stavke koju zelite izmjeniti");

        System.out.println("1. NAZIV");
        System.out.println("2. OPIS");
        System.out.println("3. TIP");
        System.out.println("4. NAZIV");
        System.out.println("5. TRENUTNI STATUS");
        System.out.println("6. KOMPLEKSNOST");
        System.out.println("7. POTROSENO VRIJEME");
        System.out.println("8. POCETNI DATUM I VRIJEME");
        System.out.println("9. ZAVRSNI DATUM I VRIJEME");

        Integer changeSelect = readChange.nextInt();

        changeTask(changeSelect, changeItem);
        readChange.close();

    }

    public void changeTask(Integer changeSelect, String changeItem){
        Scanner readSelect = new Scanner(System.in);

        switch(changeSelect){
            case 1:
            System.out.print("Unesi novi naziv:");
            String newName = readSelect.nextLine();
            System.out.println("");
            // changeTaskName(newName, changeItem);
        }

        readSelect.close();
    }

    
    public void postTaskUI(){
        Scanner readTask = new Scanner(System.in);
        System.out.println("Molimo unesite detalje zadatka:");
        System.out.print("Naziv: ");
        String scannedName = readTask.nextLine();
        System.out.println("");

        System.out.print("Opis: ");
        String scannedDesc = readTask.nextLine();
        System.out.println("");

        System.out.print("Tip(bug/task): ");
        String scannedType = readTask.nextLine();
        System.out.println("");

        System.out.print("Trenutni status: ");
        String scannedStatus = readTask.nextLine();
        System.out.println("");

        System.out.print("Kompleksnost: ");
        Integer scannedComp = readTask.nextInt();
        System.out.println("");

        readTask.nextLine();

        System.out.print("Potroseno vrijeme (u satima): ");
        Integer scannedSpend = readTask.nextInt();
        System.out.println("");

        readTask.nextLine();

        System.out.print("Pocetni datum i vrijeme (dd/MM/yyyy/HH:mm:ss): ");
        String scannedStart = readTask.nextLine();
        System.out.println("");

        System.out.print("Zavrsni datum i vrijeme (dd/MM/yyyy/HH:mm:ss): ");
        String scannedEnd = readTask.nextLine();
        System.out.println("");

        System.out.print("OIB zaposlenika na ovome zadatku ('exit' za izlazak): ");
        ArrayList<String> scannedEmployees = new ArrayList<String>();
        
        String input;

        while(true) {
            input = readTask.nextLine();

            if(input.equalsIgnoreCase("exit")){
                break;
            }

            scannedEmployees.add(input);
        }

        postTask(scannedName, scannedDesc, scannedType, scannedStatus, scannedComp, scannedSpend, scannedStart, scannedEnd, scannedEmployees);
        readTask.close();
    }

    public void postTask(String scannedName, String scannedDesc, String scannedType, String scannedStatus, Integer scannedComp, Integer scannedSpend, String scannedStart, String scannedEnd, ArrayList<String> scannedEmployees){
        /*DateTimeFormatter toDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy/HH:mm:ss");
        try{
            LocalDateTime start = LocalDateTime.parse(scannedStart, toDateTime);
            LocalDateTime end = LocalDateTime.parse(scannedEnd, toDateTime);
        }
        catch(DateTimeParseException e){
            System.out.println("Invalid date and time!");
        }
        */

        String compString = Integer.toString(scannedComp);
        String spendString = Integer.toString(scannedSpend);
        String employees = "";

        for(int i = 0; i < scannedEmployees.size(); i++){
            if(i == scannedEmployees.size() - 1){
                employees = employees + scannedEmployees.get(i);
            }
            else{
                employees = employees + scannedEmployees.get(i) + ",";
            }
        }


        String dataInsert = scannedName + "|" + scannedDesc + "|" + scannedType + "|" + scannedStatus + "|" + compString + "|" + spendString + "|" + scannedStart + "|" + scannedEnd + "|" + employees;

        try{
            FileWriter writer = new FileWriter(tasks, true);
            writer.write(dataInsert);
            writer.write("\n");
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }

    public void workplaceReport(){
        HashMap<String, Integer> totalData = new HashMap<String, Integer>();

        System.out.println("Ukupan broj radnika na pojedinom radnom mjestu:");
        try{
            Scanner readFile = new Scanner(data);
            while(readFile.hasNextLine()){
                String employee = readFile.nextLine();
                String workPlace = employee.split("/")[3];
                if(totalData.get(workPlace) == null){
                    totalData.put(workPlace, 1);
                }
                else{
                    int newValue = totalData.get(workPlace) + 1;
                    totalData.put(workPlace, newValue);
                }
            }
            readFile.close();
            for(String wPlace : totalData.keySet()){
                Integer wPlaceNum = totalData.get(wPlace);
                if(wPlaceNum == 1){
                    System.out.println(wPlace + " = " + wPlaceNum + " zaposlenik");
                }
                else{
                    System.out.println(wPlace + " = " + wPlaceNum + " zaposlenik");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    

    public void changeEmployeeUI(){
        System.out.print("Unesite OIB zaposlenika na kojem zelite napravit izmjenu: ");
        Scanner oibInput = new Scanner(System.in);
        Long scannedOib = oibInput.nextLong();
        System.out.println("");

        System.out.print("Odaberite zeljenu izmjenu: ");
        System.out.println("");

        System.out.println("1.IME");
        System.out.println("2.PREZIME");
        System.out.println("3.RADNO MJESTO");

        Scanner changeInput = new Scanner(System.in);
        Integer scannedChange = changeInput.nextInt();

        if(scannedChange == 1){
            changeNameUI(scannedOib);
        }

        else if(scannedChange == 2){
            changeSurnameUI(scannedOib);
        }

        else if(scannedChange == 3){
            changeWorkUI(scannedOib);
        }

        oibInput.close();
        changeInput.close();
    }

    public void changeNameUI(Long scannedOib){
        System.out.print("Unesite ime za promjenu: ");
        Scanner nameChange = new Scanner(System.in);
        String scannedNameString = nameChange.nextLine();
        System.out.println("");

        changeName(scannedOib, scannedNameString);
        nameChange.close();
    }

    public void changeSurnameUI(Long scannedOib){
        System.out.print("Unesite prezime za promjenu: ");
        Scanner surnameChange = new Scanner(System.in);
        String scannedSurnameString = surnameChange.nextLine();
        System.out.println("");

        changeSurname(scannedOib, scannedSurnameString);
        surnameChange.close();
    }

    public void changeWorkUI(Long scannedOib){
        System.out.print("Unesite radno mjesto za promjenu: ");
        Scanner workChange = new Scanner(System.in);
        String scannedWorkString = workChange.nextLine();
        System.out.println("");

        changeWork(scannedOib, scannedWorkString);
        workChange.close();
    }

    public void changeName(Long scannedOib, String scannedNameString){
        File tempFile = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/temp.txt");
        String oibString = Long.toString(scannedOib);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(data));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null){
                String trimmedOIB = currentLine.trim().split("/")[0];
                if(trimmedOIB.equals(oibString)){
                    String[] trimmedString = currentLine.trim().split("/");
                    trimmedString[1] = scannedNameString;
                    String newName = String.join("/", trimmedString[0], trimmedString[1], trimmedString[2], trimmedString[3]);
                    writer.write(newName);
                    writer.write("\n");
                }
                else{
                    writer.write(currentLine);
                    writer.write("\n");
                }
            }
            writer.close();
            reader.close();
            tempFile.renameTo(data);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void changeSurname(Long scannedOib, String scannedSurnameString){
        File tempFile = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/temp.txt");
        String oibString = Long.toString(scannedOib);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(data));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null){
                String trimmedOIB = currentLine.trim().split("/")[0];
                if(trimmedOIB.equals(oibString)){
                    String[] trimmedString = currentLine.trim().split("/");
                    trimmedString[2] = scannedSurnameString;
                    String newSurname = String.join("/", trimmedString[0], trimmedString[1], trimmedString[2], trimmedString[3]);
                    writer.write(newSurname);
                    writer.write("\n");
                }
                else{
                    writer.write(currentLine);
                    writer.write("\n");
                }
            }
            writer.close();
            reader.close();
            tempFile.renameTo(data);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void changeWork(Long scannedOib, String scannedWorkString){
        File tempFile = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/temp.txt");
        String oibString = Long.toString(scannedOib);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(data));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null){
                String trimmedOIB = currentLine.trim().split("/")[0];
                if(trimmedOIB.equals(oibString)){
                    String[] trimmedString = currentLine.trim().split("/");
                    trimmedString[3] = scannedWorkString;
                    String newWork = String.join("/", trimmedString[0], trimmedString[1], trimmedString[2], trimmedString[3]);
                    writer.write(newWork);
                    writer.write("\n");
                }
                else{
                    writer.write(currentLine);
                    writer.write("\n");
                }
            }
            writer.close();
            reader.close();
            tempFile.renameTo(data);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void deleteEmployee(Long OIB){
        File tempFile = new File("/Users/dominikspajic/Desktop/ATOS_PRAKSA/Zadaci/Zadatak15/temp.txt");
        String oibString = Long.toString(OIB);

        try{
            BufferedReader reader = new BufferedReader(new FileReader(data));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null){
                String trimmedOIB = currentLine.trim().split("/")[0];
                if(trimmedOIB.equals(oibString)){
                    continue;
                }
                writer.write(currentLine);
                writer.write("\n");
            }
            writer.close();
            reader.close();
            tempFile.renameTo(data);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
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

    public void deleteEmployeeUI(){
        System.out.print("Unesite OIB zaposlenika kojeg zelite izbrisati: ");
        Scanner oibInput = new Scanner(System.in);
        Long scannedOib = oibInput.nextLong();
        System.out.println("");

        deleteEmployee(scannedOib);
        oibInput.close();
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
