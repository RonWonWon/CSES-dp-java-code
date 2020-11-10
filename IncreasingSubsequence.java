import java.io.*;
import java.util.*;

public class IncreasingSubsequence {

	static int dp[], len;

	static int ceilBs(int x){
		int low = 0,mid, high = len-1;
		while(low<=high){
			mid = (low+high)/2;
			if(dp[mid]<x) low = mid+1;
			else high = mid-1;
		}
		return low;
	}

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = in.readArray(n);
        dp = new int[n+1];
        len = 1;
        dp[0] = a[0];
        for(int i=1;i<n;i++){
        	if(a[i]>dp[len-1]){
        		dp[len++] = a[i];
        	}
        	else{
        		dp[ceilBs(a[i])] = a[i];
        	}
        }

        out.println(len);
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int j = random.nextInt(n), temp = a[j];
			a[j] = a[i]; a[i] = temp;
		}
		Arrays.sort(a);
	}
}
