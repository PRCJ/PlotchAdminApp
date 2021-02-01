/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.plotch.sdk.Constants;

import android.content.Context;
import android.content.SharedPreferences;

import com.plotch.sdk.network.URLConstants;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mahesh Nayak on 19-02-2016.
 */
public class PreferenceManager {

    private static final String FILE_NAME = "pref";
    private static PreferenceManager instance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private PreferenceManager(Context ctx) {
        initFields(ctx);
    }

    private static void initFields(Context ctx) {
        sharedPreferences = ctx.getApplicationContext().getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static PreferenceManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new PreferenceManager(ctx);
        }
        return instance;
    }

    public static void storePrefBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getPrefBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void setRationaleShown(String key) {
        editor.putBoolean(key, true).commit();
    }

    public static boolean isRationaleShown(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public String getCustomerId() {
        return sharedPreferences.getString(Keys.CUSTOMER_ID, Constants.EMPTY_TEXT);
    }

    public String getDefaultButtonColor() {
        return sharedPreferences.getString(Keys.DEFAULT_BUTTON_COLOR, "#971937");
    }

    public void setDefaultButtonColor(String token) {
        editor.putString(Keys.DEFAULT_BUTTON_COLOR, token).commit();
    }

    public void setCustomerId(String token) {
        editor.putString(Keys.CUSTOMER_ID, token).commit();
    }


    public String getPlotchSecretKey() {
        return sharedPreferences.getString(Keys.PLOTCH_SECRATE_KEY, Constants.EMPTY_TEXT);
    }

    public void setPlotchSecretKey(String plotch_secrate_key) {
        editor.putString(Keys.PLOTCH_SECRATE_KEY, plotch_secrate_key).commit();
    }

    public String getGuestId() {
        return sharedPreferences.getString(Keys.GUEST_SESSION_ID, Constants.EMPTY_TEXT);
    }

    public void setGuestId(String token) {
        editor.putString(Keys.GUEST_SESSION_ID, token).commit();
    }

    public String getGcmToken() {
        return sharedPreferences.getString(Keys.GCM_TOKEN, Constants.EMPTY_TEXT);
    }

    public void setGcmToken(String token) {
        editor.putString(Keys.GCM_TOKEN, token).commit();
    }

    public void insertInt(int pageId) {
        editor.putInt("perPageProduct", pageId).commit();
    }

    public int getInt() {
        return sharedPreferences.getInt("perPageProduct", 0);
    }

    public String getColorData() {
        return sharedPreferences.getString(Keys.COLOR_APP, Constants.EMPTY_TEXT);
    }

    public void setColorData(String value) {
        editor.putString(Keys.COLOR_APP, value).commit();
    }

    public int getMinPrice() {
        return sharedPreferences.getInt(Keys.MINPRICE, 0);
    }

    public void setMinPrice(int minprice) {
        editor.putInt(Keys.MINPRICE, minprice).commit();
    }

    public int getMaxPrice() {
        return sharedPreferences.getInt(Keys.MAXPRICE, 0);
    }

    public void setMaxPrice(int maxPrice) {
        editor.putInt(Keys.MAXPRICE, maxPrice).commit();
    }

    public void setFilterjson(JSONObject filterjson) {
        editor.putString(Keys.FILTERJSON, filterjson.toString()).commit();

    }

    public String getFilterJson() {
        return sharedPreferences.getString(Keys.FILTERJSON, "");
    }

    public String getRecentlyViewdProduct() {
        return sharedPreferences.getString(Keys.RECENTLY_VIEWED_PRODUCT, "");
    }

    public void setRecentlyViewdProduct(String recentlyViewedProduct) {
        editor.putString(Keys.RECENTLY_VIEWED_PRODUCT, recentlyViewedProduct).commit();
    }

    public String getSortJson() {
        return sharedPreferences.getString(Keys.SORTJSON, "");
    }

    public void setSortJson(JSONObject filterjson) {
        editor.putString(Keys.SORTJSON, filterjson.toString()).commit();

    }

    public int getCartProductSize() {
        return sharedPreferences.getInt(Keys.CART_PRODUCT_SIZE, -1);
    }

    public void setCartProductSize(int size) {

        editor.putInt(Keys.CART_PRODUCT_SIZE, size).commit();
    }

    public String getUrlHandlerJson() {

        return sharedPreferences.getString(Keys.HandlerJson, "");
    }

    public void setUrlHandlerJson(JSONObject jsonObject) {

        editor.putString(Keys.HandlerJson, jsonObject.toString()).commit();
    }

    public String getAdvertId() {
        return sharedPreferences.getString(Keys.GCM_TOKEN, "");
    }

    public void setAdvertId(String id) {
        editor.putString(Keys.ADVERTISINGID, id).commit();
    }

    public String getLoginUserWishList() {
        return sharedPreferences.getString(Keys.LoginUser, "");
    }

    public void setLoginUserWishList(ArrayList<Integer> mList) {
        editor.putString(Keys.LoginUser, mList.toString()).commit();
    }

    public void setGuestUserWishList(ArrayList<String> mList) {
        editor.putString(Keys.GuestUser, mList.toString()).commit();
    }

    public String getGuestUserList() {
        return sharedPreferences.getString(Keys.GuestUser, "");
    }

    public String getGuestWishListDetail() {
        return sharedPreferences.getString(Keys.GetUserDetails, "");
    }

    public void setGuestWishListDetail(String mList) {
        editor.putString(Keys.GetUserDetails, mList).commit();
    }

    public String getPincode() {
        return sharedPreferences.getString(Keys.PINCODE, Constants.DEFAULT_PINCODE);
    }

    public void setPincode(String pincode) {
        editor.putString(Keys.PINCODE, pincode).commit();
    }

    public boolean isHomePageViewedFirstTime() {
        return sharedPreferences.getBoolean(Keys.HOME_PAGE_VIEWED_FIRSTTIME, false);
    }

    public void setHomePageViewedFirstTime(boolean value) {
        editor.putBoolean(Keys.HOME_PAGE_VIEWED_FIRSTTIME, value).commit();
    }

    public boolean shouldShowNativeOrders() {
        return sharedPreferences.getBoolean(Keys.SHOULD_SHOW_NATIVE_ORDERS, false);
    }

    public void setShowNativeOrders(boolean value) {
        editor.putBoolean(Keys.SHOULD_SHOW_NATIVE_ORDERS, value).commit();
    }

    public String getFirstTimeUser() {
        return sharedPreferences.getString(Keys.LOGIN_FIRSTTIME, "");
    }

    public void setFirstTimeUser(String first) {
        editor.putString(Keys.LOGIN_FIRSTTIME, first).commit();
    }

    public String getTrackConfirmation() {
        return sharedPreferences.getString(Keys.TRACK_CONFIRM, "");
    }

    public void setTrackConfirmation(String yes) {
        editor.putString(Keys.TRACK_CONFIRM, yes).commit();
    }

    public int getAppliedMin() {
        return sharedPreferences.getInt(Keys.AppliedMin, 0);
    }

    public void setAppliedMin(int min) {
        editor.putInt(Keys.AppliedMin, min).commit();
    }

    public int getAppliedMax() {
        return sharedPreferences.getInt(Keys.AppliedMax, 0);
    }

    public void setAppliedMax(int max) {
        editor.putInt(Keys.AppliedMax, max).commit();
    }

    public int getSavedAppVersion() {
        return sharedPreferences.getInt(Keys.APP_VERSION, Integer.MIN_VALUE);
    }

    public void setSavedAppVersion(int value) {
        editor.putInt(Keys.APP_VERSION, value).commit();
    }

    public String getUserEmail() {
        return sharedPreferences.getString(Constants.LoginSourceType.SocialoLoginEmail, Constants.EMPTY_TEXT);
    }

    public void setUserEmail(String name) {
        editor.putString(Constants.LoginSourceType.SocialoLoginEmail, name).apply();
    }

    public String getBaseCheckoutUrl() {
        return sharedPreferences.getString(Keys.BASE_CHECKOUT_URL, null);
    }

    public void setBaseCheckoutUrl(String value) {
        editor.putString(Keys.BASE_CHECKOUT_URL, value).commit();
    }

    public String getBaseUrl() {
        return sharedPreferences.getString(Keys.BASE_URL, null);
    }

    public void setBaseUrl(String value) {
        editor.putString(Keys.BASE_URL, value).commit();
    }

    public void setSingleViewArrangeInCategory(boolean isSingleView) {
        setUserHasChangedViewType(true);
        editor.putBoolean(Keys.IS_SINGLE_VIEW_TYPE, isSingleView).apply();
    }

    public boolean getProductListArrangeType() {
        return sharedPreferences.getBoolean(Keys.IS_SINGLE_VIEW_TYPE, false);
    }

    public String getTrackOrderWidgetCustomerIdDetails() {
        return sharedPreferences.getString(Keys.TRACK_ORDER_WIDGET, Constants.EMPTY_TEXT);
    }

    public void setTrackOrderWidgetCustomerIdDetails(String customerId) {
        editor.putString(Keys.TRACK_ORDER_WIDGET, customerId).commit();
    }

    public String getTrackOrderWidgetDateDetails() {
        return sharedPreferences.getString(Keys.TRACK_ORDER_WIDGET_DATE, Constants.EMPTY_TEXT);
    }

    public void setTrackOrderWidgetDateDetails(String date) {
        editor.putString(Keys.TRACK_ORDER_WIDGET_DATE, date).commit();
    }

    public boolean isInstallTracked() {
        return sharedPreferences.getBoolean(Keys.APP_INSTALLS, false);
    }

    public void setFirstInstall(boolean token) {
        editor.putBoolean(Keys.APP_INSTALLS, token).commit();
    }

    public boolean hasPlacedOrder() {
        return sharedPreferences.getBoolean(Keys.ORDER_PLACED, false);
    }

    public void setHasPlacedOrder() {
        editor.putBoolean(Keys.ORDER_PLACED, true).commit();
    }

    public boolean isRatingPopUpShown() {
        return sharedPreferences.getBoolean(Keys.RATING_SHOWN, false);
    }

    public void setRatingPopupShown(boolean value) {
        editor.putBoolean(Keys.RATING_SHOWN, value).commit();
    }

    public int getLaunchCount() {
        return sharedPreferences.getInt(Keys.LAUNCH_COUNT, 0);
    }

    public void setLaunchCount(int value) {
        editor.putInt(Keys.LAUNCH_COUNT, value).commit();
    }

    public String getUtmData() {
        return sharedPreferences.getString(Keys.UTM_PARAMETERS, Constants.EMPTY_TEXT);
    }

    public void setUtmData(String data) {
        editor.putString(Keys.UTM_PARAMETERS, data);
        editor.commit();
    }

    public String getUserGender() {
        return sharedPreferences.getString(Keys.USER_GENDER, Constants.EMPTY_TEXT);
    }

    public void setUserGender(String data) {
        editor.putString(Keys.USER_GENDER, data);
        editor.commit();
    }

    public String getAutoSuggestionString() {
        return sharedPreferences.getString(Keys.SEARCH_AUTOSUGGESTION, Constants.EMPTY_TEXT);
    }

    public void setAutoSuggestionString(String data) {
        editor.putString(Keys.SEARCH_AUTOSUGGESTION, data);
        editor.commit();
    }

    public boolean getUserPhoneDetails() {
        return sharedPreferences.getBoolean(Keys.USER_PHONE_DETAILS, false);
    }

    public void setUserPhoneDetails(boolean isUserDetailsPresent) {
        editor.putBoolean(Keys.USER_PHONE_DETAILS, isUserDetailsPresent);
        editor.commit();
    }

    public boolean hasVerifiedContactDetails() {
        return sharedPreferences.getBoolean(Keys.IS_CONTACT_INFO_VERIFIED, false);
    }

    public void setVerifiedContactDetails(boolean isVerified) {
        editor.putBoolean(Keys.IS_CONTACT_INFO_VERIFIED, isVerified);
        editor.commit();
    }

    public String getFirstTimeLaunchedDate() {
        return sharedPreferences.getString(Keys.FIRST_LAUNCHED_DATE, Constants.EMPTY_TEXT);
    }

    public void setFirstTimeLaunchedDate(String firstLaunchDate) {
        editor.putString(Keys.FIRST_LAUNCHED_DATE, firstLaunchDate);
        editor.commit();
    }

    public void setShouldUseDeprecatedCodEndpoint(boolean value) {
        editor.putBoolean(Keys.USE_DEPRECATED_COD_ENDPOINT, value).commit();
    }

    public boolean useDeprecatedCodEndpoint() {
        return sharedPreferences.getBoolean(Keys.USE_DEPRECATED_COD_ENDPOINT, false);
    }

    public void setUserHasChangedViewType(boolean value) {
        editor.putBoolean(Keys.HAS_USER_CHANGED_VIEW_TYPE, value).commit();
    }

    public boolean hasUserChangedViewType() {
        return sharedPreferences.getBoolean(Keys.HAS_USER_CHANGED_VIEW_TYPE, false);
    }


    public String getUserContactNumber() {
        return sharedPreferences.getString(Keys.USER_CONTACT_NUMBER, null);
    }

    public void setUserContactNumber(String data) {
        editor.putString(Keys.USER_CONTACT_NUMBER, data);
        editor.commit();
    }

    public String getPdpPriceSubtext() {
        return sharedPreferences.getString(Keys.PDP_PRICE_SUBTEXT, null);
    }

    public void setPdpPriceSubtext(String data) {
        editor.putString(Keys.PDP_PRICE_SUBTEXT, data);
        editor.commit();
    }


    public String getCategoryListViewType() {
        return sharedPreferences.getString(Keys.CONFIG_PRODUCT_LIST_VIEW_TYPE, null);
    }

    public void setCategoryListViewType(String data) {
        editor.putString(Keys.CONFIG_PRODUCT_LIST_VIEW_TYPE, data);
        editor.commit();
    }

    public String getImageBaseUrl(URLConstants.ImageType type) {
        String key = Keys.IMG_BASE_URL_SMALL;
        switch (type) {
            case MEDIUM:
                key = Keys.IMG_BASE_URL_MEDIUM;
                break;
            case LARGE:
                key = Keys.IMG_BASE_URL_LARGE;
        }
        return sharedPreferences.getString(key, null);
    }

    public void setImageBaseUrl(URLConstants.ImageType type, String val) {
        switch (type) {
            case SMALL:
                editor.putString(Keys.IMG_BASE_URL_SMALL, val);
                break;
            case MEDIUM:
                editor.putString(Keys.IMG_BASE_URL_MEDIUM, val);
                break;
            case LARGE:
                editor.putString(Keys.IMG_BASE_URL_LARGE, val);
        }

    }


    public boolean isShareHighlighted() {
        return sharedPreferences.getBoolean(Keys.SHARE_HIGHLIGHTED, false);
    }

    public void setShareHighlighted(boolean val) {
        editor.putBoolean(Keys.SHARE_HIGHLIGHTED, val);
        editor.commit();
    }


    private long timeAgoInMili(long timestamp) {
        try {
            long past = timestamp;
            Date now = new Date();
            return now.getTime() - past;
        } catch (Exception j) {
            return 0;
        }
    }


    public String getbannerText() {
        return sharedPreferences.getString(Keys.PDP_BANNER_SUBTEXT, null);
    }

    public void setbannerText(String data) {
        editor.putString(Keys.PDP_BANNER_SUBTEXT, data);
        editor.commit();
    }

    public String getSessionID() {
        return sharedPreferences.getString(Keys.SESSION_ID, null);
    }

    public void setSessionID(String data) {
        editor.putString(Keys.SESSION_ID, data);
        editor.commit();
    }

    public String getChatbotInstanceId() {
        return sharedPreferences.getString(Keys.CHATBOT_INSTANCE_ID, null);
    }

    public void setChatbotInstanceId(String data) {
        editor.putString(Keys.CHATBOT_INSTANCE_ID, data);
        editor.commit();
    }

    public int getAccountId() {
        return sharedPreferences.getInt(Keys.ACCOUNT_ID, 0);

    }

    public void setAccountId(int accountId) {
        editor.putInt(Keys.ACCOUNT_ID, accountId);
        editor.commit();
    }


    public String notificationTitle() {
        return sharedPreferences.getString(Keys.NOTIFICATION_TITLE, "");
    }

    public void setNotificationTitle(String notificationTitle) {
        editor.putString(Keys.NOTIFICATION_TITLE, notificationTitle);
        editor.commit();
    }

    public String notificationDesc() {
        return sharedPreferences.getString(Keys.NOTIFICATION_DESC, "");
    }

    public void setNotificationDesc(String notificationTitle) {
        editor.putString(Keys.NOTIFICATION_DESC, notificationTitle);
        editor.commit();
    }

    public String notificationImg() {
        return sharedPreferences.getString(Keys.NOTIFICATION_IMG, "");
    }

    public void setNotificationImg(String notificationTitle) {
        editor.putString(Keys.NOTIFICATION_IMG, notificationTitle);
        editor.commit();
    }

    public String getAppIcon() {
        return sharedPreferences.getString(Keys.NOTIFICATION_IMG, "");
    }

    public void setAppIcon(String appicon) {
        editor.putString(Keys.APP_ICON, appicon);
        editor.commit();
    }

    public int getChatbotId() {
        return sharedPreferences.getInt(Keys.CHATBOT_ID, 0);

    }

    public void setChatbotId(int chatbotId) {
        editor.putInt(Keys.CHATBOT_ID, chatbotId);
        editor.commit();
    }

    public int getCodMaxCartValue() {
        return sharedPreferences.getInt(Keys.MAX_COD_VALUE, 10000);
    }

    public void setCodMaxCartValue(int codMaxCartValue) {
        editor.putInt(Keys.MAX_COD_VALUE, codMaxCartValue);
        editor.commit();
    }

    public String getChatBotName() {
        return sharedPreferences.getString(Keys.CHATBOT_NAME, "");

    }

    public void setChatBotName(String chatBotName) {
        editor.putString(Keys.CHATBOT_NAME, chatBotName);
        editor.commit();
    }

    public String getChatBotDescription() {
        return sharedPreferences.getString(Keys.CHATBOT_DESCRIPTION, "");

    }

    public void setChatBotDescription(String chatBotDescription) {
        editor.putString(Keys.CHATBOT_DESCRIPTION, chatBotDescription);
        editor.commit();
    }

    public String getNotificationInstanceId() {
        return sharedPreferences.getString(Keys.NOTIFICATION_INSTANCE_ID, "");

    }

    public void setNotificationInstanceId(String ID) {
        editor.putString(Keys.NOTIFICATION_INSTANCE_ID, ID);
        editor.commit();
    }

    public String getAuthToken() {
        return sharedPreferences.getString(Keys.AUTH_TOKEN, "");

    }

    public void setAuthToken(String ID) {
        editor.putString(Keys.AUTH_TOKEN, ID);
        editor.commit();
    }


    public String getChatBotIcon() {
        return sharedPreferences.getString(Keys.CHATBOT_ICON, "");

    }

    public void setChatBotIcon(String chatBotIcon) {
        editor.putString(Keys.CHATBOT_ICON, chatBotIcon);
        editor.commit();
    }

    public String getChatBotDefaultPrimaryColor() {
        return sharedPreferences.getString(Keys.CHATBOT_PRIMARY_COLOR, "");
    }

    public void setChatBotDefaultPrimaryColor(String chatbotDescription) {
        editor.putString(Keys.CHATBOT_PRIMARY_COLOR, chatbotDescription);
        editor.commit();
    }
    public String getPlotchDefaultBanner() {
        return sharedPreferences.getString(Keys.PlotchDefaultBanner, "http://plotch.ai/assets/img/logo/plotch_white.png");
    }
    public void setPlotchDefaultBanner(String banner) {
        editor.putString(Keys.PlotchDefaultBanner, banner);
        editor.commit();
    }

    public interface Keys {
        String TOKEN = "token";
        String CUSTOMER_ID = "customer_id";
        String GUEST_SESSION_ID = "guest_id";
        String CUSTOMER_PIN = "customer_pin";
        String CUSTOMER_CART_COUNT = "customer_cart_count";
        String IS_CONTACT_INFO_VERIFIED = "contact_info_verified";
        String ADDRESS_ID = "ADDRESSID";
        String STORE_ADDRESS_ID = "STOREADDRESSID";
        String LOGIN_TYPE = "type";
        String RECENT_SEARCH = "recent_search";
        String TREND_SEARCH = "trend_search";
        String LOGIN_Email = "email";
        String COLOR_APP = "color";
        String MINPRICE = "min";
        String MAXPRICE = "max";
        String FILTERJSON = "filter";
        String SORTJSON = "sort";
        String CART_PRODUCTS = "cart_products";
        String CART_PRODUCT_SIZE = "cart_product_size";
        String HandlerJson = "handler";
        String RECENTLY_VIEWED_PRODUCT = "recently_viewed";
        String LoginUser = "login";
        String GuestUser = "guest";
        String GetUserDetails = "guestdetails";
        String PINCODE = "pincode";
        String HOME_PAGE_VIEWED_FIRSTTIME = "homepage_viewed_firsttime";
        String LOGIN_FIRSTTIME = "login_firsttime";
        String GCM_TOKEN = "gcm";
        String ADVERTISINGID = "advertId";
        String TRACK_CONFIRM = "orderConfirm";
        String AppliedMin = "MIni";
        String AppliedMax = "Maxi";
        String BASE_URL = "base_url_v2";
        String COACHMARKS = "coachmark_data";
        String APP_VERSION = "app_version";
        String IS_SINGLE_VIEW_TYPE = "isSingleView";
        String APP_INSTALLS = "app_installs";
        String UTM_PARAMETERS = "utm_parameters";
        String TRACK_ORDER_WIDGET = "trackOrderWidget";
        String TRACK_ORDER_WIDGET_DATE = "trackOrderWidgetDate";
        String USER_GENDER = "gender";
        String SEARCH_AUTOSUGGESTION = "SearchAuto";
        String USER_PHONE_DETAILS = "phone";
        String USER_CONTACT_NUMBER = "contactNumber";
        String ORDER_PLACED = "order_placed";
        String RATING_SHOWN = "rating_popup_shown";
        String LAUNCH_COUNT = "launch_count";
        String INSTALL_DATE = "install_date";
        String BASE_CHECKOUT_URL = "checkout_url";
        String FIRST_LAUNCHED_DATE = "date";
        String IMG_BASE_URL_SMALL = "image_base_url_small";
        String IMG_BASE_URL_MEDIUM = "image_base_url_medium";
        String IMG_BASE_URL_LARGE = "image_base_url_large";
        String CART_DATA = "cart_data";
        String USE_DEPRECATED_COD_ENDPOINT = "use_deprecated_cod_endpoint";
        String PDP_PRICE_SUBTEXT = "pdp_price_subtext";
        String PDP_BANNER_SUBTEXT = "banner_subtext";
        String CONFIG_PRODUCT_LIST_VIEW_TYPE = "config_product_list_view_type";
        String HAS_USER_CHANGED_VIEW_TYPE = "has_user_changed_view_type";
        String INSTANCE_ID = "instance_id";
        String SHOULD_SHOW_NATIVE_ORDERS = "should_show_native_orders";
        String SHARE_HIGHLIGHTED = "ShareHighlighted";
        String CHATBOT_NAME = "chatbot_name";
        String CHATBOT_DESCRIPTION = "chatbot_description";
        String CHATBOT_ICON = "chatbot_icon";
        String MAX_COD_VALUE = "codMaxCartValue";
        String ACCOUNT_ID = "accountId";
        String CHATBOT_ID = "chatbotId";
        String NOTIFICATION_TITLE = "NOTIFICATION_TITLE";
        String NOTIFICATION_DESC = "NOTIFICATION_DESC";
        String NOTIFICATION_IMG = "NOTIFICATION_IMG";
        String APP_ICON = "APP_ICON";
        String SESSION_ID = "SESSION_ID";
        String CHATBOT_INSTANCE_ID = "CHATBOT_INSTANCE_ID";
        String NOTIFICATION_INSTANCE_ID = "NOTIFICATION_INSTANCE_ID";
        String AUTH_TOKEN = "AUTH_TOKEN";
        String CUSTOMER_TOKEN = "CUSTOMER_TOKEN";
        String PLOTCH_SECRATE_KEY = "PLOTCH_SECRATE_KEY";
        String DEFAULT_BUTTON_COLOR = "DEFAULT_BUTTON_COLOR";
        String CHATBOT_PRIMARY_COLOR = "CHATBOT_PRIMARY_COLOR";
        String PlotchDefaultBanner ="pref_banner" ;
    }


}

