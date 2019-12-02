public class Day2 {

     public static void main(String []args){
        java.util.Scanner input = new java.util.Scanner(System.in);
        input.useDelimiter("\\D");
        java.util.ArrayList<Integer> values = new java.util.ArrayList<Integer>();
        while (input.hasNextInt()) {
            values.add(input.nextInt());
        }

        Integer[] valuesArray = values.toArray(new Integer[0]);
        valuesArray[1] = 12;
        valuesArray[2] = 2;
        for (int i=0;i<valuesArray.length;i++) {
            int opCode = valuesArray[i];
            int iPos1 = 0;
            int iPos2 = 0;
            int oPos = 0;
            switch(opCode) {
                case 1:
                    iPos1 = valuesArray[++i];
                    iPos2 = valuesArray[++i];
                    oPos = valuesArray[++i];
                    valuesArray[oPos] = valuesArray[iPos1] + valuesArray[iPos2];
                    break;
                case 2:
                    iPos1 = valuesArray[++i];
                    iPos2 = valuesArray[++i];
                    oPos = valuesArray[++i];
                    valuesArray[oPos] = valuesArray[iPos1] * valuesArray[iPos2];
                    break;
                case 99:
                    i = valuesArray.length;
                    break;
                default:
                    break;
            }
        }
        System.out.println(valuesArray[0]);
     }
}
