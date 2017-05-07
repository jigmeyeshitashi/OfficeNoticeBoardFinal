package bt.gov.dit.officenoticeboard.server.response.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tashi Choden on 25-Jan-17.
 */

public class LoginResponse implements Serializable {

    @SerializedName("employee_id")
    private String employeeId;
    @SerializedName("password")
    private String password;
    @SerializedName("status")
    private int status;
    @SerializedName("first_login")
    private int firstlogin;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPassword() {
        return password;
    }
    public int getStatus() {
        return status;
    }
    public int getFirstlogin() {
        return firstlogin;
    }

}
