package com.example.arlangomez.stc;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ArlanGomez on 26/02/2018.
 */

public class MapFragment extends Fragment {
    private static final String TAG = "Tab3Fragment";
    private static LatLng central = new LatLng(14.250248, 121.064888);
    private static LatLng nuvali = new LatLng(14.241346, 121.058030);
    private static LatLng dlsu = new LatLng(14.2626, 121.0429);

    private Marker mCentral;
    private Marker mNuvali;
    private Marker mDlsu;
    MapView mMapView;
    private GoogleMap googleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.tab3_fragment, container, false);

        mMapView =  view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;



                googleMap.setMyLocationEnabled(true);

                // For dropping a marker at a point on the Map
                mNuvali = mMap.addMarker(new MarkerOptions().position(nuvali).title("Nuvali"));
                mDlsu = mMap.addMarker(new MarkerOptions().position(dlsu).title("DLSU"));
                mCentral = mMap.addMarker(new MarkerOptions().position(central).title("Laguna Central"));
                //mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) getActivity());

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(dlsu).zoom(14).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


}
