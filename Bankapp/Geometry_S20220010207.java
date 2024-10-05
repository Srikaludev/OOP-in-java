import java.util.*;
class Geometry {
    public static double cubeVolume(double h) {
        return h * h * h;
    }

    public static double cubeSurface(double h) {
        return 6 * h * h;
    }

    public static double sphereVolume(double r) {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }

    public static double sphereSurface(double r) {
        return 4 * Math.PI * r * r;
    }

    public static double cylinderVolume(double r, double h) {
        return Math.PI * r * r * h;
    }

    public static double cylinderSurface(double r, double h) {
        return 2 * Math.PI * r * (r + h);
    }

    public static double coneVolume(double r, double h) {
        return (1.0 / 3.0) * Math.PI * r * r * h;
    }

    public static double coneSurface(double r, double h) {
        double slantHeight = Math.sqrt(r * r + h * h);
        return Math.PI * r * (r + slantHeight);
    }
}
class Geometry_S20220010207 {
    public static void main(String[] args) {
        System.out.println("Enter the radius and height:");
        Scanner inp = new Scanner(System.in);
        double r = inp.nextDouble();
        double h = inp.nextDouble();

        double coneVol = Geometry.coneVolume(r, h);
        double cylinderSurf = Geometry.cylinderSurface(r, h);
        double coneSurf = Geometry.coneSurface(r, h);
        double sphereSurf = Geometry.sphereSurface(r);
        double sphereVol = Geometry.sphereVolume(r);
        double cubeVol = Geometry.cubeVolume(h);
        double cubeSurf = Geometry.cubeSurface(h);

        System.out.println("Cone Volume: " + coneVol);
        System.out.println("Cylinder Surface Area: " + cylinderSurf);
        System.out.println("Cone Surface Area: " + coneSurf);
        System.out.println("Sphere Surface Area: " + sphereSurf);
        System.out.println("Sphere Volume: " + sphereVol);
        System.out.println("Cube Volume: " + cubeVol);
        System.out.println("Cube Surface Area: " + cubeSurf);
        inp.close();
    }
}