classDiagram
direction BT
class GeometricObject {

- String color
- boolean filled

+ GeometricObject(String, boolean)
+ GeometricObject()
+ getColor() String
+ getPerimeter() double
+ setColor(String) void
+ isFilled() boolean
+ setFilled(boolean) void
+ getArea() double
  }
  class Triangle {

- double side1
- double side3
- double side2

+ Triangle(double, double, double)
+ Triangle()
+ getSide1() double
+ toString() String
+ getSide3() double
+ getArea() double
+ getPerimeter() double
+ getSide2() double
  }

Triangle -->  GeometricObject 
