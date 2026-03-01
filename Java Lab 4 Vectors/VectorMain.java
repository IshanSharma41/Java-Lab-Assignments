public class VectorMain {

    public static void main(String[] args) throws InvalidDimensionException{

        try {

            // Creating array of vectors
            Vector[] vectors = new Vector[4];

            vectors[0] = new Vector(2, 3);        // 2D
            vectors[1] = new Vector(4, 6);        // 2D
            vectors[2] = new Vector(1, 2, 3);     // 3D
            vectors[3] = new Vector(4, 5, 6);     // 3D

            System.out.println("2D Operations:");
            Vector add2D = vectors[0].add(vectors[1]);
            Vector sub2D = vectors[0].subtract(vectors[1]);
            double dot2D = vectors[0].dotProduct(vectors[1]);

            System.out.print("Addition: ");
            add2D.display();

            System.out.print("Subtraction: ");
            sub2D.display();

            System.out.println("Dot Product: " + dot2D);


            System.out.println("\n3D Operations:");
            Vector add3D = vectors[2].add(vectors[3]);
            Vector sub3D = vectors[2].subtract(vectors[3]);
            double dot3D = vectors[2].dotProduct(vectors[3]);

            System.out.print("Addition: ");
            add3D.display();

            System.out.print("Subtraction: ");
            sub3D.display();

            System.out.println("Dot Product: " + dot3D);


            // Exception Example
            System.out.println("\nException Example:");
            Vector wrong = vectors[0].subtract(vectors[2]); // 2D + 3D

        }
        catch (InvalidDimensionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}