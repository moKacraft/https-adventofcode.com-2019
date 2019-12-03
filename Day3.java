package adventcode;

public class Day3 {

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Day3.class.getName());

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		String[][] puzzleInput = new String[2][];
		for (int i = 0; input.hasNextLine() && i < 2; i++) {
			puzzleInput[i] = input.nextLine().split("\\s*,\\s*");
		}

		java.util.ArrayList<java.awt.Point>[] lines = new java.util.ArrayList[2];
		int lineNum = 0;
		for (String[] line : puzzleInput) {
			lines[lineNum] = new java.util.ArrayList<>();
			int x = 0, y = 0;
			for (String direction_value : line) {
				String next = direction_value;
				char direction = next.charAt(0);
				int value = Integer.parseInt(next.substring(1));

				switch (direction) {
				case 'U':
					for (int i = 0; i < value; i++) {
						y += 1;
						lines[lineNum].add(new java.awt.Point(x, y));
					}
					break;
				case 'R':
					for (int i = 0; i < value; i++) {
						x += 1;
						lines[lineNum].add(new java.awt.Point(x, y));
					}
					break;
				case 'D':
					for (int i = 0; i < value; i++) {
						y -= 1;
						lines[lineNum].add(new java.awt.Point(x, y));
					}
					break;
				case 'L':
					for (int i = 0; i < value; i++) {
						x -= 1;
						lines[lineNum].add(new java.awt.Point(x, y));
					}
					break;
				default:
					break;
				}

			}
			lineNum++;
		}
		input.close();

		java.util.ArrayList<java.awt.Point> intersections = new java.util.ArrayList<>();
		java.util.ArrayList<java.awt.Point> stepsValues = new java.util.ArrayList<>();

		for (java.awt.Point point : lines[0]) {
			for (java.awt.Point point2 : lines[1]) {
				if (point.x == point2.x && point.y == point2.y) {
					intersections.add(point);
					stepsValues.add(new java.awt.Point(lines[0].indexOf(point) + 1, lines[1].indexOf(point2) + 1));
					break;
				}
			}
		}

		int distance = 0;
		for (java.awt.Point p : intersections) {
			if (p.x < 1) {
				p.x *= -1;
			}
			if (p.y < 1) {
				p.y *= -1;
			}
			int intersectionDistance = p.x + p.y;
			if (distance == 0 || distance > intersectionDistance) {
				distance = intersectionDistance;
			}
		}
		LOGGER.info("distance: " + distance);

		int steps = 0;
		for (java.awt.Point p : stepsValues) {
			if (p.x < 1) {
				p.x *= -1;
			}
			if (p.y < 1) {
				p.y *= -1;
			}
			int intersectionSteps = p.x + p.y;
			if (steps == 0 || steps > intersectionSteps) {
				steps = intersectionSteps;
			}
		}
		LOGGER.info("steps: " + steps);
	}
}
