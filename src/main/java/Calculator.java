import java.util.ArrayList;

public class Calculator {

    int persons;
    double summ = 0.0;
    ArrayList<ProductAndPrice> arrayOfProductsPrices = new ArrayList<>();

    void addProdPrice(String prodName, Double price) {
        // 3.При добавлении товара в калькулятор нужно считать текущую общую сумму всех товаров.
        this.summ = this.summ + price;

        // 4.Калькулятор должен запоминать названия всех добавленных товаров, чтобы выводить все товары, которые были в него добавлены.
        ProductAndPrice productAndPrice = new ProductAndPrice(prodName, price);
        arrayOfProductsPrices.add(productAndPrice);
    }

    void showAllProducts() {
        System.out.println("Добавленные товары:");
        int size = arrayOfProductsPrices.size();

        for (int i = 0; i < size; i++)
            System.out.println(arrayOfProductsPrices.get(i).productName);
    }

    void splitSumToPerson() {
        double resOut;
        Formatter formatter = new Formatter();

        for (int i = 0; i < persons; i++) {
            // Хз как иначе получить 2 знака после запятой для корректного расчёта остатка копеек
            resOut = Math.ceil((summ / persons * 100)) / 100;

            // Последний элемент, кидаем копейки от деления на последний вывод
            if (i == persons - 1)
                resOut = summ - i * resOut;
            System.out.println("Человек " + (i + 1) + " сумма: " + formatter.getFormatDouble(resOut) + " " + formatter.getRubblies(resOut));
        }

        System.out.println("Итого: "+formatter.getFormatDouble(summ)+" "+formatter.getRubblies(summ));
    }

    Calculator(int persons) {
        this.persons = persons;
    }
}
