public class Day1{
     public static void main(String []args){
        java.util.Scanner input = new java.util.Scanner(System.in);
        int anwser = 0;
        while (input.hasNextInt()) {
            int nextInt = input.nextInt()/3-2;
            anwser += nextInt;
            while (nextInt > 0) {
                nextInt = nextInt/3-2;
                if (nextInt > 0) {
                    anwser += nextInt;
                }
            }
        }
         System.out.println(anwser);
     } 
}
