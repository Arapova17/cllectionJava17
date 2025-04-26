package task_lms.task_set;

import task_lms.task_set.models.Group;
import task_lms.task_set.models.Lessons;
import task_lms.task_set.service.AdminService;
import task_lms.task_set.service.GroupService;
import task_lms.task_set.service.LessonService;
import task_lms.task_set.service.serviceImpl.AdminServiceImpl;
import task_lms.task_set.service.serviceImpl.GroupServiceImpl;
import task_lms.task_set.service.serviceImpl.LessonServiceImpl;

import javax.crypto.spec.PSource;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        LessonService lessonService = new LessonServiceImpl();

        time();
        System.out.println(adminService.registerAdmin());

        while (true){
            System.out.println("""
                    MENU
                    1. add Group 
                    2. group By Name 
                    3. update Group Name 
                    4. getAllGroup 
                    5. delete Group
                    6. add New Lessons 
                    7. get All Lessons By Name 
                    8. get All Lessons By Group 
                    9. delete Lessons""");

            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    try {
                        System.out.println("group name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("description: ");
                        String desc = new Scanner(System.in).nextLine();
                        System.out.println(groupService.addGroup(new Group(name, desc)));
                        System.out.println(groupService.getAllGroup());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 2:
                    try {
                        System.out.println("Group name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(groupService.groupByName(name));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 3:
                    try {
                        System.out.println("Write name group: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println("new name: ");
                        String newName = new Scanner(System.in).nextLine();
                        System.out.println("description: ");
                        String desc = new Scanner(System.in).nextLine();
                        System.out.println(groupService.updateGroupName(name, new Group(newName, desc)));
                        System.out.println(groupService.getAllGroup());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 4:
                    try {
                        System.out.println("getAllGroup = " + groupService.getAllGroup());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 5:
                    try {
                        System.out.println("write name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(groupService.deleteGroup(name));
                        System.out.println(groupService.getAllGroup());
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 6:
                    try {
                        System.out.println("write name:");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(lessonService.addNewLessons(new Lessons(name)));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 7:
                    try {
                        System.out.println("write name: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(lessonService.getAllLessonsByName(name));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 8:
                    try {
                        System.out.println("write group: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(lessonService.getAllLessonsByGroup(name));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                case 9:
                    try{
                        System.out.println("write lesson: ");
                        String name = new Scanner(System.in).nextLine();
                        System.out.println(lessonService.deleteLessons(name));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
        }


    }

    public static void time (){
        // Реалдуу убакытты алуу
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        // Убакытты кадимки форматта көрсөтүү (мисалы: 09:23)
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Саатка жараша саламдашуу
        String greeting;

        if (hour >= 5 && hour < 12) {
            greeting = "Кутман таң!";
        } else if (hour >= 12 && hour < 17) {
            greeting = "Кутан күн!";
        } else if (hour >= 17 && hour < 22) {
            greeting = "Кутман кеч!";
        } else {
            greeting = "Кутман түн!";
        }

        // Натыйжаны чыгаруу
        System.out.println("Саат -> " + formattedTime);
        System.out.println(greeting);

    }
}
