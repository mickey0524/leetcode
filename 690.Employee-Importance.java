// https://leetcode.com/problems/employee-importance/
//
// algorithms
// Easy (55.3%)
// Total Accepted: 56,702
// Total Submissions: 102,529


/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;  // 直属下属
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        int res = 0;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(id);

        while (!q.isEmpty()) {
            int curId = q.pollFirst();
            Employee e = map.get(curId);
            if (e != null) {
                res += e.importance;
                if (e.subordinates != null) {
                    for (int n : e.subordinates) {
                        q.add(n);
                    }
                }
            }
        }

        return res;
    }
}