package lds_lab_4;
//second hash function, the hash method is changed to this, insert is still the same
public class HashList2 extends HashList {

	//gets the ASCII value for the first letter in the string
		public int hash(Element element) {
			
			if(element.word == "") {
				return 0;
			}
			return (element.word.charAt(0) % 256);
		}
}
