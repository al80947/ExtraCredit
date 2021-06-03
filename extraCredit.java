import java.util.ArrayList;
import java.lang.Math;

public class extraCredit {

    public static ArrayList<Integer> getFactors(int num) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = num; i > 0; i--) {
            if(num % i == 0) {
                nums.add(i);
            }
        }
        return nums;
    }

    public static int getGFC(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> commonFactors = new ArrayList<Integer>();
        int gcf = 0;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            if(b.contains(num)) {
                commonFactors.add(num);
            }
        }
        for (int i = 0; i < commonFactors.size(); i++) {
            int num = commonFactors.get(i);
            if(num > gcf) {
                gcf = num;
            }
        }
        return gcf;
    }
    public static void main(String[] args) {
        int tally = 0;
        // int max = Integer.MAX_VALUE;
        int max = 100000;
        // int count = 10000000
        int count = 100000;
        double magicNumber = 0.0;
        for(int i = 0; i < count; i++) {
            int num1 = (int) (Math.random()*(max+1-1)) + 1;
            int num2 = (int) (Math.random()*(max+1-1)) + 1;
            int factor = getGFC(getFactors(num1), getFactors(num2));
            if(factor == 1) {
                tally++;
            }
            System.out.println(factor);
        } 
        System.out.println("The two integers were coprime " + tally + " times");  
        int proportion = tally*100/count;
        System.out.println(proportion + "% was coprime");
        magicNumber = Math.sqrt(6/((double)proportion/100));
        System.out.println("The magic number is " + magicNumber);

    }
}