/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nguyenhuuphuc;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList; // Nhập thư viện ArrayList
import java.util.List; // Nhập thư viện List
import java.util.Scanner; // Nhập thư viện Scanner

public class Student {

    private String studentId; // Khai báo thuộc tính id của sinh viên
    private String name; // Khai báo thuộc tính name của sinh viên
    private int age; // Khai báo thuộc tính age của sinh viên

    // Constructor khởi tạo đối tượng Student với id, name, và age
    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    // Getter và setter cho các thuộc tính
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Phương thức hiển thị thông tin sinh viên dưới dạng bảng
    @Override
    public String toString() {
        return String.format("| %-10s | %-20s | %-5d |", studentId, name, age);
    }

    private static List<Student> students = new ArrayList<>(); // Tạo danh sách lưu trữ sinh viên
    private static Scanner scanner = new Scanner(System.in); // Tạo đối tượng Scanner để nhập liệu

    public static void main(String[] args) {
        // Nhập số lượng sinh viên cần thêm
        System.out.print("Nhap so luong sinh vien can them: ");
        int numStudents = Integer.parseInt(scanner.nextLine()); // Nhập số lượng sinh viên từ bàn phím

        // Nhập thông tin sinh viên
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            System.out.print("ID: ");
            String studentId = scanner.nextLine(); // Nhập ID của sinh viên
            System.out.print("Name: ");
            String name = scanner.nextLine(); // Nhập tên của sinh viên
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine()); // Nhập tuổi của sinh viên

            students.add(new Student(studentId, name, age)); // Thêm sinh viên vào danh sách
        }

        // Hiển thị thông tin sinh viên dưới dạng bảng
        displayStudents();

        // Hiển thị menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Xoa sinh vien");
            System.out.println("2. Sua sinh vien");
            System.out.println("3. Thoat");
            System.out.print("Lua chon cua ban: ");
            int choice = Integer.parseInt(scanner.nextLine()); // Nhập lựa chọn của người dùng

            // Xử lý lựa chọn của người dùng
            switch (choice) {
                case 1:
                    deleteStudent(); // Xóa sinh viên
                    break;
                case 2:
                    updateStudent(); // Sửa thông tin sinh viên
                    break;
                case 3:
                    System.exit(0); // Thoát chương trình
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai."); // Thông báo lựa chọn không hợp lệ
            }

            displayStudents(); // Cập nhật bảng sau mỗi thao tác
        }
    }

    // Phương thức hiển thị bảng thông tin sinh viên
    private static void displayStudents() {
        System.out.println("+------------+----------------------+-----+");
        System.out.println("| ID         | Name                 | Age |");
        System.out.println("+------------+----------------------+-----+");
        for (Student student : students) {
            System.out.println(student); // Hiển thị thông tin từng sinh viên
        }
        System.out.println("+------------+----------------------+-----+");
    }

    // Phương thức xóa sinh viên theo ID
    private static void deleteStudent() {
        System.out.print("Nhap ID sinh vien can xoa: ");
        String studentId = scanner.nextLine(); // Nhập ID sinh viên cần xóa
        students.removeIf(student -> student.getStudentId().equals(studentId)); // Xóa sinh viên khỏi danh sách
        System.out.println("Sinh vien da duoc xoa."); // Thông báo sinh viên đã được xóa
    }

    // Phương thức cập nhật thông tin sinh viên theo ID
    private static void updateStudent() {
        System.out.print("Nhap ID sinh vien can sua: ");
        String studentId = scanner.nextLine(); // Nhập ID sinh viên cần sửa
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Chon thong tin can sua:");
                System.out.println("a. ID");
                System.out.println("b. Name");
                System.out.println("c. Age");
                System.out.print("Lua chon cua ban: ");
                char option = scanner.nextLine().charAt(0); // Nhập lựa chọn của người dùng

                // Xử lý lựa chọn của người dùng
                switch (option) {
                    case 'a':
                        System.out.print("Nhap ID moi: ");
                        student.setStudentId(scanner.nextLine()); // Cập nhật ID mới
                        break;
                    case 'b':
                        System.out.print("Nhap Name moi: ");
                        student.setName(scanner.nextLine()); // Cập nhật tên mới
                        break;
                    case 'c':
                        System.out.print("Nhap Age moi: ");
                        student.setAge(Integer.parseInt(scanner.nextLine())); // Cập nhật tuổi mới
                        break;
                    default:
                        System.out.println("Lua chon khong hop le."); // Thông báo lựa chọn không hợp lệ
                }

                System.out.println("Thong tin sinh vien da duoc cap nhat."); // Thông báo thông tin sinh viên đã được cập nhật
                break;
            }
        }
    }
}
