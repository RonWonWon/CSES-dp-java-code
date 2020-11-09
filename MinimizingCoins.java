import java.io.*;
import java.util.*;

public class MinimizingCoins {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(), x = in.nextInt();
        int a[] = in.readArray(n);
        int dp[] = new int[(int)1e6+10];
        Arrays.fill(dp,(int)1e9);
        for(int i : a) dp[i] = 1;
        for(int i=1;i<=x;i++){
        	for(int j : a){
        		if(i-j>=0&&dp[i-j]!=(int)1e9){
        			dp[i] = Math.min(dp[i],dp[i-j] + 1);
        		}
        	}
        }
        out.println((dp[x]==(int)1e9)?-1:dp[x]);
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
