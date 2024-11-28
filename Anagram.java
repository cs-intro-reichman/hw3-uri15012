/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		int [] nCharCounter1 = new int [27]; 
		int [] nCharCounter2 = new int [27];

		for (int i = 0; i < str1.length; i++) {
			if (str1.charAt (i) == ' '){
				nCharCounter1 [26]++;
			}else{
				nCharCounter1[str1.charAt(i) - 'a']++;

			}
			}

			for (int i = 0; i < str2.Length(); i++) {
				if (str2.CharAt (i) == ' '){
					nCharCounter2 [26]++;
				} else{
					nCharCounter2 [ str2.charAt (i) - 'a']++;

				}
				
				
			}

			for (int i = 0; i < 26; i++){
				if (nCharCounter1 [i] != nCharCounter2 [i])
				return false;
			}
			

			return true;
		}
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) { // String str specifies the data type the mthod preProcess expects an input of type String.
		// the str can be manipulated 
		String answer = ""; // initialize an empty string para preencher ela 

		for (int i = 0; i < str.length(); i++) { // loop trhough each character pq eh de zero ate length nao precisa de -1 
			char ch = str.charAt(i); // char data type for a single character and ch variable
			if ((ch >= 'A' && ch <= 'Z')|| (ch == ' ')){ // A = 65 and z=90  quando compara ==
				ch = (char) (ch + 32);
				
				answer = answer + ch;
				
				 // as minusculas se adiciona 32 nao vai ta nem definida eu n quero modificar o 32
			} else if (ch >='a' && ch <= 'z'){
					answer = answer + ch;
				}
					
			}

			
			//ans = ans + ch; // append the letter to the initial variable , aqui ta entrando pontuacao espaco qualquer merda e vc quer impedir isso. joga para 
			//pq la so entra as letras 
		
		return answer;
	}
	
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) { 

		int nlength = str.length();
		str = preProcess(str); // str para pegar a palavra pronta para random 
		boolean [] bUsedChar = new boolean [nlength]; // para garantir q a letra que foi usada uma vez n apareca duas vezes string length p boolean ter o mesmo tamanho da palavra 
		// o length do boolean eh importante para ter examente a mesma palavra comeca [false,false,false,false]
		String answer = ""; // definindo a string nova que vai sair 

		while (answer.length() < nlength){ // para garantir q vai ter o mesmo numero de letras 
			int randomIndex = (int) (Math.random() * str.length());

			if (!bUsedChar[randomIndex]) { // toda array de boolean quando vc n inicia ela eh falso e so quando inicia vira true. como se fosse not true
				answer = answer + str.charAt(randomIndex);// pega o index que saiu e coloca na string 
				bUsedChar [randomIndex] = true;// vira true para garantir q n pode colocar la dnv 

			}

		}

		return answer;
	}
}
