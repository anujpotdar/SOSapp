package com.example.inpota00.sosapp;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.example.inpota00.sosapp.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements LocationListener {

    ActivityMainBinding binding;
    final int CAMERA_PIC_REQUEST = 1337;
    MainActivity activity;
    APIInterface apiInterface;
    APIInterface apiInterfaceForCloudant;
    private int wxIcon;
    private String wxPhrase;
    private double lattitude;
    private double longitude;
    LocationManager locationManager;
    public static final int PERMISSION_READ_STATE = 999;
    private boolean hasCalledWeatherAPI = false;
    FirebaseStorage storage;
    StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create a storage reference from our app
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();
        // Create a child reference
        // imagesRef now points to "images"
        StorageReference imagesRef = storageRef.child("images");

        // Child references can also take paths
        // spaceRef now points to "images/space.jpg
        // imagesRef still points to "images"
        StorageReference spaceRef = storageRef.child("images/space.jpg");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activity = this;
        apiInterface = ServiceGenerator.getClient().create(APIInterface.class);
        apiInterfaceForCloudant = ServiceGenerator.getClientForCloudant().create(APIInterface.class);
        requestPhonePermission();
        requestLocationPermission();
        setOnClick();
    }

    private void requestPhonePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//
            if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION_READ_STATE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant

                return;
            }
        }//
    }

    private void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},
                        PERMISSION_READ_STATE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant

                return;
            }
        }//
    }

    @Override
    public void onBackPressed() {
        if (binding.afterReceiveImage.getVisibility() != View.GONE) {
            binding.afterReceiveImage.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    private void setOnClick() {
        binding.sosLinLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(grantResults.length>0){
            switch (requestCode) {
                case PERMISSION_READ_STATE:
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        //granted
                    } else {
                        //not granted
                    }
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }

    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            lattitude = location.getLatitude();
            longitude = location.getLongitude();
            if(hasCalledWeatherAPI){
                return;
            }else{

                callWeatherAPI();
            }
            //locationText.setText(locationText.getText() + "\n"+addresses.get(0).getAddressLine(0)+", "+
                    //addresses.get(0).getAddressLine(1)+", "+addresses.get(0).getAddressLine(2));
        }catch(Exception e)
        {

        }

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MainActivity.this, "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }


    private void callWeatherAPI() {
        Call<WeatherApi> call = apiInterface.getWeatherCondition(String.valueOf(lattitude)+"/"+String.valueOf(longitude)+"/observations.json?units=m&language=en-US");

        call.enqueue(new Callback<WeatherApi>() {
            @Override
            public void onResponse(Call<WeatherApi> call, Response<WeatherApi> response) {
                if (response != null) {
                    if (response.body() != null) {
                        wxIcon = response.body().getObservation().getWxIcon();
                        wxPhrase = response.body().getObservation().getWxPhrase();
                        hasCalledWeatherAPI = true;
                        sendToCloudant();
                    } else {
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<WeatherApi> call, Throwable t) {
                binding.loader.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Network Error. Please try again.", Toast.LENGTH_LONG).show();
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (data != null) {

                setupHelpRequestCard(data);
                binding.sosLinLay.setVisibility(View.GONE);

                //dialogFragment.getDialog().getWindow().setLayout((6 * width)/7, LinearLayout.LayoutParams.WRAP_CONTENT);
            }

        }
    }

    private void sendToCloudant(){
        Cloudant cloudant = new Cloudant();
        cloudant.setArea(getArea());
        if(TextUtils.isEmpty(binding.helpMessage.getText().toString())){
            cloudant.setComment("No Comment Added");
        }else{
            cloudant.setComment(binding.helpMessage.getText().toString());
        }
        cloudant.setImageUrl("www.google.com");
        cloudant.setWxIcon(String.valueOf(wxIcon));
        cloudant.setWxPhrase(wxPhrase);
        cloudant.setPhoneNo(binding.phoneNo.getText().toString());
        cloudant.setLatitude(lattitude);
        cloudant.setLongitude(longitude);

        Call<CloudantResponse> call = apiInterfaceForCloudant.uploadToCloudant("test_database",cloudant);

        call.enqueue(new Callback<CloudantResponse>() {
            @Override
            public void onResponse(Call<CloudantResponse> call, Response<CloudantResponse> response) {
                if(response!=null){
                    if(response.body()!=null){
                        binding.loader.setVisibility(View.GONE);
                        binding.sendSos.setText("SOS issued.");
                        binding.sendSos.setOnClickListener(null);
                        sendNotification();
                        binding.waitForHelp.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<CloudantResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API Fail", Toast.LENGTH_LONG).show();
                binding.loader.setVisibility(View.GONE);
                binding.sendSos.setText("SOS issued.");
                binding.sendSos.setVisibility(View.VISIBLE);
            }
        });
    }

    void sendNotification(){
        Intent intent = new Intent(activity, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(activity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder b = new NotificationCompat.Builder(activity);

        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis()+ 20000)
                .setSmallIcon(R.drawable.sos)
                .setTicker("Hearty365")

                .setContentTitle("Help is on its way")
                .setContentText("Hello a rescue team has been deployed to your area. We hope it reaches you on time.")
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND)
                .setContentIntent(contentIntent)
                .setContentInfo("Info");


        NotificationManager notificationManager = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, b.build());
    }

    private String getArea(){
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(lattitude,longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (addresses.get(0).getPostalCode());
    }

    private void setupHelpRequestCard(Intent data) {
        Bitmap image = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byteArray = baos.toByteArray();


        binding.helpImage.setImageBitmap(image);

        UploadTask uploadTask = storageRef.putBytes(byteArray);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });


        binding.afterReceiveImage.setVisibility(View.VISIBLE);

        binding.sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                TelephonyManager tMgr = (TelephonyManager) activity.getSystemService(activity.TELEPHONY_SERVICE);
                binding.afterReceiveImage.setVisibility(View.GONE);

                    binding.loader.setVisibility(View.VISIBLE);

                    binding.sendSos.setVisibility(View.GONE);
                    binding.helpMessage.clearFocus();
                    getLocation();
                    return;
                }else{
                    requestPhonePermission();
                }

            }
        });

        binding.helpMessage.requestFocus();
    }
}
