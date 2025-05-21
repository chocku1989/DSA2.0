//package org.training.java8;
//
//import java.io.InputStream;
//import java.util.*;
//import java.text.SimpleDateFormat;
//
//import static org.training.java8.RentalTime.getOccurrenceCount;
//
//public class CarRental {
//    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
//
//
//        List<RentalTime> lst = new ArrayList<>();
//        lst.addAll(rentalTimes);
//        Collections.sort(lst, Comparator.comparing(RentalTime::getStart));
//
//        RentalTime r1 = lst.get(0);
//        Date prevEnd = r1.getEnd();
//
//        for (int j = 1; j < rentalTimes.size(); j++) {
//            RentalTime r2 = lst.get(j);
//            Date currentStart = r2.getStart();
//            Date currentEnd = r2.getEnd();
//            if (currentStart.compareTo(prevEnd) < 0) {
//                return false;
//            }
//            prevEnd = currentEnd;
//        }
//
//
//        return true;
//    }
//
//    public static void main(String[] args) throws Exception {
//        getOccurrenceCount();
//        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");
//
//        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 23:30")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
//        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:30"), sdf.parse("03/05/2020 23:00")));
//
//        System.out.println(CarRental.canScheduleAll(rentalTimes));
//    }
//}
//
//class RentalTime {
//    private Date start, end;
//
//    public RentalTime(Date start, Date end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    public Date getStart() {
//        return this.start;
//    }
//
//    public Date getEnd() {
//        return this.end;
//    }
//
//    public static void  getOccurrenceCount()   {
//        String msg = "Hey! How are you?\nI am good, how about you?\nI am good too.";
////        String str=stream.toString();
//        String[] split = stream.toString().split("\n");
//        int count=0;
//        for (String s : split){
//            if(s.contains()){
//                count++;
//            }
//        }
//        return count;
//        System.out.println(split.length);
//    }
//}
