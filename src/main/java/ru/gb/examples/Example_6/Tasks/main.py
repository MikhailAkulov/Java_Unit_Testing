from application import Application

if __name__ == '__main__':
    avg = Application.calculate_list_average([1, 2, 3, 4, 5])
    print(avg)

    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])
    Application.compare_lists_averages([1, 2, 3, 4, 5], [1, 8, 3, 4, 5])
    Application.compare_lists_averages([9, 2, 3, 4, 5], [1, 8, 3, 4, 5])
