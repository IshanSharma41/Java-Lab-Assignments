public class Vector {

    private double x;
    private double y;
    private double z;
    private int dimension;

    // 2D Constructor
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.dimension = 2;
    }

    // 3D Constructor
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = 3;
    }

    public Vector add(Vector other) throws InvalidDimensionException {
        if (this.dimension != other.dimension) {
            throw new InvalidDimensionException("Vectors must have same dimension for addition.");
        }

        if (dimension == 2)
            return new Vector(this.x + other.x, this.y + other.y);
        else
            return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector subtract(Vector other) throws InvalidDimensionException {
        if (this.dimension != other.dimension) {
            throw new InvalidDimensionException("Vectors must have same dimension for subtraction.");
        }

        if (dimension == 2)
            return new Vector(this.x - other.x, this.y - other.y);
        else
            return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public double dotProduct(Vector other) throws InvalidDimensionException {
        if (this.dimension != other.dimension) {
            throw new InvalidDimensionException("Vectors must have same dimension for dot product.");
        }

        if (dimension == 2)
            return (this.x * other.x + this.y * other.y);
        else
            return (this.x * other.x + this.y * other.y + this.z * other.z);
    }

    public void display() {
        if (dimension == 2)
            System.out.println("(" + x + ", " + y + ")");
        else
            System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}