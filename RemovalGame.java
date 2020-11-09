import java.io.*;
import java.util.*;

public class RemovalGame {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = in.readArray(n);
        long sum = 0;
        for(int i : a) sum += i;
        long dp[][] = new long[n+1][n+1];
        //for(int i=0;i<=n;i++) Arrays.fill(dp[i],(int)1e9);
        for(int i=n-1;i>=0;i--){
        	for(int j=i;j<n;j++){
        		if(i==j) dp[i][i] = a[i];
        		else 
        			dp[i][j] = Math.max(a[i]-dp[i+1][j],a[j]-dp[i][j-1]);
        	}
        }
        out.println((dp[0][n-1]+sum)/2);
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
