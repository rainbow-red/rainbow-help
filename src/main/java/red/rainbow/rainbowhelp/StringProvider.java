package red.rainbow.rainbowhelp;

public class StringProvider {

    private static final String pf = red.rainbow.rainbowhelp.Help.pf;

    private static final String[] generalCategories = {"friends", "party"};
    private static final String[] survivalCategories = {"homes"};
    private static final String mainscreen =
            pf +"§d§lRainbowRED HELPSCREEN§r" +
                    "\n" + pf + "§7Please choose a valid help category by using §o/help [yourChosenCategory].§r" +
                    "\n" + pf + "§6Golden §7category commands are available everywhere." +
                    "\n" + pf + "§aLime §7category commands are available only in survival worlds." +
                    "\n" + pf + "§7You can choose from the following categories:§r";
    private static final String categoryHomes =
            pf +"§d§lHelp category: §aHomes§r" +
                    "\n" + pf +"§a/sethome §7- Set your homepoint." +
                    "\n" + pf +"§a/home §7- Sends you back to your set homepoint.";

    public static String[] getAllCategories() {
        int generalLength = generalCategories.length;
        int survivalLength = survivalCategories.length;

        String[] returnArray = new String[generalLength + survivalLength];

        System.arraycopy(generalCategories, 0, returnArray, 0, generalLength);
        System.arraycopy(survivalCategories, 0, returnArray, generalLength, survivalLength);

        return returnArray;
    }

    public static String getMainscreen() {
        StringBuilder returnString = new StringBuilder(mainscreen);

        for (int i = 0; i < generalCategories.length; i++) {
            returnString.append("\n" + pf + "§6").append(generalCategories[i].toUpperCase()).append("§r");
        }
        for (int i = 0; i < survivalCategories.length; i++) {
            returnString.append("\n" + pf + "§a").append(survivalCategories[i].toUpperCase()).append("§r");
        }

        return returnString.toString();
    }

    public static String getScreenForCategory(String category) {
        switch (category.toLowerCase()) {
            case "homes":
                return categoryHomes;
            case "friends":
                return null;
            case "party":
                return null;
            default:
                return "§cInternal error. Please inform a staff member about this.";
        }
    }

    public static String getReplacementCommand(String category) {
        switch (category.toLowerCase()) {
            case "friends":
                return "friend";
            case "party":
                return "party";
            default:
                return null;
        }
    }

}