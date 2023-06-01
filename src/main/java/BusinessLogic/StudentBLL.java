//package BusinessLogic;
//
//import BusinessLogic.Validators.EmailValidator;
//import BusinessLogic.Validators.StudentAgeValidator;
//import BusinessLogic.Validators.Validator;
//import DataAccess.StudentDAO;
//import Model.Student;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//public class StudentBLL {
//    private List<Validator<Student>> validators;
//
//    public StudentBLL() {
//        validators = new ArrayList<Validator<Student>>();
//        validators.add(new EmailValidator());
//        validators.add(new StudentAgeValidator());
//    }
//
//    public Student deleteStudent(String condition){
//        Student st = StudentDAO.delete(condition);
////        if(st == null){
////            throw new NoSuchElementException("The student was not found!");
////        }
//        System.out.println("Delete successful!");
//        return null;
//    }
//    public Student findStudentById(int id) {
//        Student st = StudentDAO.findById(id);
//        if (st == null) {
//            throw new NoSuchElementException("The student with id =" + id + " was not found!");
//        }
//        return st;
//    }
//
//    public Student updateStudentById(int id, String name, String address, String email, int age){
//
//        Student st = StudentDAO.updateById(id, name, address, email, age);
//        if(st == null){
//            throw new NoSuchElementException("The student with id = " + id + " was not found!");
//        }
//        return st;
//    }
//
//    public int insertStudent(Student student) {
//        for (Validator<Student> v : validators) {
//            v.validate(student);
//        }
//        return StudentDAO.insert(student);
//    }
//
//}
