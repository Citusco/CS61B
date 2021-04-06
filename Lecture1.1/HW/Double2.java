public class Double2 {
	public static void main(String[] ags){
		String a = "Achilles";
		String t = "Tortoise";
		double aPos = 0;
		double tPos = 100;
		double aspeed = 20;
		double tspeed = 10;
		double totalTime = 0;
		// show the every a and t's position by every 1 second.
		while (aPos < tPos){
			System.out.println("At time: " + totalTime);
			System.out.println("	" + a + " at the position" + aPos);
			System.out.println("	" + t + " at the position" + tPos);
			totalTime = totalTime + 1;
			aPos = aPos + aspeed * 1;
			tPos = tPos + tspeed * 1;
		}
	}

}