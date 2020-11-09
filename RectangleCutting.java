import java.io.*;
import java.util.*;

public class RectangleCutting {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt(), b = in.nextInt();
        int dp[][] = new int[a+1][b+1];
        for(int i=1;i<=a;i++) Arrays.fill(dp[i],(int)1e9);
        for(int i=1;i<=a;i++){
        	for(int j=1;j<=b;j++){
        		if(i==j){
        			dp[i][j] = 0; continue;
        		}
        		int m1,m2; m1=m2=Integer.MAX_VALUE;
        		for(int p=1;p<i;p++){
        			m1 = Math.min(m1,dp[p][j]+dp[i-p][j]);
        		}
        		for(int p=1;p<j;p++){
        			m2 = Math.min(m2,dp[i][p]+dp[i][j-p]);
        		}
        		dp[i][j] = 1 + Math.min(m1,m2);
        	}
        } 
        out.println(dp[a][b]);
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
