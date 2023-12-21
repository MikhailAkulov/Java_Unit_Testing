from pytest import raises

from src.main.java.ru.gb.examples.Example_6.Tasks.application import Application


# Unit тесты для функции calculate_list_average
def test_calculate_average():
    assert Application.calculate_list_average([1, 2, 3, 4, 5]) == 3
    assert Application.calculate_list_average([8]) == 8


def test_calculate_average_with_empty_list():
    assert Application.calculate_list_average([]) == 0


def test_calculate_average_raises_with_not_list():
    with raises(TypeError):
        Application.calculate_list_average("not list")


def test_calculate_average_raises_with_not_numbers():
    with raises(TypeError):
        Application.calculate_list_average(["i", "j"])


# Unit тесты для функции compare_lists_averages
def test_compare_lists_averages_first_greater_second(capfd):
    Application.compare_lists_averages([9, 2, 3, 4, 5], [1, 8, 3, 4, 5])
    captured = capfd.readouterr()
    assert captured.out.strip() == "Первый список имеет большее среднее значение"


def test_compare_lists_averages_second_greater_first(capfd):
    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 8, 3, 4, 5])
    captured = capfd.readouterr()
    assert captured.out.strip() == "Второй список имеет большее среднее значение"


def test_compare_lists_averages_equal_lists(capfd):
    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])
    captured = capfd.readouterr()
    assert captured.out.strip() == "Средние значения равны"
    