import java.io.*;
import java.util.*;

public class TwoSetsII {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int m = in.nextInt();
        int n = (m*(m+1))/4;
        int mod = (int)1e9+7;
        if(((m*(m+1))/2)%2==1) out.println(0);
        else{
        	int dp[][] = new int[m][n+1];
        	for(int i=1;i<m;i++){
        		dp[i][i] = 1;
        		for(int j=1;j<=n;j++){
        			dp[i][j] += dp[i-1][j];
        			if(j-i>0) dp[i][j] = (dp[i][j] + dp[i-1][j-i])%mod;
        		}
        	}
       		out.println(dp[m-1][n]);
        }
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
