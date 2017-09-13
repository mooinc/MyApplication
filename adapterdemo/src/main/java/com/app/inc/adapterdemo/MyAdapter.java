package com.app.inc.adapterdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 自定义适配器
 */
public class MyAdapter extends BaseAdapter {

    private Context context;//上下文
    private List<Person> data;//数据集合
    private MyInterface mi;

    //通过构造方法初始化必要属性
    public MyAdapter(Context context, List<Person> data, MyInterface mi) {
        this.context = context;
        this.data = data;
        this.mi = mi;
    }

    //获取集合的总数
    public int getCount() {
        return data.size();
    }

    //根据索引下标获取集合中选项
    public Object getItem(int position) {
        return data.get(position);
    }

    //获取集合选项ID
    public long getItemId(int position) {
        return position;
    }

    //自定义视图(重点方法)
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载指定子视图对象
        convertView = View.inflate(context, R.layout.item_layout, null);
        //获取加载的子视图中的组件
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
        //获取集合中的选项
        Person p = data.get(position);
        //设置数据内容的显示
        id.setText(p.getId());
        name.setText(p.getName());
        phone.setText(p.getPhone());


        //为组件单独添加点击事件
        id.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(context, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
                //show.setText(((TextView)v).getText());
                mi.setTxt(((TextView)v).getText().toString());
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(context, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
                //show.setText(((TextView)v).getText());
                //调用接口的抽象方法
                mi.setTxt(((TextView)v).getText().toString());
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(context, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
                //show.setText(((TextView)v).getText());
                mi.setTxt(((TextView)v).getText().toString());
            }
        });


        //根据索引下表判断单双行
        if(position%2==0){
            //设置组件的字体颜色
            name.setTextColor(Color.parseColor("#00FF00"));
            //设置子视图的背景颜色
            convertView.setBackgroundColor(Color.parseColor("#7FFFD4"));
        }else{
            name.setTextColor(Color.parseColor("#FF00DD"));
        }

        if(p.getPhone().endsWith("8")){
            phone.setTextColor(Color.parseColor("#FF0000"));
            phone.setTextSize(20.0f);//设置字体大小
        }


        //返回自定义视图
        return convertView;
    }
}
