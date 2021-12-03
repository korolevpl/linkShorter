import java.util.Scanner;

public class Manager {
    private static  final String HELP_STRING = """
                Выбирай команду:
                Short
                Long            
                """;
    private void help() {
        System.out.println(HELP_STRING);
    }
//    private static  final String HELP2_STRING = """
//                Yes
//                No
//                """;
//    private void help2() {
//        System.out.println(HELP2_STRING);
//    }
    public static void main(String[] args) {
        System.out.println("Я могу укоротить(Short) или увеличить(Long) твою ссылку");
            Manager manager = new Manager();
            manager.help();
            Handler handler = new Handler();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] words = input.split(" ");
            String link = "";
            switch (words[0]) {
                case "Short":
                    link = handler.getShortLink(words[1]);
                    break;
                case "Long":
                    link = handler.getLongLink(words[1]);
                    break;

            }
        System.out.println(link);
//        boolean b = true;
//            while (b) {
//                System.out.println("Есть еще ссылка?");
//                main.help2();
//                switch ()
//            }
    }




}
