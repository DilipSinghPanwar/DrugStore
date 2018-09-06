package com.bluemortar.interfaces;

/**
 * Created by ADMIN on 01-Sep-17.
 */

public interface UrlConfig {

    String DEVICE_TYPE = "android";
    String PER_PAGE = "10";
    int TIME_OUT_MIN = 1000 * 20;
    int TIME_OUT_MAX = 1000 * 40;

    String AUTH_KEY = "X-GRUBPOINTSAUTHKEY";
    String AUTH_VALUE = "123456";

    String CONTENT_TYPE_KEY = "Content-Type";
    String CONTENT_TYPE_VALUE = "application/json";

    String BASEURL = "http://demozero.grubpoints.com/webservice/";

    String USER_SIGNUP = BASEURL + "register";
    String VERIFY_OTP = BASEURL + "verify_OTP";
    String RESEND_OTP = BASEURL + "resent_OTP";
    String FORGET_PASSWORD = BASEURL + "forget_passwrod";
    String USER_SIGNIN = BASEURL + "login";
    String DEVICE_TOKEN = BASEURL + "devicetoken";

    String SOCIAL_LOGIN = BASEURL + "social_login";

    String RESET_PASSWORD = BASEURL + "resetpassword";
    String UPDATE_PASSWORD = BASEURL + "updatepassword";
    String UPDATE_PROFILE = BASEURL + "updateprofile";
    String VIEW_PROFILE = BASEURL + "view_profile";

    String RESTAURENT_SEARCH = BASEURL + "restaurant_search";
    String RESTAURENT_DETAILS = BASEURL + "restaurantdetail";
    String FOOD_DETAILS = BASEURL + "fooddetail";

    // restaurant favourite unfavourite
    String FAVOURITE_RESTAURENT = BASEURL + "make_favourite_restaurent";
    String UNFAVOURITE_RESTAURENT = BASEURL + "remove_favourite_restaurent";
    String FAVOURITE_RESTAURENT_LIST = BASEURL + "favourite_restaurent_list";


    // favourite food
    String FAVOURITE_FOOD = BASEURL + "make_favourite_food";
    String UNFAVOURITE_FOOD = BASEURL + "remove_favourite_food";

    String RESTAURENT_REVIEW = BASEURL + "restaurantreview";

    String SEARCH_RESTAURENT_FOOD = BASEURL + "food_search";
    String SEARCH_RESTAURENT_FOODMENU = BASEURL + "restaurant_food_search";

    //Cart
    String ADD_TO_CART = BASEURL + "addcart";
    String UPDATE_CART = BASEURL + "updatecart";
    String GET_CART = BASEURL + "getcart";
    String REMOVE_FOOD_CART = BASEURL + "deletefood";
    String REMOVE_FULL_CART = BASEURL + "removecart";

    String ADD_DELETE_RESTAURANT_CART = BASEURL + "add_removecart";
    String ORDER_HISTORY = BASEURL + "orderlisting";

    /*manage address*/
    String VERIFY_ADDRESS = BASEURL + "verify_delivery_address";
    String ADD_ADDRESS = BASEURL + "newdelivery_address";
    String UPDATE_ADDRESS = BASEURL + "update_delivery_address";
    String ADDRESS_LIST = BASEURL + "delivery_address_list";
    String DELETE_ADDRESS = BASEURL + "delete_delivery_address";

    /*notification*/
    String NOTIFICATION_ON_OFF = BASEURL + "notification_status";

    // About Us, Privacy, Term Condition, Contact
    String APP_CONTENT_LINK = "http://demozero.grubpoints.com/webservice/content_pages";

    /*paypal*/
    String SAVE_PAYPAL_RESPONSE = BASEURL + "save_paypal_responce";

    /*save order*/
    String SAVE_ORDER = BASEURL + "save_order";
    String UPDATE_ORDER_TYPE = BASEURL + "update_order_type";
    String RESTAURANT_OPEN = BASEURL + "restaurant_open";

    String VIEW_NOTIFICATION = BASEURL + "view_notification";
    String VIEW_ORDER = BASEURL + "view_order";

    String POST_REVIEW = BASEURL + "post_review";

    String UPDATE_CART_USER = BASEURL + "update_cart_user";


    /*Country info based on IP*/
    String GET_COUNTRY_INFO = "http://ip-api.com/json";
    String GET_LAT_LANG_USING_PIN = "http://maps.googleapis.com/maps/api/geocode/json?address=";

//    String GET_LAT_LANG_USING_PIN = "http://maps.googleapis.com/maps/api/geocode/json?address=452001,IN";
}
