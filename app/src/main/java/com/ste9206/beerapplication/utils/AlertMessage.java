package com.ste9206.beerapplication.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by stefano on 31/05/17.
 */

public class AlertMessage {

    public static AlertDialog.Builder newAlertErrorMessage(String message, Context context){
        return new AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("Ok",listener());
    }

    public static DialogInterface.OnClickListener listener()
    {
        return (dialog, which) -> {
            dialog.dismiss();
        };
    }

    public static AlertDialog.Builder newAlertMessage(String title,String message, Context context){
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok",listener());
    }

    public static AlertDialog.Builder newAlertMessageListener(String title,String message, Context context, DialogInterface.OnClickListener listener){
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok",listener);
    }

    public static ProgressDialog newProgress(String message, Context context){
        return new ProgressDialog(context);
    }
}
