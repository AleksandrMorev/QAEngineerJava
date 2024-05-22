public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + "\n" +
                "Должность: " + position + "\n" +
                "E-mail: " + email + "\n" +
                "Телефон: " + phone + "\n" +
                "Зарплата, руб: " + salary +"\n" +
                "Возраст, лет: " + age +"\n";
    }

    public void printEmployeeToConsole(){
        System.out.println(this);
    }
}
