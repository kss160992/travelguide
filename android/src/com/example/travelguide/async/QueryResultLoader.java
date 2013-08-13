package com.example.travelguide.async;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.travelguide.cpp.Storage;

public class QueryResultLoader extends AsyncTaskLoader<Storage>
{
  private final Storage mStorage;
  private final String  mQuery;
  private final double  mLat;
  private final double  mLon;
  private final boolean mUseLocation;

  public QueryResultLoader(Context context, Storage storage, String query)
  {
    super(context);
    mQuery = query;
    mUseLocation = false;
    mLat = mLon = 0;
    mStorage = storage;
  }

  public QueryResultLoader(Context context, Storage storage, String query, double lat, double lon)
  {
    super(context);
    mQuery = query;
    mUseLocation = true;
    mLat = lat;
    mLon = lon;
    mStorage = storage;
  }

  @Override
  public Storage loadInBackground()
  {
    mStorage.query(mQuery, mUseLocation, mLat, mLon);
    return mStorage;
  }

}
