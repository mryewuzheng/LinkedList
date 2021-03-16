public class ArrReverse {
    public static void main(String[] args) {

    }

    public int getarr(int nums){
        int num1 = nums%10;
        int num2 = (nums/10)%10;
        int num3 = (nums/10/10)%10;
        return num3 + num2*10 + num1*10;
    }
}
