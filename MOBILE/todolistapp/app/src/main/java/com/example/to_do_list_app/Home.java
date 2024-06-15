package com.example.to_do_list_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

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
        List<Task> mockTasks = Task.getMockTasks();

        // Pasar datos al fragmento AddTaskFragment
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("tasks", (ArrayList<? extends Parcelable>) new ArrayList<>(mockTasks));
        viewTaskFragment.setArguments(bundle);

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