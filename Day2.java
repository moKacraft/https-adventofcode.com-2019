public class Day2 {

	static final int NOUN_MAX = 99;
	static final int NOUN_REPLACE = 12;
	static final int VERB_MAX = 99;
	static final int VERB_REPLACE = 2;
	static final int OUTPUT_TO_FIND = 19690720;

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		input.useDelimiter("\\D");
		java.util.ArrayList<Integer> values = new java.util.ArrayList<Integer>();
		while (input.hasNextInt()) {
			values.add(input.nextInt());
		}
		input.close();

		for (int noun = NOUN_REPLACE; noun < NOUN_MAX; noun++) {
			for (int verb = VERB_REPLACE; verb < VERB_MAX; verb++) {
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
				if (valuesArray[0] == OUTPUT_TO_FIND) {
					int anwser = 100 * noun + verb;
					System.out.println("anwser " + anwser);
					noun = NOUN_MAX;
					verb = VERB_MAX;
				}
			}
		}
	}
}
