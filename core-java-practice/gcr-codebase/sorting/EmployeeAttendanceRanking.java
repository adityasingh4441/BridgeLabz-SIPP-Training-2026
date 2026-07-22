import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeAttendanceRanking {
    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] result = topKEmployees(employeeIds, attendance, k);
        System.out.println("Top " + k + " employee IDs:");
        for (int id : result) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        List<EmployeeRecord> records = new ArrayList<>();

        for (int i = 0; i < employeeIds.length; i++) {
            records.add(new EmployeeRecord(employeeIds[i], attendance[i]));
        }

        Collections.sort(records, new Comparator<EmployeeRecord>() {
            @Override
            public int compare(EmployeeRecord a, EmployeeRecord b) {
                if (b.attendance != a.attendance) {
                    return Integer.compare(b.attendance, a.attendance);
                }
                return Integer.compare(a.employeeId, b.employeeId);
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = records.get(i).employeeId;
        }
        return result;
    }

    static class EmployeeRecord {
        int employeeId;
        int attendance;

        EmployeeRecord(int employeeId, int attendance) {
            this.employeeId = employeeId;
            this.attendance = attendance;
        }
    }
}
