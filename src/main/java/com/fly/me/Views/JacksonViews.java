package com.fly.me.Views;

public class JacksonViews {

    public static class FlattenedTripOption {
        public static class PriceList {};
        public static class DetailedPriceList extends PriceList {};
    };

    public static class FlightTuple {
        public static class Basic {};
        public static class Detailed extends Basic {};
    };

}