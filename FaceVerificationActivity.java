package com.example.STAYHOME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.microsoft.projectoxford.face.FaceServiceClient;
import com.microsoft.projectoxford.face.contract.VerifyResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FaceVerificationActivity extends AppCompatActivity {

    private Button takePictureButton;
    private ImageView imageView;
    private Uri mUriPhotoTaken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_verification);

        takePictureButton = (Button) findViewById(R.id.button_image);
        imageView = (ImageView) findViewById(R.id.imageview);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            takePictureButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                takePictureButton.setEnabled(true);
            }
        }
    }

    /**
     * public void takePicture(View view) {
     * Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     * file = Uri.fromFile(getOutputMediaFile());
     * intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
     * <p>
     * startActivityForResult(intent, 100);
     * }
     **/
    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            // Save the photo taken to a temporary file.
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                File file = File.createTempFile("IMG_", ".jpg", storageDir);
                mUriPhotoTaken = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mUriPhotoTaken);
                startActivityForResult(intent, 100);
            } catch (IOException e) {
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                imageView.setImageURI(mUriPhotoTaken);
            }
        }
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
    }


    public void verify_gotohome(View view) {

        FaceVerification fv = new FaceVerification();
        Intent MainIntent = new Intent(FaceVerificationActivity.this, TabhomeActivity.class);
        startActivity(MainIntent);
        Toast.makeText(FaceVerificationActivity.this, "Your are verified, go to home page", Toast.LENGTH_LONG).show();

    }


    public class FaceVerification extends AppCompatActivity {
        // Background task for face verification.
        private class VerificationTask extends AsyncTask<Void, String, VerifyResult> {
            // The IDs of two face to verify.
            private UUID mFaceId0;
            private UUID mFaceId1;

            VerificationTask(UUID faceId0, UUID faceId1) {
                mFaceId0 = faceId0;
                mFaceId1 = faceId1;
            }

            @Override
            protected VerifyResult doInBackground(Void... params) {
                // Get an instance of face service client to detect faces in image.
                FaceServiceClient faceServiceClient = SampleApp.getFaceServiceClient();
                try {
                    publishProgress("Verifying...");

                    // Start verification.
                    return faceServiceClient.verify(
                            mFaceId0,      /* The first face ID to verify */
                            mFaceId1);     /* The second face ID to verify */
                } catch (Exception e) {
                    publishProgress(e.getMessage());

                    return null;
                }
            }
        }
    }
}

