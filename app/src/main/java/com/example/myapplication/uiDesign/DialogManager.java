package com.example.myapplication.uiDesign;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.database.UserDbAdapter;
import com.example.myapplication.models.User;
import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.R;
import com.example.myapplication.activity.RegisterUserActivity;
import com.example.myapplication.config.LoginManagement;
import com.example.myapplication.models.User;

public class DialogManager {
    public  static  void  loginUI(Activity activity){
        final UserDbAdapter userDbAdapter=new UserDbAdapter(activity);
        LoginManagement loginManagement = new LoginManagement(activity);
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.login_dialog, null);
        EditText edt_userName = (EditText)view.findViewById(R.id.edt_userName);
        EditText edt_password = (EditText)view.findViewById(R.id.edt_password);
        Button btn_login = (Button)view.findViewById(R.id.btn_login);
        CheckBox chk_save = (CheckBox)view.findViewById(R.id.chk_save);
        Button btn_register=(Button)view.findViewById(R.id.btn_register);
        edt_password.setText(loginManagement.getPassword());
        edt_userName.setText(loginManagement.getUserName());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edt_userName.getText().toString();
                String password=edt_password.getText().toString();
                if(chk_save.isChecked()){
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password);
                    loginManagement.saveData(user);
                }
            }

        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=edt_userName.getText().toString();
                String password=edt_password.getText().toString();

                User user=new User();
                user.setUserName(userName);
                user.setPassword(password);

                if(userDbAdapter.login(user)>0 ){

                    if(chk_save.isChecked()){
                        loginManagement.saveData(user);
                        Toast.makeText(activity,userName,Toast.LENGTH_LONG).show();
                    }
                }

                else {

                }




            }
        });
        alert.setView(view);
        alert.show();
    }
}
