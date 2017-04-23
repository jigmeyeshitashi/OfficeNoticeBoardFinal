package bt.gov.dit.officenoticeboard.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bt.gov.dit.officenoticeboard.Helper.Conditions;
import bt.gov.dit.officenoticeboard.R;
import bt.gov.dit.officenoticeboard.callback.OnReceiveResult;
import bt.gov.dit.officenoticeboard.server.asynctask.LoginAsyncTask;
import bt.gov.dit.officenoticeboard.server.response.model.LoginResponse;
import bt.gov.dit.officenoticeboard.constant.Constant;
public class LoginActivity extends Activity implements OnReceiveResult {
    private EditText userName;
    private EditText password;
private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.username_edit_text);
        password = (EditText) findViewById(R.id.password_edit_text);
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                String userName1 = userName.getText().toString();
                String pwd = password.getText().toString();
                new LoginAsyncTask(LoginActivity.this).execute(userName1, pwd);

              /*  if(Conditions.condition != 0){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                Intent intent = new Intent(LoginActivity.this, FirstTimeLoginActivity.class);
                startActivity(intent);}*/
            }
        });
    }

    @Override
    public void onReceive(Object response) {
        if(response !=null && ((LoginResponse)response).getStatus() == Constant.LOGIN_SUCCESS) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "Unable to login please check username and passowrd", Toast.LENGTH_SHORT).show();
        }
    }
}
