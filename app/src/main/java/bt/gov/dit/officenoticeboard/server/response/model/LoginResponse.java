package bt.gov.dit.officenoticeboard.server.response.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tashi Choden on 25-Jan-17.
 */

public class LoginResponse implements Serializable {

    @SerializedName("employee_id")
    private String employeeId;
    @SerializedName("login_status")
    private int status;

    public String getEmployeeId() {
        return employeeId;
    }

    public int getStatus() {
        return status;
    }
}
