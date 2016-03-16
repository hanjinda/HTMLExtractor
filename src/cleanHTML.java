//Clean The HTML Data
// @Audhor: Jinda Han

import java.io.*;

public class cleanHTML {
    public static void main(String[] args)  {
        String tmp = readFromTxt();
        String searchInput = "pains";//the words in search

        //readFromTxt();//read from file

        char[] stc = changeToLowerAndDelSymb(tmp);
        char[] newstc = new char[stc.length];
        for(int i = 0; i< stc.length; i++)
        {

            if(stc[i]>=97 && stc[i]<122){

                //System.out.print(stc[i]);
                newstc[i] = stc[i];
            }

            else{
                //System.out.print(" ");
            	if(i >= 1){
            		if(newstc[i-1]>=97 && newstc[i-1]<122)
            			newstc[i] = '\n';
            	}
            	//else
            		//newstc[i] = '\n';

            }
        }

        String back = String.valueOf(newstc);
        writeToTxt(back);//write to output file
        System.out.println("\n"+back);//for test output file
/*
        //searching output file
        if(searchExist(back, searchInput))
            System.out.print(searchExist(back, searchInput)+", Yeah man! We find the words!");
        else
            System.out.print(searchExist(back, searchInput)+", Oops, nothing find!");
*/
    }

    
    
//read from txt file// can using arryList to dynamic added later
    public static String readFromTxt(){
        //FileReader fileReader = new FileReader("input.txt");
        //String input = "input.txt";
        String [] input = new String[10000];

        File file = new File("input.txt");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        int num = 0;
        try {
            fis = new FileInputStream(file);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {

                // this statement reads the line from the file and print it to
                // the console.
                //System.out.println(dis.readLine());
                input[num] = dis.readLine();
                num++;
            }

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //change array sting to a string
        String stringout = "";
        for(int i = 0; i< input.length; i++){
            if(input[i]!=null)
                stringout += input[i];
        }

        //System.out.print(stringout);
        return stringout;
    }


//to lower case and filter the symbol out
    public static char[] changeToLowerAndDelSymb(String text){
        String lower = text.toLowerCase();//to lower case

        char[] stc = lower.toCharArray();//filter the symbol

        return stc;
    }

    
//searching the text file for file exist
    public static boolean searchExist(String text, String input){
        //indexOf for searching >0
        if(text.indexOf(input) >= 0)
            return true;
        else
            return false;
    }


    
//like change ___ to _
    public static String delMultiSpace(String src){
        String tmp = " "; 
        return tmp;
    }


    
//delete useless words like li, href, px, div, null, etc.
    public static String delUselessWords(String src){
        String tmp = " "; 
        return tmp;
    }

    
 //Write the text to file   
    public static void writeToTxt(String stc){

        try{
            //String str = "SomeMoreTextIsHere";
            File newTextFile = new File("output.txt");

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(stc);
            fw.close();

        }catch(IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }

    }

}
//97-122(a-z)
