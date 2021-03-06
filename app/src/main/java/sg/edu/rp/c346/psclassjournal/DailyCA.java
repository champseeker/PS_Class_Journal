package sg.edu.rp.c346.psclassjournal;

import java.io.Serializable;

public class DailyCA implements Serializable {

    private String dgGrade;
    private String moduleCode;
    private String moduleName;
    private int week;

    public DailyCA(String dgGrade, String moduleCode, String moduleName, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getWeek() {
        return week;
    }

}
