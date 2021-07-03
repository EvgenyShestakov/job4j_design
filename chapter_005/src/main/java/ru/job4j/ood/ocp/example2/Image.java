package ru.job4j.ood.ocp.example2;

public class Image {
    /*Метод saveToFile сохраняет изображение в JPG формате. Переписываем метод под формат PNG и код который
    использовал метод saveToFile перестает работать. Вместо этого можно написать 2 класса с логикой записи
    под разные форматы, имплементировать ими интерфейс Save и в аргументы saveToFile подставлять нужный объект.
     */
    public void saveToFile(Save save) {
    }
}
