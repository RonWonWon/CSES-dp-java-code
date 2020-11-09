import java.io.*;
import java.util.*;

public class CoinCombinationsII {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(), x = in.nextInt();
        int a[] = in.readArray(n);
        int mod = (int)1e9+7;
        int dp[] = new int[(int)1e6+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++) {
        	for(int j=0;j<=x;j++) {
        		if(j-a[i-1]>=0) dp[j] = (dp[j] + dp[j-a[i-1]])%mod;
        	}
        }
        out.println(dp[x]);
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
