package com.example.listadetarefas;

import Dao.Task;
import Dao.TaskDao;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_title, ed_description;
        Button bt_save;

        ed_title = (EditText) findViewById(R.id.ed_TiTleTask);
        ed_description = (EditText) findViewById(R.id.ed_DescriptionTask);
        bt_save = (Button) findViewById(R.id.bt_SaveTask);

        Task task = new Task();

        task.setTitle(ed_title.getText().toString());
        task.setDescription(ed_description.getText().toString());

        TaskDao dao = new TaskDao(this);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.insert(task);
            }
        });
    }
}