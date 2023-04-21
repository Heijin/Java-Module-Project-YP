public class Formatter {

    public String getRubblies(double rub) {

        double lastDigit;

        double cel = Math.floor(rub);

        if (cel>=100 && cel % 100 >=11 && cel % 100 <= 19)
            // Сразу сделаю возврат, т.к. диапазон подразумевает "рублей".
            return "рублей";
            //lastDigit = cel % 100;
        else if (cel>=10)
            lastDigit = cel % 10;
        else lastDigit = cel;

        switch ((int) lastDigit) {

            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
        }
        return "рублей";

    }

    public String getFormatDouble(double summ) {
        return String.format("%.2f", summ);
    }

}
