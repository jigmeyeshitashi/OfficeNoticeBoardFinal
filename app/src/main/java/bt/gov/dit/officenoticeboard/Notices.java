package bt.gov.dit.officenoticeboard;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Jigme on 1/26/2017.
 */

public class Notices implements Serializable {
    @SerializedName("notice_id")
    private int noticeId;
    @SerializedName("employee_id")
    private double employeeId;
    @SerializedName("purpose")
    private String purpose;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("end_date")
    private String endDate;
    @SerializedName("description")
    private String description;
    @SerializedName("office_order")
    private String officeOrder;
    @SerializedName("posted_time")
    private String postedTime;

    public int getNoticeId() {
        return noticeId;
    }

    public double getEmployeeId() {
        return employeeId;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getOfficeOrder() {
        return officeOrder;
    }

    public String getPostedTime() {
        return postedTime;
    }
}
