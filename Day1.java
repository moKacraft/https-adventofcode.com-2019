public class HelloWorld{

     public static void main(String []args){
        java.util.Scanner in = new java.util.Scanner(System.in);
        int res = 0;
        while (in.hasNextLine()  && in.hasNextInt()) {
            int r = (in.nextInt()/3)-2;
            res+=r;
            while (r > 0) {
                r = r/3-2;
                if (r > 0) {
                    res+=r;
                }
            }
        }
         System.out.println("res: " + res);
     }
}
