package com.example.mylocalbanks2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBSText;
    TextView tvOCBCText;
    TextView tvUOBText;

    String bankSelected = "";
    String url = "";
    String phoneNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBSText = findViewById(R.id.textViewDBS);
        tvOCBCText = findViewById(R.id.textViewOCBC);
        tvUOBText = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBSText);
        registerForContextMenu(tvOCBCText);
        registerForContextMenu(tvUOBText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBSText.setText("DBS");
            tvOCBCText.setText("OCBC");
            tvUOBText.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBSText.setText("星展银行");
            tvOCBCText.setText("华侨银行");
            tvUOBText.setText("大华银行");
            return true;
        } else {
            tvDBSText.setText("Error translation");
            tvOCBCText.setText("Error translation");
            tvUOBText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == tvDBSText) {
            bankSelected = "DBS";
        } else if (v == tvOCBCText) {
            bankSelected = "OCBC";
        } else if (v == tvUOBText) {
            bankSelected = "UOB";
        }
        //menu.add(Menu.NONE, R.id.action_toggle_favorite, Menu.NONE, getString(R.string.menu_toggle_favorite));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankSelected.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                url = "https://www.dbs.com.sg";
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentCall);
                return true;

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                phoneNum = "18001111111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phoneNum));
                startActivity(intentCall);
                return true;
            }
        }
        if (bankSelected.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                url = "https://www.ocbc.com";
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentCall);
                return true;

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                phoneNum = "18003633333";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phoneNum));
                startActivity(intentCall);
                return true;
            }
        }
        if (bankSelected.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                url = "https://www.uob.com.sg";
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentCall);
                return true;

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                phoneNum = "18002222121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ phoneNum));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }


}