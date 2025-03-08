
class MainPatterns {

    public static void p1(int n) {
        // 2d matrix of size n*n
        System.out.println("This is the 1st pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p2(int n) {
        // pyramid pattern
        System.out.println("This is the 2nd pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p3(int n) {
        // triangular number pattern
        System.out.println("This is the 3rd pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%d ", j + 1);
            }
            System.out.println();
        }
    }

    public static void p4(int n) {
        // triangular number pattern (all the digits in a row are the row number itself)
        System.out.println("This is the 4th pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%d ", i + 1);
            }
            System.out.println();
        }
    }

    public static void p5(int n) {
        // reverse pyramid pattern
        System.out.println("This is the 5th pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void p6(int n) {
        // reverse numerical triangle pattern
        System.out.println("This is the 6th pattern");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%d", j + 1);
            }
            System.out.println();
        }
    }

    public static void p7(int n) {
        // full pyramid pattern
        System.out.println("This is the 7th pattern");
        
    }

    public static void main(String[] args) {
        int n = 5;
        p1(n);
        p2(n);
        p3(n);
        p4(n);
        p5(n);
        p6(n);
        p7(n);
    }
}
