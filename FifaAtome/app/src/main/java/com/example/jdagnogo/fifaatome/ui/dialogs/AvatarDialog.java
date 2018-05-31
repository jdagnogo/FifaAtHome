package com.example.jdagnogo.fifaatome.ui.dialogs;


import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;

import com.example.jdagnogo.fifaatome.R;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AvatarDialog {

    public static void createDialog(Activity activity,Consumer toto) {
        final Dialog openDialog = new Dialog(activity);
        openDialog.setContentView(R.layout.avatar_dialog_view);

        TextView validate = openDialog.findViewById(R.id.validate);
        Disposable disposable = RxView.clicks(validate).subscribe(toto);

        openDialog.setOnDismissListener(dialog -> {
            if (!disposable.isDisposed())
                disposable.dispose();
        });
        openDialog.show();

    }
}
