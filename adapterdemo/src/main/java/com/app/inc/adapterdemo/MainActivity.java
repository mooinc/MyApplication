package com.app.inc.adapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取组件
        lv = (ListView) this.findViewById(R.id.lv);
        show = (EditText) this.findViewById(R.id.show);


        List<Person> data = new ArrayList<Person>();
        for(int i=1;i<=10;i++){
            Person p = new Person();
            p.setId(i+"");
            p.setName("张三"+i);
            p.setPhone("1355555555"+i);
            data.add(p);
        }
        //创建适配器
        MyAdapter adapter = new MyAdapter(this, data, new MyInterface() {
            public void setTxt(String s) {
                show.setText(s);
            }
        });

        //设置适配器
        lv.setAdapter(adapter);

        /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyAdapter ma = (MyAdapter) parent.getAdapter();
                Person p = (Person) ma.getItem(position);
                //Toast.makeText(MainActivity.this, p.getId()+" "+p.getName()+" "+p.getPhone(), Toast.LENGTH_SHORT).show();
                show.setText(p.getId()+" "+p.getName()+" "+p.getPhone());
            }
        });
        */

        //刷新集合列表的显示
        //1、lv.setAdapter();//重新设置适配器内容
        //2、adapter.notifyDataSetChanged();//更新适配内容



    }
}
