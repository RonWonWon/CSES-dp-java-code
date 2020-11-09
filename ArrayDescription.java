import java.io.*;
import java.util.*;

public class ArrayDescription {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt(), m = in.nextInt();
        int a[] = in.readArray(n);
        int mod = (int)1e9+7;
        int dp[][] = new int[n][m+1];
        if(a[0]==0) for(int i=1;i<=m;i++) dp[0][i] = 1;
        else dp[0][a[0]] = 1;
        for(int i=1;i<n;i++){
        	if(a[i]!=0){
        		for(int k=-1;k<=1;k++){
        			if(a[i]+k>=1&&a[i]+k<=m) dp[i][a[i]] = (dp[i][a[i]]+dp[i-1][a[i]+k])%mod;
        		}
        	}
        	else{
        		for(int j=1;j<=m;j++){
        			for(int k=-1;k<=1;k++){
        				if(j+k>=1&&j+k<=m) dp[i][j] = (dp[i][j]+dp[i-1][j+k])%mod;
        			}
        		}
        	}
        }
        int ans = 0;
        for(int i=1;i<=m;i++) ans = (ans+dp[n-1][i])%mod;
        out.println(ans);
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
