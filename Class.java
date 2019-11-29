
/**
 * Write a description of class Class_Omoyola here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class 
{
    private String className;
    private char letterGrade;

    /**
     * Constructor for objects of class Class_Omoyola
     */
    public Class()
    {
      
    }
    
    /**
     *  Parameter Constructor for objects of class Class_Omoyola
     */
    public Class(String cName, char grade)
    {
        this.className = cName;
        this.letterGrade = grade;
      
    }
    
     /**
     *  Parameter Constructor for objects of class Class_Omoyola
     */
    public Class(String cName)
    {
        this.className = cName;
        this.letterGrade = 'X';
      
    }
    
    public char getGrade()
    {
        
        if(letterGrade == 'A'){
            return 'A';
        }else if (letterGrade == 'B'){
            return 'B';
        }else if (letterGrade == 'C'){
            return 'C';
        }else if (letterGrade == 'D'){
            return 'D';
        }else if (letterGrade == 'F'){
            return 'F';
        }else{
            return 'X';
        } 
           
    }
    
    public String getClassName(){
        return className;
    }
    
    public String toString()
    {
        return  (className + " - " + letterGrade);
    }
    
     public Class deepCopy()
    {
        Class clone = new Class (className,letterGrade);
                return clone;
    }
}
