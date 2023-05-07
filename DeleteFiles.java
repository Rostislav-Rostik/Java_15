import java.io.File;
import java.util.Scanner;

public class DeleteFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directoryName = args[0];
        File directory = new File(directoryName);
        if (!directory.isDirectory()) {
            System.out.println("Каталог " + directoryName + " не існує.");
            return;
        }
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Каталог " + directoryName + " порожній.");
            return;
        }
        System.out.println("У каталозі " + directoryName + " знайдено наступні файли:");
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.print("Ви бажаєте видалити ці файли? (Y/N): ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            for (File file : files) {
                file.delete();
                System.out.println("Файл " + file.getName() + " успішно видалено.");
            }
        } else {
            System.out.println("Видалення скасовано.");
        }
    }
}
