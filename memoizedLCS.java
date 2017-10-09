/**
 * Created by vatsa on 4/4/2016.
 */



public class memoizedLCS {
    public static int RecursiveCalls = 0;

    public int lcs( String x, String y,int i, int j,int [] []c){
        RecursiveCalls++;
        if (i == -1||j == -1) {
            return 0;
        }
        else{
            if (c[i][j] == -1){
                c[i][j] = 0;
                if (x.charAt(i) == y.charAt(j)){
                    c[i][j] = 1 + lcs(x,y,i-1,j-1,c);
                }
                else{
                    c[i][j] = Math.max(lcs(x, y, i - 1, j, c),lcs(x, y, i, j - 1, c));
                }

            }
            return c[i][j];

        }

    }

    public String recoverLCS(String x, String y, int m, int n, int [] []c){
        StringBuffer actualLCS = new StringBuffer();
        int flag = 0;

        while(m >- 1 && n >- 1) {
            if (x.charAt(m) == y.charAt(n)) {
                actualLCS.append(x.charAt(m));
                m -= 1;
                n -= 1;
            }
            else{

                if(c[m][n] == c[m-1][n]){
                    m = m - 1;
                }
                else{
                    n = n - 1;
                }
            }

            if (m == 0) {
                while( n >-1 ) {
                    if (x.charAt(m) == y.charAt(n)) {
                        actualLCS.append(x.charAt(m));
                        flag = 1;
                        break;
                    }
                    n--;
                }
                if (flag == 1) {
                    break;
                }
            }

            if (n == 0){
                while(m >- 1) {
                    if (x.charAt(m) == y.charAt(n)) {
                        actualLCS.append(x.charAt(m));
                        flag = 1;
                        break;
                    }
                    m--;
                }
                if (flag == 1) {
                    break;
                }

            }

        }

        return actualLCS.reverse().toString();
    }


    public String callActualLCS(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        int [] [] c= new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                c[i][j] = -1;
            }
        }
        //return lcs(s1,s2,m-1,n-1,c);
       return recoverLCS(s1, s2, m - 1, n - 1, c);

    }
    public int NumberOfRec() {
        return RecursiveCalls;
    }
    public static void main(String[] args) {
        memoizedLCS l1 = new memoizedLCS();

        int m=args[0].length();
        int n=args[1].length();

        int [] [] c= new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                c[i][j] = -1;
            }
        }

        int longestLength=l1.lcs(args[0],args[1],m-1,n-1,c);

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                System.out.print(" "+c[i][j]);
            }
            System.out.print("\n");
        }

        System.out.println("The length is "+longestLength);
        if (longestLength>0) {
            System.out.println("The longest sub-sequence is " +
                    l1.recoverLCS(args[0], args[1], m - 1, n - 1, c));
        }
        String str = "abdjdgjsg";
        int len = str.length();
        System.out.println("Number of calls: " + RecursiveCalls +"  " + len);


    }
}
