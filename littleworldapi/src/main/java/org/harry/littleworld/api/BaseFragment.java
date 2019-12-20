package org.harry.littleworld.api;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.harry.littleworld.api.appproxy.ProxyActivity;

/**
 * Created by zhanghai on 2019/1/9.
 * function：
 */
public class BaseFragment extends Fragment implements ILittleWorldFragment {

    protected Fragment fragment;


    @Override
    public void attach(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if(fragment == null){
            super.startActivityForResult(intent, requestCode);
        }else {
            fragment.startActivityForResult(intent,requestCode);
        }
    }

    public void startActivityForResult(String className,int requestCode){
        Intent intent = new Intent(getActivity(), ProxyActivity.class);
        intent.putExtra(LittleWorldConstantApi.ExtraKey.API_KEY_CLASS_NAME,className);
        startActivityForResult(intent,requestCode);
    }


    @Override
    public void startActivity(Intent intent) {
        if(fragment == null){
            super.startActivity(intent);
        }else {
            fragment.startActivity(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(fragment == null){
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
