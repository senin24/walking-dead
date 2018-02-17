# walking-dead
Эмуляция жизни на острове "Ходячих мертвецов" с помощью Интерфейсов, Абстрактных классов + Enum

Остров - прямоугольная карта. Каждой координате соответсвует какая-либо сущность (Люди, Зомби, препятсвие, шаурма, дробовик) или пустое место. В начале эмуляции сущности случайно раскидываются по карте. Затем Люди и Зомби начинают ходить по определенным алгоритмам. Эмуляция заканчивается пока полностью не пропадут Зомби или Люди.

# Сущности

## Human
Ходит на одну клетку (вертикаль, горизонталь, диагональ).
Видит вокруг себя на одну клетку.
Запас хода без еды (5 шагов).
Может быть двух полов.
Может иметь дробовик (при инициализации острова все люди без оружия)
Алгоритм хода в соседнюю ячейку, приоритеты:
1. Если нет оружия, идти в клетку с оружием. Появляется способность убивать зомби. Минус один ход.
2. Если есть оружие, идти в клетку с Зомби. Минус один ход.
3. Идти в клету с едой. Сброс счетчика запаса хода на (5) шагов.
4. Идти в клету с человеком противоположного пола. На следующий ход появляется + 1 человек в случайном свободном месте карты. Минус один ход.
5. Идти в пустую клетку (если их несколько, выбирать случайную). Минус один ход.
6. Оставаться на месте. Минус один ход.

## Zombie
Ходит на одну клетку (вертикаль, горизонталь, диагональ).
Видит вокруг себя на одну клетку.
Запас хода без еды (не съел человека) (10 шагов).
Алгоритм хода в соседнюю ячейку, приоритеты:
1. Если рядом есть клетка с человеком - идти в нее. Если человек без оружия, то сброс счетчика запаса хода на (10) шагов, иначе человек убивает зомби и уничтожает его труп.
2. Если рядом есть клетка с мертвым зомби - идти в нее. Сброс счетчика запаса хода на (10) шагов.
3. Выбрать любую пустую клетку. Минус один ход.
4. Оставаться на месте. Минус один ход.

## Tako
Еда. Как только человек съедает шаурму, на следующий ход появлется новая шаурма в случайном свободном месте карты.

## Weapon
Оружие. После того, как оно найдено человеком, новое оружие на карте не появляется.

## Stone
Просто камень, в эту ячейку никто не может попасть.

## READY
* Структура классов сущностей с конструкторыми инициализации новых объектов.
* Enum класс для общих методов, выполнение которых, зависит только от типа сущности
* Класс Остров, содержит в себе HashMap мира (Ключ - координаты, значение - Сущность).
* Метод отображения острова с сущностями в консоль с цветной подсветкой сущностей.
* Генерация uber jar (jar со всеми зависимостями)
* Логика шагов Человека на основе Шаблона игровой ситации, в котором перечисленны варианты состояния объекта Человек + варианты состояния объекта рядом + весовой коэфицент преимущества при совпадении шаблона.

## TODO
* ~~*Нужен дебаг* - Реализовать логику ходов для Зомби и Людей. Проверку условий завершения эмуляции.~~
* Реализовать логику подсчета статистики (причины смертей сущностей, длительность жизни каждого экземпляра сущности и т.п.).
* Реализовать отображение некоторых параметров статистики в виде графиков.
* Реализовать отображение графического интерфейса программы в веб-интерфейсе.
* Захостить эмулятор в Google Cloud App Engine Flexible Environment

# Картинки
Вид цветной карты в консоле

![Вид цветной карты в консоле](https://github.com/senin24/walking-dead/raw/master/images/view_map.png)

Simple UML

![Simple UML](https://github.com/senin24/walking-dead/raw/master/images/UML.png)