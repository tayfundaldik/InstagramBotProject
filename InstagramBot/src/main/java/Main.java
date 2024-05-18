import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Enter which account you want to like: ");
        String account = sc.nextLine();

        App app = new App();
        app.Login(username, password);
        app.Navigate(account);
        app.LikeAllPhotos();
    }
}
