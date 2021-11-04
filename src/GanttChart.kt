/**
 * У тебя есть текстовое представление диаграммы Ганта.
 * Диаграмма - временное представление некого бизнес процесса.
 * Составить json объект , элементом которого будет задача из диаграммы .
 * Символ - день .
 * Длинна задачи в днях соответствует длинне символов , включая открывающие и закрывающие элементы .
 * Задачи могут иметь вложенные задачи.
 * Задачи могут повторяться в разные промежутки времени.
 * Родительские задачи начинаются с upper case , а дочерние (вложенные) - с lower case той же буквы.
 * Рядом с буквой задачи стоит номер ее выполнения.
 * Таким образов в представленном примере ниже в тех процессе етсь две родительские задачи (процесса) : A , B.
 * В каждой задаче по три подпроцесса : a1,a2,a3 и b1,b2,b3.
 * При этом a1 повторяется дважды. Также как и b2.
 * Фигурная левая скобка всегда открывает родительскую задачу .
 * Фигурная правая скобка всегда закрывает родительскую или дочернюю задачу, завершающую процесс родительской.
 * Составить json объект , элементом которого будет задача из диаграммы с соответствующей вложенностью.
 * Вывести json в out.
 *
 * A0  {---------------------|
 * a1  |---|        |--------}
 * a2       |------|
 * B0         {----------------------|
 * b1         |---|
 * b2               |-----|      |---}
 * b3                     |------|
 */

class SubTask(val name: String, val order: Int, val periods: MutableList<Period>)
class MainTask(val name: String, val order: Int, val periods: MutableList<Period>, val subTasks: MutableList<SubTask>)
class Period(val start: Int, val end: Int)

fun main() {
    val input = "A0  {---------------------|\n" +
            "a1  |---|        |--------}\n" +
            "a2       |------|\n" +
            "B0         {----------------------|\n" +
            "b1         |---|\n" +
            "b2               |-----|      |---}\n" +
            "b3                     |------|"

    val result = toJson(input)
    println(result)
}

private fun toJson(input: String): List<MainTask> {
    val strings = input.split("\n")
    val mainTasks = mutableListOf<MainTask>()
    var currentMainTask: MainTask? = null

    for (element in strings) {
        val pattern = "(?<name>[a-zA-Z])(?<order>\\d+)  (?<periods>.*)".toRegex().toPattern()
        val matcher = pattern.matcher(element)

        if (matcher.find()) {
            val name = matcher.group("name")
            val order = matcher.group("order").toInt()
            val periods = matcher.group("periods")
            var ps: List<Period>

            if (name[0].isUpperCase()) {
                currentMainTask = MainTask(name, order, mutableListOf(), mutableListOf())
                ps = currentMainTask.periods
                mainTasks.add(currentMainTask)
            } else {
                if (currentMainTask == null)
                    throw IllegalStateException()
                val currentSubTask = SubTask(name, order, mutableListOf())
                ps = currentSubTask.periods
                currentMainTask.subTasks.add(currentSubTask)
            }

            var i = 0
            while (i < periods.length) {
                while (i < periods.length && periods[i] == ' ')
                    i++
                val periodStart = i
                while (i < periods.length && setOf('|', '{', '}', '-').contains(periods[i]))
                    i++
                val periodEnd = i - 1
                ps.add(Period(periodStart, periodEnd))
            }
        }
    }

    return mainTasks
}
