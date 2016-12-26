package pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.GradeDao;
import pk.edu.nust.seecs.gradebook.dao.StudentDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) {
        CloDao clodao = new CloDao();
        TeacherDao TDao = new TeacherDao();
        StudentDao SDao = new StudentDao();
        GradeDao GDao = new  GradeDao();
        CourseDao CDao = new  CourseDao();

        // Add new clo
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("Design efficient solutions for algorithmic problems");
        clo.setPlo("2");
        clodao.addClo(clo);

        clodao.updateClo(clo);
       
        long seconds = 11199999;
        
        Date endDate = new Date();
        Date startDate = new Date(seconds);
        Set<String> Contents = new HashSet<String>();
        
        Set<String> FCourses = new HashSet<String>();
        FCourses.add("Advanced Programming");
        Set<String> WCourses = new HashSet<String>();
        WCourses.add("Artificial Intelligence");
        Set<String> MCourses = new HashSet<String>();
        MCourses.add("Advanced Programming");        
        Set<String> NCourses = new HashSet<String>();
        NCourses.add("Computer Networks");
        
        Contents.add("To build a better Pakistan.");
        
        Teacher FahadSatti = new Teacher();
        FahadSatti.setName("Fahad Satti");
        FahadSatti.setCourses(FCourses);
        TDao.addTeacher(FahadSatti);
        TDao.updateTeacher(FahadSatti);

        Teacher WajahatHussain = new Teacher();
        WajahatHussain.setName("Wajahat Hussain");
        WajahatHussain.setCourses(WCourses);
        TDao.addTeacher(WajahatHussain);
        TDao.updateTeacher(WajahatHussain);

        Teacher Manzil = new Teacher();
        Manzil.setName("Manzil-e-Maqsood");
        Manzil.setCourses(MCourses);
        TDao.addTeacher(Manzil);
        TDao.updateTeacher(Manzil);
        
        Teacher NadeemAhmed = new Teacher();
        NadeemAhmed.setName("Nadeem Ahmed");
        NadeemAhmed.setCourses(NCourses);
        TDao.addTeacher(NadeemAhmed);
        TDao.updateTeacher(NadeemAhmed);
        
        Course AP = new Course();
        AP.setClasstitle("Advanced Programming");
        AP.setCreditHours(4);
        AP.setStartsOn(startDate);
        AP.setEndsOn(endDate);
        AP.setContents(Contents);
        AP.setTeacher(Manzil);
        CDao.addCourse(AP);
        CDao.updateCourse(AP);
        
        Course CN = new Course();
        CN.setClasstitle("Computer Networks");
        CN.setCreditHours(4);
        CN.setStartsOn(startDate);
        CN.setEndsOn(endDate);
        CN.setContents(Contents);
        CN.setTeacher(NadeemAhmed);
        CDao.addCourse(CN);
        CDao.updateCourse(CN);
        
        Course AI = new Course();
        AI.setClasstitle("Artificial Intelligence");
        AI.setCreditHours(4);
        AI.setStartsOn(startDate);
        AI.setEndsOn(endDate);
        AI.setContents(Contents);
        AI.setTeacher(WajahatHussain);
        CDao.addCourse(AI);
        CDao.updateCourse(AI);
        
        Course SE = new Course();
        SE.setClasstitle("Software Engineering");
        SE.setCreditHours(3);
        SE.setStartsOn(startDate);
        SE.setEndsOn(endDate);
        SE.setContents(Contents);
        SE.setTeacher(Manzil);
        CDao.addCourse(SE);
        CDao.updateCourse(SE);
        
        Student Talha = new Student();
        Talha.setName("Muhammad Talha");
        Set<Course> myCourses = new HashSet<Course>();
        myCourses.add(AP);
        myCourses.add(CN);
        myCourses.add(AI);
        myCourses.add(SE);
        
        Talha.setCourses(myCourses);
        
        SDao.addStudent(Talha);
        SDao.updateStudent(Talha);
        
        
        
        // Delete an existing clo
        //dao.deleteClo(1);

        // Get all clos
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }

        // Get clo by id
        System.out.println(clodao.getCloById(1));

        
    }

}