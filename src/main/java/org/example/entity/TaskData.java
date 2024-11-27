package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
        }
        return Set.of();
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> allTasks = new HashSet<>();

        for(Set<Task> set: sets) {
            allTasks.addAll(set);
        }

        return allTasks;
    }

    public Set<Task> getIntersection(Set<Task> task1, Set<Task> task2) {
        Set<Task> retainTask = new HashSet<>(task1);

        retainTask.retainAll(task2);

        return retainTask;
    }

    public Set<Task> getDifferences(Set<Task> task1, Set<Task> task2) {
        Set<Task> removeTask = new HashSet<>(task1);

        removeTask.removeAll(task2);

        return removeTask;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
}
