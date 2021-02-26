package lds_lab_5;
//hash function is changed to this and the insert method from HashList is still used
public class HashList3 extends HashList {

	//this has function was created using the given equation from the lab instructions
		public int hash(Element element) {
			
			int hashNumber = 0;
			
			for(int i = 0; i < element.word.length(); i++) {
				
				hashNumber = (hashNumber*31) + element.word.charAt(i);
				
			}
			
			int hashValue = Math.abs(hashNumber % 256);
			return hashValue;
		}
}
