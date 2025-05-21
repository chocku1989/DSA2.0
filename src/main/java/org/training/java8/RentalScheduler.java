package org.training.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RentalScheduler {

  static class Rental implements Comparable<Rental> {
    LocalDateTime start;
    LocalDateTime end;

    public Rental(LocalDateTime start, LocalDateTime end) {
      this.start = start;
      this.end = end;
    }

    public int compareTo(Rental rental) {
      return (this.start.compareTo(rental.start));
    }

    @Override
    public String toString() {
      return "[" + start + " to " + end + "]";
    }
  }

  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    List<Rental> test1 =
        Arrays.asList(
            new Rental(
                LocalDateTime.parse("2020-05-03 19:00", formatter),
                LocalDateTime.parse("2020-05-03 23:30", formatter)),
            new Rental(
                LocalDateTime.parse("2020-05-03 22:10", formatter),
                LocalDateTime.parse("2020-05-03 22:30", formatter)),
            new Rental(
                LocalDateTime.parse("2020-05-03 22:30", formatter),
                LocalDateTime.parse("2020-05-03 23:00", formatter)));

    List<Rental> test2 =
        Arrays.asList(
            new Rental(
                LocalDateTime.parse("2020-05-03 10:00", formatter),
                LocalDateTime.parse("2020-05-03 12:00", formatter)),
            new Rental(
                LocalDateTime.parse("2020-05-03 12:01", formatter),
                LocalDateTime.parse("2020-05-03 13:00", formatter)),
            new Rental(
                LocalDateTime.parse("2020-05-03 13:30", formatter),
                LocalDateTime.parse("2020-05-03 14:00", formatter)));
    System.out.println(canScheduleAllRentals(test1));
    System.out.println(canScheduleAllRentals(test2));
    boolean result2 = canScheduleAllRentals(test2);

    // You can add asserts or print statements to check results here if needed
  }

  // Implement this method
  public static boolean canScheduleAllRentals(List<Rental> rentals) {

    if(rentals==null ||rentals.size()<2){return true;}
    Collections.sort(rentals);
    LocalDateTime prevEndTime = rentals.get(0).end;
    for (int i = 1; i < rentals.size(); i++) {
      LocalDateTime currStartTime = rentals.get(i).start;
      if (!currStartTime.isAfter(prevEndTime)) {
        return false;
      }
    }

    return true;
  }
}
