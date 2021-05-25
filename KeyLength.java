/*
This program findes the key length by findeng the index of conincidence on a given text.
*/

import java.io.*;
import java.util.*;

public class KeyLength {

    public static void main(String [] args) throws IOException {

            try {
                File file = new File("encrypted2.dec");				
                System.out.println("Successfully found the file.");

                Scanner s = new Scanner(file);									

                List<String> text = new ArrayList<String>();
                int coincidenceCounter = 0;
                int maxCC = 0;
                int keyLength = 0;

                while(s.hasNext()){
                    text.add(s.nextLine());
                }
                
                List<String> text2 = new ArrayList<String>();
                List<String> text3 = new ArrayList<String>();

                for(int i=0 ; i<text.size(); i++) {
                    text2 =  separateLetters(text.get(i));
                    for(int j=0 ; j<text2.size(); j++) {
                        text3.add(text2.get(j));
                    }
                }

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the expected range for the key length");
                System.out.println("Enter the start of the range");
                String startRange = sc.next();
                System.out.println("Enter the end of the range");
                String endRange = sc.next();
                int startShift = Integer.parseInt(startRange);
                int endShift = Integer.parseInt(endRange);

                while(startShift > endShift){
                    System.out.println("Error: The start of the range must be smaller than the end of the range");
                    System.out.println("Enter the start of the range");
                    String startRangeE = sc.next();
                    System.out.println("Enter the end of the range");
                    String endRangeE = sc.next();
                    startShift = Integer.parseInt(startRangeE);
                    endShift = Integer.parseInt(endRangeE);
                }

                for(int i=startShift; i<=endShift; i++){

                    List<String> comp1 = new ArrayList<String>();

                    for(int j=0 ; j<text3.size(); j++) {
                        comp1.add(text3.get(j));
                    }
                    
                    for(int j=0 ; j<i; j++) {
                        comp1.add(0, "");
                    }
    
                    for(int j=0 ; j<text3.size(); j++) {
                        if(comp1.get(j).equals(text3.get(j))){
                            coincidenceCounter++;
                        }

                    }
                    if(coincidenceCounter > maxCC){
                        keyLength = i;
                    }
                    maxCC = Math.max(maxCC, coincidenceCounter);
                    coincidenceCounter = 0;
                }

                System.out.println("Key length = " + keyLength + " With coincidence counter of = " + maxCC);
                s.close();
                sc.close();
              } catch (IOException e) {
                System.out.println("The file is not found!");
                System.out.println("Try to change the location of the file or check the file name you entered");
                e.printStackTrace();
              }

           }

        public static List<String> fillCharacters() {
	
            List<String> list = new ArrayList<String>();
    
            String e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,.?! ";
            char enc[] = e.toCharArray();
            
            for (int i=0 ; i<enc.length ; i++) {
                String s = enc[i] + "";
                list.add(s);	
            }
            
            return list;	
            
        }

        public static List<String> separateLetters(String text){
		
            List<String> separatedLetters = new ArrayList<String>();
            
            for (int i=0; i<text.length(); i++) {
                String t = text.substring(i,i+1);
                separatedLetters.add(t);
            }
            
            return separatedLetters;	
        }

    }

