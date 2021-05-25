/*
This program finds the most frequent character in a given text.
*/

import java.io.*;
import java.util.*;

public class FA {

    public static void main(String [] args) throws IOException {

            try {
                File file = new File("encrypted1.txt");					
                System.out.println("Successfully found the file.");

                Scanner s = new Scanner(file);									
                int[] charfrequency = new int[67];
                int i = 0;
                int j =  0;
                int textlength = 0;
                String e = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,.?! ";
                char enc[] = e.toCharArray();
                while(s.hasNext()){
                    String plaintext = s.nextLine();
                    while(i < plaintext.length()) {
                        char c  = plaintext.charAt(i);
                        int cN = (int) c;
        
                        for(int x = 0; x < enc.length; x++){
                            int lN = (int) enc[x];
                            if(cN == lN){
                                j = x;
                            }
                        }
        
                        if(j >= 0 && j <= 66) {
                            charfrequency[j]++;
                            textlength++;
                        }
                        i++;
                        j = 0;
                    }
                    i = 0;
                }
                

                double ic = 0;
                for(int k = 0; k < 67; k++) 
                    ic += charfrequency[k] * (charfrequency[k] - 1);
                ic /= textlength * (textlength - 1);
                System.out.println("The index of coincidence is " + ic + ".");
    
                for(int k = 0; k < charfrequency.length; k++) {
                    System.out.println("[ " + charfrequency[k] + "  |  '" + enc[k] + "'  |  " + k + " ]");
                }

                int max = 0; 
                int inde = 0;         

                for (int k = 0; k < charfrequency.length; k++) {
                    charfrequency[k] = max;
            
            
                    for (int o = i+1; o<charfrequency.length; o++) {
                        if (charfrequency[o] > max) {
                           max = charfrequency[o];
                           inde = o;
                        }
            
                    }
                }

                System.out.println("\n The most frequent character");
                System.out.println(max + " | " + inde);

                s.close();
              } catch (IOException e) {
                System.out.println("The file is not found!");
                System.out.println("Try to change the location of the file or check the file name you entered");
                e.printStackTrace();
              }

           }
           
    }

    

