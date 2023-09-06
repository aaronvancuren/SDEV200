// GeometricObject.java: The abstract GeometricObject class
public abstract class GeometricObject
{
    private String color = "white";
    private boolean filled;
    private final java.util.Date dateCreated;

    /**
     * Default construct
     */
    protected GeometricObject()
    {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object
     */
    protected GeometricObject(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
        dateCreated = new java.util.Date();
    }

    /**
     * Getter method for color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Setter method for color
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * Getter method for filled. Since filled is boolean,
     * so, the get method name is isFilled
     */
    public boolean isFilled()
    {
        return filled;
    }

    /**
     * Setter method for filled
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated()
    {
        return dateCreated;
    }
}