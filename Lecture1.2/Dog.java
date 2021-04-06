// without "main", you cannot run the Dog class.
public class Dog {
	/*public static void makenoise(){
		System.out.println("Bark!");
	}*/
	public int weightInPounds;
	public Dog(int w) {
		weightInPounds = w;
	}
	public static Dog maxDog(Dog d1, Dog d2) {
		if (d1.weightInPounds > d2.weightInPounds) {
			return d1;
		}
		return d2;
	}
	public Dog maxDog(Dog d2) {
		if(this.weightInPounds > d2.weightInPounds) {
			return this;
		}
		return d2;
	}
}