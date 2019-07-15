/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mytask1;

/**
 *
 * @author M.Ramar
 */
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.google.gson.Gson;
public class Mytask1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        File f1 = new File("library.json"); 
		if (f1.createNewFile()) {  
                System.out.println("New File is created!");  
            } else {  
                System.out.println("File already exists.");  
            } 
        int f=0;
			Scanner s=new Scanner(System.in);	
			while(true)
			{
				System.out.println("1.create a record");
				System.out.println("2.Read the records");
				System.out.println("3.Delete a record");
				System.out.println("4.exit");
				int option=s.nextInt();
				switch(option)
				{
				case 1:
					create();
					break;
				case 2:
					read();
					break;
				case 3:
					
					break;
				case 4:
					f=1;
					break;
				}
				if(f==1)
				break;
				}
    }
    static void create() throws Exception
    {
        Scanner br=new Scanner(System.in);

System.out.println("enter the studenet name");
String name=br.nextLine();

System.out.println("enter the book name");
String book=br.nextLine();


DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   String date=dtf.format(now);  
        library l=new library(name,book,date);
        Gson gson = new Gson();
    
    String json = gson.toJson(l);
    FileWriter file1 = new FileWriter("library.json",true);
        	BufferedWriter file=new BufferedWriter(file1);
                PrintWriter out=new PrintWriter(file);
            out.print(json);
           out.println();
           
            out.flush();
    

    
}
    static void read() throws Exception
    {
        BufferedReader br = new BufferedReader(
     new FileReader("library.json"));
      
   Gson gson = new Gson();
    //convert the json string back to object
library l = gson.fromJson(br, library.class);
  
  System.out.println(l);

 
   
    }
}
class library
{
    String name;
    String timing;
    String bookname;
    library(String name,String bookname,String timing)
    {
        this.name=name;
        this.timing=timing;
        this.bookname=bookname;
    }
    public String toString() {
                return "name :"+name+"  timing :"+timing+"   bookname:"+bookname;
        }
}

    

