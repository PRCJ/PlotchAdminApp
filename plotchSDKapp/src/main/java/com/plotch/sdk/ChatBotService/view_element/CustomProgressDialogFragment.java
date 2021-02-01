package com.plotch.sdk.ChatBotService.view_element;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.plotch.sdk.R;

/**
 * Created by Ranajit on 2 Aug 19.
 */

public class CustomProgressDialogFragment extends DialogFragment {

    public static final String TAG = "CustomProgressDialogFragment";
/*    @BindView(R.id.manufacturer_text_view)
    ProximaNovaTextViewRegular manufacturerTextViewRegular;
    @BindView(R.id.user_info_share_imageview)
    ImageView shareImageView;
    @BindView(R.id.mImageViewBackButton)
    ImageView backButton;*/

    public static CustomProgressDialogFragment newInstance() {

        Bundle args = new Bundle();

        CustomProgressDialogFragment fragment = new CustomProgressDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog configDialog = getDialog();
        if (configDialog != null) {
            configDialog.getWindow().setWindowAnimations(
                    //R.style.MaterialDialogSheetAnimation);
                    R.style.MaterialDialogSheetRightAnimation);
            configDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            configDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_custom_pregress_sdk, container, false);
        initView();
        return view;
    }

    private void initView() {


    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }



  /*  @OnClick(R.id.mImageViewBackButton)
    public void onBackButtonClicked() {
        dismiss();
    }*/

}
