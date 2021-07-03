package ru.job4j.ood.ocp.example3;
/*Если не исользовать абстакцию и поле logger сослать на конкретный тип(например SimpleLogger)
то при изменении требования к записи логов в базу данных, необходимо заменить SimpleLogger на
DatabaseLogger. Это прямое нарушение принципа OCP. Нужно оба вида логгеров привязать к абстракции и
в аргументах конструктора указать тип интерфейса.
 */
public class SmtpMailer {
    private Logger logger;

    public SmtpMailer(Logger logger) {
        this.logger = logger;
    }

    public void sendMessage(String message) {
        logger.log(message);
    }
}
