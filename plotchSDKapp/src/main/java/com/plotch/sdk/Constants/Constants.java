package com.plotch.sdk.Constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String ACTIVITY = "Activity";
    public static final String FROM_WHICH_SCREEN = "FROM_WHICH_SCREEN";
    public static final String IS_NEW_ADDRESS = "IS_NEW_ADDRESS";
    public static final String SPACE = " ";
    public static final String EMPTY_TEXT = "";
    public static final String Checkout = "CheckedOut";
    public static final String customerId = "CutomerId";
    //Dynamic Url Handler public
    public static final String type = "Type";
    public static final String CATEGORY_ID = "CATEGORY_ID";
    public static final String PRODUCT_ID = "PRODUCT_ID";
    public static final String IsFromDeepLinkingAndNotification = "deepNotify";
    public final static String DEFAULT_PINCODE = "000000";
    public static final String COD = "cod";

    public static String CHATBOT_NAME = "chatbot_name";
    public static String CHATBOT_DESCRIPTION = "ChatbotDescription";
    public static String CHATBOT_IMAGE = "ChatbotImage";
    public static String CHATBOT_PRIMARY_COLOR = "DefaultPrimaryColor";

    public static List<String> STATUS_FOR_COMMISSION = Arrays.asList("Processing", "Handed To Courier", "Shipped To Customer",
            "Delivered", "Tracking Requested", "Request In Process",
            "Assumed Delivered");


    public enum RequestMode {
        CACHE,
        API
    }

    public interface Screen {
        int NO_AUTH = -1;
        int CART = 1;
        int NONE = 0;
    }



    public interface RequestBodyKeys {
        int NETWORK_WIFI = 1;
        int NETWORK_MOBILE = 0;
        String TAG_NETWORK_TYPE = "networkType";
        String TAG_NETWORK_SPEED = "networkSpeed";
        String CUSTOMER_ID = "customerId";
        String COUPON_CODE = "couponCode";
        String PRODUCT_ID = "productId";

    }

    public interface GetQueryKeys {
        String PRODUCT_ID = "?productId=";
        String PRODUCT_IDS = "?productIds=";
        String EMAIL_ID = "?emailId=";
        String CHECK_PINCODE_PINCODE = "?customerPincode=";
        String CHECK_PINCODE_VENDOR_PINCODE = "&vendorPincode=";
        String CHECK_PINCODE_VENDOR_COD = "&vendorCod=";
        String TERM = "?term=";
        String EMAILID_GUEST = "emailId";

        String HOME = "?";
        String RECENT_SEARCH = "?params=";
        String DEVICCE_ID = "?deviceId=";
        String CHAT_OPENED = "?chatOpened=";
        String CHAT_CLOSE = "?chatClose=";
        String PLATFORM = "&platform=";
        String APP_VERSION = "&appVersion=";
        String PARAMS = "?params=";
        String PINCODE = "&customerPincode=";
        String PAGE_URL = "pageUrl";
        String USER_ID = "userId";
        String CUSTOMER_ID = "&customerId=";
        String TYPE = "type=";
        String ID = "&id=";

        String CHAT_DURATION = "?chatDuarion=";
    }

    public interface AppConstants {
        String PLATFORM = "Android";
        String CONTENT_FORMAT = "application/json";
        String NO_CACHE = "no-cache";
    }

    public interface ErrorStatusCodes {
        int NO_RESPONSE = -1;
        int SUCCESS_ZERO = 0;
        int NO_INTERNET = 1;

    }

    public interface ErrorMessageCodes {
        String SHIPMENT_SHIPPED = "shipment_shipped";
        String ACTION_REDUNDANT = "action_redundant";
        String RETURN_ELAPSED = "return_time_elapsed";
        String BANK_INFO_NEEDED = "bank_info_required";
    }

    public interface BundleKeys {
        String CURRENT_SCREEN = "current_screen";
        String TABS = "tabs";
        String BANNER_IMAGE = "banner_image_url";
        String BANNER_ID = "baner_id";
        String TAB_ID = "tab_id";
        String CATEGORY_ID = "categoryId";
        String ACTION_TITLE = "action_title";
        String IS_SEARCH = "is_search";
        String SEARCH_QUERY = "query";
        String PRODUCT_ID = "product_id";
        String PRODUCT_NAME = "productName";
        String IS_SIMILAR_PRODUCT = "is_similar_product";
        String ORDER_STATUS = "order_status";
        String ADDRESS_ITEM = "address_item";
        String FILTER_ITEM_POSITION = "filter_item_position";
        String FILTER_TITLE = "filter_title";
        String SUB_CATEGORIES = "sub_categories";
        String VENDOR_ID = "vendor_id";
        String WEB_URL = "web_url";
        String FEED_ID = "feed_ID";
        String BANNER_TYPE = "banner_type";
        String BANNER_NAME = "bannner_name";
        String IS_CHECKOUT = "is_checkout";
        String DELIVERY_ADDRESS = "deliveryAddress";
        String TAG_ID = "tag_id";
        String CUSTOMER_ID = "customer_id";
        String ADDRESS_ID = "address_id";
        String FRAGMENT_NAME = "fragment_name";
        String PRODUCT_IMAGE_POSITION = "ïmage_pos";
        String IS_PAGER = "is_pager";
        String PRODUCT_DESCRIPTION = "description";
        String PRODUCT = "product";
        String GALLERY_LIST = "mGalleryList";
        String POSITION = "position";
        String FROM_WHICH_SCREEN = "from_whichscreen";
        String EMAIL_ID = "emailid";
        String IS_GUEST_USER = "isGuestUser";
        String PAGEID = "pageId";
        String PERPAGE = "perPage";
        String FEEDID = "feedId";
        String BUNDLE = "bundle";
        String HOME_SCREEN = "homeScreen";

        // home screen navigation ids
        int HOME_FRAGMENT = 1;
        int CATEGORIES_FRAGMENT = 2;
        int WISHLIST_FRAGMENT = 4;
        int PROFILE_FRAGMENT = 5;
        int DEALS_FRAGMENT = 3;
        int SCANNER_FRAGMENT = 6;

        String USER_TYPE = "userType";
        String PAGE_TYPE = "pageType";
        String IS_CATEGORY_ACTIVE = "is_category_active";
        String TOOLBARTITLE = "ToolBarTitle";
        String IS_FROM_SEARCH = "isFromSearch";
        String PARENT = "parent";

        int FILTER_FRAGMENT = 1;
        int SORT_FRAGMENT = 2;
        String STORE_ID = "storeId";
        String VENDOR_ID_BOGO = "vendorId";
        String STORE_NAME = "storeName";
        String STORE_LAT = "storeLat";
        String STORE_LON = "storeLon";
        String STORE_OBJECT = "storeObject";
        String PAGE_URL = "pageUrl";

    }


    public interface OrderStatus {
        String CURRENT = "CURRENT";
        String COMPLETED = "COMPLETED";
        String CANCELED = "CANCELLED";
        String ORDER_ID = "ORDER_ID";
    }

    public interface HomeContent {
        String SLIDER = "slider";
        String CATEGORY = "categoryBox";
        String PRODUCT_GRID = "productGrid";
        String VENDOR_GRID = "vendorShopGrid";
        String PAGE = "staticPage";
        String COLOR_GRID = "colorBox";
        String FEED_BOX = "feedBox";
    }

    public interface LoginSourceType {
        String FACEBOOK = "facebook";
        String GOOGLE = "google";
        String SocialoLoginEmail = "email";
    }

    public interface ActivityRequestCodes {
        int RC_SIGN_IN = 555;
        int LOGIN_NAVIGATION = 1000;
        int LOGIN_COMPULSORY = 1001;
        int FILTER = 1002;
        int OAUTH_MANAGER = 1003;
        int FROM_CART_PAGE = 1004;
        int FROM_CART_PAGE_LOGIN = 1005;
        int PRODUCT_DETAIL_ACTIVITY = 1006;
    }

    public interface SwitchScreenFromLoginDialog {
        int FROM_HOME_SCREEN = 1;
        int FROM_ONBOARDING_SCREEN = 2;
        int FROM_MYACCOUNT_SCREEN = 3;
        int FROM_CART_SCREEN = 4;
        int FROM_WISHLIST_SCREEN = 5;
        int FROM_CHECKOUT_SCREEN = 6;
        int FROM_OBA_SCREEN = 7;
        int FROM_WALLET_SCREEN = 8;
        int FROM_CHAT_SCREEN = 9;
    }

    public interface ForGcm {
        String SENT_TOKEN_TO_SERVER = "sentTokenToServer";
        String NOTIFICATION_ID = "NOTIFICATION_ID";
    }

    public interface UrlHandlerKey {
        String MID = "MID";
        String FILTER = "filter";
        String SORT = "sort";

    }

    public interface MyAccount {
        String MY_ACCOUNT = "MY_ACCOUNT";
        String MY_ORDER = "myOrder";
        String ADDRESS = "address";
        String BANK_DETAILS = "bankDetails";
        String ACCOUNT = "account";

    }

    public interface Gcm {
        String GCM_TITLE = "title";
        String GCM_DISPLAY = "disp";
        String GCM_ACTION = "action";
        String GCM_CONTENT = "content";

    }

    public interface Payment {
        String VISA = "VISA";
        String MASTERCARD = "MASTERCARD";
        String AMEX = "AMEX";
        String MAESTRO = "MAESTRO";
        String DINERS = "DINERS";
        String RUPAY = "RUPAY";
        String JCB = "JCB";
        int[] FORMAT_14_15 = {4, 10};
        int[] FORMAT_16 = {4, 8, 12};
        String DELIMITER = "-";
        String COD = "cod";
        String JUSPAY_ERROR_INVALID_CARD = "invalid_card_number";
        String JUSPAY_ERROR_INVALID_CVV = "invalid_card_cvv";
        String JUSPAY_ERROR_INVALID_YEAR = "invalid_expiry_year";
        String JUSPAY_ERROR_INVALID_MONTH = "invalid_expiry_month";
        String RETRY = "Retry";
        String CREDIT = "CREDIT";
    }

    public interface PaymentOptions {
        String COD = "cod";
        String NETBANKING = "net_banking";
        String WALLET = "wallet";
        String DEBIT_CARD = "debit_card";
        String CREDIT_CARD = "credit_card";
        String CARD = "card";
        String UPI = "upi";

    }

    public interface PaymentType {
        String COD = "cod";
        String CARD = "card";
        String NETBANKING = "netbanking";
        String WALLET = "wallet";
    }

    public interface PaymentDisplayName {
        String COD = "Cash On Delivery";
        String CARD = "card";
        String NETBANKING = "NetBanking";
        String WALLET = "Wallet";
    }

    public interface UserTypes {
        String OBA = "oba";
        String CRAFTSVILLA = "craftsvilla";
    }

    public interface AccountType {
        String MOBILE = "mobile";
        String EMAIL = "email";
    }

    public interface ProductMediaType {
        String VIDEO = "video";
        String IMAGE = "image";
    }

    public static final class HomeAdapterRowViewType {

        public static final int COROUSAL = 1;
        public static final int FIXED_SINGLE = 2;
        public static final int SLIDER = 3;
        public static final int TRACK = 4;
        //SLIDER ALWAYS
        public static final int RECENTLY_VIEWED = 5;
        public static final int PRODUCTS = 20;
        public static final int FIXED_GRID = 6;
        public static final int SLIDER_PRODUCT = 7;
        public static final int FIXED_GRID_SINGLE = 8;
        public static final int FIXED_SINGLE_BANNER = 9;
        public static final int SLIDER_PRODUCT_API = 10;
        public static final int FIRST_TIME_LOGIN_WELCOME = 11;
        public static final int FIXED_GRID_SCROLL_VERTICAL = 12;
        public static final int DEFAULT = 13;
        public static final int SECURITY_POLICY = 100;
        public static final int SPANNED_GRID = 14;
        public static final int CLUBBED_API = 15;
        public static final int VIDEO_FIXED = 16;
        public static final int MAP_FIXED = 17;
        public static final int BLOG_LIST = 18;
        public static final int LAST_ORDER_STATUS = 19;
        public static final int NEW_SLIDER = 21;
        public static final int PRODUCT_TARGET_BUTTON = 22;
    }
}
