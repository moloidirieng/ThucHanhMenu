package com.example.thuchanhmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnMenuPopup;
    Button btnSetBackGround;
    LinearLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMenuPopup=findViewById(R.id.idMenuPopup);
        manHinh=findViewById(R.id.manHinh);
        btnSetBackGround=findViewById(R.id.btnSetBackGround);

        registerForContextMenu(btnMenuPopup);



        btnMenuPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuPopup();
            }
        });

        // khoi bạo menu content

    }


    /// menu context
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        //menu.setHeaderTitle("Set Background");
        menu.setHeaderTitle("Set Background");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idRed:
                manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.idBlue:
                manHinh.setBackgroundColor(Color.BLUE);
                break;
            case R.id.idWhite:
                manHinh.setBackgroundColor(Color.WHITE);
                break;

        }

        return super.onContextItemSelected(item);
    }


    // menu popup
    private void menuPopup() {
        PopupMenu popupMenu=new PopupMenu(MainActivity.this,btnMenuPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.idThem:
                        btnMenuPopup.setText("Menu Thêm");
                        break;
                    case R.id.idSua:
                        btnMenuPopup.setText("Menu Sửa");
                        break;
                    case R.id.idXoa:
                        btnMenuPopup.setText("Menu Xóa");
                        break;

                }

                return false;
            }
        });

        popupMenu.show();
    }


    // menu thuong
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.youtube,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId()){
           case R.id.app_bar_search:
               Toast.makeText(this, "chọn menu search", Toast.LENGTH_SHORT).show();
               break;
           case R.id.idXemTrenTV:
               Toast.makeText(this, "chọn xem tren tivi", Toast.LENGTH_SHORT).show();
               break;
           case R.id.idSettings:
               Toast.makeText(this, "chọn settings", Toast.LENGTH_SHORT).show();
               break;
           case R.id.idPhongNumber:
               Toast.makeText(this, "chọn phone number", Toast.LENGTH_SHORT).show();
               break;
           case R.id.idSend_Email:
               Toast.makeText(this, "chọn send email", Toast.LENGTH_SHORT).show();
               break;
       }

        return super.onOptionsItemSelected(item);
    }

}
//app:actionViewClass="android.widget.SearchView" />


