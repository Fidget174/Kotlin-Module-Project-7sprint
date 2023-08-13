package data

abstract class Data(){
    abstract val name:String
}

data class Note (override val name:String, val description:String):Data()

data class Archive (override val name:String):Data(){
    val listOfNotes = mutableListOf<Note>()

    fun showNote(index:Int) {                           //Вывод заметки
        println("Заголовок: ${listOfNotes[index].name}")
        println("\"${listOfNotes[index].description}\"")
    }

    fun createNote(){                                     //Создание заметки и добавление в list
        var name: String
        var description: String
        while (true) {
            println("Введите название заметки :")
            name = readlnOrNull()?: ""
            if (name.isBlank())
                println("Вы ввели пустое название. Введите непустое название!")
            else {
                println("Введите текст заметки: ")
                description = readlnOrNull()?.trim() ?: ""
                if (description.isBlank())
                    println("Вы ввели пустое поле текста. Введите текст в поле заметки!")
                else{
                    println("Заметка \"$name\" успешно создана")
                    break
                }
            }
        }
        listOfNotes.add(Note(name, description))
    }
}