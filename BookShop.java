import java.io.*;
import java.util.*;
		
public class BookShop {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(), x = in.nextInt();
        int price[] = in.readArray(n), pages[] = in.readArray(n);
        int dp[][] = new int[n+1][x+1];
        for(int i=1;i<=n;i++){
        	for(int j=0;j<=x;j++){
        		dp[i][j] = dp[i-1][j];
        		if(j-price[i-1]>=0) dp[i][j] = Math.max(dp[i][j],dp[i-1][j-price[i-1]] + pages[i-1]);
        	}
        }/*
        for(int i=0;i<=n;i++){
        	for(int j=0;j<=x;j++) out.print(dp[i][j]+" ");
        		out.println();
        }*/
        for(int i=0;i<=x;i++){
        	dp[n][x] = Math.max(dp[n][x],dp[n][i]);
        }
        out.println(dp[n][x]);
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
