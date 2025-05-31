import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    List<Workout> workouts = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public void addWorkout(String[] args) {
        System.out.println("Enter your workout (BOXING, RUNNING, SWIMMING, YOGA, GYM):");
        String typeInput = scan.nextLine().toUpperCase();
        WorkoutType type;
        try {
            type = WorkoutType.valueOf(typeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type!");
            return;
        }

        System.out.println("Enter date in format yyyy-mm-dd (Example: 2025-05-26): ");
        LocalDate date = LocalDate.parse(scan.nextLine());

        System.out.println("Enter duration in minutes: ");
        int durationMinutes = Integer.parseInt(scan.nextLine());

        System.out.println("Enter burned calories: ");
        int burnedCalories = Integer.parseInt(scan.nextLine());

        Workout workout = new Workout(date, type, durationMinutes, burnedCalories);
        workouts.add(workout);
    }

    public void showAllWorkouts() {
        for (Workout w : workouts) {
            System.out.println(w);
        }
    }

    public void deleteWorkout() {
        if (workouts.isEmpty()) {
            System.out.println("There are no workouts to delete.");
            return;
        }

        for (int i = 0; i < workouts.size(); i++) {
            System.out.println(i + ": " + workouts.get(i));
        }

        System.out.print("Enter the index of the workout you want to delete: ");
        int index = Integer.parseInt(scan.nextLine());

        if (index >= 0 && index < workouts.size()) {
            workouts.remove(index);
            System.out.println("Workout removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void calculateCaloriesForWeek() {
        System.out.println("Enter start date of the week (yyyy-mm-dd): ");
        LocalDate startDate;
        try {
            startDate = LocalDate.parse(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return;
        }

        LocalDate endDate = startDate.plusDays(6);
        int totalCalories = 0;

        for (Workout w : workouts) {
            if (!w.getDate().isBefore(startDate) && !w.getDate().isAfter(endDate)) {
                totalCalories += w.getCaloriesBurned();
            }
        }

        System.out.println("Total calories burned from " + startDate + " to " + endDate + ": " + totalCalories);
    }

    public void calculateCaloriesForMonth() {
        System.out.println("Enter year (e.g. 2025): ");
        int year;
        try {
            year = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid year.");
            return;
        }

        System.out.println("Enter month (1–12): ");
        int month;
        try {
            month = Integer.parseInt(scan.nextLine());
            if (month < 1 || month > 12) {
                System.out.println("Invalid month.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid month.");
            return;
        }

        int totalCalories = 0;

        for (Workout w : workouts) {
            LocalDate date = w.getDate();
            if (date.getYear() == year && date.getMonthValue() == month) {
                totalCalories += w.getCaloriesBurned();
            }
        }

        System.out.println("Total calories burned in " + year + "-" + String.format("%02d", month) + ": " + totalCalories);
    }
}
