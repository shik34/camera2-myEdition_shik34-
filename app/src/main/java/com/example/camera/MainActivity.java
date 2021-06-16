package com.example.camera;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

//import ru.mobilab.sample.R;

public class MainActivity extends Activity {
        ImageView iv;
/** Called when the activity is first created. */
private static final int CAMERA_PIC_REQUEST=1112;
@Override
public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=(ImageView) findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.cat);

        final Button button1=(Button) findViewById(R.id.button1);
       button1.setOnClickListener(button_click);

/*        final Button button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(button_click);*/

        }
public void onClick2(View v){
                iv.buildDrawingCache();
                Bitmap bitmap = iv.getDrawingCache();
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
/*            intent.putExtra("BitmapImage", bitmap);
            startActivity(intent);*/

    Intent i = new Intent(this, MainActivity2.class);
//    Bitmap b = null;

    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
  //  i.putExtra("byteArray", bs.toByteArray());



  //  Bitmap img=//set here the image you got from the camera.

/*
            Bundle extras = new Bundle();
    extras.putParcelable("image", bitmap);
    i.putExtras(extras);*/
    startActivity(i);



        }

public OnClickListener button_click=new OnClickListener(){

public void onClick(View v){

        Intent cameraIntent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
//        iv.setImageResource(R.drawable.cat);
        }


// TODO Auto-generated method stub

        };
/*public void button_click( ){}*/
protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode== CAMERA_PIC_REQUEST){
                Bitmap thumbnail=(Bitmap) data.getExtras().get("data");

                iv.setImageBitmap(thumbnail);
        }
}
}
