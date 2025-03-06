package com.mycompany.nguyenhuuphuc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class StudentNGTest {
    
    private Student student;
    private List<Student> students;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        student = new Student("S001", "Nguyen Huu Phuc", 20);
        students = new ArrayList<>();
        students.add(student);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testGetStudentId() {
        String expResult = "S001";
        String result = student.getStudentId();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetStudentId() {
        String studentId = "S002";
        student.setStudentId(studentId);
        assertEquals(student.getStudentId(), studentId);
    }

    @Test
    public void testGetName() {
        String expResult = "Nguyen Huu Phuc";
        String result = student.getName();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetName() {
        String name = "Le Thi B";
        student.setName(name);
        assertEquals(student.getName(), name);
    }

    @Test
    public void testGetAge() {
        int expResult = 20;
        int result = student.getAge();
        assertEquals(result, expResult);
    }

    @Test
    public void testSetAge() {
        int age = 21;
        student.setAge(age);
        assertEquals(student.getAge(), age);
    }

    @Test
    public void testToString() {
        String expResult = String.format("| %-10s | %-20s | %-5d |", "S001", "Nguyen Huu Phuc", 20);
        String result = student.toString();
        assertEquals(result, expResult);
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student("S002", "Tran Van C", 19);
        students.add(newStudent);
        assertEquals(2, students.size());
        assertTrue(students.contains(newStudent));
    }

    @Test
    public void testDeleteStudent() {
        students.removeIf(student -> student.getStudentId().equals("S001"));
        assertEquals(0, students.size());
    }

    @Test
    public void testUpdateStudent() {
        for (Student s : students) {
            if (s.getStudentId().equals("S001")) {
                s.setName("Updated Name");
                s.setAge(22);
                break;
            }
        }
        assertEquals(students.get(0).getName(), "Updated Name");
        assertEquals(students.get(0).getAge(), 22);
    }
}
