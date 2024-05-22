public class EmployeeData {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иванов Константин Игоревич", "Директор",
                "iki@mailbox.com", "89231231212", 1000000, 60);
        empArray[1] = new Employee("Семенов Антон Юрьевич", "Заместитель директора",
                "sau@mailbox.com", "89231231287", 300000, 50);
        empArray[2] = new Employee("Агапов Алексей Андреевич", "Начальник отдела",
                "aaa@mailbox.com", "89231231256", 100000, 40);
        empArray[3] = new Employee("Тимаков Игорь Савельевич", "Инженер",
                "tis@mailbox.com", "89231231222", 50000, 30);
        empArray[4] = new Employee("Стриженов Сергей Анатольевич", "Стажер",
                "ssa@mailbox.com", "89231231298", 10000, 20);
        System.out.println("Массив сотрудников содержит "+ empArray.length+ " записей:");
        for (Employee e:empArray) e.printEmployeeToConsole();
    }
}
