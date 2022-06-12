/**
 * Represents information about a table of bits.
 * 
 * @author (Almog Tshukati) 
 * @version (14/01/2021)
 */
import util.hash.MurmurHash3;

public class Mytable {
    private int seeds;//number of the functions
    private int[]bitmap;//the table of bits
     /**
     * Constructor for objects of class table of bits. Construct a new table and number of the functions.
     * Time complexity: O(1)
     * Space complexity: O(n)
     */
    public Mytable(int m,int k)
    {
        seeds=k;
        bitmap=new int[m];
    }
      /** Adds new int to data structure
       * for each number that insert to data structure,We're doing loop that amount is a number of seeds(functions):
       * we use the function MurmurHash3
     * after we use abs function and mod the number by the length of the table bits (for that number dosent Exceed array boundaries)
     * finally we put 1 in place of a in the table bits
     * Time complexity: o(n)
     * Space complexity: o(1)
     */
    public void insertElement(int num)
    {
        int a=0;//Place in array after operations on number
        for(int i=0;i<seeds;i++)
        {
            a=MurmurHash3.hash32(num,i);
            a=Math.abs(a)%bitmap.length;
            bitmap[a]=1; 
        }
    
    }
     /** Adds new string to data structure
      * We calculate the chars of the word by ascii table and sum
       * after for each sum that insert to data structure,We're doing loop that amount is a number of seeds(functions):
       * we use the function MurmurHash3
     * after we use abs function and mod the number by the length of the table bits(for that number dont Exceed array boundaries)
     * finally we put 1 in place of a in the table bits
     * Time complexity: o(n)
     * Space complexity: o(1)
     */
    public void insertElement(String word)
    {
        int sum=0;//Sum of the word
        int a=0;//Place in array after operations on number
        for(int i=0;i<=word.length()-1;i++)
             sum=sum+(int)word.charAt(i);

        for(int i=0;i<seeds;i++)
        {
            a=MurmurHash3.hash32(sum,i);
            a=Math.abs(a)%bitmap.length;
            bitmap[a]=1; 
        }
    }
     /** Cneck int in the table bits
     * for each number that check in table bits,We're doing loop that amount is a number of seeds(functions):
     * we use the function MurmurHash3
     * after we use abs function and mod the number by the length of the table bits(for that number dont Exceed array boundaries)
     * if Place in array after operations on number equal to 1,Added one to count 
     * if the count equal to number of seeds(functions) then return true,otherwise return false 
     * Time complexity: o(n)
     * Space complexity: o(1)
     */
    public boolean checkElement(Integer num)
    {
        int count=0;//number of the true that num have in table 
        int a=0;//Place in array after operations on number
        for(int i=0;i<seeds; i++)
        {
            a=MurmurHash3.hash32(num,i);
            a=Math.abs(a)%bitmap.length;
            if(bitmap[a]==1)
                count++; 
        }
        if(count==seeds)
            return true;
        return false;
    }
     /** Cneck string in the table bits
      * We calculate the chars of the word by ascii table and sum
     * for each sum that check in table bits,We're doing loop that amount is a number of seeds(functions):
     * we use the function MurmurHash3
     * after we use abs function and mod the number by the length of the table bits(for that number dont Exceed array boundaries)
     * if Place in array after operations on number equal to 1,Added one to count 
     * if the count equal to number of seeds(functions) then return true,otherwise return false 
     * Time complexity: o(n)
     * Space complexity: o(1)
     */
    public boolean checkElement(String word)
    {
        int count=0;//number of the true that num have in table 
        int sum=0;//Sum of the word
        int a=0;//Place in array after operations on number
        for(int i=0;i<=word.length()-1;i++)
             sum=sum+(int)word.charAt(i);

        for(int i=0;i<seeds;i++)
        {
            a=MurmurHash3.hash32(sum,i);
            a=Math.abs(a)%bitmap.length;
            if(bitmap[a]==1)
                count++; 
        }
        if(count==seeds)
            return true;
        return false;
    }
}