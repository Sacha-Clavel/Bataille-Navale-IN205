package app.main.annexes;


public class ColorUtil {

    /* ***
     * Constructeur de la classe ColorUtil, utilisable uniquement par la classe elle-même
     */
    private ColorUtil() {};

    /* ***
     * enum Color interne à la classe ColorUtil
     */
    enum Color {
        RESET("\u001B[0m"),
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        /* ***
         * Attribut de l'enum Color
         */
        private final String value;

        /* ***
         * Constructeur de l'enum Color
         */
        Color(String value) {
            this.value = value;
        }
    }

    /* ***
     * Méthodes de la classe ColorUtil
     */
    public static String colorize(String text, String colorString) {

        Color color;            // Je suis obligé d'ajouter ce switch case car quand j'appelle colorize("blabla", Color.Util.RED)
        switch (colorString){   // Je n'ai pas le droit d'utilier Color.Util.Red ... qui est utilisable uniquement dans les méthodes de Color.Util !
            case "reset":
                color = Color.RESET;
                break;
            case "black" :
                color = Color.BLACK;
                break;
            case "red" :
                color = Color.RED;
                break;
            case "green" :
                color = Color.GREEN;
                break;
            case "yellow" :
                color = Color.YELLOW;
                break;
             case "blue" :
                color = Color.BLUE;
                break;
            case "purple" :
                color = Color.PURPLE;
                break;   
            case "cyan" :
                color = Color.CYAN;
                break;
            case "white" :
                color = Color.WHITE;
                break;
            default :
                color = Color.RESET;
                break;
        } 

        return String.format("%s%s%s", color.value, text, Color.RESET.value);
    }

    public static String colorize(Character text, String color) {
        return colorize("" + text, color);
    }
}
