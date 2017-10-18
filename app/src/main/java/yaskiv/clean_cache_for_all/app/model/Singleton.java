package yaskiv.clean_cache_for_all.app.model;

import java.util.ArrayList;
import java.util.List;

import yaskiv.clean_cache_for_all.app.adapter.AppsListAdapter;



public class Singleton {
    public static List<AppsListItem> getmItems() {
        return mItems;
    }

    public static void setmItems(List<AppsListItem> mItems) {
        Singleton.mItems = mItems;
    }
    public static AppsListAdapter mAppsListAdapter;
    public static List<AppsListItem> mItems = new ArrayList<>();

    public static CleanerService getmCleanerService() {
        return mCleanerService;
    }

    public static void setmCleanerService(CleanerService mCleanerService) {
        Singleton.mCleanerService = mCleanerService;
    }



    public static AppsListAdapter getmAppsListAdapter() {
        return mAppsListAdapter;
    }

    public static void setmAppsListAdapter(AppsListAdapter mAppsListAdapter) {
        Singleton.mAppsListAdapter = mAppsListAdapter;
    }


    public static long getmTotalMemory() {
        return mTotalMemory;
    }

    public static void setmTotalMemory(long mTotalMemory) {
        Singleton.mTotalMemory = mTotalMemory;
    }

    public static long getmLowMemory() {
        return mLowMemory;
    }

    public static void setmLowMemory(long mLowMemory) {
        Singleton.mLowMemory = mLowMemory;
    }

    public static long getmMedMemory() {
        return mMedMemory;
    }

    public static void setmMedMemory(long mMedMemory) {
        Singleton.mMedMemory = mMedMemory;
    }

    public static long getmHighMemory() {
        return mHighMemory;
    }

    public static void setmHighMemory(long mHighMemory) {
        Singleton.mHighMemory = mHighMemory;
    }

    public static CleanerService mCleanerService;
    public static long mTotalMemory, mLowMemory, mMedMemory, mHighMemory;

    public static String getmLastDateOfClean() {
        return mLastDateOfClean;
    }

    public static void setmLastDateOfClean(String mLastDateOfClean) {
        Singleton.mLastDateOfClean = mLastDateOfClean;
    }

    private static String mLastDateOfClean;
}
