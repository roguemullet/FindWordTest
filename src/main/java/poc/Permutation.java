package poc;

import java.util.*;

//Java program to print all permutations of a 
//given string. 
public class Permutation 
{ 
	List<String> permutations = null;
	
	public List<String> getPermutations(String str){
		this.permutations = new ArrayList<String>();
		this.permute(str, 0, str.length() -  1);
		return this.permutations;
	}
 /** 
  * permutation function 
  * @param str string to calculate permutation for 
  * @param l starting index 
  * @param r end index 
  */
 private void permute(String str, int l, int r) 
 { 
     if (l == r) 
         this.permutations.add(str);
     else
     { 
         for (int i = l; i <= r; i++) 
         { 
             str = swap(str,l,i); 
             permute(str, l+1, r); 
             str = swap(str,l,i); 
         } 
     } 
 } 

 /** 
  * Swap Characters at position 
  * @param a string value 
  * @param i position 1 
  * @param j position 2 
  * @return swapped string 
  */
 public String swap(String a, int i, int j) 
 { 
     char temp; 
     char[] charArray = a.toCharArray(); 
     temp = charArray[i] ; 
     charArray[i] = charArray[j]; 
     charArray[j] = temp; 
     return String.valueOf(charArray); 
 } 

} 

//This code is contributed by Mihir Joshi 