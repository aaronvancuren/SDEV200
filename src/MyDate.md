classDiagram
direction BT
class MyDate {

- int year
- int month
- int day

+ MyDate()
+ MyDate(int, int, int)
+ MyDate(long)
+ setDate(long) void
+ getYear() int
+ getDay() int
+ getMonth() int
  }

