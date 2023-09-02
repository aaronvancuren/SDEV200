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