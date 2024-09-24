package second;

//________________________________interface_____________________________________________
interface Animal {
	void eat(); // abstract method: without body.

	void sleep();

	default void breathe() {
		System.out.println("Dog breathes");
	}

	static void showInfo() {
		System.out.println("this is the dog info");
	}
}

public class Dog implements Animal {
	public void eat() {
		System.out.println("Dog eats");
	}

	public void sleep() {
		System.out.println("Dog sleeps");
	}
}

//_________A class can implement multiple interfaces_______
interface Flyable {
	void fly();
}

interface Swimmable {
	void swim();
}

class Duck implements Flyable, Swimmable {
	public void fly() {
		System.out.println("Duck flies");
	}

	public void swim() {
		System.out.println("Duck swims");
	}
}

//abstraction
//It focuses on what an object does rather than how it does it
abstract class Animal2 {
	abstract void makeSound(); // Abstract method
}

class Dog2 extends Animal2 {
	void makeSound() {
		System.out.println("Bark");
	}
}
