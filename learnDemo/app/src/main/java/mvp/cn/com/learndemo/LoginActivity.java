package mvp.cn.com.learndemo;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout username;
    private TextInputLayout passwd;
    private Button btn;

    private static final String  EMAIL_PATTEM="^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern=Pattern.compile(EMAIL_PATTEM);
    private Matcher matcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_text_input);
        username= (TextInputLayout) findViewById(R.id.username_input);
        passwd = (TextInputLayout) findViewById(R.id.password_input);
        btn= (Button) findViewById(R.id.bt);

        username.setHint("用户名");
        passwd.setHint("密码");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取输入的密码和用户名
                String user =username.getEditText().getText().toString();
                String pwd =passwd.getEditText().getText().toString();

                if (!validateEmail(user)){
                    //Toast.makeText(LoginActivity.this,"用户名格式不正确",Toast.LENGTH_LONG).show();
                    username.setError("用户名格式不正确");
                    return;
                }
                if(!validatePasswd(pwd)){
                   // Toast.makeText(LoginActivity.this,"密码至少六位",Toast.LENGTH_LONG).show();
                    passwd.setError("密码至少六位");
                    return;
                }
                username.setErrorEnabled(false);//当输入正确后之前的错误提示消失
                passwd.setErrorEnabled(false);
                doLogin();

            }
        });
    }

    /**
     * 登录操作
     */
    private void doLogin() {
        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    private boolean validateEmail(String email){
        matcher =pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 验证密码最少六位
     * @param passwd
     * @return
     */
    private boolean validatePasswd(String passwd){
        if(null !=passwd && passwd.length()!=0)

        return passwd.length()>5;

        return false;

    }


}
