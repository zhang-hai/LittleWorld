package org.harry.littleworld.api;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhanghai on 2019/1/9.
 * function：
 */
public interface ILittleWorldFragment {
    void attach(Fragment fragment);
    void onCreate(@Nullable Bundle savedInstanceState);
    void onViewCreated(View view, @Nullable Bundle savedInstanceState);
    View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
    void onResume();
    void onStart();
    void onPause();
    void onStop();
    void onDestroyView();
    void onDestroy();

}
