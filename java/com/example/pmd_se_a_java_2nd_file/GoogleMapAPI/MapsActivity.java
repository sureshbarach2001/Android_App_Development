package com.example.pmd_se_a_java_2nd_file.GoogleMapAPI;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.pmd_se_a_java_2nd_file.R;
import com.example.pmd_se_a_java_2nd_file.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       /* locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
//                Log.d("TAG",location.toString());
//                LatLng obj = new LatLng(location.getLatitude(),location.getLongitude());
//                mMap.addMarker(new MarkerOptions().position(obj).title("New Location"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(obj,7));
                mapOnUserLocation(location,"User Current Location");
            }
        };*/
       /* if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},01);
        }
        else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0,locationListener);
            Location userLasrLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            mapOnUserLocation(userLasrLocation,"user last location");
        }*/
    }
    public void mapOnUserLocation(Location location, String title)
    {
        LatLng UserLocation = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(UserLocation).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UserLocation, 10));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Address1 = new LatLng(31.60, 73.03);
        LatLng Address2 = new LatLng(41.60, 83.03);
        LatLng Address3 = new LatLng(51.60, 93.03);
        LatLng Address4 = new LatLng(61.60, 103.03);
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(Address1)
                    .add(Address2)
                        .add(Address3)
                            .add(Address4);
//        Polyline polyline = mMap.addPolyline(polylineOptions);
        PolygonOptions polygonOptions = new PolygonOptions()
                .add(Address1)
                .add(Address2)
                .add(Address3)
                .add(Address4);
//        Polygon polygon = mMap.addPolygon(polygonOptions);
        CircleOptions options = new CircleOptions()
                .center(Address1)
                    .radius(2000)
                        .strokeWidth(10)
                            .strokeColor(Color.RED)
                                .fillColor(Color.BLUE);

//        Circle circle = mMap.addCircle(options);

        mMap.addMarker(new MarkerOptions().position(Address1).title("Marker in Loonawala")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Address1));
    }
}