package ru.mirea.khelimskiy.mireaproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MAdapter implements GoogleMap.InfoWindowAdapter {
   private final View NInfo;
   private Context Ncontext;
    public MAdapter (Context context){
        Ncontext = context;
        NInfo = LayoutInflater.from(context).inflate(R.layout.markerinfo, null);
    }

    private void InfoMarker(Marker marker, View view){

        String title = marker.getTitle();
TextView mTitle = view.findViewById(R.id.location_marker_title);

if(!title.equals("")){
    mTitle.setText(title);
}
        String snip = marker.getSnippet();
        TextView mSnip = view.findViewById(R.id.location_marker_snippet);
        if(!snip.equals("")){
            mSnip.setText(snip);
        }

    }





    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
       InfoMarker(marker, NInfo);
        return NInfo;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        InfoMarker(marker, NInfo);
        return NInfo;
    }
}
