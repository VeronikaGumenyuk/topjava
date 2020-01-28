package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        mealsTo.forEach(System.out::println);

   //     System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static boolean isCaloriesPerDay(List<UserMeal> meals, LocalDate date, int caloriesPerDay) {
        int count = 0;
        for (UserMeal meal: meals) {
            if(meal.getDateTime().toLocalDate().isEqual(date)) {
                count += meal.getCalories();
            }
        }
        return count > caloriesPerDay;
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
   /*     Map<LocalDate, Integer> mapOfCalories = new HashMap<>();
        for (UserMeal meal : meals) {
            mapOfCalories.merge(meal.getDateTime().toLocalDate(), meal.getCalories(), Integer::sum);
        }
*/
        List<UserMealWithExcess> list = new ArrayList<>();
        for (UserMeal meal : meals) {
            LocalTime time = meal.getDateTime().toLocalTime();
            if (TimeUtil.isBetweenInclusive(time, startTime, endTime)) {
                list.add(new UserMealWithExcess(meal.getDateTime(), meal.getDescription(), meal.getCalories(), isCaloriesPerDay(meals, meal.getDateTime().toLocalDate(), caloriesPerDay)));
            }
        }
        return list;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
        return null;
    }
}
