import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu{
    List<Workout> workouts = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public void  addWorkout(String[] args){
        System.out.println("Enter your workout(BOXING,\n" +
                "    RUNNING,\n" +
                "    SWIMMING,\n" +
                "    YOGA,\n" +
                "    GYM)");
        String typeInput = scan.nextLine().toUpperCase();
        WorkoutType type;
        try {
            type = WorkoutType.valueOf(typeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type!");
            return;
        }

        System.out.println("Enter date in format day.month.year(Example: 26.05.2025): ");
        LocalDate date = LocalDate.parse(scan.nextLine());

        System.out.println("Enter duration minutes: ");
        int durationMinutes = Integer.parseInt(scan.nextLine());

        System.out.println("Enter burned calories: ");
        int burnedCalories = Integer.parseInt(scan.nextLine());

        Workout workout = new Workout(date,type,durationMinutes,burnedCalories);
        workouts.add(workout);
    }

    public void showAllWorkouts(){
        for(Workout w: workouts){
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


}
