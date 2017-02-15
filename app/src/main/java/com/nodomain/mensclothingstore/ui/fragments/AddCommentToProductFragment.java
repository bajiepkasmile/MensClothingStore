package com.nodomain.mensclothingstore.ui.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.AddCommentToProductMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.AddCommentToProductMvpView;
import com.nodomain.mensclothingstore.navigation.AddCommentToProductNavigator;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;
import com.nodomain.mensclothingstore.utils.ErrorUtil;
import com.nodomain.mensclothingstore.utils.ToastUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


public class AddCommentToProductFragment extends BaseFragment<AddCommentToProductMvpPresenter>
        implements AddCommentToProductMvpView {

    private static final String ARG_PRODUCT = "product";

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_text)
    EditText etText;

    @Inject
    AddCommentToProductNavigator navigator;
    @Inject
    ErrorUtil errorUtil;
    @Inject
    ToastUtil toastUtil;

    private ProgressDialog pdAddComment;

    public static AddCommentToProductFragment newInstance(Product product) {
        AddCommentToProductFragment fragment = new AddCommentToProductFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_PRODUCT, product);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.getMainActivitySubComponent(getActivity()).inject(this);
        return inflater.inflate(R.layout.fragment_add_comment_to_product, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayHomeButton();
        mvpPresenter.init(getProductFromArgs());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mvpPresenter.returnToPreviousView();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProduct(Product product) {
        setTitle(product.getName());
    }

    @Override
    public void showAddCommentProgress() {
        pdAddComment = createProgressDialog(R.string.adding);
        pdAddComment.show();
    }

    @Override
    public void hideAddCommentProgress() {
        pdAddComment.hide();
    }

    @Override
    public void showPreviousView() {
        navigator.navigateToPreviousView();
    }

    @Override
    public void showError(Error error) {
        String errorMessage = errorUtil.errorToErrorMessage(error);
        Toast errorToast = toastUtil.createCenteredToast(errorMessage);
        errorToast.show();
    }

    @OnClick(R.id.btn_add)
    public void onAddClick() {
        String senderName = etName.getText().toString();
        String text = etText.getText().toString();
        mvpPresenter.addComment(senderName, text);
    }

    private Product getProductFromArgs() {
        return getArguments().getParcelable(ARG_PRODUCT);
    }

    private ProgressDialog createProgressDialog(@StringRes int messageResId) {
        ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setMessage(getString(messageResId));
        pd.setCancelable(false);
        return pd;
    }
}
