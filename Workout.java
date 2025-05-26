import java.time.LocalDate;

public class Workout {
       private LocalDate date;
       private int durationMinutes;
       private int caloriesBurned;
       private WorkoutType type;

    public Workout(LocalDate date, int durationMinutes, int caloriesBurned, WorkoutType type) {
        this.date = date;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Date: " + date +
                " | Training duration: " + durationMinutes + " min" +
                " | Burned calories: " + caloriesBurned +
                " | Workout type: " + type;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }
}
