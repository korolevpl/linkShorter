import java.util.Scanner;

public class Manager {
    private static  final String HELP_STRING = """
                Enter the command:
                short
                long
                exit            
                """;
    private void help() {
        System.out.println(HELP_STRING);
    }

    public static void main(String[] args) {

        Manager manager = new Manager();
        Handler handler = new Handler();
        Scanner scanner = new Scanner(System.in);
        String link = "";
        boolean cycle = true;
        while (cycle) {
            manager.help();
            String input = scanner.nextLine();
            String[] words = input.split(" ");

            switch (words[0]) {
                case "short":
                    link = handler.getShortLink(words[1]);
                    System.out.println(link);
                    break;
                case "long":
                    link = handler.getLongLink(words[1]);
                    System.out.println(link);
                    break;
                case "exit":
                    System.out.println("Bye");
                    cycle = false;
                    break;
                default:
                    System.out.println(words[0] + " - this command is invalid. Try again.");
                    break;
            }
        }
    }
}
