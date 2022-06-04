package com.example.myapplication_bigwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calenderView);
        //calendarView 监听事件
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth) {
                //显示用户选择的日期
                Toast.makeText(MainActivity.this,year + "年" + month + "月" + dayOfMonth + "日",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //从item_menu.xml中构建菜单页面布局
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id)
        {
            case R.id.item_home:
            Intent intent_home = new Intent();
            /* 指定intent要启动的类 */
            intent_home.setClass(MainActivity.this, MainActivity.class);
            /* 启动一个新的Activity */
            startActivity(intent_home);
            /* 关闭当前的Activity */
            MainActivity.this.finish();
            break;


            case R.id.item_list:
            Intent intent_list = new Intent();
            /* 指定intent要启动的类 */
            intent_list.setClass(MainActivity.this, ListActivity.class);
            /* 启动一个新的Activity */
            startActivity(intent_list);
            /* 关闭当前的Activity */
            MainActivity.this.finish();
            break;

            case R.id.item_statistic:
            Intent intent_statistic = new Intent();
            /* 指定intent要启动的类 */
            intent_statistic.setClass(MainActivity.this, StatisticActivity.class);
            /* 启动一个新的Activity */
            startActivity(intent_statistic);
            /* 关闭当前的Activity */
            MainActivity.this.finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
