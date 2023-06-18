public class Department {

    private int id;
    private String name;
    private Employee[] employees;
    private int employeeCount;
    // add your code here
    // you are allowed to add variables here
    // there can be at most 10 departments
    static Department[] departments = new Department[10];
    static int departmentCount = 0;

    // you are not allowed to write any other constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new Employee[10];
        // add your code here
        employeeCount = 0;
        departments[departmentCount++] = this;
    }

    // add your code here
    public void addEmployee(Employee e) {
        employees[employeeCount++] = e;
    }

    public double getDepartmentSalary() {
        double salary = 0.0;
        for (int i = 0; i < employeeCount; i++) {
            salary += employees[i].getSalary();
        }
        return salary;
    }

    public Employee getMaxSalaryEmployee() {
        Employee employee = employees[0];
        double max_salary = employee.getSalary();
        for (int i = 1; i < employeeCount; i++) {
            if(employees[i].getSalary() > max_salary) {
                employee = employees[i];
                max_salary = employee.getSalary();
            }
        }
        return employee;
    }

    public static double getTotalSalary() {
        double total_salary = 0.0;
        for(int i = 0; i < departmentCount; i++) {
            total_salary += departments[i].getDepartmentSalary();
        }
        return total_salary;
    }

    public void giveIncrementToEmployees(double amount) {
        Employee maxSalaryemployee = getMaxSalaryEmployee();
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getSalary() != maxSalaryemployee.getSalary()) {
                employees[i].setSalary(employees[i].getSalary() + amount);
            }
        }
    }
}