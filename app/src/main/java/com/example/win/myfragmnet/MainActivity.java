package com.example.win.myfragmnet;




import android.os.Bundle;
import android.app.FragmentManager;
import android.widget.Toast;

import com.example.win.fragment.uitl.BaseFragment;
import com.example.win.fragment.uitl.Functions;
import com.example.win.fragment.uitl.Param;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void setFunctionsForFragment(int fragmentId) {
        super.setFunctionsForFragment(fragmentId);
        switch (fragmentId){
            case R.id.main:
                FragmentManager fm = getFragmentManager();
                BaseFragment fragment = (BaseFragment) fm.findFragmentById(fragmentId);
                fragment.setFunctions(
                        new Functions().addFunction(
                                new Functions.FunctionNoParamAndResult(MainFragment.FUNCTION_NO_PARAM_NO_RESULT) {
                    @Override
                    public void function() {
                        Toast.makeText(MainActivity.this, "成功调用无参无返回值方法", Toast.LENGTH_LONG).show();
                    }
                }).addFunction(new Functions.FunctionWithParam(MainFragment.FUNCTION_HAS_PARAM_NO_RESULT) {
                            @Override
                            public void function(Param param) {
                                Toast.makeText(MainActivity.this, "成功调用有参无返回值方法 "+param.getStr(), Toast.LENGTH_LONG).show();
                            }
                        })
                );
                break;
        }
    }
}
