import java.util.*;
import java.io.*;
/**
 * Write a description of class FA2019_HashedStructureDemo_Omoyola here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FA2019_HashedStructureDemo_Omoyola
       {
          public static void main(String [] args){
             Scanner keyboard = new Scanner(System.in);
       
              String first_Name,id, last_Name,className, fecthedStd;
              String [] students;
              char grade;
              int userInput, userInput2, userInput3;
              int size = 100;
             
              Student_Omoyola std = null;
              Student_Omoyola fetched,temp,temp3, fetchedStudent;
              Class aClass;
              LQ_Hashed_Omoyola lqHashedList = new LQ_Hashed_Omoyola(size);
              Hashtable<String, Student_Omoyola> table = new Hashtable<String, Student_Omoyola>();
             
       
          do{
             System.out.println(
                    " MAIN MENU – HASHED STRUCTURE – ABIMBOLA OMOYOLA \n"+
                    " 1. LQHashed Structure\n" +
                    " 2. Java Hashtable \n"+
                    " 0. Exit \n"  
                    );
                   userInput = keyboard.nextInt();
                   keyboard.nextLine();
              switch(userInput){
                  //LQHashed Structure
                case 1:
                try {
            
            File file = new File("students.csv");
            Scanner scanner = new Scanner(file);
            
            
            while ( scanner.hasNextLine()) {
                
                
                String fileNames = scanner.nextLine();
                students = fileNames.split(",");
                
                  id = students[0];
                  last_Name = students[1];
                  first_Name =students[2];
                  className =students[3];
                  grade = students[4].charAt(0);
                  
                aClass = new Class(className, grade);
                std = new Student_Omoyola(id, last_Name, first_Name, aClass);
                lqHashedList.insert(std);
                
                
                
            }
            System.out.println("*****************Student File Insert Sucess****************");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
                
                do{
                   
                  System.out.println(
                    " MENU – LQHASHED STRUCTURE – ABIMBOLA OMOYOLA \n"+
                    " 1. Insert Student \n" +
                    " 2. Fetch \n"+
                    " 3. Verify Encapsulation \n" +
                    " 4. Update \n"+
                    " 5. Delete \n" +
                    " 6. Show all \n"+
                    " 0. Exit \n"  
                    );
                    userInput2 = keyboard.nextInt();
                   keyboard.nextLine();
                   switch(userInput2){
                    case 1:
                    //Insert Student
                    System.out.println("Enter Student First Name");
                    first_Name = keyboard.nextLine();
                    System.out.println("Enter Student Last  Name");
                    last_Name = keyboard.nextLine();
                    System.out.println("Enter A Class Name");
                    className = keyboard.nextLine();
                    
                   
                    aClass = new Class(className);
                    std = new Student_Omoyola(last_Name,first_Name,aClass);
                    lqHashedList.insert(std);
                   
                    System.out.println(std.toString());
                    
                   
                    break;
                   
                    case 2:
                    // Fetch Student
                    try{
                        System.out.println("Enter the Student ID Number");
                        fecthedStd = keyboard.nextLine();
                        fetched = lqHashedList.fetch(fecthedStd);
                        // Display found STUDENT
                        System.out.println(fetched.toString());
                     }catch(NullPointerException e){
                       System.out.println("********* Student Cannot be Found ********");  
                    }
                    break;
                   
                    case 3:
                    // Verify Encapsulation
                    //Allow users to type a student id from the keyboard, id
                    System.out.println("Enter Student id");
                    fecthedStd = keyboard.nextLine();
                    //Search in the data structure. If the student is found named it as temp
                    temp =  lqHashedList.fetch(fecthedStd);
                    //-Display message to ask for new last name.
                    System.out.println("Enter a new Last name for student");
                    String newName = keyboard.nextLine();
                    //Modify the last name of the student temp
                    temp.setName(newName);
                    //Fetch from the selected data structure a student with above id; store to fetchedStudent
                    fetchedStudent = lqHashedList.fetch(fecthedStd);
                    
                    // Compare both
                    if(fetchedStudent.getName().equals(temp.getName()))
                    {
                    System.out.println("LQHashed not encapsulasted");
                    }else {
                    System.out.println("LQHashed is encapsulasted");
                    }
                    
                    // Display Fetched Student
                    System.out.println("**********Fectched Student**************");
                    System.out.println(fetchedStudent.toString());
                    // Display temp
                    System.out.println("*****************Edited Student******************");
                    System.out.println(temp.toString());
                    
                    break;
                   
                    case 4:
                    // Update
                       String lname;
                       //Display the message to ask users to enter the student id
                       System.out.println("Enter Student id");
                       fecthedStd = keyboard.nextLine();
                       
                       // Using the student id to fetch the student from the selected data structure to temp3
                        temp3 =  lqHashedList.fetch(fecthedStd);
                        System.out.println(temp3.toString());
                        
                        //Asking users to enter one new last name from the keyboard then change the thisnew information of temp3
                        System.out.println("Enter a new Last name for student");
                        lname = keyboard.nextLine();
                        temp3.setName(lname);
                        lqHashedList.update(fecthedStd, temp3);
                        System.out.println(temp3.toString());
                    break;
                   
                    case 5:
                    // Delete
                    System.out.println("Enter Student id you want to delete");
                    lqHashedList.delete(keyboard.nextLine());
                    break;
                   
                    case 6:
                    // Show All
                    lqHashedList.showAll();
                    break;
                   
                    }
                }while(userInput2 != 0);
                    lqHashedList.toFile("students.csv");
                break;
               
                 
                case 2:
                //JAVA HASHTABLE
                     try {
            
            File file = new File("students.csv");
            Scanner scanner = new Scanner(file);
            
            
            while (scanner.hasNextLine()) {
                
                
                String fileNames = scanner.nextLine();
                students = fileNames.split(",");
                
                  id =         students[0];
                  last_Name =  students[1];
                  first_Name = students[2];
                  className =  students[3];
                  grade =      students[4].charAt(0);
                  
                aClass = new Class(className, grade);
                std = new Student_Omoyola(id, last_Name, first_Name, aClass);
                table.put(id, std);
                 
                
                
            }
            System.out.println("*****************Student File Insert Sucess****************");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
                do{
                  System.out.println(
                    " MENU – JAVA HASTABLE STRUCTURE – ABIMBOLA OMOYOLA \n"+
                    " 1. Insert Student \n" +
                    " 2. Fetch \n"+
                    " 3. Verify Encapsulation \n" +
                    " 4. Update \n"+
                    " 5. Delete \n" +
                    " 6. Show all \n"+
                    " 0. Exit \n"  
                    );
                    userInput3 = keyboard.nextInt();
                   keyboard.nextLine();
                   switch(userInput3){
                    case 1:
                    //Insert Student
                    System.out.println("Enter Student First Name");
                    first_Name = keyboard.nextLine();
                    System.out.println("Enter Student Last  Name");
                    last_Name = keyboard.nextLine();
                    System.out.println("Enter A Class Name");
                    className = keyboard.nextLine();
                    String Std_id = String.valueOf(std.randomNumber());
                   
                    aClass = new Class(className);
                    std = new Student_Omoyola(Std_id,last_Name,first_Name,aClass);
                    table.put(Std_id,std);
                     System.out.println("*****************Insert Sucess****************");  
                    System.out.println(std.toString());
                    break;
                   
                    case 2:
                    // Fetch Student
                     System.out.println("Enter the Student ID Number");
                     fecthedStd = keyboard.nextLine();
                     fetched = table.get(fecthedStd);
                        if(fetched != null){
                        // Display found STUDENT
                        System.out.println("********* Student Found ********"); 
                        System.out.println(fetched.toString());
                    }else
                       System.out.println("********* Student Cannot be Found ********");     
                    break;
                   
                    case 3:
                     // Verify Encapsulation
                    //Allow users to type a student id from the keyboard, id
                    System.out.println("Enter Student id");
                    fecthedStd = keyboard.nextLine();
                    //Search in the data structure. If the student is found named it as temp
                    temp =  table.get(fecthedStd);
                    //-Display message to ask for new last name.
                    System.out.println("Enter a new Last name for student");
                    String newName = keyboard.nextLine();
                    //Modify the last name of the student temp
                    temp.setName(newName);
                    //Fetch from the selected data structure a student with above id; store to fetchedStudent
                    fetchedStudent = table.get(fecthedStd);
                    
                    // Compare both
                    if(fetchedStudent.getName().equals(temp.getName()))
                    {
                    System.out.println("Java Hashtable not encapsulasted");
                    }else {
                    System.out.println("Java Hastable is encapsulasted");
                    }
                    
                    // Display Fetched Student
                    System.out.println("**********Fectched Student**************");
                    System.out.println(fetchedStudent.toString());
                    // Display temp
                    System.out.println("*****************Edited Student******************");
                    System.out.println(temp.toString());
                    break;
                   
                    case 4:
                    // Update
                       String lname;
                       //Display the message to ask users to enter the student id
                       System.out.println("Enter Student id");
                       fecthedStd = keyboard.nextLine();
                       
                       // Using the student id to fetch the student from the selected data structure to temp3
                        temp3 =  table.get(fecthedStd);
                        System.out.println(temp3.toString());
                        
                        //Asking users to enter one new last name from the keyboard then change the thisnew information of temp3
                        System.out.println("Enter a new Last name for student");
                        lname = keyboard.nextLine();
                        temp3.setName(lname);
                        table.put(fecthedStd, temp3);
                        System.out.println(temp3.toString());
                    break;
                   
                    case 5:
                    System.out.println("Enter Student id you want to delete");
                    table.remove(keyboard.nextLine());
                    
                    break;
                   
                    case 6:
                    // showAll
                    Enumeration keyset = table.keys();
                    while (keyset.hasMoreElements())
                    {
                        String studentId = keyset.nextElement().toString();
                        System.out.println(table.get(studentId));
                    }
                    break;
                   
                    }
                }while(userInput3 != 0);
                 
                   try{
                  PrintWriter nodes = new PrintWriter ("students.csv");
                   Enumeration keyset = table.keys();
                    while (keyset.hasMoreElements())
                    {
                        String  studentId = keyset.nextElement().toString();
                        fetchedStudent =table.get(studentId);
                        nodes.println(fetchedStudent.toFile());
                    }
                    
                    System.out.println("Students have been writen to the file (Java Hastable)");
                    nodes.close();
                }catch(Exception e){
                    System.out.println(e);
                    System.out.println("writing failed");
                   
               }   
                break;
                 
               
                }
             }while(userInput !=0);
             keyboard.close();
             System.out.println("Thank you. The application is terminating.......");
       
         }  
       
        }    