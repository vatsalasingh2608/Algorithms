/**
 * Created by vatsa on 5/5/2016.
 */
public class DynamicLCS {
    public String dynLCS(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] mem = new int[m+1][n+1];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (x.charAt(i) == y.charAt(j)){
                    mem[i+1][j+1] = mem[i][j] + 1;

                }
                else {
                    mem[i+1][j+1] = Math.max(mem[i+1][j],mem[i][j+1]);
                }
            }
        }
        //int len = mem[m][n];
        //return len;
        // recovering the strings
        StringBuffer str = new StringBuffer();
        for ( int i = m, j = n; i != 0 && j != 0;) {
            if (mem[i][j] == mem[i-1][j]) {
                i--;
            }
            else if (mem[i][j] == mem[i][j-1]) {
                j--;
            }
            else {
                str.append(x.charAt(i-1));
                i--;
                j--;
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args){
        DynamicLCS dlcs = new DynamicLCS();
        String len = dlcs.dynLCS("fjdkjfdfj", "djsskfjdfjlfj");
        System.out.println("Longest common subsequence is :" + len);
    }

}
