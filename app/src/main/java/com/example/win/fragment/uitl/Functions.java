package com.example.win.fragment.uitl;

import java.util.HashMap;

/**
 * Created by win on 2016/4/8.
 */
public class Functions {


    //带参数方法的集合，key值为方法的名字
    private HashMap mFunctionWithParam ;
    //无参数无返回值的方法集合，同理key值为方法名字
    private HashMap mFunctionNoParamAndResult ;
    /**
     * 创建Function抽象基类
     */
    public  static  abstract class  Function{
        public String mFunctionName;
        public Function(String functionName){
            this.mFunctionName = functionName;
        }
    }

    /**
     * 带有参数没有返回值的function类集成基类
     */
    public static abstract class FunctionWithParam extends Function{

        public FunctionWithParam(String functionName) {
            super(functionName);
        }

        public  abstract void function(Param param);
    }

    /**
     * 带有参数没有返回值的function类集成基类
     */
    public static  abstract class FunctionNoParamAndResult extends Function{

        public FunctionNoParamAndResult(String functionName) {
            super(functionName);
        }

        public abstract void function();
    }

    /**
     * 添加带参数的函数
     * @param function
     * @return
     */
    public Functions addFunction(FunctionWithParam function){
        if(function==null){
            return this;
        }
        if(mFunctionWithParam == null){
            mFunctionWithParam = new HashMap(1);
        }
        mFunctionWithParam.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 添加一个无参无返回值的方法类
     * @param function
     * @return
     */
    public  Functions addFunction(FunctionNoParamAndResult function){

        if(function==null){
            return this;
        }
        if(mFunctionNoParamAndResult == null){
            mFunctionNoParamAndResult = new HashMap(1);
        }
        mFunctionNoParamAndResult.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 根据函数名，回调无参无返回值的函数
     * @param funcName
     * @throws Exception
     */
    public void invokeFunc(String funcName) throws Exception{
        FunctionNoParamAndResult f = null;
        if(mFunctionNoParamAndResult !=null){
            f = (FunctionNoParamAndResult) mFunctionNoParamAndResult.get(funcName);
            if(f!=null){
                f.function();
            }
        }
        if(f == null){
            throw  new Exception("没有次函数");
        }
    }

    /**
     *  调用具有参数的函数
     * @param funcName
     * @param param
     * @throws Exception
     */
    public  void invokeFunc(String funcName,Param param) throws Exception{
        FunctionWithParam f = null;
        if(mFunctionWithParam != null){
            f = (FunctionWithParam) mFunctionWithParam.get(funcName);
            if(f!=null){
                f.function(param);
            }
        }
    }
}
