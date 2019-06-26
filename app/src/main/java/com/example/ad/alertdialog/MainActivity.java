package com.example.ad.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialogID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show the actual dialog (alert dialog)
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                //set things up - setup title
                //alertDialog.setTitle(R.string.title);
                alertDialog.setTitle(getResources().getString(R.string.title));
                alertDialog.setIcon(android.R.drawable.btn_star_big_on);

                //Set Message
                alertDialog.setMessage(getResources().getString(R.string.message));

                //set Cancelable
                alertDialog.setCancelable(false);

                //Set positive button
                alertDialog.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Exit our window activity
                                MainActivity.this.finish();
                            }
                        });

                //set negative button
                alertDialog.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                //create the actual dialog
                AlertDialog dialog = alertDialog.create();

                //show the dialog
                dialog.show();

            }
        });

    }
}
