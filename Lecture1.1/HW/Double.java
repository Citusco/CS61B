public class Double {
	public static void main(String[] ags){
		String a = "Achilles";
		String t = "Tortoise";
		double aPos = 0;
		double tPos = 100;
		double aspeed = 20;
		double tspeed = 10;
		double totalTime = 0;
		// show the last position before a reach t's original position.
		while (aPos < tPos){
			System.out.println("At time: " + totalTime);
			System.out.println("	" + a + " at the position" + aPos);
			System.out.println("	" + t + " at the position" + tPos);
			double timeToReach = (tPos - aPos) / aspeed;
			totalTime = totalTime + timeToReach;
			aPos = aPos + aspeed * totalTime;
			tPos = tPos + tspeed * totalTime;
		}
	}

}