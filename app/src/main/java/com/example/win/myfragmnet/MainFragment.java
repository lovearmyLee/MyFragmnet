package com.example.win.myfragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Fragment;
import com.example.win.fragment.uitl.BaseFragment;
import com.example.win.fragment.uitl.Param;

/**
 * Created by win on 2016/4/8.
 */
public class MainFragment extends BaseFragment {
    /** * 没有参数没有返回值的函数 */
    public static final String FUNCTION_NO_PARAM_NO_RESULT = "FUNCTION_NO_PARAM_NO_RESULT";
    /** * 有参数没有返回值的函数 */
    public static final String FUNCTION_HAS_PARAM_NO_RESULT = "FUNCTION_HAS_PARAM_NO_RESULT";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((Button)getView().findViewById(R.id.btn1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    functions.invokeFunc(FUNCTION_NO_PARAM_NO_RESULT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button)getView().findViewById(R.id.btn2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Param a = new Param("测试");
                    functions.invokeFunc(FUNCTION_HAS_PARAM_NO_RESULT,a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
