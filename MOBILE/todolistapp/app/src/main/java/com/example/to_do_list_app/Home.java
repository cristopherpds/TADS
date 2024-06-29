package com.example.to_do_list_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    private AddTaskFragment addTaskFrag;
    private ViewTaskFragment viewTaskFragment;
    private  PomodorTaskFragment pomodorTask;
    private BottomNavigationView navMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addTaskFrag = new AddTaskFragment();
        viewTaskFragment = new ViewTaskFragment();
        pomodorTask =new PomodorTaskFragment();

        navMenu = findViewById(R.id.menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, addTaskFrag).commit();

        navMenu.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.item1){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, addTaskFrag).commit();
                return true;
            } else if (item.getItemId() == R.id.item2) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, viewTaskFragment).commit();
                return true;
            } else if (item.getItemId() == R.id.item3) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame, pomodorTask).commit();
                return true;
            }
            return false;
        });
    }
}