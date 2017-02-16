package com.nodomain.mensclothingstore.ui.fragments;


import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.StringRes;


public class ProgressDialogFragment extends DialogFragment {

    private static final String ARG_MESSAGE_RES = "message_res";

    public static ProgressDialogFragment newInstance(@StringRes int messageRes) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_MESSAGE_RES, messageRes);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog pd = new ProgressDialog(getActivity());
        String message = getString(getMessageResFromArgs());
        pd.setMessage(message);
        return pd;
    }

    private int getMessageResFromArgs() {
        return getArguments().getInt(ARG_MESSAGE_RES);
    }
}
