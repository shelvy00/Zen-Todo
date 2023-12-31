package org.zenmanager.ZenTasks.models;

public enum TaskProgress {
    TODO("To Do"),
    INPROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String displayStatus;

    TaskProgress(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public static TaskProgress fromDisplayString(String displayString)
    {
        for(TaskProgress myEnum : TaskProgress.values()){
            if(myEnum.getDisplayStatus().equals(displayString.trim().toUpperCase())){
                return myEnum;}


        } return null;
    }
}
