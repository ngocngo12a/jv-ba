package lesson3.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

public class ManageStudentService {
    private Connection connection;

    public ManageStudentService() {
    }

    public ManageStudentService(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnections() {
        try{
            connection = getConnection("jdbc:mysql://127.0.0.1:3306/manage_student","root","ngochoatuyen");
            return connection;
        }
        catch (Exception e){
            System.out.println("Loi khi connect database" + e);
        }
        return null;
    }
    public void updateNoOfStudentInDepartment(){
        try{
            String queryDeptID = "SELECT COUNT(*), DeptID FROM students GROUP BY DeptID";
            Statement statement = getConnections().createStatement();

            ResultSet deptIDs = statement.executeQuery(queryDeptID);

            while (deptIDs.next()){
                Integer noOfStudent = deptIDs.getInt(1);
                String deptID = deptIDs.getString(2);

                System.out.println("Updating no of student for deptID: " + deptID);
                String update = "UPDATE departments SET NoOfStudents = " + noOfStudent + " WHERE DeptID = '" + deptID +"'";
                Statement statement1 = getConnections().createStatement();
                statement1.execute(update);
            }

            String updateRemain = "UPDATE departments SET NoOfStudents = 0 WHERE NoOfStudents IS NULL";
            statement.execute(updateRemain);

        }catch (Exception e){
            System.out.println("Cập nhật thất bại! "+e);
        }
    }
    public  void updateAvegerScore(){
        try{
            String getStudentId = "SELECT distinct StudentID FROM manage_student.results";
            Statement statement = getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(getStudentId);
            List<String> studentIds = new ArrayList<>();
            while(resultSet.next()){
                studentIds.add(resultSet.getString(1));
            }

            String getCourseCredits = "SELECT CourseID , Credits FROM courses";
            Statement creditSt = getConnections().createStatement();
            ResultSet creditRs = creditSt.executeQuery(getCourseCredits);
            Map<String, Integer> mapCredit = new HashMap<>();
            while (creditRs.next()){
                mapCredit.put(creditRs.getString(1), creditRs.getInt(2));
            }

            for(String stId : studentIds){
                String getCourse = "SELECT CourseID, Mark FROM results WHERE StudentID ='" + stId +"'";
                Statement statement1 = getConnections().createStatement();
                ResultSet resultSet1 = statement1.executeQuery(getCourse);

                Map<String, Float> studentStore = new HashMap<>();
                while (resultSet1.next()){
                    String courseId = resultSet1.getString(1);
                    Float mark = resultSet1.getFloat(2);

                    Float value = studentStore.get(courseId);
                    if(value == null){
                        studentStore.put(courseId, mark);
                    } else {
                        if(value < mark){
                            studentStore.put(courseId, mark);
                        }
                    }
                }

                // Calculate score
                Float total = 0.0f;
                Integer creditTotal = 0;
                for(String courseId : studentStore.keySet()){

                    Float mark = studentStore.get(courseId);
                    Integer credit = mapCredit.get(courseId);

                    total = total + mark * credit;

                    creditTotal = creditTotal + credit;

                }

                Float avgScore = total/creditTotal;
                String updateStudent = "UPDATE students SET AverageScore = '" + avgScore + "' WHERE StudentID = '" + stId + "'";
                Statement updateSt = getConnections().createStatement();
                updateSt.executeUpdate(updateStudent);
            }
        }catch (Exception e){
            System.out.println("" +e);
        }
    }
}
