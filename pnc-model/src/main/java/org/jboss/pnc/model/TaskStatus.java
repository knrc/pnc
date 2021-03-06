package org.jboss.pnc.model;

/**
 * Created by <a href="mailto:matejonnet@gmail.com">Matej Lazar</a> on 2014-12-03.
 */
public class TaskStatus {
    int percentageDone;
    Operation operation;

    public TaskStatus(Operation operation, int percentageDone) {
        this.operation = operation;
        this.percentageDone = percentageDone;
    }

    public enum Operation {
        NEW,
        BUILD_SCHEDULED,
        BUILD_IN_PROGRESS,
        BUILD_COMPLETED,
        BUILD_FAILED;
    }

    /**
     * @return -1 if operation failed
     */
    public int getPercentageDone() {
        return percentageDone;
    }

    public Operation getOperation() {
        return operation;
    }
}
