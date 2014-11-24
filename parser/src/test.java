import java.util.Arrays;
import java.util.Scanner;


public class test {
	public static void main (String args[]){
		Scanner in= new Scanner(System.in);
		int n= in.nextInt();
		int [] a= new int [n];
		int [] match = new int [2000001];
		Arrays.fill(match, 0);
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
			match[a[i]]++;
		}
		
		Arrays.sort(a);
		int max_=a[n-1];
		for(int i=1;i<=2*max_;i++)
			match[i]+=match[i-1];
		int lo=0; int hi=a[n-1];
		while(lo<hi){
			int mid=lo+hi+1;
			mid/=2;
			if(!check(mid,a,match,n)) 
				hi=mid-1;
			else 
				lo=mid;
			//System.out.println(lo + "  " + hi);
		}
		System.out.print("hey the answer is = ");
		System.out.println(lo);
		
		
		
	
	}

	private static boolean check(int rem, int[] a, int[] match,int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			if(a[i]<=rem)continue;
			if(i>0 && a[i-1]==a[i])continue;
			for(int base=a[i];base<=a[n-1];base+=a[i]){
				if(match[base+a[i]-1]-match[base+rem-1]>0)return true;
			}
		}
		return false;
	}
}
