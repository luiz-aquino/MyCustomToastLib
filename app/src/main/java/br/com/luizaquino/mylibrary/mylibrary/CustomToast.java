package br.com.luizaquino.mylibrary.mylibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by logonrm on 02/08/2017.
 */

public class CustomToast {

    private enum MESSAGE_TYPE
    {
        INFORMATION,
        SUCCESS,
        WARNING,
        ERROR
    }

    private void showMessage(Context context, String mensagem, MESSAGE_TYPE type)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customToastRoot = inflater.inflate(R.layout.custom_toast, null);
        Toast customToast = new Toast(context);

        customToast.setView(customToastRoot);
        TextView textView = (TextView) customToastRoot.findViewById(R.id.textView1);
        textView.setText(mensagem);
        ImageView imgView = (ImageView) customToastRoot.findViewById(R.id.imageView1);

        switch (type){
            case INFORMATION:
                imgView.setImageResource(R.drawable.information);
                break;
            case SUCCESS:
                imgView.setImageResource(R.drawable.checked);
                break;
            case WARNING:
                imgView.setImageResource(R.drawable.danger);
                break;
            case ERROR:
                imgView.setImageResource(R.drawable.Error);
                break;
        }

        customToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
        customToast.setDuration(Toast.LENGTH_LONG);
        customToast.show();
    }

    public void showToast(Context context, String mensagem) {
        this.showMessage(context, mensagem, MESSAGE_TYPE.INFORMATION);
    }

    public void showError(Context context, String mensagem) {
        this.showMessage(context, mensagem, MESSAGE_TYPE.ERROR);
    }

    public void showWarning(Context context, String mensagem) {
        this.showMessage(context, mensagem, MESSAGE_TYPE.WARNING);
    }

    public void showSuccess(Context context, String mensagem) {
        this.showMessage(context, mensagem, MESSAGE_TYPE.SUCCESS);
    }
}
