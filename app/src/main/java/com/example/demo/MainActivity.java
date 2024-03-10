package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Fragment messageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageFragment = new MessageFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.center_layout, messageFragment);
        fragmentTransaction.commit();
    }

    public void changeTab(View view) {
        // 先将所有tabs的图标设置为未选中状态
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);

        // 将所有ImageView重置为默认图标
        imageView1.setImageResource(R.drawable.message1);
        imageView2.setImageResource(R.drawable.contact1);
        imageView3.setImageResource(R.drawable.discover1);
        imageView4.setImageResource(R.drawable.my1);

        // 根据点击的视图ID设置相应的ImageView为选中状态
        if (view.getId() == R.id.imageView1) {
                imageView1.setImageResource(R.drawable.message2);
        } else if (view.getId() == R.id.imageView2){
            imageView2.setImageResource(R.drawable.contact2);
        } else if (view.getId() == R.id.imageView3){
            imageView3.setImageResource(R.drawable.discover2);
        } else if (view.getId() == R.id.imageView4){
            imageView4.setImageResource(R.drawable.my2);
        }
    }
}