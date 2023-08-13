package logic

import data.Archive
import data.Data

class Menu() {
    private var listOfArchive: MutableList<Archive> = mutableListOf()

    init{
        startProgram()
    }

    private fun startProgram() {
        println("Добро пожаловать в программу \"Заметки\"!")
        choiceArchiveNumber(listOfArchive)
        println("Спасибо за пользование нашей программой!")
    }

    private fun choiceArchiveNumber(list: MutableList<out Data>) {      //Главное меню
        while (true) {
            printMenu(list = listOfArchive)
            when (val number = enterNumber()!!) {
                0 -> return
                1 -> createArhive()
                in 2..list.size + 1 -> choiceNoteNumber(listOfArchive[number-2])
                else -> {
                    println("Такого числа нет в меню. Введите корректное число")
                    continue
                }
            }
        }
    }

    private fun choiceNoteNumber(archive:Archive){                  //Меню заметок
        while(true){
            printMenu(  onFirst = {println("Меню архива \"${archive.name}\"\n1. Создать заметку")},
                list = archive.listOfNotes,
                onLast = {println("0. Вернуться на главный экран")},)
            when(val number = enterNumber()!!){
                0 -> return
                1 -> archive.createNote()           //создание заметки
                in 2..archive.listOfNotes.size+1 -> archive.showNote(number-2)
                else -> {
                    println("Такого числа нет в меню. Введите корректное число")
                    continue
                }
            }

        }

    }

    private fun createArhive() {
        var name: String
        while (true) {
            println("Для создания архива введите имя:")
            name = readlnOrNull() ?: ""
            if (name.isBlank())
                println("Вы ввели пустое имя. Введите непустое имя!")
            else {
                println("Архив \"$name\" успешно создан")
                break
            }
        }
        listOfArchive.add(Archive(name))
    }
}