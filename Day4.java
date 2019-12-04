package adventcode;

public class Day4 {
	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Day4.class.getName());

	static final int LOW_RANGE = 168630;
	static final int HIGH_RANGE = 718098;

	public static void main(String[] args) {
		java.util.ArrayList<Integer> meetCriteria = new java.util.ArrayList<>();
		for (int i = LOW_RANGE; i < HIGH_RANGE + 1; i++) {
			int[] array = new int[6];
			int value = i;
			int index = 5;
			while (value >= 1) {
				array[index--] = value % 10;
				value /= 10;
			}
			if (hasAdjacentsSame(array) && neverDrecreases(array)) {
				meetCriteria.add(i);
			}
		}
		LOGGER.info("" + meetCriteria.size());
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
