package com.plotch.sdk.ChatBotService.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.plotch.sdk.BuildConfig;
import com.plotch.sdk.ChatBotService.adapter.AddressInChatAdapter;
import com.plotch.sdk.ChatBotService.adapter.CancellationReasonAdapter;
import com.plotch.sdk.ChatBotService.adapter.ConversationAdapter;
import com.plotch.sdk.ChatBotService.adapter.RecyclerViewChipClickListener;
import com.plotch.sdk.ChatBotService.adapter.RecyclerViewOrdersInChatClickListener;
import com.plotch.sdk.ChatBotService.adapter.RecyclerViewProductClickListener;
import com.plotch.sdk.ChatBotService.adapter.RecyclerViewSizeClickListener;
import com.plotch.sdk.ChatBotService.adapter.ResponseChipsAdapter;
import com.plotch.sdk.ChatBotService.adapter.ShowOrdersAdapter;
import com.plotch.sdk.ChatBotService.adapter.ShowProductsAdapter;
import com.plotch.sdk.ChatBotService.adapter.SizeSelectionAdapter;
import com.plotch.sdk.ChatBotService.adapter.WalletTransactionAdapter;
import com.plotch.sdk.ChatBotService.base.BaseActivity;
import com.plotch.sdk.Constants.Constants;
import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.data.AddressListData;
import com.plotch.sdk.data.CancelReason;
import com.plotch.sdk.data.ChatBotRequest;
import com.plotch.sdk.data.ChatBotResponse;
import com.plotch.sdk.data.ChatData;
import com.plotch.sdk.data.CodOrderPlacedDetails;
import com.plotch.sdk.data.FcmUpdateData;
import com.plotch.sdk.data.OptionList;
import com.plotch.sdk.data.OrdersInChat;
import com.plotch.sdk.data.PinCodeAddress;
import com.plotch.sdk.data.PurchaseData;
import com.plotch.sdk.data.ShipmentStatusData;
import com.plotch.sdk.data.SimilarProductData;
import com.plotch.sdk.data.Statements;
import com.plotch.sdk.data.Variants;
import com.plotch.sdk.data.WalletDataForChat;
import com.plotch.sdk.network.Connectivity;
import com.plotch.sdk.network.URLConstants;
import com.plotch.sdk.utils.GeneralUtils;
import com.plotch.sdk.utils.ToastUtils;
import com.plotch.sdk.utils.Utils;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ChatbotActivity extends BaseActivity<ChatbotPresenter> implements ChatbotContract.View {
    RecyclerView chatList;
    RecyclerView chipList;
    RecyclerView productList;
    RecyclerView walletTransactionlist;
    LinearLayout optionChips;
    LinearLayout optionProducts;
    LinearLayout walletView;
    LinearLayout tracking_view;
    TextView total_wallet_balance;
    TextView craftsvilla_coin;
    TextView craftsvilla_money;
    TextView ok;
    ImageView mImageViewBackButton;
    ImageView upDown;
    RelativeLayout lang;
    TextView language_text;
    RelativeLayout upDown_lay;
    TextView up_down_text;
    TextView notFoundText;
    LinearLayout lay_proceed;
    RelativeLayout text_back;
    EditText enter_text;
    RelativeLayout scroll;
    ImageView apply;
    NestedScrollView nested_scroll;
    RecyclerView cancel_reason_list;
    LinearLayout cancel_reason_lay;
    EditText mEditTextFullAddress;
    EditText mEditTextMobileNumber;
    ImageView mAddressCrossImageView;
    TextInputLayout mTextInputPinCode;
    TextInputLayout mTextInputCity;
    TextInputLayout mTextInputState;
    TextInputLayout mTextInputFullAddress;
    TextInputLayout mTextInputMobileNumber;
    LinearLayout mTextInputCityStateLayout;
    AppCompatButton mProceedToPayButton;
    TextInputLayout mTextInputFirstName, mTextInputLastName;
    TextView mEditTextFirstName, mEditTextLastName, mEditTextCity, mEditTextState;
    Button mButtonSaveAddressButton;
    Button mButtonCancelAddressButton;
    EditText mEditTextPinCode;
    AppCompatImageView product_image;
    TextView product_name, expected_delivery_title, price_and_qty, latest_update_summary, shipment_summary, shipment_summary1;
    TextView shipment_id, requested_text, titel, price_titel, price_amount, order_id, product_name_titel;
    ImageView image_circle_requested, image_circle_approved, image_circle_shipped, image_circle_delivered;
    View view_requested_right, view_approved_left, view_approved_right, view_shipped_left, view_shipped_right, view_delivered_left, view_delivered_right;
    ImageView tracker_requested;
    ImageView tracker_approved;
    ImageView tracker_shipped;
    ImageView tracker_delivered;
    ImageView tracker_returned;
    RelativeLayout orderLay;
    Button cancle;
    LinearLayout return_layout, track_lay;
    Animation zoom_in, zoom_out;
    BottomSheetDialog bottomSheetLoginDialog;
    BottomSheetDialog bottomSheetPurchaseDialog;
    BottomSheetBehavior bottomSheetBehavior;

    RelativeLayout loadingBack, notFoundBack;

    BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                if (bottomSheetLoginDialog != null) {
                    bottomSheetLoginDialog.dismiss();
                }
                if (bottomSheetLoginDialog != null) {
                    bottomSheetLoginDialog.dismiss();
                }
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };
    BottomSheetBehavior.BottomSheetCallback bottomSheetCallbackPurchase = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                if (bottomSheetPurchaseDialog != null) {
                    bottomSheetPurchaseDialog.dismiss();
                }
                if (bottomSheetPurchaseDialog != null) {
                    bottomSheetPurchaseDialog.dismiss();
                }
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }

    };
    BottomSheetBehavior.BottomSheetCallback bottomSheetOrderSts = new BottomSheetBehavior.BottomSheetCallback() {
        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                if (bottomSheetPurchaseDialog != null) {
                    bottomSheetPurchaseDialog.dismiss();
                }
                if (bottomSheetPurchaseDialog != null) {
                    bottomSheetPurchaseDialog.dismiss();
                }
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }

    };
    private ChatBotRequest chatbotRequest;
    private LinearLayoutManager layoutChipManager;
    private LinearLayoutManager conveersationlayoutManager;
    private ArrayList<Statements> satements;
    private int tags = 0;
    private ConversationAdapter cahtAdapter;
    private LinearLayoutManager layoutProdManager;
    private String shipmentids = "";
    private LinearLayoutManager walletLayoutmanager;
    private final int posForLoading = 0;
    private Statements loadingObject;
    private String orderids;
    private String imageUrl;
    private Thread thread;
    private String language = "english";
    private String startTime = "";
    private ArrayList<OptionList> optionData = new ArrayList<>();
    private ResponseChipsAdapter rcAdapter;
    private SimilarProductData spd;
    private String paymentMode;
    private int adressPos = 0;
    private OrdersInChat Oic;
    private final boolean isPinCodeChecked = false;
    private AddressInChatAdapter aica;
    private AddressListData finalAddressList;
    private BottomSheetDialog bottomSheetOrderSuccessDialog;
    private BottomSheetDialog bottomSheetOrderStatus;
    private String targets = "";
    private String sessionId = "";
    private int accountId = 0;
    private int chatbotId = 0;
    private ImageView mImageViewCartItem, codSelected, prepaidSelected;
    private TextView add_address, total_wallet_amount, wallet_amount, payment_change, address_change, mTextViewItemTitle, mTextViewSizeValue, mTextViewColorValue, mSubTotalTextView, mTaxesTextView, mShippingTextView, mTotalPayableTextView, address_name, txtAddress, txtMobileNumber;
    private Button buttonPlaceCodOrder;
    private RecyclerView adressList;
    private RelativeLayout addAddressLay;
    private LinearLayout address_lay;
    private RelativeLayout prepaid_back_enable;
    private RelativeLayout cod_back_enable;
    private String customerId = "";
    private String guestId = "";
    private String chatBotName = "";
    private String chatBotIcon = "";
    private String chatBotDescription = "";
    private String chatbotInstanceId = "101481";
    private String notificationInstanceId = "";
    private final String FirebaseToken = "";
    private final String FirebaseInstaneID = "";

    private String orderDetailClassQualifiedName = "com.craftsvilla.app.features.account.myaccount.activities.OrderDetailActivity";
    private String productDetailsFullQualifiedname = "com.craftsvilla.app.features.discovery.productDetail.ui.ProductDetailActivity";
    private String walletPageFullQualifiedName = "com.craftsvilla.app.features.discovery.home.HomeActivity";
    private String optScreenFullQualifiedName = "com.craftsvilla.app.features.oba.ui.otp.OtpActivity";
    private String orderDetailsScreen = "com.craftsvilla.app.features.account.myaccount.activities.OrderDetailActivity";
    private ArrayList<AddressListData> aldList;
    private RelativeLayout wallet_layout;
    private CheckBox walletUsed;
    private Boolean iswalletUsed = true;
    private LinearLayoutManager layoutHorManager;
    private SizeSelectionAdapter ssAdapter;
    private BottomSheetDialog bottomSheetSizeDialog;
    private TextView cancle_titel;


    @Override
    protected void setUpViews() {
        initView();
    }

    private void setUpChatBot() {
        loadingBack.setVisibility(View.GONE);
        notFoundBack.setVisibility(View.GONE);
        nested_scroll.setVisibility(View.VISIBLE);

        zoom_in = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoom_out = AnimationUtils.loadAnimation(this, R.anim.zoom_out);

        spd = new SimilarProductData();
        chatbotRequest = new ChatBotRequest();
        chatbotRequest.setCustomerId(customerId);
        chatbotRequest.setLanguage(language);
        chatbotRequest.setBotSessionId(sessionId);
        chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
        satements = new ArrayList<>();
        conveersationlayoutManager = new LinearLayoutManager(this);
        conveersationlayoutManager.setOrientation(RecyclerView.VERTICAL);
        chatList.setLayoutManager(conveersationlayoutManager);
        cahtAdapter = new ConversationAdapter(satements, this);
        chatList.setAdapter(cahtAdapter);


        getPresenter().getChatData(this, chatbotRequest);

        mImageViewBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        addRemoveConversation(null, null, "showLoadingNow", "", "showLoadingNow", -1, "remote");

        upDown_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float angle = upDown.getRotation();
                angle = angle + 180;
                upDown.setRotation(angle);

                if (lay_proceed.getVisibility() == View.VISIBLE) {
                    if (language.equalsIgnoreCase("hindi")) {
                        up_down_text.setText(" विकल्प दिखाने के लिए यहां स्पर्श करें ");
                    } else {
                        up_down_text.setText(" Touch here to show options ");
                    }

                    lay_proceed.setVisibility(View.GONE);
                    lay_proceed.startAnimation(zoom_out);
                    conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

                } else {
                    if (language.equalsIgnoreCase("hindi")) {
                        up_down_text.setText(" विकल्प कम से कम करने के लिए यहां स्पर्श करें ");
                    } else {
                        up_down_text.setText(" Touch here to minimize options ");
                    }

                    lay_proceed.setVisibility(View.VISIBLE);
                    lay_proceed.startAnimation(zoom_in);
                    conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

                }

            }
        });

        lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLang();
            }
        });

        apply.setBackgroundColor(ContextCompat.getColor(ChatbotActivity.this, R.color.grey_l));
        apply.setEnabled(true);
        enter_text.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() > 0) {
                    apply.setBackgroundColor(ContextCompat.getColor(ChatbotActivity.this, R.color.grey_p));
                    apply.setEnabled(true);
                } else {
                    apply.setBackgroundColor(ContextCompat.getColor(ChatbotActivity.this, R.color.grey_l));
                    apply.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        optionChips.setVisibility(View.GONE);
        optionProducts.setVisibility(View.GONE);
        walletView.setVisibility(View.GONE);
        text_back.setVisibility(View.GONE);
        upDown_lay.setVisibility(View.GONE);
        tracking_view.setVisibility(View.GONE);
        cancel_reason_lay.setVisibility(View.GONE);

        updateAnalyticsOnChatSessionOpen();
    }

    private void initView() {
        chatList = findViewById(R.id.chatList);
        chipList = findViewById(R.id.chipList);
        notFoundText = findViewById(R.id.notFoundText);
        productList = findViewById(R.id.productList);
        walletTransactionlist = findViewById(R.id.walletTransactionlist);
        optionChips = findViewById(R.id.optionChips);
        optionProducts = findViewById(R.id.optionProducts);
        walletView = findViewById(R.id.walletView);
        tracking_view = findViewById(R.id.tracking_view);
        total_wallet_balance = findViewById(R.id.total_wallet_balance);
        craftsvilla_coin = findViewById(R.id.craftsvilla_coin);
        craftsvilla_money = findViewById(R.id.craftsvilla_money);
        ok = findViewById(R.id.ok);
        mImageViewBackButton = findViewById(R.id.mImageViewBackButton);
        upDown = findViewById(R.id.upDown);
        lang = findViewById(R.id.lang);
        language_text = findViewById(R.id.language_text);
        upDown_lay = findViewById(R.id.upDown_lay);
        up_down_text = findViewById(R.id.up_down_text);
        lay_proceed = findViewById(R.id.lay_proceed);
        text_back = findViewById(R.id.text_back);
        enter_text = findViewById(R.id.enter_text);
        scroll = findViewById(R.id.scroll);
        apply = findViewById(R.id.apply);
        cancel_reason_list = findViewById(R.id.cancel_reason_list);
        cancle_titel = findViewById(R.id.cancle_titel);
        cancel_reason_lay = findViewById(R.id.cancel_reason_lay);
        loadingBack = findViewById(R.id.loadingBack);
        notFoundBack = findViewById(R.id.notFoundBack);
        nested_scroll = findViewById(R.id.nested_scroll);
        loadingBack.setVisibility(View.VISIBLE);
        nested_scroll.setVisibility(View.GONE);
        notFoundBack.setVisibility(View.GONE);
        orderDetailClassQualifiedName = BuildConfig.OrderDetailsActivityQualifiedName;
        productDetailsFullQualifiedname = BuildConfig.ProductDetailsActivityQualifiedName;
        walletPageFullQualifiedName = BuildConfig.WalletActivityQualifiedName;
        optScreenFullQualifiedName = BuildConfig.LoginActivityQualifiedName;
        orderDetailsScreen = BuildConfig.OrderDetailsActivityQualifiedName;


        if (!TextUtils.isEmpty(getIntent().getStringExtra("notification_instance_id"))) {
            PreferenceManager.getInstance(this).setNotificationInstanceId(getIntent().getStringExtra("notification_instance_id"));
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("chatbot_instance_id"))) {
            PreferenceManager.getInstance(this).setChatbotInstanceId(getIntent().getStringExtra("chatbot_instance_id"));
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("chatbot_name"))) {
            PreferenceManager.getInstance(this).setChatBotName(getIntent().getStringExtra("chatbot_name"));
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("chatbot_icon"))) {
            PreferenceManager.getInstance(this).setChatBotIcon(getIntent().getStringExtra("chatbot_icon"));
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("auth_token"))) {
            PreferenceManager.getInstance(this).setAuthToken(getIntent().getStringExtra("auth_token"));
        } else {
            PreferenceManager.getInstance(this).setAuthToken("");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("customer_id"))) {
            PreferenceManager.getInstance(this).setCustomerId(getIntent().getStringExtra("customer_id"));
        } else {
            PreferenceManager.getInstance(this).setCustomerId("");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("plotch_secret_key"))) {
            PreferenceManager.getInstance(this).setPlotchSecretKey(getIntent().getStringExtra("plotch_secret_key"));
        } else {
            PreferenceManager.getInstance(this).setPlotchSecretKey("");
        }
        if (!TextUtils.isEmpty(getIntent().getStringExtra("default_primary_color"))) {
            PreferenceManager.getInstance(this).setDefaultButtonColor(getIntent().getStringExtra("default_primary_color"));
        } else {
            PreferenceManager.getInstance(this).setDefaultButtonColor(null);
        }


        startTime = getCurrentLocalDateTimeStamp();
        accountId = PreferenceManager.getInstance(this).getAccountId();
        chatbotId = PreferenceManager.getInstance(this).getChatbotId();
        customerId = PreferenceManager.getInstance(this).getCustomerId();
        guestId = PreferenceManager.getInstance(this).getCustomerId();
        chatBotName = PreferenceManager.getInstance(this).getChatBotName();
        chatBotIcon = PreferenceManager.getInstance(this).getChatBotIcon();
        chatBotDescription = PreferenceManager.getInstance(this).getChatBotDescription();
        chatbotInstanceId = PreferenceManager.getInstance(this).getChatbotInstanceId();
        notificationInstanceId = PreferenceManager.getInstance(this).getNotificationInstanceId();

        if (BuildConfig.DEBUG)
            Log.d("fcm", "onSuccess: chatbotInstanceId " + chatbotInstanceId +
                    "\n---------notificationInstanceId " + notificationInstanceId +
                    "\n---------chatBotDescription " + chatBotDescription +
                    "\n---------chatBotName " + chatBotName
            );

        setUpChatBot();
    }

    @Override
    protected ChatbotPresenter createPresenter() {
        return new ChatbotPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.chat_layout_sdk;

    }


    @Override
    public void showMessage(String message) {
        ToastUtils.showToast(this, message);
    }

    @Override
    public void showMessage(int resId) {
        ToastUtils.showToast(this, resId);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

        }
    }

    @Override
    public void showLoadingIndicator(String loadingMsg) {
        addRemoveConversation(null, null, "showLoadingNow", "", "showLoadingNow", -1, "remote");
        lay_proceed.setAlpha(0.5f);

        float angle = upDown.getRotation();
        angle = angle + 180;
        upDown.setRotation(angle);

        if (lay_proceed.getVisibility() == View.VISIBLE) {
            up_down_text.setText("  Please wait  ");
            upDown_lay.setVisibility(View.GONE);
            lay_proceed.setVisibility(View.GONE);
            lay_proceed.startAnimation(zoom_out);
            conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

        }

    }

    @Override
    public boolean isNetworkAvailable() {
        return false;
    }

    @Override
    public boolean isNetworkAvailable(boolean showMsg) {
        return false;
    }

    @Override
    public void hideLoadingIndicator() {
    }

    @Override
    public void showLoadingIndicator() {
    }

    @Override
    public void showLoadingIndicator(int msgResId) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setChatBotResponse(ChatBotResponse data) {
        if (BuildConfig.DEBUG)
            Log.d("chat", "setChatBotResponse: caht response" + data);
        if (data == null) {
            addRemoveConversation(null, null, "", "", "", -2, "");
            addRemoveConversation(null, null, "कुछ तकनीकी समस्या है कृपया कुछ समय बाद पुनः प्रयास करें।", "", "Something is wrong with server please try again after sometime.", 0, "remote");
        } else {
            if (data.d == null) {
                addRemoveConversation(null, null, "", "", "", -2, "");
                addRemoveConversation(null, null, "कुछ तकनीकी समस्या है कृपया कुछ समय बाद पुनः प्रयास करें।।", "", "No response from bot server.", 0, "remote");
            } else {
                if (!TextUtils.isEmpty(data.d.getSessionId())) {
                    sessionId = data.d.getSessionId();
                }
                if (data.d.getStatements() == null) {
                    ToastUtils.showToast(this, "Server error please try again");
                } else {
                    addBulkConversations(data);
                }
            }
        }
//        }

    }

    @Override
    public void onBackPressed() {
        loggerExit();
    }

    @SuppressLint("NewApi")
    @Override
    public void getAddressFromPinCodeSuccess(PinCodeAddress pinCodeAddress) {
        if (isAlive()) {
            mEditTextCity.setFocusableInTouchMode(false);
            mEditTextState.setFocusableInTouchMode(false);
            mTextInputPinCode.setError("");
            mTextInputPinCode.setErrorEnabled(false);
            mTextInputCityStateLayout.setVisibility(View.VISIBLE);
            if (pinCodeAddress.city != null && pinCodeAddress.city.trim().length() != 0) {
                mEditTextCity.setText(pinCodeAddress.city);
                mEditTextState.setText(pinCodeAddress.state);
                mEditTextFullAddress.requestFocus();
                mTextInputCity.setError(null);
                mTextInputState.setError(null);
            } else {
                mEditTextCity.setText("");
                mEditTextCity.requestFocus();
                mEditTextState.setText("");
                mTextInputPinCode.setError("Pincoode not serviceable/deliverablele");
                mTextInputPinCode.setErrorEnabled(true);

            }

        }


    }

    @SuppressLint("NewApi")
    @Override
    public void getAddressFromPinCodeFailure(String errorMessage) {
        if (isAlive()) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
            mTextInputCityStateLayout.setVisibility(View.GONE);
            mEditTextPinCode.setText("");
            mTextInputPinCode.setError(errorMessage);
            mTextInputPinCode.setEnabled(true);
        }
    }

    @Override
    public void setChatBot(FcmUpdateData response, boolean b, String s) {
        if (response != null)
            setUpChatBot();
        else {
            notFoundBack.setVisibility(View.VISIBLE);
            nested_scroll.setVisibility(View.GONE);
            loadingBack.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(s))
                notFoundText.setText(s);
        }
    }


    private void showLang() {
        final Dialog dialog = new Dialog(ChatbotActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.lang_alert_sdk);

        TextView hindi = dialog.findViewById(R.id.hindi);
        TextView english = dialog.findViewById(R.id.english);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language = "english";
                language_text.setText("English");
                cahtAdapter.setLanguage(language);
                if (optionData != null)
                    if (optionData.size() > 0)
                        rcAdapter.updateData(optionData, language);
                up_down_text.setText(" Choose options from below  ");
                nested_scroll.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nested_scroll.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100);
                dialog.dismiss();
            }
        });
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language = "hindi";
                language_text.setText("हिन्दी");
                cahtAdapter.setLanguage(language);
                if (optionData != null)
                    if (optionData.size() > 0)
                        rcAdapter.updateData(optionData, language);

                up_down_text.setText("  नीचे से विकल्प चुनें  ");
                nested_scroll.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nested_scroll.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                }, 100);
                dialog.dismiss();

            }
        });
        dialog.setCancelable(true);
        dialog.show();


    }

    private void setProductData(ArrayList<SimilarProductData> productsList) {
        if (optionProducts.getVisibility() == View.GONE) {
            optionProducts.setVisibility(View.VISIBLE);
            optionProducts.startAnimation(zoom_in);
        }
        layoutChipManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productList.setLayoutManager(layoutChipManager);
        ShowProductsAdapter spAdapter = new ShowProductsAdapter(new RecyclerViewProductClickListener() {
            @Override
            public void onClick(View view, int position, SimilarProductData oic, String type) {
                spd = oic;

                String msgE = "";
                String msgH = "";

                msgH = "आपने अभी देखा है \n" + spd.getName() + "\nप्रोडक्ट " + spd.getEntityId() + "\nकीमत " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(spd.getDiscountedPrice()));
                msgE = "You have just viewed \n" + spd.getName() + "\nProduct id " + spd.getEntityId() + "\nPrice " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(spd.getDiscountedPrice()));
                addRemoveConversation(null, spd, msgH, spd.getImage(), msgE, tags, "self");

                if (type.equalsIgnoreCase("option")) {
                    goToPdP();
                } else if (type.equalsIgnoreCase("buy")) {
                    if (oic.getVariants().size() > 0) {
                        showSizeSelectionList(oic);
                    } else {
                        buyProductRequest(oic);
                    }
                }
                optionProducts.setVisibility(View.GONE);

            }
        });
        productList.setAdapter(spAdapter);
        spAdapter.updateData(productsList);
    }

    private void buyProductRequest(SimilarProductData oic) {
        tags = oic.getBuyProductOptionId();
        chatbotRequest = new ChatBotRequest();
        chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
        chatbotRequest.setTag(oic.getBuyProductOptionId());
        chatbotRequest.setProductId(oic.getEntityId());
        chatbotRequest.setShipmentId("");
        chatbotRequest.setLanguage(language);
        chatbotRequest.setBotSessionId(sessionId);
        chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
        chatbotRequest.setAccountId(accountId);

        showLoadingIndicator("Fetching help data....");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
            }
        }, 800);
    }

    private void goToPdP() {


        Intent productActivityIntent = null;
        try {
            productActivityIntent = new Intent(this, Class.forName(productDetailsFullQualifiedname));
            Bundle bundle = new Bundle();
            bundle.putString(Constants.BundleKeys.PRODUCT_ID, spd.getEntityId());
            productActivityIntent.putExtra(Constants.BundleKeys.BUNDLE, bundle);
            startActivity(productActivityIntent);
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "Failed to navigate to pdp activity", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }

    private void setWalletData(final WalletDataForChat data) {
        if (walletView.getVisibility() == View.GONE) {
            walletView.setVisibility(View.VISIBLE);
            walletView.startAnimation(zoom_in);
        }
        total_wallet_balance.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(data.getTotalWalletAmount())));
        craftsvilla_money.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(data.getMoneyAmount())));
        craftsvilla_coin.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(data.getCoinAmount())));

        WalletTransactionAdapter WTadapter = new WalletTransactionAdapter(data.getRecentTransactions(), "chat", new WalletTransactionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int collections) {

            }
        });
        walletLayoutmanager = new LinearLayoutManager(this);
        walletLayoutmanager.setOrientation(RecyclerView.VERTICAL);
        walletTransactionlist.setLayoutManager(walletLayoutmanager);
        walletTransactionlist.setAdapter(WTadapter);
        conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWalletString(data);
                if (walletView.getVisibility() == View.VISIBLE) {
                    walletView.setVisibility(View.GONE);
                    walletView.startAnimation(zoom_out);
                    conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());
                }

            }
        });

    }

    private void setWalletString(WalletDataForChat data) {
        String sE = "";
        String sH = "";
        sH = sH + "वॉलेट सारांश" +
                "\n" + "-----------------------" + "\n" +
                "कुल वॉलेट बैलेंस" + GeneralUtils.getAmountString(String.valueOf(data.getTotalWalletAmount())) + "\n" +
                "क्राफ्ट्सविला कॉइन बैलेंस" + GeneralUtils.getAmountString(String.valueOf(data.getCoinAmount())) + "\n" +
                "क्राफ्ट्सविला मनी बैलेंस" + GeneralUtils.getAmountString(String.valueOf(data.getMoneyAmount())) +
                "\n" + "-----------------------" + "\n"
                + "वॉलेट ट्रांज़ैक्शन सारांश" +
                "\n" + "-----------------------" + "\n";
        sE = sE + "Wallet Summery" +
                "\n" + "-----------------------" + "\n" +
                "Total wallet balance" + GeneralUtils.getAmountString(String.valueOf(data.getTotalWalletAmount())) + "\n" +
                "C_Coin balance" + GeneralUtils.getAmountString(String.valueOf(data.getCoinAmount())) + "\n" +
                "C_Money balance" + GeneralUtils.getAmountString(String.valueOf(data.getMoneyAmount())) +
                "\n" + "-----------------------" + "\n"
                + "Transaction Summery" +
                "\n" + "-----------------------" + "\n";


        String aE = "";
        String aH = "";
        for (int i = 0; i < data.getRecentTransactions().size(); i++) {

            String daeducted_addedE = "";
            String daeducted_addedH = "";
            if (data.getRecentTransactions().get(i).amount >= 0) {
                daeducted_addedH = " जोड़ा ";
                daeducted_addedE = " added ";
            } else {
                daeducted_addedH = " कटौती ";
                daeducted_addedE = " deducted ";
            }

            aE = aE + GeneralUtils.getAmountString(String.valueOf(data.getRecentTransactions().get(i).amount)) + daeducted_addedE + " on " + data.getRecentTransactions().get(i).getCreatedAt() + "\n";
            aH = aH + GeneralUtils.getAmountString(String.valueOf(data.getRecentTransactions().get(i).amount)) + daeducted_addedH + " पर " + data.getRecentTransactions().get(i).getCreatedAt() + "\n";
        }
        sE = sE + aE;
        sH = sH + aH;


        addRemoveConversation(null, null, sH, "", sE, 0, "remote");


    }

    private void setOrders(ArrayList<OrdersInChat> orders) {
        if (optionProducts.getVisibility() == View.GONE) {
            optionProducts.setVisibility(View.VISIBLE);
            optionProducts.startAnimation(zoom_in);
        }
        layoutChipManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productList.setLayoutManager(layoutChipManager);
        ShowOrdersAdapter spAdapter = new ShowOrdersAdapter(new RecyclerViewOrdersInChatClickListener() {
            @Override
            public void onClick(View view, int position, OrdersInChat oic) {
                Oic = oic;
                shipmentids = oic.getShipmentId();
                orderids = oic.getOrderId();
                String msgH = "";
                String msgE = "";

                msgH = "शिपमेंट " + oic.getShipmentId()
                        + "\nदिया गया " + oic.getCreatedAt()
                        + "\nवैल्यू " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(oic.getPrice()));
                msgE = "Shipment id " + oic.getShipmentId()
                        + "\ncreated on " + oic.getCreatedAt()
                        + "\namount paid " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(oic.getPrice()));


                addRemoveConversation(oic, null, msgH, oic.getImage(), msgE, tags, "self");
                chatbotRequest = new ChatBotRequest();
                chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
                chatbotRequest.setTag(tags);
                chatbotRequest.setShipmentId(shipmentids);
                chatbotRequest.setLanguage(language);
                chatbotRequest.setBotSessionId(sessionId);
                chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
                chatbotRequest.setAccountId(accountId);


                showLoadingIndicator("Fetching help data....");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
                    }
                }, 800);
            }
        });
        productList.setAdapter(spAdapter);
        spAdapter.updateData(orders);
    }

    private void setOptions(final ChatBotResponse data) {
        if (optionChips.getVisibility() == View.GONE) {
            optionChips.setVisibility(View.VISIBLE);
            optionChips.startAnimation(zoom_in);
        }
        FlexboxLayoutManager manager = new FlexboxLayoutManager(this);
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setJustifyContent(JustifyContent.FLEX_START);
        chipList.setLayoutManager(manager);
        rcAdapter = new ResponseChipsAdapter(new RecyclerViewChipClickListener() {
            @Override
            public void onClick(View view, int position, String target, int optionId) {
                if (target == null) {
                    target = "";
                    targets = "";
                } else {
                    targets = target;
                }

                updateAnalyticsOnChatOptionSelected(data.d.getOptions().get(position).getStatement_english(), optionId);

                tags = optionId;
                chatbotRequest = new ChatBotRequest();

                if (target.equalsIgnoreCase("order_page")) {
                    showOrderDetailActivity(orderids);
                } else if (targets.equalsIgnoreCase("view_product")) {
                    goToPdP();
                } else if (targets.equalsIgnoreCase("wallet_page")) {
                    showWalletActivity();
                } else if (targets.equalsIgnoreCase("login")) {
                    showLoginDoialog();
                } else if (targets.equalsIgnoreCase("search_product")) {
                    showSearchTextBox("search");
                } else if (targets.equalsIgnoreCase("other_query")) {
                    showSearchTextBox("other_query");
                }
//                else if (targets.equalsIgnoreCase("buy_product")) {
//                    goToPdP();
//                }
                else {
                    if (targets.equalsIgnoreCase("back")) {
                        shipmentids = "";
                        orderids = "";
                        addRemoveConversation(null, null, "पिछले विकल्प दिखाएं", "", "Show previous options", optionId, "self");
                    } else {
                        addRemoveConversation(null, null, data.d.getOptions().get(position).getStatement_hindi(), "", data.d.getOptions().get(position).getStatement_english(), optionId, "self");

                    }

                    if (targets.equalsIgnoreCase("exit")) {
                        shipmentids = "";
                        orderids = "";
                    }
                    if (target.equalsIgnoreCase("buy_product")) {
                        chatbotRequest.setProductId(spd.getEntityId());
                    } else {
                        chatbotRequest.setProductId(orderids);
                    }

                    chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
                    chatbotRequest.setTag(optionId);
                    chatbotRequest.setShipmentId(shipmentids);
                    chatbotRequest.setLanguage(language);
                    chatbotRequest.setBotSessionId(sessionId);
                    chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
                    chatbotRequest.setAccountId(accountId);


                    showLoadingIndicator("Fetching help data....");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
                        }
                    }, 800);

                }
            }

        });
        chipList.setAdapter(rcAdapter);
        rcAdapter.updateData(data.d.getOptions(), language);
        optionData = data.d.getOptions();


    }

    private void showSearchTextBox(final String extra) {
        if (text_back.getVisibility() == View.GONE) {
            text_back.setVisibility(View.VISIBLE);
            text_back.startAnimation(zoom_in);
        }

        if (extra.equalsIgnoreCase("search")) {
            enter_text.setHint("Search products");
        } else if (extra.equalsIgnoreCase("extra")) {
            enter_text.setHint("Enter your queries");
        } else {
            enter_text.setHint("Enter text here");
        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        showKeyboard(enter_text);
        enter_text.requestFocus();
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(enter_text.getText().toString())) {
                    text_back.setVisibility(View.GONE);
                    text_back.startAnimation(zoom_out);
                    hideSoftKeyboard(enter_text);
                    addRemoveConversation(null, null, enter_text.getText().toString(), "", enter_text.getText().toString(), tags, "self");
                    chatbotRequest = new ChatBotRequest();
                    chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
                    chatbotRequest.setTag(tags);
                    chatbotRequest.setBotSessionId(sessionId);
                    chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
                    chatbotRequest.setAccountId(accountId);

                    if (extra.equalsIgnoreCase("search")) {
                        chatbotRequest.setExtraText(enter_text.getText().toString());
                    } else if (extra.equalsIgnoreCase("other_query")) {
                        chatbotRequest.setExtraData(enter_text.getText().toString());
                    }
                    chatbotRequest.setLanguage(language);

                    showLoadingIndicator("Fetching help data....");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            enter_text.setText("");
                            getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
                        }
                    }, 800);

                } else {

                }
            }
        });


    }

    private void showWalletActivity() {
        Intent productActivityIntent = null;
        try {
            productActivityIntent = new Intent(this, Class.forName(walletPageFullQualifiedName));
            Bundle bundle = new Bundle();
            bundle.putString("to", "wallet_page");
            productActivityIntent.putExtra(Constants.BundleKeys.BUNDLE, bundle);
            productActivityIntent.putExtra("to", "wallet_page");
            startActivity(productActivityIntent);
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "Failed to navigate to wallet activity", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    private void showOrderDetailActivity(String orderids) {
        if (!TextUtils.isEmpty(orderids)) {
            String msgH = "";
            String msgE = "";

            msgH = "आपने अभी विवरण देखा है\nशिपमेंट आईडी " + orderids + " से संबंधित है ";
            msgE = "You have just viewed the details \nrelated to the  order id " + orderids;
            addRemoveConversation(null, null, msgH, "", msgE, tags, "self");

            Intent productActivityIntent = null;
            try {
                productActivityIntent = new Intent(this, Class.forName(orderDetailClassQualifiedName));
                Bundle bundle = new Bundle();
                bundle.putString("orderId", orderids);
                productActivityIntent.putExtra(Constants.BundleKeys.BUNDLE, bundle);
                productActivityIntent.putExtra("orderId", orderids);
                startActivity(productActivityIntent);
            } catch (ClassNotFoundException e) {
                Toast.makeText(this, "Failed to navigate to OrderDetailActivity", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        } else {
            String msgH = "";
            String msgE = "";
            msgH = "डेटा उपलब्ध नहीं होने के कारण ऑर्डर विवरण दिखाने में असमर्थ";
            msgE = "Unable to show order detail as data not available";
            addRemoveConversation(null, null, msgH, "", msgE, tags, "remote");
            ToastUtils.showToast(ChatbotActivity.this, "Order id unavailable");
        }
    }

    private void addBulkConversations(final ChatBotResponse data) {

        if (data.d.getStatements().size() > 0) {
            setStatementArrey(data);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    addRemoveConversation(null, null, "", "", "", -2, "");
                }
            }, 500);
        }

        int u = (data.d.getStatements().size()) - 1;

        if (targets.equalsIgnoreCase("exit")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loggerExit();
                }
            }, 2000 * (data.d.getStatements().size()));

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    lay_proceed.setAlpha(1f);
                    float angle = upDown.getRotation();
                    angle = angle + 180;
                    upDown_lay.setVisibility(View.VISIBLE);
                    upDown.setRotation(angle);
                    if (language.equalsIgnoreCase("hindi")) {
                        up_down_text.setText("  नीचे से विकल्प चुनें  ");
                    } else {
                        up_down_text.setText(" Choose options from below  ");
                    }

                    lay_proceed.setVisibility(View.VISIBLE);
                    lay_proceed.startAnimation(zoom_in);
                    conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

                    if (optionProducts.getVisibility() == View.VISIBLE) {
                        optionProducts.setVisibility(View.GONE);
                        optionProducts.startAnimation(zoom_out);
                    }
                    if (walletView.getVisibility() == View.VISIBLE) {
                        walletView.setVisibility(View.GONE);
                        walletView.startAnimation(zoom_out);
                    }
                    if (tracking_view.getVisibility() == View.VISIBLE) {
                        tracking_view.setVisibility(View.GONE);
                        tracking_view.startAnimation(zoom_out);
                    }
                    if (optionChips.getVisibility() == View.VISIBLE) {
                        optionChips.setVisibility(View.GONE);
                        optionChips.startAnimation(zoom_out);
                    }
                    if (text_back.getVisibility() == View.VISIBLE) {
                        text_back.setVisibility(View.GONE);
                        text_back.startAnimation(zoom_out);
                    }
                    if (cancel_reason_lay.getVisibility() == View.VISIBLE) {
                        cancel_reason_lay.setVisibility(View.GONE);
                        cancel_reason_lay.startAnimation(zoom_out);
                    }


                    if (data.d.getOptions() != null && data.d.getOptions().size() > 0) {
                        if (data.d.getOptions().size() > 0) {
                            setOptions(data);
                        }
                    }
                    if (data.d.getChat_data() != null) {
                        if (data.d.getChat_data().getOrders() != null) {
                            if (data.d.getChat_data().getOrders().size() > 0) {
                                setOrders(data.d.getChat_data().getOrders());
                            }
                        }
                        if (data.d.getChat_data().getWalletDetails() != null) {
                            setWalletData(data.d.getChat_data().getWalletDetails());
                        }
                        if (data.d.getChat_data().getProductsList() != null) {
                            if (data.d.getChat_data().getProductsList().size() > 0) {
                                setProductData(data.d.getChat_data().getProductsList());
                            }
                        }
                        if (data.d.getChat_data().getCartDetails() != null) {
                            setPurchaseData(data.d.getChat_data());

                        }
                        if (data.d.getChat_data().getOrderStatusdata() != null) {
                            showTrackingBottomDologue(data.d.getChat_data().getOrderStatusdata());

                        }
                        if (data.d.getChat_data().getCancellationReason() != null) {
                            showCancellationReasonList(data.d.getChat_data().getCancellationReason());

                        }
                        if (data.d.getChat_data().getCodOrderPlacedDetails() != null) {
                            showOrderSuccessDoialog(data.d.getChat_data().getCodOrderPlacedDetails());

                        }
                    }
                }
            }, 2000 * u);
        }

    }

    private void showCancellationReasonList(final ArrayList<CancelReason> cancellationReason) {
        if (cancel_reason_lay.getVisibility() == View.GONE) {
            cancel_reason_lay.setVisibility(View.VISIBLE);
            cancel_reason_lay.startAnimation(zoom_out);
        }
        cancle_titel.setText("Please choose cancellation reason");

        FlexboxLayoutManager manager = new FlexboxLayoutManager(this);
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setJustifyContent(JustifyContent.FLEX_START);
        cancel_reason_list.setLayoutManager(manager);

        CancellationReasonAdapter clra = new CancellationReasonAdapter(new RecyclerViewChipClickListener() {
            @Override
            public void onClick(View view, int position, String tag, int optionId) {

                addRemoveConversation(null, null, tag, "", tag, tags, "self");

                chatbotRequest = new ChatBotRequest();
                chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
                chatbotRequest.setTag(tags);
                chatbotRequest.setProductId(null);
                chatbotRequest.setShipmentId(shipmentids);
                chatbotRequest.setCancellationReasonId(optionId);
                chatbotRequest.setLanguage(language);
                chatbotRequest.setBotSessionId(sessionId);
                chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
                chatbotRequest.setAccountId(accountId);

                showLoadingIndicator("Fetching help data....");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
                    }
                }, 800);

            }
        });
        cancel_reason_list.setAdapter(clra);
        clra.updateData(cancellationReason, language);


    }

    private void showSizeSelectionList(SimilarProductData oic) {
        if (cancel_reason_lay.getVisibility() == View.GONE) {
            cancel_reason_lay.setVisibility(View.VISIBLE);
            cancel_reason_lay.startAnimation(zoom_out);
        }
        cancle_titel.setText("Please select the size");
        FlexboxLayoutManager manager = new FlexboxLayoutManager(this);
        manager.setFlexDirection(FlexDirection.ROW);
        manager.setJustifyContent(JustifyContent.FLEX_START);
        cancel_reason_list.setLayoutManager(manager);
        ssAdapter = new SizeSelectionAdapter(oic.getVariants(), new RecyclerViewSizeClickListener() {
            @Override
            public void onClick(View view, int position, Variants v) {
                String msgE = "";
                String msgH = "";

                msgE = "You have selected the size " + v.getSize();
                msgH = "आपने " + v.getSize() + " का चयन कर लिया है ";
                addRemoveConversation(null, null, msgH, "", msgE, tags, "self");

                oic.setEntityId(v.getProductId());
                buyProductRequest(oic);

                cancel_reason_lay.setVisibility(View.GONE);
            }
        });
        cancel_reason_list.setAdapter(ssAdapter);


    }

    private void setStatementArrey(final ChatBotResponse data) {
        for (int i = 0; i < data.d.getStatements().size(); i++) {

            final int finalI = i;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    addRemoveConversation(null, null, "", "", "", -2, "");
                    addRemoveConversation(null, null, data.d.getStatements().get(finalI).getMessageHindi(), data.d.getStatements().get(finalI).getImageUrl(), data.d.getStatements().get(finalI).getMessageEnglish(), 0, data.d.getStatements().get(finalI).getType());

                    if (finalI != (data.d.getStatements().size() - 1)) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                addRemoveConversation(null, null, "showLoadingNow", "", "showLoadingNow", -1, "remote");
                            }
                        }, 500);
                    }

                }
            }, 2000 * finalI);

        }
    }

    private void setPurchaseData(ChatData chat_data) {
        showPurchaseDoialog(chat_data);
    }

    private void addRemoveConversation(OrdersInChat oic, SimilarProductData sdf, String statementH, String imageUrl, String statementE, int tag, String type) {
        if (tag == (-1)) {  //loading
            Statements s = new Statements();
            s.setTag(tag);
            s.setType(type);
            s.setMessageHindi(statementH);
            s.setMessageEnglish(statementE);
            s.setTimestamp(System.currentTimeMillis());
            s.setImageUrl(imageUrl);
            s.setOic(oic);
            s.setSpd(sdf);
            loadingObject = s;
            satements.add(s);
            cahtAdapter.notifyDataSetChanged();
            cahtAdapter.setLanguage(language);
            conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

        } else if (tag == (-2)) { //remove
            int posi = 0;
            for (int j = 0; j < satements.size() - 1; j++) {
                if (satements.get(j) == loadingObject) {
                    posi = j;
                    break;
                }
            }
            satements.remove(loadingObject);
            cahtAdapter.notifyItemRemoved(posi);
            cahtAdapter.setLanguage(language);

        } else {
            Statements s = new Statements();
            s.setTag(tag);
            s.setType(type);
            s.setMessageHindi(statementH);
            s.setMessageEnglish(statementE);
            s.setTimestamp(System.currentTimeMillis());
            s.setImageUrl(imageUrl);
            s.setOic(oic);
            s.setSpd(sdf);
            if (tag != (-3)) //don't add
            {
                satements.add(s);
            }
            cahtAdapter.notifyDataSetChanged();
            cahtAdapter.setLanguage(language);
            conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());

        }
        nested_scroll.postDelayed(new Runnable() {
            @Override
            public void run() {
                nested_scroll.fullScroll(ScrollView.FOCUS_DOWN);
            }
        }, 100);
    }

    public void showKeyboard(EditText mEtSearch) {
        mEtSearch.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public void hideSoftKeyboard(EditText mEtSearch) {
        mEtSearch.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEtSearch.getWindowToken(), 0);


    }

    void showLoginDoialog() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.include_onboarding_v2_sdk, null);
        bottomSheetLoginDialog = new BottomSheetDialog(ChatbotActivity.this, R.style.DialogStyle);
        bottomSheetLoginDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback);
        bottomSheetLoginDialog.setCanceledOnTouchOutside(true);
        bottomSheetLoginDialog.setCancelable(true);
        bottomSheetLoginDialog.show();
        bottomSheetLoginDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                try {
                    bottomSheetLoginDialog.dismiss();
                } catch (Exception e) {
                    bottomSheetLoginDialog.dismiss();

                }

            }
        });
        EditText mmMobile = bottomSheetView.findViewById(R.id.mEdittextMobileuserOrGuestUser);
        mmMobile.requestFocus();
        ImageView companyBanner=bottomSheetLoginDialog.findViewById(R.id.companyBanner);
        Picasso.get().load(PreferenceManager.getInstance(ChatbotActivity.this).getPlotchDefaultBanner()).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(companyBanner);

        FloatingActionButton mButtonLogin = bottomSheetView.findViewById(R.id.mButtonStartInstantlyOnboarding);
        LinearLayout parent_layout=bottomSheetLoginDialog.findViewById(R.id.parent_layout);
        parent_layout.setBackgroundColor(Color.parseColor(PreferenceManager.getInstance(this).getChatBotDefaultPrimaryColor()));
        mButtonLogin.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(PreferenceManager.getInstance(this).getChatBotDefaultPrimaryColor())));

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mmMobile.getText().toString().trim().length() < 10) {
                    ToastUtils.showToast(ChatbotActivity.this, "Enter Valid Number");
                } else {

                    FirebaseAnalytics firebaseAnalytics = null;
                    if (Connectivity.isConnected(ChatbotActivity.this)) {
                        firebaseAnalytics = FirebaseAnalytics.getInstance(ChatbotActivity.this);
                        Bundle params = new Bundle();
                        params.putString("activityName", "ChatBotActivity");
                        params.putString("screenName", "ChatBotPage");
                        if (PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId() != null)
                            params.putString("userId", PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());

                        params.putString("userDevice", Build.MODEL);
                        params.putString("appVersion", String.valueOf(BuildConfig.VERSION_CODE));
                        params.putString("campaignName", "");
                        firebaseAnalytics.logEvent("APP_ANDROID_OTP_REQUEST", params);
                    }
                    try {
                        Intent intent = new Intent(ChatbotActivity.this, Class.forName(optScreenFullQualifiedName));
                        intent.putExtra("data", mmMobile.getText().toString().trim());
                        intent.putExtra(Constants.BundleKeys.FROM_WHICH_SCREEN, Constants.SwitchScreenFromLoginDialog.FROM_CHAT_SCREEN);
                        startActivity(intent);
                        bottomSheetLoginDialog.dismiss();
                        loggerExit();

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    void showOrderSuccessDoialog(CodOrderPlacedDetails codOrderPlacedDetails) {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.order_suc_card_sdk, null);
        bottomSheetOrderSuccessDialog = new BottomSheetDialog(ChatbotActivity.this, R.style.DialogStyle);
        bottomSheetOrderSuccessDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback);
        bottomSheetOrderSuccessDialog.setCanceledOnTouchOutside(true);
        bottomSheetOrderSuccessDialog.setCancelable(true);
        bottomSheetOrderSuccessDialog.show();
        bottomSheetOrderSuccessDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                try {
                    bottomSheetOrderSuccessDialog.dismiss();
                } catch (Exception e) {
                    bottomSheetOrderSuccessDialog.dismiss();
                }
            }
        });

        TextView order_thank_you = bottomSheetView.findViewById(R.id.order_thank_you);
        TextView order_placed_successfully = bottomSheetView.findViewById(R.id.order_placed_successfully);
        TextView order_number_confirmation = bottomSheetView.findViewById(R.id.order_number_confirmation);
        TextView expected_delivery_title = bottomSheetView.findViewById(R.id.expected_delivery_title);
        TextView expected_date = bottomSheetView.findViewById(R.id.expected_date);
        TextView payment_mode_title = bottomSheetView.findViewById(R.id.payment_mode_title);
        TextView payment_mode = bottomSheetView.findViewById(R.id.payment_mode);
        Button track_order = bottomSheetView.findViewById(R.id.track_order);
        TextView cancle_satement = bottomSheetView.findViewById(R.id.cancle_satement);
        TextView easy_return = bottomSheetView.findViewById(R.id.easy_return);
        LottieAnimationView order_status_image = bottomSheetView.findViewById(R.id.order_status_image);


        GradientDrawable gd = (GradientDrawable) track_order.getBackground().getCurrent();
        gd.setColor(Color.parseColor(PreferenceManager.getInstance(this).getDefaultButtonColor()));

        if (!TextUtils.isEmpty(codOrderPlacedDetails.getCustomerName())) {
            order_thank_you.setText("Thank you, " + codOrderPlacedDetails.getCustomerName());
        } else {
            order_thank_you.setText("Thank you for shopping with us \n" + "+91-" + codOrderPlacedDetails.getCustomerMobile());
        }

        if (!TextUtils.isEmpty(codOrderPlacedDetails.getOrderId()) && !TextUtils.isEmpty(codOrderPlacedDetails.getCustomerMobile())) {
            order_number_confirmation.setText("Order (No. " + codOrderPlacedDetails.getOrderId() + ") Confirmation is sent on\n" + "your email and +91-" + codOrderPlacedDetails.getCustomerMobile());
        } else {
            order_number_confirmation.setText("Order details has been sent to your mobile number and email id if provided");
        }

        if (!TextUtils.isEmpty(codOrderPlacedDetails.getOrderDeliveryExpectedDate())) {
            expected_date.setText(codOrderPlacedDetails.getOrderDeliveryExpectedDate());
        } else {
            expected_date.setText("Not Available");
        }

        if (!TextUtils.isEmpty(codOrderPlacedDetails.getPaymentMode())) {
            payment_mode.setText(codOrderPlacedDetails.getPaymentMode());
        } else {
            payment_mode.setText("Not Available");
        }

        String msgH = "";
        String msgE = "";


        track_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ChatbotActivity.this, Class.forName(orderDetailsScreen));
                    intent.putExtra("orderId", codOrderPlacedDetails.getOrderId());
                    intent.putExtra(Constants.BundleKeys.FROM_WHICH_SCREEN, Constants.SwitchScreenFromLoginDialog.FROM_CHAT_SCREEN);
                    startActivity(intent);
                    bottomSheetOrderSuccessDialog.dismiss();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void showTrackingBottomDologue(final ShipmentStatusData sst) {
        if (tracking_view.getVisibility() == View.GONE) {
            tracking_view.setVisibility(View.VISIBLE);
            tracking_view.startAnimation(zoom_in);
        }
        orderLay = findViewById(R.id.orderLay);
        tracker_requested = findViewById(R.id.tracker_requested);
        tracker_requested.setVisibility(View.INVISIBLE);
        tracker_approved = findViewById(R.id.tracker_approved);
        tracker_approved.setVisibility(View.INVISIBLE);
        tracker_shipped = findViewById(R.id.tracker_shipped);
        tracker_shipped.setVisibility(View.INVISIBLE);
        tracker_delivered = findViewById(R.id.tracker_delivered);
        tracker_delivered.setVisibility(View.INVISIBLE);
        tracker_returned = findViewById(R.id.tracker_returned);
        tracker_returned.setVisibility(View.INVISIBLE);
        return_layout = findViewById(R.id.return_layout);
        requested_text = findViewById(R.id.requested_text);
        track_lay = findViewById(R.id.track_lay);
        product_image = findViewById(R.id.product_image);
        shipment_summary = findViewById(R.id.shipment_summary);
        shipment_summary1 = findViewById(R.id.shipment_summary1);
        latest_update_summary = findViewById(R.id.latest_update_summary);
        order_id = findViewById(R.id.order_id);
        titel = findViewById(R.id.titel);
        product_name = findViewById(R.id.product_name);
        product_name_titel = findViewById(R.id.product_name_titel);
        expected_delivery_title = findViewById(R.id.expected_delivery_title);
        price_titel = findViewById(R.id.price_titel);
        price_amount = findViewById(R.id.price_amount);
        image_circle_requested = findViewById(R.id.image_circle_requested);
        image_circle_approved = findViewById(R.id.image_circle_approved);
        image_circle_shipped = findViewById(R.id.image_circle_shipped);
        image_circle_delivered = findViewById(R.id.image_circle_delivered);
        view_requested_right = findViewById(R.id.view_requested_right);
        view_approved_left = findViewById(R.id.view_approved_left);
        view_approved_right = findViewById(R.id.view_approved_right);
        view_shipped_left = findViewById(R.id.view_shipped_left);
        view_shipped_right = findViewById(R.id.view_shipped_right);
        view_delivered_left = findViewById(R.id.view_delivered_left);
        view_delivered_right = findViewById(R.id.view_delivered_right);
        cancle = findViewById(R.id.cancle_window);

        String orderStatusText = sst.shipmentStatus;

        String imageUrl = URLConstants.getImageUrl(this, sst.productImageURL, URLConstants.ImageType.SMALL);
        if (Build.VERSION.SDK_INT >= 21)
            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(product_image);
        else Picasso.get().load(imageUrl).into(product_image);
        if (BuildConfig.DEBUG)
            Log.d("orderstatus", "onBindViewHolder:111 " + URLConstants.getImageUrl(this, sst.productImageURL, URLConstants.ImageType.SMALL));
        product_name.setText(String.valueOf(sst.orderId));
        product_name_titel.setText("Order Id :");
        price_titel.setText(sst.amountTitel);
        price_amount.setText("₹" + sst.price);

        if (sst.amountTitel.equalsIgnoreCase("refund amount")) {
            price_amount.setTextColor(ContextCompat.getColor(this, R.color.red));
        } else {
            price_amount.setTextColor(ContextCompat.getColor(this, R.color.green));
        }

        expected_delivery_title.setText(sst.dateStatus);
        shipment_summary.setText("Shipment Id : " + sst.shipmentId);
        shipment_summary1.setText("Placed On : " + sst.placedOn);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tracking_view.getVisibility() == View.VISIBLE) {
                    tracking_view.setVisibility(View.GONE);
                    tracking_view.startAnimation(zoom_out);
                    conveersationlayoutManager.smoothScrollToPosition(chatList, null, satements.size());
                }
            }
        });

        if (sst.message != null) {
            latest_update_summary.setText(sst.message);
        } else {
            latest_update_summary.setVisibility(View.GONE);
        }

        orderLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(sst.orderId)) {
                    showOrderDetailActivity(sst.orderId);
                }
            }
        });

        if (orderStatusText.equalsIgnoreCase("cancelled")) {
            tracker_requested.setVisibility(View.VISIBLE);
            tracker_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.cancel_icon));
            return_layout.setVisibility(View.GONE);
            requested_text.setText("Cancelled");
            requested_text.setTextColor(ContextCompat.getColor(view_requested_right.getContext(), R.color.red));
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_red));
        } else if (orderStatusText.equalsIgnoreCase("approved")) {
            tracker_requested.setVisibility(View.VISIBLE);
            return_layout.setVisibility(View.GONE);
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_green));
        } else if (orderStatusText.equalsIgnoreCase("processing")) {
            tracker_approved.setVisibility(View.VISIBLE);
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_green));
            view_requested_right.setBackground(ContextCompat.getDrawable(view_requested_right.getContext(), R.color.green));
            view_approved_left.setBackground(ContextCompat.getDrawable(view_approved_left.getContext(), R.color.green));
            image_circle_approved.setImageDrawable(ContextCompat.getDrawable(image_circle_approved.getContext(), R.drawable.circle_green));
        } else if (orderStatusText.equalsIgnoreCase("shipped")) {
            tracker_shipped.setVisibility(View.VISIBLE);
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_green));
            view_requested_right.setBackground(ContextCompat.getDrawable(view_requested_right.getContext(), R.color.green));
            view_approved_left.setBackground(ContextCompat.getDrawable(view_approved_left.getContext(), R.color.green));
            image_circle_approved.setImageDrawable(ContextCompat.getDrawable(image_circle_approved.getContext(), R.drawable.circle_green));
            view_approved_right.setBackground(ContextCompat.getDrawable(view_approved_right.getContext(), R.color.green));
            view_shipped_left.setBackground(ContextCompat.getDrawable(view_shipped_left.getContext(), R.color.green));
            image_circle_shipped.setImageDrawable(ContextCompat.getDrawable(image_circle_shipped.getContext(), R.drawable.circle_green));
        } else if (orderStatusText.equalsIgnoreCase("delivered")) {
            tracker_delivered.setVisibility(View.VISIBLE);
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_green));
            view_requested_right.setBackground(ContextCompat.getDrawable(view_requested_right.getContext(), R.color.green));
            view_approved_left.setBackground(ContextCompat.getDrawable(view_approved_left.getContext(), R.color.green));
            image_circle_approved.setImageDrawable(ContextCompat.getDrawable(image_circle_approved.getContext(), R.drawable.circle_green));
            view_approved_right.setBackground(ContextCompat.getDrawable(view_approved_right.getContext(), R.color.green));
            view_shipped_left.setBackground(ContextCompat.getDrawable(view_shipped_left.getContext(), R.color.green));
            image_circle_shipped.setImageDrawable(ContextCompat.getDrawable(image_circle_shipped.getContext(), R.drawable.circle_green));
            view_shipped_right.setBackground(ContextCompat.getDrawable(view_shipped_right.getContext(), R.color.green));
            view_delivered_left.setBackground(ContextCompat.getDrawable(view_delivered_left.getContext(), R.color.green));
            image_circle_delivered.setImageDrawable(ContextCompat.getDrawable(image_circle_delivered.getContext(), R.drawable.circle_green));
        } else if (orderStatusText.equalsIgnoreCase("returned")) {
            tracker_returned.setVisibility(View.VISIBLE);
            view_delivered_right.setVisibility(View.VISIBLE);
            return_layout.setVisibility(View.VISIBLE);
            track_lay.setWeightSum(5);
            image_circle_requested.setImageDrawable(ContextCompat.getDrawable(image_circle_requested.getContext(), R.drawable.circle_green));
            view_requested_right.setBackground(ContextCompat.getDrawable(view_requested_right.getContext(), R.color.green));
            view_approved_left.setBackground(ContextCompat.getDrawable(view_approved_left.getContext(), R.color.green));
            image_circle_approved.setImageDrawable(ContextCompat.getDrawable(image_circle_approved.getContext(), R.drawable.circle_green));
            view_approved_right.setBackground(ContextCompat.getDrawable(view_approved_right.getContext(), R.color.green));
            view_shipped_left.setBackground(ContextCompat.getDrawable(view_shipped_left.getContext(), R.color.green));
            image_circle_shipped.setImageDrawable(ContextCompat.getDrawable(image_circle_shipped.getContext(), R.drawable.circle_green));
            view_shipped_right.setBackground(ContextCompat.getDrawable(view_shipped_right.getContext(), R.color.green));
            view_delivered_left.setBackground(ContextCompat.getDrawable(view_delivered_left.getContext(), R.color.green));
            image_circle_delivered.setImageDrawable(ContextCompat.getDrawable(image_circle_delivered.getContext(), R.drawable.circle_green));
            view_delivered_right.setBackground(ContextCompat.getDrawable(view_delivered_left.getContext(), R.color.red));
        }

    }


    void showPurchaseDoialog(final ChatData chat_data) {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.include_purchase_v2_sdk, null);
        bottomSheetPurchaseDialog = new BottomSheetDialog(ChatbotActivity.this, R.style.DialogStyle);
        bottomSheetPurchaseDialog.setContentView(bottomSheetView);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallbackPurchase);
        bottomSheetPurchaseDialog.setCanceledOnTouchOutside(true);
        bottomSheetPurchaseDialog.setCancelable(true);
        bottomSheetPurchaseDialog.show();
        bottomSheetPurchaseDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                try {
                    bottomSheetPurchaseDialog.dismiss();
                } catch (Exception e) {
                    bottomSheetPurchaseDialog.dismiss();

                }

            }
        });

        mImageViewCartItem = bottomSheetView.findViewById(R.id.mImageViewCartItem);
        codSelected = bottomSheetView.findViewById(R.id.codSelected);
        prepaidSelected = bottomSheetView.findViewById(R.id.prepaidSelected);
        mTextViewItemTitle = bottomSheetView.findViewById(R.id.mTextViewItemTitle);
        mTextViewSizeValue = bottomSheetView.findViewById(R.id.mTextViewSizeValue);
        mTextViewColorValue = bottomSheetView.findViewById(R.id.mTextViewColorValue);
        mSubTotalTextView = bottomSheetView.findViewById(R.id.mSubTotalTextView);
        mTaxesTextView = bottomSheetView.findViewById(R.id.mTaxesTextView);
        mShippingTextView = bottomSheetView.findViewById(R.id.mShippingTextView);
        mTotalPayableTextView = bottomSheetView.findViewById(R.id.mTotalPayableTextView);
        address_name = bottomSheetView.findViewById(R.id.address_name);
        txtAddress = bottomSheetView.findViewById(R.id.txtAddress);
        txtMobileNumber = bottomSheetView.findViewById(R.id.txtMobileNumber);
        address_change = bottomSheetView.findViewById(R.id.address_change);
        payment_change = bottomSheetView.findViewById(R.id.payment_change);
        wallet_amount = bottomSheetView.findViewById(R.id.wallet_amount);
        total_wallet_amount = bottomSheetView.findViewById(R.id.total_wallet_amount);
        add_address = bottomSheetView.findViewById(R.id.add_address);
        buttonPlaceCodOrder = bottomSheetView.findViewById(R.id.mProceedToPayButton);
        adressList = bottomSheetView.findViewById(R.id.adressList);
        addAddressLay = bottomSheetView.findViewById(R.id.addAddressLay);
        mTextInputPinCode = bottomSheetView.findViewById(R.id.mTextInputPinCode);
        mTextInputCity = bottomSheetView.findViewById(R.id.mTextInputCity);
        mTextInputState = bottomSheetView.findViewById(R.id.mTextInputState);
        mTextInputFullAddress = bottomSheetView.findViewById(R.id.mTextInputFullAddress);
        mTextInputMobileNumber = bottomSheetView.findViewById(R.id.mTextInputMobileNumber);
        mTextInputCityStateLayout = bottomSheetView.findViewById(R.id.mTextInputCityStateLayout);
        mEditTextPinCode = bottomSheetView.findViewById(R.id.mEditTextPinCode);
        mEditTextCity = bottomSheetView.findViewById(R.id.mEditTextCity);
        mEditTextState = bottomSheetView.findViewById(R.id.mEditTextState);
        mEditTextFullAddress = bottomSheetView.findViewById(R.id.mEditTextFullAddress);
        mEditTextMobileNumber = bottomSheetView.findViewById(R.id.mEditTextMobileNumber);
        mButtonSaveAddressButton = bottomSheetView.findViewById(R.id.mButtonSaveAddressButton);
        mButtonCancelAddressButton = bottomSheetView.findViewById(R.id.mButtonCancelAddressButton);
        mEditTextFirstName = bottomSheetView.findViewById(R.id.mEditTextFirstName);
        mEditTextLastName = bottomSheetView.findViewById(R.id.mEditTextLastName);
        mTextInputFirstName = bottomSheetView.findViewById(R.id.mTextInputFirstName);
        mTextInputLastName = bottomSheetView.findViewById(R.id.mTextInputLastName);
        wallet_layout = bottomSheetView.findViewById(R.id.wallet_layout);
        walletUsed = bottomSheetView.findViewById(R.id.walletUsed);
        TextView wallet_amount_used = bottomSheetView.findViewById(R.id.wallet_amount_used);
        TextView mWalletTextView = bottomSheetView.findViewById(R.id.mWalletTextView);
        RelativeLayout walletContainer = bottomSheetView.findViewById(R.id.walletContainer);
        TextView out_of = bottomSheetView.findViewById(R.id.out_of);


        if (chat_data.getWalletInformation() != null) {
            wallet_layout.setVisibility(View.VISIBLE);
            mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())));
            buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())) + " While Delivery");
        } else {
            wallet_layout.setVisibility(View.GONE);
            mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())));
            buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())) + " While Delivery");

        }

        cod_back_enable = bottomSheetView.findViewById(R.id.cod_back_enable);
        prepaid_back_enable = bottomSheetView.findViewById(R.id.prepaid_back_enable);
        address_lay = bottomSheetView.findViewById(R.id.address_lay);

        String imageUrl = URLConstants.getImageUrl(this, chat_data.getCartDetails().getProducts().get(0).getImgUrl(), URLConstants.ImageType.SMALL);

        if (Build.VERSION.SDK_INT >= 21)
            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(mImageViewCartItem);
        else Picasso.get().load(imageUrl).into(mImageViewCartItem);

        codSelected.setVisibility(View.VISIBLE);
        prepaidSelected.setVisibility(View.INVISIBLE);
        address_lay.setVisibility(View.GONE);
        adressList.setVisibility(View.GONE);
        add_address.setVisibility(View.GONE);
        addAddressLay.setVisibility(View.GONE);

        aldList = new ArrayList<>();

        if (chat_data.getAddressList() != null) {
            if (chat_data.getAddressList().size() > 0) {
                aldList = chat_data.getAddressList();
                address_lay.setVisibility(View.VISIBLE);
                address_name.setText(aldList.get(0).getFirstName() + " " + aldList.get(0).getLastName());
                txtAddress.setText(aldList.get(0).getStreet() + ", " + aldList.get(0).getCity() + ", " + aldList.get(0).getRegion() + ", " + aldList.get(0).getPostcode());
                txtMobileNumber.setText(aldList.get(0).getCountryPhoneCode() + aldList.get(0).getTelephone());
                finalAddressList = aldList.get(0);

            } else {
                addAddressLay.setVisibility(View.VISIBLE);
            }
        }


