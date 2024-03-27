package com.kral.doctor;

import com.nau.pet.Dog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class VetClinic { //Deserialization
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		try(FileInputStream fir = new FileInputStream("Blanket.ser");
				ObjectInputStream ois = new ObjectInputStream(fir)){
			
			Object object = ois.readObject();
			//System.out.println(object);
			Dog dog = (Dog) object;
			System.out.println(dog);
		}
	}

}
