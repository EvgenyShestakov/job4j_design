package ru.job4j.ood.lsp.example3;

// Инвариант нарушен. У потомка отсутствует валидация пароля.
public class Email extends Account {
    private String login;
    private String password;

    public Email(String login, String password) {
        super(login, password);
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
