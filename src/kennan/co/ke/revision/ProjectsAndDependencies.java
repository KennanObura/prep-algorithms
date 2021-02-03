package kennan.co.ke.revision;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProjectsAndDependencies {
    public static void main(String[] args) {
        char[] projectArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = {
                {'a', 'd'},
                {'f', 'b'},
                {'b', 'd'},
                {'f', 'a'},
                {'d', 'c'}};
        ProjectGraph graph = new ProjectGraph(projectArray, dependencies);
        Map<Character, Project> map = graph.getProjectMap();

        boolean isCycle = true;
        LinkedList<Project> result = new LinkedList<>();

        for (Map.Entry<Character, Project> entry : map.entrySet())
            if (entry.getValue().getDependants().isEmpty()) {
                isCycle = false;
                break;
            }

        if (isCycle) System.out.println(new ArrayList<>());


        doTopologicalSort(map.get('f'), result);

        for(Project project : result)
            System.out.print( project.getValue() + ", ");
    }

    private static void doTopologicalSort(Project project, LinkedList<Project> result) {
        for (Project p : project.getDependants()) {
            if (!p.isFinished()) {
                p.setFinished(true);
                doTopologicalSort(p, result);
            }
        }
        result.addFirst(project);
    }
}


class ProjectGraph {
    final char[] projects;
    final char[][] dependencies;
    Map<Character, Project> projectMap;

    public ProjectGraph(char[] projects, char[][] dependencies) {
        this.projects = projects;
        this.dependencies = dependencies;
        this.projectMap = new HashMap<>();
        this.buildGraph();
    }

    private void buildGraph() {
        for (char project : projects)
            projectMap.putIfAbsent(project, new Project(project));

        for (char[] dependency : dependencies)
            projectMap.get(dependency[0]).addDependency(projectMap.get(dependency[1]));
    }

    public Map<Character, Project> getProjectMap() {
        return projectMap;
    }
}

class Project {
    private Character value;
    private boolean finished;
    LinkedList<Project> dependants;

    public Project(char value) {
        this.value = value;
        finished = false;
        dependants = new LinkedList<>();
    }

    public LinkedList<Project> getDependants() {
        return dependants;
    }

    public Character getValue() {
        return value;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public void addDependency(Project dependency) {
        dependants.addFirst(dependency);
    }
}
