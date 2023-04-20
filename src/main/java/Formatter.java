public class Formatter {

    //public String RubDesc = "";

    public String getRubblies(double rub) {

        double lastDigit;

        double cel = Math.floor(rub);

        if (cel > 9)
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
