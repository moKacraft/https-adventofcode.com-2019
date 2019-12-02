public class Day2 {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		input.useDelimiter("\\D");
		java.util.ArrayList<Integer> values = new java.util.ArrayList<Integer>();
		while (input.hasNextInt()) {
			values.add(input.nextInt());
		}

		for (int noun = 12; noun < 99; noun++) {
			for (int verb = 2; verb < 99; verb++) {
				System.out.println(noun + " : " + verb);

				Integer[] valuesArray = values.toArray(new Integer[0]);
				valuesArray[1] = noun;
				valuesArray[2] = verb;
				for (int i = 0; i < valuesArray.length; i++) {
					int opCode = valuesArray[i];
					int iPos1 = 0;
					int iPos2 = 0;
					int oPos = 0;
					switch (opCode) {
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
				if (valuesArray[0] == 19690720) {
					int anwser = 100 * noun + verb;
					System.out.println("anwser " + anwser);
					noun = 99;
					verb = 99;
				}
				if (valuesArray[0] > 19690720) {
					System.out.println("too high");
					noun = 99;
					verb = 99;
				}

			}
		}
	}
}
