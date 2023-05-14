package org.example;
import org.example.MyHashTable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rand = new Random();

        // create some students
        Student student1 = new Student("John", 20);
        Student student2 = new Student("Jane", 19);
        Student student3 = new Student("Bob", 22);

// put the students into the table
        table.put(new MyTestingClass(1, "obj1"), student1);
        table.put(new MyTestingClass(2, "obj2"), student2);
        table.put(new MyTestingClass(3, "obj4"), student3);

// get a student by key
        Student student = table.get(new MyTestingClass(2, "obj2"));
        System.out.println("Student with key 2: " + student.getName() + " " + student.getAge());

// remove a student by key
        Student removedStudent = table.remove(new MyTestingClass(1, "obj1"));
        System.out.println("Removed student: " + removedStudent.getName() + " " + removedStudent.getAge());

// check if a student is in the table
        boolean containsStudent = table.contains(student3);
        System.out.println("Contains student3: " + containsStudent);

// put a new student with the same key, updating the previous value
        Student newStudent = new Student("Sam", 21);
        table.put(new MyTestingClass(2, "obj2"), newStudent);

// get the updated student by key
        Student updatedStudent = table.get(new MyTestingClass(2, "obj2"));
        System.out.println("Updated student with key 2: " + updatedStudent.getName() + " " + updatedStudent.getAge());

// check if the removed student is still in the table
        containsStudent = table.contains(removedStudent);
        System.out.println("Contains removed student: " + containsStudent);


        for (int i = 0; i < 10000; i++) {
            MyTestingClass key2 = new MyTestingClass(rand.nextInt(1000), "name" + i);
            Student value = new Student("student" + i, rand.nextInt(20) + 18);
            table.put(key2, value);
        }

        table.printBucketSizes();
    }
}