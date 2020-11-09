import java.io.*;
import java.util.*;

public class MoneySums {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int a[] = in.readArray(n);
        int sum = 0;
        for(int i : a) sum+=i;
        int dp[][] = new int[n+1][sum+1];
    	dp[0][0] = 1;
    	for(int i=1;i<=n;i++){
    		dp[i][a[i-1]] = 1;
    		for(int j=1;j<=sum;j++){
    			if(dp[i-1][j]==1) dp[i][j] = 1;
    			if(j-a[i-1]>=0&&dp[i-1][j-a[i-1]]==1) dp[i][j] = 1;
    		}
    	}
    	int ans = 0;
    	for(int i=1;i<=sum;i++) if(dp[n][i]==1) ans++;
    	out.println(ans);
    	for(int i=1;i<=sum;i++) if(dp[n][i]==1) out.print(i+" ");
    	out.println();
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
