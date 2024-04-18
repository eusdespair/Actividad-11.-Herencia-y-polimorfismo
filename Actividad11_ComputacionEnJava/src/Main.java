import java.util.Scanner;

interface Shape {
    double getArea();
    double getPerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle implements Shape {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Triángulo");
        System.out.println("3. Cuadrado");
        int option = scanner.nextInt();

        Shape shape;
        switch (option) {
            case 1:
                System.out.println("Ingrese el radio del círculo:");
                double radius = scanner.nextDouble();
                shape = new Circle(radius);
                break;
            case 2:
                System.out.println("Ingrese los lados del triángulo:");
                double side1 = scanner.nextDouble();
                double side2 = scanner.nextDouble();
                double side3 = scanner.nextDouble();
                shape = new Triangle(side1, side2, side3);
                break;
            case 3:
                System.out.println("Ingrese el lado del cuadrado:");
                double side = scanner.nextDouble();
                shape = new Square(side);
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        System.out.println("Seleccione la propiedad a calcular:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int property = scanner.nextInt();

        double result;
        switch (property) {
            case 1:
                result = shape.getArea();
                System.out.println("El área es: " + result);
                break;
            case 2:
                result = shape.getPerimeter();
                System.out.println("El perímetro es: " + result);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}