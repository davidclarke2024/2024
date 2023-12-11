import java.util.Random;
import java.util.Scanner;

public class lab {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }
            double a, b, r; // change 1
            if (input.equals("square")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the square is: " + a * 4);
                System.out.println("The area of the square is: " + a * a);

            } else if (input.equals("rectangle")) {
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the length of side b: ");
                b = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the rectangle is: " + (2 * a + 2 * b));
                System.out.println("The area of the rectangle is: " + (a * b));
            } else if (input.equals("circle")) {
                System.out.println("Enter the radius: ");
                r = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the circle is: " + (Math.PI * r * 2));
                System.out.println("The area of the circle is: " + (Math.PI * r * r));
            } else
                System.out.println("not a valid input"); // change 2
        }
    }

    public static void Q2() {
        System.out.println("Q2: Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());
        boolean possible = false;
        int num = 1;
        while (!possible) { // change 1
            System.out.println("Enter the current day: ");
            num = Integer.parseInt(scan.nextLine());

            // change 2
            if (num2 == 4 || num2 == 6 || num2 == 9 || num2 == 11) {
                if (num > 0 && num <= 30)
                    possible = true;
            } else if (num2 == 2) {
                if (num > 0 && num <= 29)
                    possible = true;
            } else if (num == 1 || num == 3 || num == 5 || num == 7 || num == 8 || num == 10 || num == 12) {
                possible = true;
            } else {
                System.out.println("not a valid date");
            }
        }

        if (num == 1) // change 3
            System.out.print("You selected 1st of ");
        else if (num == 2)
            System.out.print("You selected 2nd of ");
        else if (num == 3)
            System.out.print("You selected 3rd of ");
        else if (num > 3)
            System.out.print("You selected " + num + "th of ");
        else
            System.out.println("Invalid day");

        switch (num2) { // change 4
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid month");
        }
    }

    public static void Q3() {
        System.out.println("Q3: Enter how many numbers you want to check for primality: ");
        int n = Integer.parseInt(scan.nextLine());
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (i < 2)
                continue;
            boolean check = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                } else {

                }
            }
            if (check == true) {
                counter++;
            } else {
            }
        }

        System.out.println("There are: " + counter + " primes between 0 and " + n);
    }

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println(
                "Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack, \"C\" to search for a better weapon. Kill the enemy to win!");
        System.out.println(
                "Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int a = 0;
        boolean weapon = false;
        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            boolean search = false; // change 1
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    case "C", "c":
                        search = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }
            if (search) { // change 2
                int luck = rng.nextInt(0, 20);
                if (luck > 18) {
                    System.out.println("You found a better weapon! Damage is permanently doubled!");
                    weapon = true;
                } else
                    System.out.println("You could not find a weapon this time!");
            }
            if (doAttack) {
                a++;
                int attackRoll = rng.nextInt(20) + 1;
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if (check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if (check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if (check) {
                        System.out.print(" (buffed attack)");
                    }
                    if (weapon) {
                        damage = damage * 2;
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + a + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}
