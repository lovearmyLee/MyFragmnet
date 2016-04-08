package com.example.win.fragment.uitl;

import android.app.Activity;
import android.app.Fragment;


import com.example.win.myfragmnet.BaseActivity;

/**
 * Created by win on 2016/4/8.
 */
public class BaseFragment extends Fragment {
    protected BaseActivity mBaseActivity;
    protected  Functions functions;
    public void setFunctions(Functions functions){
        this.functions = functions;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity){
            mBaseActivity  = (BaseActivity)activity;
            int d = getId();
            mBaseActivity.setFunctionsForFragment(getId());
        }

    }
}
