import java.util.*; 
import java.io.*;

public class Project {
	public static void main(String[] args) throws Exception {
		
		//--------------| Fill the encription characters |--------------//
		List<String> characters = new ArrayList<String>();
		characters = fillCharacters();

		//--------------| User input |--------------//
		Scanner scan = new Scanner(System.in);
		String input;

		//--------------| User opration request |--------------//

		do{
			System.out.println("Hello \nPress (E) for Encrypt a message or (D) for Decrypt a message?");
		
			input = scan.next();
			input = input.toLowerCase();

			if(input.equals("e")) {													//encrypt oparation

				System.out.println("Enter the name of the file you want to encrypt with the extension of the file.");
				System.out.println("Example! ( Text.txt or Text.dec )");
				String userFileName = scan.next();
	
				try {
					File file = new File(userFileName);					//find user file
					System.out.println("Successfully found the file.");
	
					Scanner s = new Scanner(file);									//read file 
					String Key = s.nextLine();										//read encryption kay
					List<String> text = new ArrayList<String>();					//text lines ArrayList
				
					while(s.hasNext()){
						text.add(s.nextLine());										//read text lines and store them to text lines ArrayList
					}
	
					List<String> finalEncryptedText = encrypt(characters, text, Key);//encryption finall result in an ArrayList
					System.out.println("Enter the new file name that will contain the encrypted message:");
					System.out.println("Important! ( Enter a new file name without file type such as .txt or .dec )");
					String encFile = createNewEncryptionFile(scan.next());			//craet a new file for the encrypted message
					writeToFile(encFile, finalEncryptedText, "");					//write the message to the new file
					
					s.close();
				  } catch (IOException e) {
					System.out.println("The file is not found!");
					System.out.println("Try to change the location of the file or check the file name you entered");
					e.printStackTrace();
				  }
				
			}else if(input.equals("d")) {											//decrypt opartion
	
				System.out.println("Enter the name of the file you want to decrypt with the extension of the file.");
				System.out.println("Example! ( Text.txt or Text.dec )");
				String userFileName = scan.next();
	
				System.out.println("Enter the key for decryption:");
				String key = ",aGXmBy ";											//read decryption kay
	
				try {
					File file = new File(userFileName);								//find user file
					Scanner s = new Scanner(file);									//read file
					List<String> text = new ArrayList<String>();					//text lines ArrayList
					
					while(s.hasNext()){
						text.add(s.nextLine());										//read text lines and store them to text lines ArrayList
					}
					
					List<String> finalDecryptedText = decrypt(characters, text, key);//encryption finall result in an ArrayList
					System.out.println("Enter the new file name that will contain the decrypted message:");
					System.out.println("Important! ( Enter a new file name without file type such as .txt or .dec )");
					String decFile = createNewDecryptionFile(scan.next());			//craet a new file for the encrypted message
					writeToFile(decFile, finalDecryptedText, key);					//write the message to the new file

					s.close();
				  } catch (IOException e) {
					System.out.println("The file is not found!");
					System.out.println("Try to change the location of the file or check the file name you entered");
					e.printStackTrace();
				  }
				
			}
		} while(!(input.equals("e") || input.equals("d")));

		scan.close();
	}
	
	//------------------------------------------| Encrypt method |------------------------------------------//	
	public static List<String> encrypt(List<String> characters, List<String> text, String key){
		
		List<String> finalEncryptedText = new ArrayList<String>();
		List<String> keyLetters = new ArrayList<String>();
		keyLetters = separateLetters(key);
		int indexOfKey = 0 ;
		
		for (int i=0 ; i<text.size(); i++) {
			List<String> textLine = new ArrayList<String>();
			String t = text.get(i);
			textLine = separateLetters(t);
			
			String encrybtedLine = "";
			for(int y=0 ; y<textLine.size(); y++) {
				
				indexOfKey = indexOfKey % keyLetters.size();
				int KLetterInCharacters = characters.indexOf(keyLetters.get(indexOfKey));
				int TLetterInCharacters = characters.indexOf(textLine.get(y));
				String encrybtedLetter = characters.get((KLetterInCharacters + TLetterInCharacters) % characters.size());
				encrybtedLine += encrybtedLetter;
				indexOfKey++;
			}
			finalEncryptedText.add(encrybtedLine);
		}
		return finalEncryptedText;
	}

	//------------------------------------------| Decrypt method |------------------------------------------//
	public static List<String> decrypt(List<String> characters, List<String> text, String key){
		
		List<String> finalDecryptedText = new ArrayList<String>();
		List<String> keyLetters = new ArrayList<String>();
		keyLetters = separateLetters(key);
		int indexOfKey = 0 ;

		
		
		for (int i=0 ; i<text.size(); i++) {
			List<String> textLine = new ArrayList<String>();
			String t = text.get(i);
			textLine = separateLetters(t);
			String encrybtedLine = "";
			for(int y=0 ; y<textLine.size(); y++) {
				
				indexOfKey = indexOfKey % keyLetters.size();
				int KLetterInCharacters = characters.indexOf(keyLetters.get(indexOfKey));
				int TLetterInCharacters = characters.indexOf(textLine.get(y));
				int finalInCharacters = TLetterInCharacters - KLetterInCharacters ;
				if (finalInCharacters < 0) {
					String encrybtedLetter = characters.get(finalInCharacters % characters.size() + characters.size());
					encrybtedLine += encrybtedLetter;
				}else {
					String encrybtedLetter = characters.get(finalInCharacters % characters.size());
					encrybtedLine += encrybtedLetter;
				}
				indexOfKey++;
			}
			finalDecryptedText.add(encrybtedLine);
		}
		return finalDecryptedText;
	}
		
	//------------------------------------------| Fill characters method |------------------------------------------//
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
	
	//------------------------------------------| Separate letters method |------------------------------------------//
	public static List<String> separateLetters(String text){
		
		List<String> separatedLetters = new ArrayList<String>();
		
		for (int i=0; i<text.length(); i++) {
			String t = text.substring(i,i+1);
			separatedLetters.add(t);
		}
		
		return separatedLetters;	
	}

	//------------------------------------------| Create new Encryption file method |------------------------------------------//
	public static String createNewEncryptionFile(String fileName) {

		String fileNameDEC = fileName + ".dec";

		try {
			File myFile = new File(fileNameDEC);
			if (myFile.createNewFile()) {
			  System.out.println("File created: " + myFile.getName());
			  return fileNameDEC;
			} else {
			  System.out.println("File already exists.");
			  return fileNameDEC;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
		  return fileNameDEC;
	}

	//------------------------------------------| Create new Decryption file method |------------------------------------------//
	public static String createNewDecryptionFile(String fileName) {

		String fileNameTXT = fileName + ".txt";
	
		try {
			File myFile = new File(fileNameTXT);
			if (myFile.createNewFile()) {
			  System.out.println("File created: " + myFile.getName());
			  return fileNameTXT;
			} else {
			  System.out.println("File already exists.");
			  return fileNameTXT;
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
		  return fileNameTXT;
	}

	//------------------------------------------| Write to file method |------------------------------------------//
	public static void writeToFile(String fileName, List<String> textLine, String key) {

		try {
			FileWriter myWriter = new FileWriter(fileName);

			if(key.length() > 0){
				myWriter.write(key + "\n");	
				for (int i=0 ; i<textLine.size() ; i++){
					myWriter.write(textLine.get(i) + "\n");	
				}
			}else{
				for (int i=0 ; i<textLine.size() ; i++){
					myWriter.write(textLine.get(i) + "\n");	
				}
			}

			System.out.println("Successfully wrote to the file.");
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}

}
