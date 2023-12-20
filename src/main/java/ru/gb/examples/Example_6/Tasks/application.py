class Application:

    # Функция для вычисления среднего значения в списке
    @staticmethod
    def calculate_list_average(numbers: list[int | float]) -> float:
        if not isinstance(numbers, list):
            raise TypeError("Input should be a list.")
        if not numbers:
            return 0
        try:
            return sum(numbers) / len(numbers)
        except TypeError as e:
            raise TypeError("List must contain only numbers") from e

    # Функция для сравнения средних значений двух списков
    @staticmethod
    def compare_lists_averages(first: list[int | float], second: list[int | float]) -> None:
        list1_average = Application.calculate_list_average(first)
        list2_average = Application.calculate_list_average(second)
        if list1_average > list2_average:
            print("Первый список имеет большее среднее значение")
        elif list1_average < list2_average:
            print("Второй список имеет большее среднее значение")
        else:
            print("Средние значения равны")
