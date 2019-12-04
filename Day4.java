public class Day4 {
	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Day4.class.getName());

	static final int LOW_RANGE = 168630;
	static final int HIGH_RANGE = 718098;

	public static void main(String[] args) {
		java.util.ArrayList<Integer> meetCriteriaPart1 = new java.util.ArrayList<>();
		for (int i = LOW_RANGE; i < HIGH_RANGE + 1; i++) {
			int[] array = new int[6];
			int value = i;
			int index = 5;
			while (value >= 1) {
				array[index--] = value % 10;
				value /= 10;
			}
			if (hasAdjacentsSame(array) && neverDrecreases(array)) {
				meetCriteriaPart1.add(i);
			}
		}
		LOGGER.info("part1: " + meetCriteriaPart1.size());
		java.util.ArrayList<Integer> meetCriteriaPart2 = new java.util.ArrayList<>();
		for (int i : meetCriteriaPart1) {
			int[] array = new int[6];
			int value = i;
			int index = 5;
			while (value >= 1) {
				array[index--] = value % 10;
				value /= 10;
			}
			if (hasAtLeastTwoAdjacents(array)) {
				meetCriteriaPart2.add(i);
			}
		}
		LOGGER.info("part2: " + meetCriteriaPart2.size());
	}

	private static boolean hasAtLeastTwoAdjacents(final int[] value) {
		if ((value[0] == value[1] && value[1] != value[2]) || (value[3] != value[4] && value[4] == value[5])) {
			return true;
		}
		int i = 0;
		while (i != 3) {
			int j = i++;
			if ((value[j] != value[j + 1] && value[j + 1] == value[j + 2] && value[j + 2] != value[j + 3])) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasAdjacentsSame(final int[] value) {
		int i = 0;
		while (i != 5) {
			if (value[i] == value[++i]) {
				return true;
			}
		}
		return false;
	}

	private static boolean neverDrecreases(final int[] value) {
		int i = 0;
		while (i != 5) {
			if (value[i] > value[++i]) {
				return false;
			}
		}
		return true;
	}

}
