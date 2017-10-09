/**
 * Created by vatsa on 5/7/2016.
 */
public class HirshbergLCS {
    public int[] algoB(int m, int n, String x, String y) {

        int[][] k = new int[2][n+1];
        for( int j=0; j<=n; j++) {
            k[1][j] = 0;
        }


        for(int i=1; i<=m; i++) {

            for(int j=0; j<=n; j++) {
                k[0][j] = k[1][j];
            }


            for(int j=1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    k[1][j] = k[0][j-1] + 1;
                }else{
                    k[1][j] = Math.max(k[1][j-1], k[0][j]);
                }
            }
        }


        return k[1];
    }
    public String algoC(int m, int n, String x, String y) {
        int i=0;
        int j=0;
        String c = "";

        if( n==0 ) {
            c = "";
        } else if( m==1 ) {
            c = "";
            for( j=0; j<n; j++ ) {
                if( x.charAt(0)==y.charAt(j) ) {
                    c= ""+x.charAt(0);
                    break;
                }
            }
        } else {
            i= (int) Math.floor(((double)m)/2);
            int[] l1 = algoB(i, n, x.substring(0,i), y);
            int[] l2 = algoB(m-i, n, reverseString(x.substring(i)), reverseString(y));
            int a = 0;
            int k = 0;

            for(int l = 0; l <= n; l++) {
                if(a < ( l1[l] + l2[n-l] )) {
                    a = l1[l] + l2[n-l];
                    k = l;
                }
            }
            String c1 = algoC(i, k, x.substring(0, i), y.substring(0, k));
            String c2 = algoC(m-i, n-k, x.substring(i), y.substring(k));
            c = c1 + c2;
        }

        return c;
    }
    public String reverseString(String str) {
        String rev = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        return rev;
    }

    public static void main(String[] args){
        HirshbergLCS lcs = new HirshbergLCS();
        String x = "fjdkjfdfj";
        String y = "djsskfjdfjlfj";
        int m = x.length();
        int n = y.length();
        String something = lcs.algoC(m,n,x,y);
        System.out.println(something);

    }
}
