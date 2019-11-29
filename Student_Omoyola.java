import java.util.*;

/**
 * Write a description of class Student_Omoyola here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student_Omoyola
{
    private String student_id;
    private String lastName;
    private String firstName;
    private Class aClass;

    /**
     * Constructor for objects of class Student_Omoyola
     */
    public Student_Omoyola()
    {
       
       
    }

     /**
     *  Parameterized Constructor for objects of class Student_Omoyola
     *  
     */
    public Student_Omoyola( String id,String lName, String fName, Class aClass)
    {
        this.student_id = id;
        this.lastName = lName;
        this.firstName = fName;
        this.aClass = aClass;  
    }
   
       /**
     *  Parameterized Constructor for objects of class Student_Omoyola
     *  to prompt user
     */
    public Student_Omoyola( String lName, String fName, Class aClass)
    {
        this.student_id = String.valueOf(randomNumber());
        this.lastName = lName;
        this.firstName = fName;
        this.aClass = aClass.deepCopy();
       
       
    }
    
   
    public String getKey()
    {
        return student_id;
    }
   
      public int compareTo(String targetKey)
     {
        return(student_id.compareTo(targetKey));
       
     }
   
    public int randomNumber()
    {
        Random random = new Random();
        return random.nextInt(10000000);
   
    }
   
    public String toFile()
    
    {
           
           return (student_id + "," + lastName + "," + firstName + "," + aClass.getClassName() +"," + aClass.getGrade());
    }
   
   
    
     public String toString() {
          
          return  "Student ID: " +student_id+ "\n" +
                 "Student: "    +firstName +" "+lastName+ "\n" +
                 "Classes:" +"\n" +
                 aClass + "\n";
       }
     
    public String getName()
    {
    return lastName;
    }
    
 
    public void setName(String name)
    {
    lastName = name;
    }
    

    public Student_Omoyola deepCopy()
    {
        Student_Omoyola clone = new Student_Omoyola (student_id, lastName, firstName,aClass);
                return clone;
    }
   
}