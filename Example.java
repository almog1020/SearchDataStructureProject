/**
 * Quickly checks an organ's belonging to a data structure
 * @author (Almog Tshukati) 
 * @version (14/01/2021)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        String Token = ",";
        File insertFile = new File("insert.txt");//page of insert the members
        File checkFile = new File("check.txt");//page of check the members

        System.out.println ("enter the m");//the array length
         Scanner scan=new Scanner(System.in);
         int m=scan.nextInt();
         System.out.println ("enter the k");//the number of the functions
         int k=scan.nextInt();
         scan.close();

         Mytable awesomeTable =new Mytable(m, k);//table bit
        /**
         * Read the insert page and insert the member to the table bit
         */
        try {
            Scanner insertFileReader = new Scanner(insertFile);
            insertFileReader.useDelimiter(Token);
            try {
                while (insertFileReader.hasNext()) {
                    if (insertFileReader.hasNextInt()) {
                        int num=insertFileReader.nextInt();
                        System.out.println("Inserted int element: "+ num);
                        awesomeTable.insertElement(num);
                    } else {
                        String st=insertFileReader.next();
                        System.out.println("Inserted string element: " + st);
                        awesomeTable.insertElement(st);
                    }
                }
            } 
            finally {
                insertFileReader.close();//finish the scan on the insert page
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("insert file not found");//the scan doesnt find the insert page
        }

         /**
         * Read the check page and find the member in the table bit
         */
        try {
            Scanner checkFileReader = new Scanner(checkFile);
            checkFileReader.useDelimiter(Token);

            try {
                while (checkFileReader.hasNext()) {
                    if (checkFileReader.hasNextInt()) {
                        int num=checkFileReader.nextInt();
                        System.out.println("Checked int element: " + num);
                       boolean b1=awesomeTable.checkElement(num);
                            if(b1==true)
                            {
                                System.out.println ("yes");//Number found in structure
                            }
                            else {
                                System.out.println ("No"); //Number doesnt found in structure
                            }  
                    } else {
                        String st=checkFileReader.next();
                        System.out.println("Checked string element: " + st);
                        boolean b1=awesomeTable.checkElement(st);
                        if(b1==true)
                            {
                                System.out.println ("yes");//string found in structure
                            }
                            else {
                                System.out.println ("No");//string doesnt found in structure
                            } 
                    }
                }
            } 
            finally {
                checkFileReader.close();//finish the scan on the check page
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("check file not found");//the scan doesnt find the check page
        }
    }

}
