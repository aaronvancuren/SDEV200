classDiagram
direction BT
class Circle {

+ Circle()
+ Circle(double)
+ Circle(double, String, boolean)

- double radius

+ getDiameter() double
+ getArea() double
+ getPerimeter() double
+ printCircle() void
+ getRadius() double
+ equals(Object) boolean
+ setRadius(double) void
+ compareTo(Circle) int
  }
  class Comparable~T~ {
  <<Interface>>
+ compareTo(T) int
  }
  class GeometricObject {

# GeometricObject(String, boolean)

# GeometricObject()

- String color
- boolean filled
- Date dateCreated

+ getColor() String
+ getDateCreated() Date
+ isFilled() boolean
+ setColor(String) void
+ setFilled(boolean) void
  }

Circle ..>  Comparable~T~
Circle -->  GeometricObject 
