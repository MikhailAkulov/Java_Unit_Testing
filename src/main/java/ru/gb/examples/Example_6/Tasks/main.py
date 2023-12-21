from application import Application

if __name__ == '__main__':
    avg1 = Application.calculate_list_average([1, 2, 3, 4, 5])
    avg2 = Application.calculate_list_average([1, 8, 3, 4, 5])
    print(avg1, avg2)

    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])
    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 8, 3, 4, 5])
    Application.compare_lists_averages([9, 2, 3, 4, 5], [1, 8, 3, 4, 5])
