package lesson3;

import lesson3.Services.ManageStudentService;

public class ApplicationStudent {
    public static void main(String[] args) {
        ManageStudentService manageStudentService = new ManageStudentService();

        manageStudentService.updateNoOfStudentInDepartment();
        manageStudentService.updateAvegerScore();
    }

}
