from unittest.mock import patch

from pytest import raises

from main.java.ru.gb.examples.Example_6.Tasks.application import Application


# Unit тесты для функции calculate_list_average
def test_calculate_average():
    assert Application.calculate_list_average([1, 2, 3, 4, 5]) == 3
    assert Application.calculate_list_average([8]) == 8


def test_calculate_average_empty_list():
    assert Application.calculate_list_average([]) == 0


def test_calculate_average_raises_with_not_list():
    with raises(TypeError):
        Application.calculate_list_average("not list")


def test_calculate_average_raises_with_not_numbers():
    with raises(TypeError):
        Application.calculate_list_average(["i", "j"])


# Unit тесты для функции compare_lists_averages
# def test_compare_lists_averages():
