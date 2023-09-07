package com.example.mybookmark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mybookmark.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; //맴버변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());//클래스 구조로 띄우기
        setContentView(binding.getRoot());



        //뷰페이저가 프레그먼트 3개와 연결하고자한다
        binding.viewPager.setAdapter(new ViewRageAdapter(this));

        //텝과 연결해보자
        TabLayoutMediator.TabConfigurationStrategy strategy=null;
        strategy=new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position==0){
                    tab.setText("월요일");
                }else if (position==1){
                    tab.setText("화요일");
                }else if (position==2){
                    tab.setText("환경설정");
                }
            }
        };
        new TabLayoutMediator(binding.tabLayout,binding.viewPager,strategy).attach();


    }
}