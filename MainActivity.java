package com.example.qrcodegenerator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button generateButton = findViewById(R.id.generateButton);
        ImageView qrCodeImageView = findViewById(R.id.qrCodeImageView);

        generateButton.setOnClickListener(v -> {
            String textToEncode = editText.getText().toString().trim();
            if (!textToEncode.isEmpty()) {
                try {
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(
                            textToEncode,
                            BarcodeFormat.QR_CODE,
                            300,
                            300
                    );
                    qrCodeImageView.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
