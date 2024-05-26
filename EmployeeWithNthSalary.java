import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeWithNthSalary {

    public static void main(String[] args) {
        var employeeWithSalary = new HashMap<String,Integer>();
        employeeWithSalary.put("Aritra",1200);
        employeeWithSalary.put("Tulika",1300);
        employeeWithSalary.put("Say",1500);
        employeeWithSalary.put("Deb",1300);

        List<String> value = getNthHighestSalary(2,employeeWithSalary);
        System.out.println(value);
        //System.out.println(employeeWithSalary.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList()))));
    }

    private static List<String> getNthHighestSalary(int n , Map<String, Integer> employeewithSalary) {
        return employeewithSalary.entrySet().stream().collect
                        (Collectors.groupingBy(Map.Entry::getValue,
                                Collectors.mapping(Map.Entry::getKey, Collectors.toList()))).entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(n-1).getValue();
    }
}
