import java.io.*;
import java.util.*;

public class EditDistance {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        char a[] = in.next().toCharArray(), b[] = in.next().toCharArray();
        int n = a.length, m = b.length;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],(int)1e9);
        dp[0][0] = 0;
        for(int i=0;i<=n;i++){
        	for(int j=0;j<=m;j++){
        		if(i>0) dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
        		if(j>0) dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
        		if(i>0&&j>0) {
        			dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
        			if(a[i-1]==b[j-1]) dp[i][j] = Math.min(dp[i-1][j-1],dp[i][j]);
        		}
        	}
        }/*
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=m;j++) out.print(dp[i][j]+" ");
        	out.println();
        }*/
        out.println(dp[n][m]);
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
