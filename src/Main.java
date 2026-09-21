import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Спочатку програма виводить усю інформацію про типи даних у термінал.

        System.out.println("ІНФОРМАЦІЯ ПРО ПРИМІТИВНІ ТИПИ ДАНИХ");
        System.out.println("--------------------------------------");

        System.out.println("byte:");
        System.out.println("  Розмір: " + Byte.BYTES + " байт (" + Byte.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Byte.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Byte.MAX_VALUE);

        System.out.println();

        System.out.println("short:");
        System.out.println("  Розмір: " + Short.BYTES + " байт (" + Short.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Short.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Short.MAX_VALUE);

        System.out.println();

        System.out.println("int:");
        System.out.println("  Розмір: " + Integer.BYTES + " байт (" + Integer.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Integer.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Integer.MAX_VALUE);

        System.out.println();

        System.out.println("long:");
        System.out.println("  Розмір: " + Long.BYTES + " байт (" + Long.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Long.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Long.MAX_VALUE);

        System.out.println();

        System.out.println("float:");
        System.out.println("  Розмір: " + Float.BYTES + " байт (" + Float.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Float.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Float.MAX_VALUE);

        System.out.println();

        System.out.println("double:");
        System.out.println("  Розмір: " + Double.BYTES + " байт (" + Double.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + Double.MIN_VALUE);
        System.out.println("  Максимальне значення: " + Double.MAX_VALUE);

        System.out.println();

        System.out.println("char:");
        System.out.println("  Розмір: " + Character.BYTES + " байт (" + Character.SIZE + " біт)");
        System.out.println("  Мінімальне значення: " + (int) Character.MIN_VALUE);
        System.out.println("  Максимальне значення: " + (int) Character.MAX_VALUE);

        System.out.println();

        System.out.println("boolean:");
        System.out.println("  Розмір: не визначається засобами Java");
        System.out.println("  Мінімальне значення: false");
        System.out.println("  Максимальне значення: true");

        System.out.println();
        System.out.println("======================================");

        // Тепер програма переходить до перетворення рядка у обраний користувачем тип.

        // Програма запитує в користувача тип даних.
        while (true) {

            System.out.println();
            System.out.println("Введіть тип даних:");
            System.out.println("byte, short, int, long, float, double, char, boolean");

            String type = scanner.nextLine().trim().toLowerCase();

            // Перевіряємо, чи існує введений користувачем тип даних.
            switch (type) {

                case "byte":
                case "short":
                case "int":
                case "long":
                case "float":
                case "double":
                case "char":
                case "boolean":
                    // Якщо тип існує, програма продовжує виконання.
                    break;

                default:
                    // Якщо типу немає, програма повертається до його введення.
                    System.out.println(
                            "Введеного вами типу даних немає..."
                    );
                    continue;
            }

            // Тепер саме значення для обраного типу.
            System.out.print("Введіть значення: ");
            String input = scanner.nextLine().trim();

            try {

                switch (type) {

                    case "byte":
                        Byte byteValue = Byte.parseByte(input);
                        System.out.println("Отримано byte: " + byteValue);
                        break;

                    case "short":
                        Short shortValue = Short.parseShort(input);
                        System.out.println("Отримано short: " + shortValue);
                        break;

                    case "int":
                        Integer intValue = Integer.parseInt(input);
                        System.out.println("Отримано int: " + intValue);
                        break;

                    case "long":
                        Long longValue = Long.parseLong(input);
                        System.out.println("Отримано long: " + longValue);
                        break;

                    case "float":
                        Float floatValue = Float.parseFloat(input);
                        System.out.println("Отримано float: " + floatValue);
                        break;

                    case "double":
                        Double doubleValue = Double.parseDouble(input);
                        System.out.println("Отримано double: " + doubleValue);
                        break;

                    case "boolean":

                        // Оскільки Boolean.parseBoolean не виводить помилку, програма перевіряє введення.
                        if (input.equalsIgnoreCase("true") ||
                                input.equalsIgnoreCase("false")) {

                            Boolean booleanValue = Boolean.parseBoolean(input);
                            System.out.println("Отримано boolean: " + booleanValue);

                        } else {
                            System.out.println(
                                    "Для boolean можна ввести тільки true або false..."
                            );
                        }

                        break;

                    case "char":

                        // char має складатися лише з одного символу.
                        if (input.length() == 1) {

                            Character charValue = input.charAt(0);
                            System.out.println("Отримано char: " + charValue);

                        } else {

                            System.out.println(
                                    "Для char не може бути введено більше одного символа..."
                            );
                        }

                        break;

                    // Якщо введеного користувачем типу данних немає, програма повертається до його введення.
                    default:
                        System.out.println(
                                "Введеного вами типу даних немає..."
                        );
                        break;
                }

            } catch (NumberFormatException e) {

                // Якщо введені користувачем дані не можуть бути перевторені у бажаний тип, він побачить це повідомлення:
                System.out.println(
                        "На жаль, ведене вами значення неможливо перетворити у тип " + type + "."
                );
            }
        }
    }
}