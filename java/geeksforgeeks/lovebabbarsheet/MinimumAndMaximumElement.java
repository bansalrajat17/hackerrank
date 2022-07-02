package java.geeksforgeeks.lovebabbarsheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            pair product = obj.getMinMax(a, n); 
            System.out.println(product.first+" "+product.second);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
 class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} */

class Compute 
{
    static long getMin(long[] a)
    {
        long min = a[0];
        for(Integer i = 0 ; i < a.length ; i++)
        {
            if(a[i] < min)
            {
                a[i] ^= min;
                min ^= a[i];
                a[i] ^= min;
            }
        }
        return min;
    }
    static long getMax(long[] a)
    {
        long max = a[0];
        for(Integer i = 0 ; i < a.length ; i++)
        {
            if(a[i] > max)
            {
                a[i] ^= max;
                max ^= a[i];
                a[i] ^= max;
            }
        }
        return max;
    }
    static pair getMinMax(long a[], long n)  
    {
        long min = a[0];
        long max = a[0];
        //Write your code here
        if(a.length == 1)
         return new pair(min,max);
        else{
       min = getMin(a);
       max = getMax(a);
        }
        
        return new pair(min,max);
    }
}
