package cs460;

/*
 * https://leetcode.com/problems/course-schedule-ii/
 * 10/31/21
 *
 * Inputs: int(number of courses/vertices), int[][](prereqs/edges))
 * Output: int[] with order necessary to take class in. Return empty array if impossible.
 */
public class CourseSchedule {
    static int clock;
    static V[] courses;
    static int[][] prereq;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        clock = numCourses-1;
        courses = new V[numCourses];
        prereq = prerequisites;
        for (int i = 0; i < numCourses; i++)
            courses[i] = new V(i);
        Explore(0);
        for (int i = 1 ; i < numCourses ; i++) {
            if (courses[i].visited)
                continue;
            Explore(i);
        }
        for (int[] edge : prerequisites) {
            if (courses[edge[1]].post > courses[edge[0]].post)
                return new int[0];
        }
        int[] topoSorted = new int[numCourses];
        for (V curr : courses) {
            topoSorted[curr.post] = curr.index;
        }
        return topoSorted;
    }

    public static void Explore(int v) {
        courses[v].visited = true;
        for (int[] edge : prereq)
            if (edge[1] == v && !courses[edge[0]].visited)
                Explore(edge[0]);
        courses[v].post = clock--;
    }

    public static void main(String[] args) {
        System.out.print("[");
        int[] returned = findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}}); //test normal
        for (int a : returned)
            System.out.print(a + " ");
        System.out.println("]");
        System.out.print("[");
        returned = findOrder(2, new int[][] {{1,0},{0,1}}); //test impossible schedule
        for (int a : returned)
            System.out.print(a + " ");
        System.out.println("]");
        System.out.print("[");
        returned = findOrder(3, new int[][] {}); //test no edges
        for (int a : returned)
            System.out.print(a + " ");
        System.out.println("]");
        System.out.print("[");
        returned = findOrder(2, new int[][] {{1,0}}); //test one edge
        for (int a : returned)
            System.out.print(a + " ");
        System.out.print("]");
    }
}

class V {
    int index;
    int post;
    boolean visited;
    public V (int index) {
        this.index = index;
    }
}
