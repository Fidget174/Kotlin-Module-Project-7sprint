package logic
import data.Data

fun printMenu(              //Вывод меню на экран
    onFirst: () -> Unit = { println("1. Создать архив") },
    list: MutableList<out Data>,        //list с архивом или заметкой
    onLast: () -> Unit = { println("0. Выйти из программы") },
) {
    println("----------")
    onFirst()
    list.forEach { element -> println("${list.indexOf(element)+2}. ${element.name}") }
    onLast()
    println("----------")
}

fun enterNumber(): Int? {           //Ввод числа с клавиатуры, проверка на не Int
    while (true) {
        println("Введите число:")
        var number: Int?
        try {
            number = readlnOrNull()?.toInt()
            return number
        } catch (ex: NumberFormatException) {
            println("Ошибка! Введите число!")
            continue
        }
    }
}