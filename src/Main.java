import exception.LoginException;
import exception.PaswordException;

public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9_]+$";
    public static void main(String[] args) {

    }

    public static Boolean chek(String login, String pasword, String confirmPasword) {
        boolean chek1 = true;
        try {
            login1(login);
            pasword1(pasword,confirmPasword);
        } catch (LoginException e) {
            System.out.println("Ошибка с логином " + e.getMessage());
            chek1 = false;
        } catch (PaswordException e) {
            System.out.println("Ошибка с паролем " + e.getMessage());
            chek1 = false;
        }
        if (chek1) {
            System.out.println("Логин и пароль корректный");
        }
       return chek1;

    }
    public static void login1(String login) throws LoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
            throw new LoginException("Login может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (login.length() > 20) {
            throw new LoginException("Login не может быть линее 20 символов");

        }

    }
    public static void pasword1(String pasword, String confirmPasword) throws PaswordException {
        if (!pasword.matches(VALIDATE_PATTERN)) {
            throw new PaswordException("Пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания");
        }
        if (pasword.length() > 20) {
            throw new PaswordException("Пароль не может быть линее 20 символов");
            }
        if (!pasword.equals(confirmPasword)) {
            throw new PaswordException("Пароли не совпадают");
        }

    }
}