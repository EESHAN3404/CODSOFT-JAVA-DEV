import java.util.Scanner;
public class STUGRADE
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER THE TOTAL NO OF SUBS: ");
        int numsubs = scan.nextInt();
        int totalmarks = 0 ;

        
        for (int i=1; i<numsubs; i++) {
            System.out.println("ENTER THE MARKS FOR SUB" + i + "(OUT OF 100): ");
            int marks = scan.nextInt();
            while(marks<0 || marks>100){
                System.out.println("INVALID MARKS. RENTER THE MARKS");
                System.out.println("ENTER MARKS FOR SUB" + i + "OUT OF 100");
                marks = scan.nextInt();
            }
            totalmarks += marks;
        }
        System.out.println("RESULT:");
        System.out.println("TOTAL MARKS OBTAINED :" + totalmarks);

        int AvgPer= totalmarks/numsubs;
        System.out.println("AVGPERCENTAGE:" + AvgPer );

        if(AvgPer >= 95){
            System.out.println("GRADE OBTAINED: O");
        }
        else if(AvgPer >= 90){
            System.out.println("GRADE OBTAINED: A+");
        }
         else if(AvgPer >= 80){
            System.out.println("GRADE OBTAINED: A");
        }
         else if(AvgPer >= 70){
            System.out.println("GRADE OBTAINED: B");
        }
        else if(AvgPer >= 60){
            System.out.println("GRADE OBTAINED: C");
        }
         else if(AvgPer >= 50){
            System.out.println("GRADE OBTAINED: D");
        }
         else if(AvgPer >= 40){
            System.out.println("GRADE OBTAINED: E");
        }
        else if(AvgPer >= 35){
            System.out.println("GRADE OBTAINED: P");
        }
         else{
            System.out.println("GRADE OBTAINED: FAILED");
        }

      scan.close();
    }
}