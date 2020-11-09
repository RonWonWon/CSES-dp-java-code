import java.io.*;
import java.util.*;

public class GridPaths {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        char ch[][] = new char[n][n];
        for(int i=0;i<n;i++) ch[i] = in.next().toCharArray();
        long dp[][] = new long[n][n];
    	long mod = (long)1e9+7;
    	dp[0][0] = 1L;
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			if(ch[i][j]=='*') continue;
    			if(i-1>=0) dp[i][j] = (dp[i][j]+dp[i-1][j])%mod;
    			if(j-1>=0) dp[i][j] = (dp[i][j]+dp[i][j-1])%mod;
    		}
    	}
    	out.println((ch[0][0]=='*')?0:dp[n-1][n-1]);
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
