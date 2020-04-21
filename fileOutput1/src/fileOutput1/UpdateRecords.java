/*
 * Cynthia C.
 * 22nd March 2020
 */
package fileOutput1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateRecords {

	public static void main(String[] args) {
		Scanner string = new Scanner(System.in);
		Scanner Int = new Scanner(System.in);
		int userChoice = 0, i = 0;
		String name, line, address, phoneNum, name2 = "";
		ArrayList<RecordsList> obj = new ArrayList<RecordsList>();
		
		try {
			FileReader reader = new FileReader("output_thing.txt");
			BufferedReader br = new BufferedReader(reader);
			
			line = br.readLine();
			
			//will create a new object in arraylist for each line
			while(line != null) {
				System.out.println(line);
				obj.add(new RecordsList(line));
				line = br.readLine();
			}
			
			br.close();
			
			FileWriter write = new FileWriter("output_thing.txt", false);
			BufferedWriter bw = new BufferedWriter(write);
			
			System.out.println("What is your name?: ");
			name = string.nextLine();
			//will loop till the name the user entered matches with one in the arraylist
			do {
				//will run if the name the user entered is not in the arraylist
				if(i >= obj.size()) {
					System.out.println("That name is not avalible\n1)Add name\n2)Select another name");
					userChoice = Int.nextInt();
					//will prompt the user to enter in different info
					if(userChoice == 2) {
						System.out.println("Enter name: ");
						name = string.nextLine();
					}else if(userChoice == 1) {
						System.out.println("Enter " + name + "'s address: ");
						address = string.nextLine();
						System.out.println("Enter " + name + "'s phone number: ");
						phoneNum = string.nextLine();
						
						line = name + ", " + address + ", " + phoneNum;
						
						obj.add(new RecordsList(line));
					}
					i = 0;
				}else {
					name2 = obj.get(i).returnName();
					i++;
				}
			}while(!name.equalsIgnoreCase(name2));
			
			i--;
			
			System.out.println("Here is your info: ");
			System.out.println("Name: " + obj.get(i).returnName() + "\nAddress: " + obj.get(i).returnAddress() + "\nPhone Number: " + obj.get(i).returnPhoneNum());
			
			System.out.println("Would you like to update: \n1)Name\n2)Address\n3)Phone Number");
			userChoice = Int.nextInt();
			
			//will loop till user chooses an option that is offered
			while(userChoice > 3 || userChoice < 1) {
				System.out.println("Option Unavailible\nChoose an applicable option: ");
				userChoice = Int.nextInt();
			}
			
			//will prompt user to enter new info
			if(userChoice == 1) {
				System.out.println("New name: ");
				obj.get(i).changeName(string.nextLine());
			}else if(userChoice == 2) {
				System.out.println("New address: ");
				obj.get(i).changeAddress(string.nextLine());
			}else {
				System.out.println("New phone number: ");
				obj.get(i).changePhoneNum(string.nextLine());
			}
			
			System.out.println("Your information has been updates");
			
			//will add all info back into the file since it was all wiped
			for(int j = 0; j < obj.size(); j++) {
				line = obj.get(j).returnName() + "," + obj.get(j).returnAddress() + "," + obj.get(j).returnPhoneNum();
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		}catch(IOException e) {
			System.out.println("This Doesn't Work");
		}
	}
}
