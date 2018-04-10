package org.rhon.tepejson;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Chevalier on 2/19/2018.
 */

public class LoadJSON {
    private Context mContext;
    private JSONObject mJSON;
    public LoadJSON(Context context) {
        this.mContext = context;
        mJSON = null;
        String json = null;
        try {
            InputStream is = mContext.getAssets().open("ig_response.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.e(null, "Data : " + json);
        } catch (IOException ex) {
            ex.printStackTrace();
            Log.e(null, "Gagal");
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("data");
            mJSON = m_jArry.getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(String path) {
        try {
            String[] paths = path.split("/");
            if (paths.length == 1) return mJSON.getString(paths[0]);
            else {
                JSONObject jsonObject = null;
                for (int i = 0; i<paths.length-1; i++){
                    jsonObject = (jsonObject == null) ?
                            mJSON.getJSONObject(paths[i]) : jsonObject.getJSONObject(paths[i]);
                }
                if (jsonObject != null)
                    return jsonObject.getString(paths[paths.length-1]);
            }
        }catch (JSONException ex){
            Log.e(null, ex.toString());
        }
        return null;
    }
}
