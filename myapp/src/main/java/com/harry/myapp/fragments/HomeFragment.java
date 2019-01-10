package com.harry.myapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.harry.myapp.DetailActivity;
import com.harry.myapp.MainActivity;
import com.harry.myapp.R;
import com.harry.myapp.service.MyService;

import org.harry.littleworld.api.BaseFragment;

import static android.app.Activity.RESULT_OK;

/**
 * Created by zhanghai on 2019/1/9.
 * function：
 */
public class HomeFragment extends BaseFragment {
    private final int CODE = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view){
        view.findViewById(R.id.btn_myapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DetailActivity.class);
                startActivityForResult(intent,CODE);
//                startActivity(intent);
            }
        });

        view.findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getActivity(),MyService.class));
            }
        });

        view.findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getActivity(),MyService.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE && resultCode == RESULT_OK){
            showToast(getActivity(),"我返回自插件的DetailActivity类");
        }
    }

    public void showToast(Activity activity, String msg){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
    }


}