//        payment_change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                payment_change.setVisibility(View.GONE);
//            }
//        });

        add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adressList.setVisibility(View.GONE);
                add_address.setVisibility(View.GONE);
                addAddressLay.setVisibility(View.VISIBLE);
                address_lay.setVisibility(View.GONE);


            }
        });

        cod_back_enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (payment_change.getVisibility() == View.GONE) {
                    codSelected.setVisibility(View.VISIBLE);
                    prepaidSelected.setVisibility(View.INVISIBLE);
                    paymentMode = "cod";
                    payment_change.setVisibility(View.VISIBLE);
                }
            }
        });
//        prepaid_back_enable.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (payment_change.getVisibility() == View.GONE) {
//                    codSelected.setVisibility(View.INVISIBLE);
//                    prepaidSelected.setVisibility(View.VISIBLE);
//                    paymentMode = "prepaid";
//                    payment_change.setVisibility(View.VISIBLE);
//
//                }
//            }
//        });
        mButtonCancelAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adressList.setVisibility(View.GONE);
                add_address.setVisibility(View.VISIBLE);
                addAddressLay.setVisibility(View.GONE);
                address_change.setVisibility(View.VISIBLE);
                if (aldList.size() > 0)
                    address_lay.setVisibility(View.VISIBLE);
                else
                    address_lay.setVisibility(View.GONE);

            }
        });
        layoutChipManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adressList.setLayoutManager(layoutChipManager);
        aica = new AddressInChatAdapter(aldList, new RecyclerViewChipClickListener() {
            @Override
            public void onClick(View view, int position, String target, int optionId) {
                address_name.setText(aldList.get(position).getFirstName() + " " + aldList.get(position).getLastName());
                txtAddress.setText(aldList.get(position).getStreet() + ", " + aldList.get(position).getCity() + ", " + aldList.get(position).getRegion() + ", " + aldList.get(position).getPostcode());
                txtMobileNumber.setText(aldList.get(position).getCountryPhoneCode() + aldList.get(position).getTelephone());
                adressPos = position;
                address_lay.setVisibility(View.VISIBLE);
                adressList.setVisibility(View.GONE);
                add_address.setVisibility(View.GONE);
                address_change.setVisibility(View.VISIBLE);

                finalAddressList = aldList.get(position);


            }
        });
        adressList.setAdapter(aica);


        address_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address_lay.setVisibility(View.GONE);
                adressList.setVisibility(View.VISIBLE);
                add_address.setVisibility(View.VISIBLE);
                address_change.setVisibility(View.GONE);
            }
        });

        mTextViewItemTitle.setText(chat_data.getCartDetails().getProducts().get(0).getProductName());

        if (chat_data.getCartDetails().getProducts().get(0).getVariant().getSize().size() > 0)
            mTextViewSizeValue.setText(chat_data.getCartDetails().getProducts().get(0).getVariant().getSize().get(0));
        else
            mTextViewSizeValue.setText("N/A");

        if (chat_data.getCartDetails().getProducts().get(0).getVariant().getColor() != null)
            mTextViewColorValue.setText(chat_data.getCartDetails().getProducts().get(0).getVariant().getColor().get(0));
        else
            mTextViewColorValue.setText("N/A");

        mSubTotalTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getSubTotal())));
        mTaxesTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTax())));
        mShippingTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getShippingCost())));

        if (aldList.size() > 0) {
            address_name.setText(aldList.get(0).getFirstName() + " " + aldList.get(0).getLastName());
            txtAddress.setText(aldList.get(0).getStreet() + ", " + aldList.get(0).getCity() + ", " + aldList.get(0).getRegion() + ", " + aldList.get(0).getPostcode());
            txtMobileNumber.setText(aldList.get(0).getCountryPhoneCode() + aldList.get(0).getTelephone());
        } else
            mTextViewColorValue.setText("N/A");


        mEditTextPinCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 6) {
                    getPresenter().getPinCodeData(ChatbotActivity.this, mEditTextPinCode.getText().toString());
                }
            }
        });

        GradientDrawable gd = (GradientDrawable) mButtonSaveAddressButton.getBackground().getCurrent();
        gd.setColor(Color.parseColor(PreferenceManager.getInstance(this).getDefaultButtonColor()));

        mButtonSaveAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (inputValid()) {
                        String city = mEditTextCity.getText().toString();
                        String pincode = mEditTextPinCode.getText().toString();
                        String fullAddress = mEditTextFullAddress.getText().toString();
                        String lastName = mEditTextLastName.getText().toString();
                        String firstName = mEditTextFirstName.getText().toString();
                        String state = mEditTextState.getText().toString();
                        String phonenumber = mEditTextMobileNumber.getText().toString().substring(mEditTextMobileNumber.getText().toString().length() - 10);


                        AddressListData al = new AddressListData();
                        al.setStreet(fullAddress);
                        al.setPostcode(pincode);
                        al.setCity(city);
                        al.setLastName(lastName);
                        al.setFirstName(firstName);
                        al.setRegion(state);
                        al.setAddressId("");
                        al.setTelephone(phonenumber);
                        al.setCountryPhoneCode("+91");


                        finalAddressList = al;
                        aldList.add(al);
                        aica.notifyDataSetChanged();

                        address_lay.setVisibility(View.GONE);
                        adressList.setVisibility(View.VISIBLE);
                        add_address.setVisibility(View.VISIBLE);
                        address_change.setVisibility(View.GONE);
                        addAddressLay.setVisibility(View.GONE);

                    }

                } catch (Exception e) {
                    Log.e("Exception", "onClick: Exception" + e);
                }

            }

            private boolean inputValid() {
                String pincode = mEditTextPinCode.getText().toString();
                if (!TextUtils.isEmpty(pincode)) {
                    mTextInputPinCode.setEnabled(true);
                    mTextInputPinCode.setError("");
                    String city = mEditTextCity.getText().toString();
                    if (!TextUtils.isEmpty(city)) {
                        mTextInputCity.setErrorEnabled(true);
                        mTextInputCity.setError("");
                        String state = mEditTextState.getText().toString();
                        if (!TextUtils.isEmpty(state)) {
                            mTextInputState.setEnabled(true);
                            mTextInputState.setError("");
                            String fullAddress = mEditTextFullAddress.getText().toString();
                            if (!TextUtils.isEmpty(fullAddress)) {
                                mTextInputFullAddress.setEnabled(true);
                                mTextInputFullAddress.setError("");
                                String firstName = mEditTextFirstName.getText().toString();
                                if (!TextUtils.isEmpty(firstName)) {
                                    mTextInputFirstName.setEnabled(true);
                                    mTextInputLastName.setError("");
                                    String lastName = mEditTextLastName.getText().toString();
                                    if (!TextUtils.isEmpty(lastName)) {
                                        mTextInputLastName.setEnabled(true);
                                        mTextInputLastName.setError("");
                                        if (mEditTextMobileNumber.getText().toString().length() == 10) {
                                            mTextInputMobileNumber.setEnabled(true);
                                            mTextInputMobileNumber.setError("");
                                            return true;
                                        } else {
                                            mTextInputMobileNumber.setError("Please enter your 10 digit mobile number");
                                            mTextInputMobileNumber.setErrorEnabled(true);
                                            return false;
                                        }
                                    } else {
                                        mTextInputLastName.setError("Please enter Last Name");
                                        mTextInputLastName.setErrorEnabled(true);
                                        return false;
                                    }
                                } else {
                                    mTextInputFirstName.setError("Please enter Fast Name");
                                    mTextInputFirstName.setErrorEnabled(true);
                                    return false;
                                }
                            } else {
                                mTextInputFullAddress.setError("Please enter Address");
                                mTextInputFullAddress.setErrorEnabled(true);
                                return false;
                            }
                        } else {
                            mTextInputState.setError("Please enter State");
                            mTextInputState.setErrorEnabled(true);
                            return false;
                        }
                    } else {
                        mTextInputCity.setError("Please enter city name");
                        mTextInputCity.setErrorEnabled(true);
                        return false;
                    }
                } else {
                    mTextInputPinCode.setError("Please enter area Pincode");
                    mTextInputPinCode.setErrorEnabled(true);
                    return false;
                }
            }
        });
        if (chat_data.getWalletInformation().getTotalUsableWalletAmount() > 0) {
            if (iswalletUsed) {
                wallet_amount_used.setText(" Wallet Amount Utilised ");
                out_of.setText(" Out Of  ");
                out_of.setVisibility(View.VISIBLE);
                wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalUsableWalletAmount())));
                total_wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalWalletAmount())));
                total_wallet_balance.setVisibility(View.VISIBLE);
                total_wallet_amount.setVisibility(View.VISIBLE);
                walletContainer.setVisibility(View.VISIBLE);
                mWalletTextView.setText((GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalUsableWalletAmount()))));
                mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())));
                buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())) + " While Delivery");

            } else {
                wallet_amount_used.setText(" Use Wallet Balance ");
                out_of.setVisibility(View.GONE);
                wallet_amount_used.setVisibility(View.VISIBLE);
                total_wallet_balance.setVisibility(View.GONE);
                total_wallet_amount.setVisibility(View.GONE);
                walletContainer.setVisibility(View.GONE);
                mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())));
                buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())) + " While Delivery");

            }
        } else {
            wallet_amount_used.setText(" Wallet Amount Utilised ");
            out_of.setText(" Out Of ");
            out_of.setVisibility(View.VISIBLE);
            wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign("0"));
            total_wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign("0"));
            total_wallet_balance.setVisibility(View.VISIBLE);
            total_wallet_amount.setVisibility(View.VISIBLE);
            walletContainer.setVisibility(View.VISIBLE);
            mWalletTextView.setText((GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalUsableWalletAmount()))));
            mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())));
            buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())) + " While Delivery");

        }
        walletUsed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    iswalletUsed = true;
                    wallet_amount_used.setText(" Wallet Amount Utilised  ");
                    out_of.setText(" Out Of  ");
                    out_of.setVisibility(View.VISIBLE);
                    wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalUsableWalletAmount())));
                    total_wallet_amount.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalWalletAmount())));
                    total_wallet_balance.setVisibility(View.VISIBLE);
                    total_wallet_amount.setVisibility(View.VISIBLE);
                    walletContainer.setVisibility(View.VISIBLE);
                    mWalletTextView.setText((GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getWalletInformation().getTotalUsableWalletAmount()))));
                    mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())));
                    buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPaybleAfterWalletDeduct())) + " While Delivery");

                } else {
                    iswalletUsed = false;
                    wallet_amount_used.setText(" Use Wallet Balance  ");
                    out_of.setVisibility(View.GONE);
                    wallet_amount_used.setVisibility(View.VISIBLE);
                    total_wallet_balance.setVisibility(View.GONE);
                    walletContainer.setVisibility(View.GONE);
                    total_wallet_amount.setVisibility(View.GONE);
                    mTotalPayableTextView.setText(GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())));
                    buttonPlaceCodOrder.setText("Pay " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(chat_data.getCartDetails().getOrderSummary().getTotalPayable())) + " While Delivery");

                }
            }
        });
        GradientDrawable gd1 = (GradientDrawable) buttonPlaceCodOrder.getBackground().getCurrent();
        gd1.setColor(Color.parseColor(PreferenceManager.getInstance(this).getDefaultButtonColor()));
        buttonPlaceCodOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                chatbotRequest = new ChatBotRequest();
                chatbotRequest.setCustomerId(PreferenceManager.getInstance(ChatbotActivity.this).getCustomerId());
                chatbotRequest.setTag(tags);
                chatbotRequest.setLanguage(language);
                chatbotRequest.setBotSessionId(sessionId);
                chatbotRequest.setChatbotInstanceId(chatbotInstanceId);
                chatbotRequest.setAccountId(accountId);


                PurchaseData purchaseData = new PurchaseData();
                purchaseData.setAddressList(finalAddressList);
                purchaseData.setCartDetails(chat_data.getCartDetails());
                if (iswalletUsed) {
                    purchaseData.setWalletInformation(chat_data.getWalletInformation());
                }
                purchaseData.setPaymentMode(paymentMode);
                chatbotRequest.setPurchaseData(purchaseData);

                bottomSheetPurchaseDialog.dismiss();
                showLoadingIndicator("Fetching help data....");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getPresenter().getChatData(ChatbotActivity.this, chatbotRequest);
                    }
                }, 800);

            }
        });
    }

    private void updateAnalyticsOnChatSessionOpen() {
        if (Connectivity.isConnected(ChatbotActivity.this)) {
            FirebaseAnalytics firebaseAnalytics = null;
            firebaseAnalytics = FirebaseAnalytics.getInstance(this);
            Bundle params = new Bundle();
            params.putString("activityName", "ChatBotActivity");
            params.putString("screenName", "Chat Screen");
            params.putString("chatOpen", startTime);
            if (!TextUtils.isEmpty(customerId))
                params.putString("userId", customerId);
            else if (!TextUtils.isEmpty(guestId))
                params.putString("guestId", guestId);

            params.putString("userDevice", Build.MODEL);
            params.putString("appVersion", String.valueOf(BuildConfig.VERSION_CODE));
            params.putString("campaignName", "");
            firebaseAnalytics.logEvent("APP_ANDROID_CHATBOT_OPEN", params);
        }
    }


    private void updateAnalyticsOnChatOptionSelected(String options, int optionIds) {
        try {
            if (Connectivity.isConnected(ChatbotActivity.this)) {

                FirebaseAnalytics firebaseAnalytics = null;
                firebaseAnalytics = FirebaseAnalytics.getInstance(this);
                Bundle params = new Bundle();
                params.putString("activityName", "ChatBotActivity");
                params.putString("screenName", "Option selection");
                params.putString("chatOptionText", options);
                params.putInt("chatOptionId", optionIds);
                if (!TextUtils.isEmpty(customerId))
                    params.putString("userId", customerId);
                else if (!TextUtils.isEmpty(guestId))
                    params.putString("guestId", guestId);

                params.putString("userDevice", Build.MODEL);
                params.putString("appVersion", String.valueOf(BuildConfig.VERSION_CODE));
                params.putString("campaignName", "");
                firebaseAnalytics.logEvent("APP_ANDROID_CHATBOT_OPTIONS_SELECT", params);
            }
        } catch (Exception e) {
        }
    }

    private void loggerExit() {
        String duartion = Utils.getDuration(startTime);
        if (Connectivity.isConnected(ChatbotActivity.this)) {

            FirebaseAnalytics firebaseAnalytics = null;
            firebaseAnalytics = FirebaseAnalytics.getInstance(this);
            Bundle params = new Bundle();
            params.putString("activityName", "ChatBotActivity");
            params.putString("screenName", "Chat Screen");
            if (!TextUtils.isEmpty(customerId))
                params.putString("userId", customerId);
            else if (!TextUtils.isEmpty(guestId))
                params.putString("guestId", guestId);
            params.putString("userDevice", Build.MODEL);
            params.putString("ChatOpen", startTime);
            params.putString("ChatClose", getCurrentLocalDateTimeStamp());
            params.putString("ChatDuration", duartion);
            params.putString("appVersion", String.valueOf(BuildConfig.VERSION_CODE));
            params.putString("campaignName", "");
            firebaseAnalytics.logEvent("APP_ANDROID_CHATBOT_CLOSE", params);
        }

        finish();
    }

    public String getCurrentLocalDateTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

}




