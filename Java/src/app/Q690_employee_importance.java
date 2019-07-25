package app;

import java.util.*;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Q690_employee_importance
{
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id)
    {
        if( employees == null )     return 0;
        if( employees.size() == 0 ) return 0;

        for( Employee e: employees ) map.put( e.id, e );
        return dfs( id );
        // // only counts the value of the next level
        // if( map.containsKey( id ) )
        // {
        //     Employee tar = map.get( id );
        //     int total = tar.importance;
        //     if( tar.subordinates != null && tar.subordinates.size() != 0 )
        //         for( int sub: tar.subordinates )
        //         {
        //             if( map.containsKey( sub ) )
        //                 total += map.get( sub ).importance;
        //         }
        //     return total;
        // }
        // return 0;
    }
    
    private int dfs( int id )
    {
        Employee e = map.get( id );
        int total = e.importance;
        for( int sub: e.subordinates )
            total += dfs( sub );
        return total;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}