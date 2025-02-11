import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int persons = 0;
        boolean exept;
        String productName;
        String qa;
        double price;
        Scanner scanner = new Scanner(System.in);

        ///////////////////////////////////////
        // 1. Входные параметры для счётчика //
        ///////////////////////////////////////
        while (true) {

            // 1.После запуска программа должна спрашивать у пользователя, на скольких человек необходимо разделить счёт.
            System.out.println("На скольких человек необходимо разделить счёт?");

            exept = false;
            try {
                persons = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Нужно обязательно вводить целое число");
                // Обновляем scanner в случае ошибки, другой способ не нашёл.
                scanner = new Scanner(System.in);
                exept = true;
            }

            if (!exept) {
                if (persons == 1) {
                    // Количество человек, введённых пользователем, равно 1. В этом случае нет смысла ничего считать и делить.
                    System.out.println("Ошибка. Нет смысла ничего считать и делить для одного человека. Повторите ввод.");
                } else if (persons < 1) {
                    // Количество человек меньше 1. Это некорректное значение для подсчёта.
                    System.out.println("Ошибка. Некорректное значение для подсчёта: " + persons + ". Повторите ввод");
                } else
                    break;
            }
        }

        // 3. После введения корректного значения > 1 создать калькулятор, который будет считать счёт на введённое пользователем количество людей.
        Calculator calculator = new Calculator(persons);

        /////////////////////////////////////////
        // 2. Добавление товаров в калькулятор //
        /////////////////////////////////////////
        while (true) {
            // 1. Запросите у пользователя название товара и его стоимость. Стоимость должна быть в формате рубли.копейки, например 10.45 или 11.40.

            System.out.println("Введите наименование товара");

            // Не обрабатываю сканнер, т.к. наименование товара в теории может быть вообще любым.
            productName = scanner.next();

            price = 0.0; // Сброс для ввода нового значения
            while (price <= 0.0) {

                if (!exept) {
                    if (price < 0.0)
                        System.out.println("Ошибка. Стоимость не может быть меньше нуля, повторите ввод");
                    else
                        System.out.println("Введите стоимость товара, она должна быть больше нуля");
                }

                exept = false;
                try {
                    price = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка. Нужно обязательно вводить число");
                    // Обновляем scanner в случае ошибки, другой способ не нашёл.
                    scanner = new Scanner(System.in);
                    exept = true;
                }

            }

            // 2. Полученный товар должен быть добавлен в калькулятор.
            calculator.addProdPrice(productName, price);
            // 5.После добавления товара в калькулятор нужно показать пользователю сообщение об успешном добавлении товара.
            System.out.println("Товар и стоимость товара успешно добавлены");
            // 6.После добавления товара нужно спрашивать у пользователя, хочет ли он добавить ещё один товар.
            System.out.println("Хотите добавить еще товар? Введите \"Завершить\" чтобы закончить ввод.");
            qa = scanner.next();
            if (qa.equalsIgnoreCase("Завершить")) {
                System.out.println("Ввод данных завершен");
                break;
            }
        }

        //////////////////////////
        // 3. Вывод результатов //
        //////////////////////////
        // 1.После того как пользователь введёт команду "Завершить" после добавления товаров, нужно
        // показать пользователю все добавленные товары и посчитать, сколько должен заплатить каждый человек.
        // 2.Каждый новый добавленный товар должен быть выведен с новой строки после текста: "Добавленные товары:".
        // Вы можете использовать символ \n в строке, чтобы указать компилятору, что нужно сделать в этом месте переноса строки.
        calculator.showAllProducts();

        // 3.Вывод суммы, которую должен заплатить каждый человек, должен быть в формате "10.45".
        // Дробная часть не должна содержать больше двух чисел после запятой.
        calculator.splitSumToPerson();


    }
}