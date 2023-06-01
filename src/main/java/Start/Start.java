//package Start;
//
//import BusinessLogic.StudentBLL;
//import Model.Student;
//
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
////import static Model.Student.findById;
//
//public class Start {
//    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());
//
//    public static void main(String[] args) throws SQLException {
//
//        Student student = new Student("Vîlcu Ștefan", "Mănăștur", "stefan@student.utcluj.ro", 21);
//
//        StudentBLL studentBll = new StudentBLL();
//        int id = studentBll.insertStudent(student);
//        if (id > 0) {
//            studentBll.findStudentById(id);
//        }
////        student.setId(id);
////        Student student = new Student();
////        StudentBLL studentBll = new StudentBLL();
////        //studentBll.findStudentById(4);
////        int id = 8;
////        String name = studentBll.findStudentById(id).getName();
////        String address = studentBll.findStudentById(id).getAddress();
////        int age = studentBll.findStudentById(id).getAge();
////        String email = studentBll.findStudentById(id).getEmail();
////        student.setId(id);
////        student.setName(name);
////        student.setAge(age);
////        student.setAddress(address);
////        student.setEmail(email);
//
////        Student student = new Student();
////        StudentBLL studentBll = new StudentBLL();
////        int id = 4;
////        String name = "Iorga Irina";
////        String address = "Observator";
////        String email = null;
////        int age = 32;
////        studentBll.updateStudentById(id, name, address, email, age);
//        //student.setId(id);
//        //student.setEmail(email);
//        //student.setAge(age);
//        //student.setAddress(address);
//        //student.setName(name);
//
////        Student student = new Student();
////        StudentBLL studentBll = new StudentBLL();
////        String condition = "id = 1";
////        studentBll.deleteStudent(condition);
//
//
//        // Generate error
//        try {
//            studentBll.findStudentById(1);
//        } catch (Exception ex) {
//            LOGGER.log(Level.INFO, ex.getMessage());
//        }
//
//
//        //obtain field-value pairs for object through reflection
//        Reflection.retrieveProperties(student);
//    }
//
//}
