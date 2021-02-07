package com.example.placetovisitinistanbul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList <String> names = new ArrayList<>();
        names.add("Ayasofya Camii");
        names.add("Sultan Ahmet Camii");
        names.add("Topkapı Sarayı Müzesi");
        names.add("Kapalı Çarşı");
        names.add("Yerebatan Sarnıcı");
        names.add("Kız Kulesi");


        ArrayList <Bitmap> bitmapler = new ArrayList<>();
        Bitmap ayasofya = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.ayasofya);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum
        Bitmap sultanahmet = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.sultanahmet);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum
        Bitmap topkapi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.topkapi);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum
        Bitmap kapalicarsi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kapalicarsi);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum
        Bitmap yerebatan = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.yerebatan);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum
        Bitmap kizkulesi = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.kizkulesi);//resmi bitmap olarak alma birinci kisim context ve kaynakları ,ikinci kisim resmin bulundugu konum

        bitmapler.add(ayasofya);
        bitmapler.add(sultanahmet);
        bitmapler.add(topkapi);
        bitmapler.add(kapalicarsi);
        bitmapler.add(yerebatan);
        bitmapler.add(kizkulesi);






        ListView listView =findViewById(R.id.listView);
        //listview ile arraylisti birbirine baglama
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,names);//birinci kisim context ikinci kisim sadece yazilari gostermek istiyorsak,ücüncü kisim gosterilecek liste
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {//listedeki bir isme tiklandiginda yapılacak islem
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//asagidaki i listviewdaki indeksi döner


                //Singleton design pattern
                Singleton singleton = Singleton.getInstance();
                singleton.setName(names.get(i));
                singleton.setBitmap(bitmapler.get(i));

                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}