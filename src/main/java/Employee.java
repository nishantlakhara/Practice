import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private String employeeId;
    private String managerId;

    public Employee(String employeeId, String managerId) {
        this.employeeId = employeeId;
        this.managerId = managerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("E1", "M1");
        Employee e2 = new Employee("E2", "M1");
        Employee e3 = new Employee("E3", "M2");
        Employee e4 = new Employee("E4", "M2");
        Employee e5 = new Employee("E5", "M2");
        Employee e6 = new Employee("E6", "M3");

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5,e6);

        Map<String, Long> groupedData = employees.stream()
                .collect(Collectors.groupingBy(Employee::getManagerId, Collectors.counting()));

        long max=0;
        for (Map.Entry<String, Long> entry: groupedData.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
            }
        }

        System.out.println(max);
    }
}
