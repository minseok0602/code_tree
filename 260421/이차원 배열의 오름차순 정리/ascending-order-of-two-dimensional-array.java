import java.util.Scanner;

public class Main {
    public static long n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        long k = sc.nextLong();
        long start = 1L;
        long end = n*n;
        long mid = 0;
        long answer = 0;
        while(start<end){
            mid = (start+end)/2;
            // mid가 가질 수 있는 최대 등수 -> mid보다 큰 것의 개수를 구해야함
            long max_rank = calculate_bigger_count(mid);
            if(max_rank>=k){
                answer = mid;
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.print(answer);

    }
    static public long calculate_bigger_count(long num){
        long cnt = 0;
        for(int i = 1;i<=n;i++){
            long start = 1;
            long end = n+1;
            long mid = 0;
            long cur_answer = n+1;
            while(start<end){
                mid = (start+end)/2;
                if(i*mid<=num){
                    start = mid + 1;
                }
                else{
                    cur_answer = mid;
                    end = mid;
                }
            }
            //i*mid는 무조건 num보다는 큰 값일 것
            if(cur_answer<=n){
                cnt+=(n+1-cur_answer);
            }
        }
        return n*n-cnt;
    }
}