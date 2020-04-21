/*
 * Cynthia C.
 * 22nd March 2020
 */
package fileOutput1;

public class RecordsList {
	private String name, address, phoneNum;
	
	/**
	 * initializes variables
	 * @param line
	 */
	public RecordsList(String line) {
		int letter = 0, y = 0;
		String[] info = new String[3];
		
		//sets the info array
		for(int i = 0; i < 3; i++) {
			info[i] = "";
		}
		
		//will add info letter by letter until it reaches a comma
		while(line.substring(letter, letter+1) != null && (letter + 1) < line.length()) {
			//once it reaches a comma it will switch which info it's putting into the object
			if(!line.substring(letter, letter+1).equals(",")) {
				info[y]+=line.substring(letter, letter+1);
			}else {
				y++;
			}
			
			letter++;
		}
		name = info[0];
		address = info[1];
		phoneNum = info[2];
	}
	
	/**
	 * changes name
	 * @param n
	 */
	public void changeName(String n) {
		name = n;
	}
	
	/**
	 * changes address
	 * @param a
	 */
	public void changeAddress(String a) {
		address = a;
	}
	
	/**
	 * changes phone number
	 * @param pn
	 */
	public void changePhoneNum(String pn) {
		phoneNum = pn;
	}
	
	/**
	 * returns name
	 * @return
	 */
	public String returnName() {
		return name;
	}
	
	/**
	 * returns phone number
	 * @return
	 */
	public String returnPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * returns address
	 * @return
	 */
	public String returnAddress() {
		return address;
	}
}
