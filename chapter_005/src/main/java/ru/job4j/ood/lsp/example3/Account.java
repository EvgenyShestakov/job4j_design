package ru.job4j.ood.lsp.example3;

public class Account {
    private String login;
    private String password;

    public Account(String login, String password) {
        validatePassword(password);
        this.login = login;
        this.password = password;
    }

    private void validatePassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Incorrect length!");
        }
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }
}
