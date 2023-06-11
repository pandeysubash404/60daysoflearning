public class Day11 {
	public int reverse(int x) {
		//assume non negative first
		boolean negFlag = false;
		//if assume got wrong
		if (x < 0) {
			negFlag = true;
			x = -x;
		}

		int prev_rev = 0, rev = 0;
		while (x != 0) {
			int curr = x % 10;
			rev = (rev * 10) + curr;
			//goes out of bounds
			if ((rev - curr) / 10 != prev_rev) {
				return 0;
			}

			prev_rev = rev;
			x = x / 10;
		} // while
		return (negFlag == true) ? -rev : rev;
	}//reverse

	public static void main(String[] args) {
		Day11 day11 = new Day11();
		int num=-123;
		int result = day11.reverse(num);
		System.out.println(result);

	}

}
