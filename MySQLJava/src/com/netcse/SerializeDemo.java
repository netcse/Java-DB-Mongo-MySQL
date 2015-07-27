package com.netcse;

import java.io.*;


class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck(){
        System.out.println("mailing check " + name + " " + address);
    }
}


class  DeserializaDemo{
    void DeserializaDemo(){
        Employee e = null;
        try {
            FileInputStream fileInput = new FileInputStream("out.ser");
            ObjectInput in = new ObjectInputStream(fileInput);
            e = (Employee)in.readObject();
            in.close();
            fileInput.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }

        System.out.println("Deserialize Example: ");
        System.out.println("Name : " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("Number : " + e.number);
        System.out.println("SSN : " + e.SSN);
    }
}

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Amran";
        e.address = "Gazipur";
        e.SSN = 123456;
        e.number = 101;
        try {
            FileOutputStream out = new FileOutputStream("out.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(e);
        }catch (IOException i){
            i.printStackTrace();
        }

        DeserializaDemo ds = new DeserializaDemo();
        ds.DeserializaDemo();
    }
}












