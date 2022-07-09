import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {
    
    public static int freqMatchChar(String s1 , String s2)
    {
        int count = 0;
        String temp;
        
        //SWAP STRING
        
        if(s1.length() < s2.length())
        {
            temp = s1;
            s1 = s2;
            s2 = temp;   
        }
        int slength = s2.length();
        if(slength > 0)
        {
            for(Integer i = 0 ; i < slength ; i++)
            {
                int index = s1.indexOf(s2.charAt(i));
                if(index >= 0)
                {
                    
                    s1 = (index == 0) ? s1.substring(index + 1):s1.substring(0, index) + s1.substring(index + 1);
                    System.out.println(s1);
                    count++;
                }
            }
        }
        return count;
    }

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code 
     int matchChar = freqMatchChar(s1 , s2);     
     return (s1.length() + s2.length() - (2 * matchChar));
    }

}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

