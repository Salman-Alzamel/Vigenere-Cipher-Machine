# Vigenere-Cipher-Machine
A Vigenere-Cipher-Machine that takes text files with Vigenere-Cipher keys at the first line to create a text file with the encrypted message and vice versa.

## Getting Started

Welcome to the Vinegar Cipher Machine Project!
This is a project for ICS254 course.
I hope you like it :).
T H A N K Y O U

## How to use the VC-Machine
First: You need to run the program using any JAVA IDE.
Then the VC-Machine will ask you whether you want to Encrypt or Decrypt your message.

    "Press (E) for Encrypt a message or (D) for Decrypt a message?"
    - When pressing the E or D buttons it will automatically ignore the case.

        - When E is pressed it runs the Encrypt operation. {

            "Enter the name of the file you want to encrypt with the extension of the file." 
            - Here the VC-Machine will ask you to enter the file that contains the message you want to encrypt.

            - The file can only be of type .txt or .dec.
            - If the file does not exist it will print an error message saying: "The file is not found!"

            - Then will suggest: "Try to change the location of the file or check the file name you entered"
            - The file you want to encrypt must be in the same folder as the VC-Machine.

            - If the file was found it will print: "Successfully found the file."

            - After that, it will read the file the first line will be taken as the encryption KEY.
            - And it will start the encryption process.

            - Then the VC-Machine will ask you to enter the name of the file that will contain the encrypted message.
            "Enter the new file name that will contain the encrypted message:"
            - It will create a new file of type .dec with the name you just entered.

            - The VC-Machine will start writing the encrypted message to the newly created file.
            - If the writing process was successful the VC-Machine will say: "Successfully wrote to the file."
            - Else it will show an error message: "An error occurred."

            - Finally you will find your encrypted message file in the same folder as the VC-Machine.
        }

        - When D is pressed it runs the Decrypt operation. {

            "Enter the name of the file you want to decrypt with the extension of the file." 
            - Here the VC-Machine will ask you to enter the file that contains the message you want to decrypt.

            - The file can only be of type .txt or .dec.
            - If the file does not exist it will print an error message saying: "The file is not found!"

            - Then will suggest: "Try to change the location of the file or check the file name you entered"
            - The file you want to decrypt must be in the same folder as the VC-Machine.

            - If the file was found it will print: "Successfully found the file."

            - After that, it will ask you for the decryption KEY.
            "Enter the key for decryption:"
            - After entering the decryption KEY it will start the decryption process.

            - Then the VC-Machine will ask you to enter the name of the file that will contain the decrypted message.
            "Enter the new file name that will contain the decrypted message:"
            - It will create a new file of type .txt with the name you just entered.

            - The VC-Machine will start writing the decrypted message to the newly created file.
            - The decryption KEY will be written at the first line of the decrypted message file.
            - If the writing process was successful the VC-Machine will say: "Successfully wrote to the file."
            - Else it will show an error message: "An error occurred."

            - Finally you will find your decrypted message file in the same folder as the VC-Machine.
        }

## Contacts info
Salman Alzamel: Salman-m-z@outlook.sa
