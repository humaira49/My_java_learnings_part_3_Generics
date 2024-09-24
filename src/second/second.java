package second;

public class second {
	public static void main(String[] args) {
//	 we start with generic__________________________________________
		Container<String> obj1 = new Container<>("Humaira");
		Container<Integer> obj2 = new Container<>(12345);
		Container<Boolean> obj3 = new Container<>(true);
		Container<Double> obj4 = new Container<>(25.59);
		System.out.println(obj1.getData() + "\n" + obj2.getData() + "\n" + obj3.getData() + "\n" + obj4.getData());
//	 Generic interfaces_______________________________________________
		Replacer<String> fce1 = new Box<>();
		Replacer<String> fce2 = new StringBag(); // non-generic class
		fce1.replace("Humaira");
		fce2.replace("Mehraban");
//		how to print them, without using getter and setter, Wow its new ! 
		System.out.println(((Box<String>) fce1).data);
		System.out.println(((StringBag) fce2).data);
//		Generic Methods___________________________________________________
		StringBox mthd1 = new StringBox();
		System.out.println(mthd1.isSrting("Humaira"));
		System.out.println(mthd1.isSrting(22));
		System.out.println(second.isDouble(30.4));
//		Multiple generic parameters_______________________________________
		Box2<String, Integer> multiParam = new Box2<>("Humaira", 22);
//		we print them using its getters
		System.out.println(multiParam.getItem1());
		System.out.println(multiParam.getItem2());
//		with setters we can set to them new values
		multiParam.setItem1("Sabrina");
		multiParam.setItem2(28);
		System.out.println(multiParam.getItem1() + " " + multiParam.getItem2());
//multiple generic method parameters, static
		System.out.println(second.areNumbers(3, "no"));
//restricting T type for Numbers 
		Box3<Integer> num1 = new Box3<>();
		num1.setData(10);
		System.out.println(num1.getData());
		Box3<Double> num2 = new Box3<>();
		num2.setData(80.4);
		System.out.println(num2.getData());
//we can do the same for generic methods 
		System.out.println(second.isZero(0));
//____________________________________wildcards__________________________________________
//not stricting DataType______________________________________
		printContainer(obj1);
		printContainer(obj2);
		printContainer2(obj2);
//______________interface___________
		Animal myDog = new Dog();
		myDog.eat();
		myDog.sleep();
		myDog.breathe();
		Animal.showInfo();
		Flyable duck = new Duck();
		Swimmable duck2 = new Duck();
		duck.fly();
		duck2.swim();
		// abstract class
		Animal2 dog = new Dog2();
		dog.makeSound();
	}

//_______________________________________Methods__________________________________
//	Generic Static Method
	public static <T> boolean isDouble(T object) {
		return object instanceof Double;
	}

//multiple generic method parameters_________________________________	
	public static <T, S> boolean areNumbers(T item1, S item2) {
		return item1 instanceof Number && item2 instanceof Number;
	}

//restricting T dataType to Numbers 
	public static <T extends Number> boolean isZero(T data) {
		return data.equals(0);
	}

//_______________________________________Wildcards_______________________________________
//not stricting DataType______________________________________________
	public static void printContainer(Container<?> container) {
		System.out.println(container.toString());
	}

//restricting wildcards
	public static void printContainer2(Container<? super Integer> container) {
		System.out.println(container.toString());
	}
}

//Generic Interfaces_____________________________________________
interface Replacer<T> {
	void replace(T data);
}

// generic class
class Box<T> implements Replacer<T> {
	public T data;

	@Override
	public void replace(T data) {
		this.data = data;
	}
}

//non-generic class
class StringBag implements Replacer<String> {
	public String data;

	@Override
	public void replace(String data) {
		this.data = data;
	}
}

//Generic Methods_____________________________________
class StringBox {
	private String data;

	public <T> boolean isSrting(T item) {
		return item instanceof String; // checks if item is String or not?
	}

}

//multiple generic parameters____________________________
class Box2<T, S> {
	private T item1;
	private S item2;

	// constructor
	public Box2(T item1, S item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

//	these are the setter and getter that eclipse itself provided
	public T getItem1() {
		return item1;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public S getItem2() {
		return item2;
	}

	public void setItem2(S item2) {
		this.item2 = item2;
	}

}

//we can restrict the T type for a specific dataType
class Box3<T extends Number> {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
//we can also specify more than one data types like this
//public class Box <T extends Number & Comparable<T>> {
//	  private T data; 
//	}
