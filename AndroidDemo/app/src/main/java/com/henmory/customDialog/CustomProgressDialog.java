package com.henmory.customDialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.henmory.androiddemo.R;


/**
 * Created by dan on 6/15/16.
 */
public class CustomProgressDialog extends Dialog {

    private TextView tv_message;

    public CustomProgressDialog(Context context) {
        super(context);
        setContentView(R.layout.custom_progress_dialog);
        tv_message = (TextView) findViewById(R.id.custom_progress_dailog_text_view);
    }

    public CustomProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.custom_progress_dialog);
        tv_message = (TextView) findViewById(R.id.custom_progress_dailog_text_view);
    }

    public CustomProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setContentView(R.layout.custom_progress_dialog);
        tv_message = (TextView) findViewById(R.id.custom_progress_dailog_text_view);
    }

    public CustomProgressDialog(Context context, CharSequence msg, OnCancelListener cancelListener) {
        this(context,R.style.CustomProgressDialog);//默认主题
        setCancelable(true);//点击返回按钮，关闭对话框
        setCanceledOnTouchOutside(false);//点击对话框窗口外不消失
        setOnCancelListener(cancelListener);
        setMessage(msg);
    }

    public void setMessage(CharSequence msg) {
        if (tv_message != null) {
            tv_message.setText(msg);
            tv_message.invalidate();
        }
    }


}
