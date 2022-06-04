package ru.mirea.khelimskiy.mireaproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Gmap extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private boolean isWork = false;
    static final int REQUEST_CODE_PERMISSION_FINE = 100;
    private SearchView searchView;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            mMap.setOnMapClickListener(Gmap.this::onMapClick);
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
// добавление кнопок изменнеия масштаба
            mMap.getUiSettings().setZoomControlsEnabled(true);
// отображение слоя загруженности дорог
            mMap.setTrafficEnabled(true);
            setUpMap();

            int locPermissionStatus = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
            if (locPermissionStatus == PackageManager.PERMISSION_GRANTED) {
                isWork = true;
            } else {
                // Выполняется запрос к пользователь на получение необходимых разрешений
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_CODE_PERMISSION_FINE);
            }
            mMap.setMyLocationEnabled(true);
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v1 = inflater.inflate(R.layout.fragment_gmap, container, false);
        searchView = v1.findViewById(R.id.idSearchView);
        return v1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || location.equals("")) {
                    Geocoder geocoder = new Geocoder(getActivity());
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);
    }


        @Override
        public void onMapReady (GoogleMap googleMap){
            mMap = googleMap;
            mMap.setOnMapClickListener(this);
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
// добавление кнопок изменнеия масштаба
            mMap.getUiSettings().setZoomControlsEnabled(true);
// отображение слоя загруженности дорог
            mMap.setTrafficEnabled(true);
            setUpMap();
            // mMap.getUiSettings().setMyLocationButtonEnabled(true);
            int locPermissionStatus = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
            if (locPermissionStatus == PackageManager.PERMISSION_GRANTED) {
                isWork = true;
            } else {
                // Выполняется запрос к пользователь на получение необходимых разрешений
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_CODE_PERMISSION_FINE);
            }
            mMap.setMyLocationEnabled(true);
        }


        @Override
        public void onRequestPermissionsResult ( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
// производится проверка полученного результата от пользователя на запрос разрешения Camera
            if (requestCode == REQUEST_CODE_PERMISSION_FINE) {
                isWork = (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED);
            }
        }
        private void setUpMap () {
mMap.setInfoWindowAdapter(new MAdapter(getContext()));
            // выбираем один вариант
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            LatLng mirea = new LatLng(55.670005, 37.479894);
            LatLng mireaStr = new LatLng(55.79353, 37.70085);
            LatLng mireaL = new LatLng(55.66826, 37.46030);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    mirea).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
            mMap.addMarker(new MarkerOptions().title("МИРЭА Стромынка")
                    .snippet("ВУЗ на Стромынке\n" + "Адрес: ул. Стромынка, 21 , Москва\n" + "Дата основания: 29 августа 1936 г.\n" +  mireaStr.latitude + " " + mireaStr.longitude).position(mireaStr));
            mMap.addMarker(new MarkerOptions().title("МИРЭА Вернадского")
                    .snippet("ВУЗ который далеко\n" + "Адрес: пр. Вернадского, 78 , Москва\n" + "Дата основания: 28 мая 1947 г.\n" + mirea.latitude + " " + mirea.longitude).position(mirea));
            mMap.addMarker(new MarkerOptions().title("Институт тонких химических технологий им. Ломоносова")
                    .snippet("ВУЗ в котором не был\n" + "Адрес: пр. Вернадского, 86 , Москва\n" + "Дата основания:  1900 г.\n" + mireaL.latitude + " " + mireaL.longitude).position(mireaL));

        }
        @Override
        public void onMapClick (LatLng latLng){
            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    latLng).zoom(12).build();
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
            mMap.addMarker(new MarkerOptions().title("Где я?")
                    .snippet("Новое место").position(latLng));

        }




}