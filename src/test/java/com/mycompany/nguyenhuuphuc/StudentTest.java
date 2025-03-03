/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.nguyenhuuphuc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    
    private Student student;

    @BeforeAll
    public static void setUpClass() {
        // Phương thức này chạy một lần trước tất cả các test case
    }

    @AfterAll
    public static void tearDownClass() {
        // Phương thức này chạy một lần sau tất cả các test case
    }

    @BeforeEach
    public void setUp() {
        // Khởi tạo đối tượng Student trước mỗi bài kiểm thử
        student = new Student("S001", "Nguyen Huu Phuc", 20);
    }

    @AfterEach
    public void tearDown() {
        // Phương thức này chạy sau mỗi bài kiểm thử
    }

    @Test
    public void testGetStudentId() {
        // Kiểm thử phương thức getStudentId()
        System.out.println("getStudentId");
        String expResult = "S001";
        String result = student.getStudentId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetStudentId() {
        // Kiểm thử phương thức setStudentId()
        System.out.println("setStudentId");
        String studentId = "S002";
        student.setStudentId(studentId);
        assertEquals(studentId, student.getStudentId());
    }

    @Test
    public void testGetName() {
        // Kiểm thử phương thức getName()
        System.out.println("getName");
        String expResult = "Nguyen Huu Phuc";
        String result = student.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        // Kiểm thử phương thức setName()
        System.out.println("setName");
        String name = "Le Thi B";
        student.setName(name);
        assertEquals(name, student.getName());
    }

    @Test
    public void testGetAge() {
        // Kiểm thử phương thức getAge()
        System.out.println("getAge");
        int expResult = 20;
        int result = student.getAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAge() {
        // Kiểm thử phương thức setAge()
        System.out.println("setAge");
        int age = 21;
        student.setAge(age);
        assertEquals(age, student.getAge());
    }

    @Test
    public void testToString() {
        // Kiểm thử phương thức toString()
        System.out.println("toString");
        String expResult = String.format("| %-10s | %-20s | %-5d |", "S001", "Nguyen Huu Phuc", 20);
        String result = student.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testMain() {
        // Phương thức main không cần kiểm thử trong phần lớn các trường hợp
    }
}
