package com.example.taxipot_android.data.cache;

public class ReportCache {
    private String reportId;
    private String reportedId;

    public String getReportId() {
        return reportId;
    }

    public String setReportId(String reportId) {
        this.reportId = reportId;
        return reportId;
    }

    public String getReportedId() {
        return reportedId;
    }

    public String setReportedId(String reportedId) {
        this.reportedId = reportedId;
        return reportedId;
    }
}
